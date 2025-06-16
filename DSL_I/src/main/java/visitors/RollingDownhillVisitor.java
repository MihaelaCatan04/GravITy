package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class RollingDownhillVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();
    private Map<String, Double> identifiers = new HashMap<>(); // To store declared identifiers and their values

    // Evaluators for conditional and loop expressions
    private ConditionalValueEvaluator conditionalEvaluator = new ConditionalValueEvaluator();
    private LoopValueEvaluator loopEvaluator = new LoopValueEvaluator();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {
        return visit(ctx.simulation_body());
    }

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        return visit(ctx.physics_module());
    }

    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.rolling_downhill() != null) {
            return visit(ctx.rolling_downhill());
        }
        return null;
    }

    @Override
    public Object visitRolling_downhill(GravITyParser.Rolling_downhillContext ctx) {
        Map<String, Object> rollingDownhillModule = new HashMap<>();

        if (ctx.gravitational_acceleration_expr() != null) {
            Double value = evaluateValueExpr(ctx.gravitational_acceleration_expr().value_expr());
            rollingDownhillModule.put("gravitational_acceleration", String.valueOf(value));
            identifiers.put("gravitational_acceleration", value);
        }

        if (ctx.coefficient_of_friction_expr() != null) {
            Double value = evaluateValueExpr(ctx.coefficient_of_friction_expr().value_expr());
            rollingDownhillModule.put("coefficient_of_friction", String.valueOf(value));
            identifiers.put("coefficient_of_friction", value);
        }

        if (ctx.bounciness_expr() != null) {
            Double value = evaluateValueExpr(ctx.bounciness_expr().value_expr());
            rollingDownhillModule.put("bounciness", String.valueOf(value));
            identifiers.put("bounciness", value);
        }

        if (ctx.angle_expr() != null) {
            Double value = evaluateValueExpr(ctx.angle_expr().value_expr());
            rollingDownhillModule.put("angle", String.valueOf(value));
            identifiers.put("angle", value);
        }

        if (ctx.velocity_along_incline_expr() != null) {
            Double value = evaluateValueExpr(ctx.velocity_along_incline_expr().value_expr());
            rollingDownhillModule.put("velocity_along_incline", String.valueOf(value));
            identifiers.put("velocity_along_incline", value);
        }

        if (ctx.ball_expr() != null) {
            Map<String, Object> ball = (Map<String, Object>) visit(ctx.ball_expr());
            rollingDownhillModule.put("ball", ball);
        }

        simulation.put("rolling_downhill", rollingDownhillModule);
        return rollingDownhillModule;
    }

    @Override
    public Object visitBall_expr(GravITyParser.Ball_exprContext ctx) {
        // Ball properties are handled by mover_basic_properties
        return visit(ctx.mover_basic_properties());
    }

    @Override
    public Object visitMover_expr(GravITyParser.Mover_exprContext ctx) {
        // This method might not be directly called in 'RollingDownhillVisitor' based on your grammar,
        // but it's good practice to ensure it uses the evaluation logic if it were.
        return visit(ctx.mover_basic_properties());
    }

    @Override
    public Object visitMover_basic_properties(GravITyParser.Mover_basic_propertiesContext ctx) {
        Map<String, Object> mover = new HashMap<>(); // Renamed from 'ball' for consistency with mover_basic_properties

        if (ctx.radius_expr() != null) {
            Double radius = evaluateValueExpr(ctx.radius_expr().value_expr());
            mover.put("radius", String.valueOf(radius));
            identifiers.put("ball_radius", radius); // Store with unique name
        }

        if (ctx.color_expr() != null) {
            // Store color components as Strings for main's parsing
            Map<String, String> color = new HashMap<>();

            if (ctx.color_expr().red_value_expr() != null) {
                Double redValue = evaluateValueExpr(ctx.color_expr().red_value_expr().value_expr());
                color.put("red_value", String.valueOf((int) Math.round(redValue)));
                identifiers.put("ball_red_value", redValue);
            }

            if (ctx.color_expr().green_value_expr() != null) {
                Double greenValue = evaluateValueExpr(ctx.color_expr().green_value_expr().value_expr());
                color.put("green_value", String.valueOf((int) Math.round(greenValue)));
                identifiers.put("ball_green_value", greenValue);
            }

            if (ctx.color_expr().blue_value_expr() != null) {
                Double blueValue = evaluateValueExpr(ctx.color_expr().blue_value_expr().value_expr());
                color.put("blue_value", String.valueOf((int) Math.round(blueValue)));
                identifiers.put("ball_blue_value", blueValue);
            }

            mover.put("color", color);
        }

        return mover;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }

    // --- Helper Methods for Value Evaluation ---

    private Double evaluateValueExpr(GravITyParser.Value_exprContext ctx) {
        if (ctx.simple_value() != null) {
            return evaluateSimpleValue(ctx.simple_value());
        } else if (ctx.conditional_value() != null) {
            return conditionalEvaluator.evaluate(ctx.conditional_value(), identifiers);
        } else if (ctx.loop_value() != null) {
            return loopEvaluator.evaluate(ctx.loop_value());
        } else {
            System.err.println("Warning: Unhandled value expression type: " + ctx.getText());
            return 0.0;
        }
    }

    private Double evaluateSimpleValue(GravITyParser.Simple_valueContext ctx) {
        if (ctx.NUMBER() != null) {
            return Double.parseDouble(ctx.NUMBER().getText());
        } else if (ctx.IDENTIFIER() != null) {
            String identifier = ctx.IDENTIFIER().getText();
            if (identifier.startsWith("_")) {
                identifier = identifier.substring(1);
            }
            if (identifiers.containsKey(identifier)) {
                return identifiers.get(identifier);
            } else {
                System.err.println("Warning: Identifier '" + ctx.IDENTIFIER().getText() + "' not found. Returning 0.0");
                return 0.0;
            }
        } else if (ctx.reference() != null) {
            System.err.println("Warning: Reference '" + ctx.reference().getText() + "' handling not implemented. Returning 0.0");
            return 0.0;
        } else {
            throw new IllegalArgumentException("Invalid simple value: " + ctx.getText());
        }
    }
}
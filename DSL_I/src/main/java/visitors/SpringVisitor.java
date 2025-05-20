package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class SpringVisitor extends GravITyBaseVisitor<Object> {
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
        if (ctx.spring() != null) {
            return visit(ctx.spring());
        }
        return null;
    }

    @Override
    public Object visitSpring(GravITyParser.SpringContext ctx) {
        Map<String, Object> springModule = new HashMap<>();

        if (ctx.spring_constant_expr() != null) {
            Double value = evaluateValueExpr(ctx.spring_constant_expr().value_expr());
            springModule.put("spring_constant", String.valueOf(value));
            identifiers.put("spring_constant", value);
        }

        if (ctx.damping_expr() != null) {
            Double value = evaluateValueExpr(ctx.damping_expr().value_expr());
            springModule.put("damping", String.valueOf(value));
            identifiers.put("damping", value);
        }

        if (ctx.spring_rest_length_expr() != null) {
            Double value = evaluateValueExpr(ctx.spring_rest_length_expr().value_expr());
            springModule.put("spring_rest_length", String.valueOf(value));
            identifiers.put("spring_rest_length", value);
        }

        if (ctx.floor_friction_expr() != null) {
            Double value = evaluateValueExpr(ctx.floor_friction_expr().value_expr());
            springModule.put("floor_friction", String.valueOf(value));
            identifiers.put("floor_friction", value);
        }

        if (ctx.ball_expr() != null) {
            Map<String, Object> ballConfig = (Map<String, Object>) visit(ctx.ball_expr());
            springModule.put("ball", ballConfig);
        }

        if (ctx.spring_expr() != null) {
            Map<String, Object> springConfig = (Map<String, Object>) visit(ctx.spring_expr());
            springModule.put("spring", springConfig);
        }

        simulation.put("spring", springModule);

        return springModule;
    }

    @Override
    public Object visitSpring_expr(GravITyParser.Spring_exprContext ctx) {
        Map<String, Object> springConfig = new HashMap<>();

        if (ctx.x_anchor_position_expr() != null) {
            Double value = evaluateValueExpr(ctx.x_anchor_position_expr().value_expr());
            springConfig.put("x_anchor_position", String.valueOf(value));
            identifiers.put("x_anchor_position", value);
        }

        if (ctx.y_anchor_position_expr() != null) {
            Double value = evaluateValueExpr(ctx.y_anchor_position_expr().value_expr());
            springConfig.put("y_anchor_position", String.valueOf(value));
            identifiers.put("y_anchor_position", value);
        }

        if (ctx.num_coils_expr() != null) {
            Double value = evaluateValueExpr(ctx.num_coils_expr().value_expr());
            springConfig.put("num_coils", String.valueOf((int) Math.round(value))); // Assuming num_coils is an integer
            identifiers.put("num_coils", value);
        }

        return springConfig;
    }

    @Override
    public Object visitBall_expr(GravITyParser.Ball_exprContext ctx) {
        Map<String, Object> ballConfig = new HashMap<>();

        if (ctx.mover_basic_properties().radius_expr() != null) {
            Double radius = evaluateValueExpr(ctx.mover_basic_properties().radius_expr().value_expr());
            ballConfig.put("radius", String.valueOf(radius));
            identifiers.put("ball_radius", radius);
        }

        if (ctx.mover_basic_properties().color_expr() != null) {
            Map<String, String> color = new HashMap<>();

            Double redValue = evaluateValueExpr(ctx.mover_basic_properties().color_expr().red_value_expr().value_expr());
            color.put("r", String.valueOf((int) Math.round(redValue)));
            identifiers.put("ball_red_value", redValue);

            Double greenValue = evaluateValueExpr(ctx.mover_basic_properties().color_expr().green_value_expr().value_expr());
            color.put("g", String.valueOf((int) Math.round(greenValue)));
            identifiers.put("ball_green_value", greenValue);

            Double blueValue = evaluateValueExpr(ctx.mover_basic_properties().color_expr().blue_value_expr().value_expr());
            color.put("b", String.valueOf((int) Math.round(blueValue)));
            identifiers.put("ball_blue_value", blueValue);

            ballConfig.put("color", color);
        }

        return ballConfig;
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
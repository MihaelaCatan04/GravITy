package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class UniformMotionVisitor extends GravITyBaseVisitor<Object> {
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
        if (ctx.uniform_motion() != null) {
            return visit(ctx.uniform_motion());
        }
        return null;
    }

    @Override
    public Object visitUniform_motion(GravITyParser.Uniform_motionContext ctx) {
        Map<String, Object> uniformMotionModule = new HashMap<>();

        Map<String, Object> mover = (Map<String, Object>) visit(ctx.mover_expr());
        uniformMotionModule.put("mover", mover);

        if (ctx.initial_speed_expr() != null) {
            Double initialSpeed = evaluateValueExpr(ctx.initial_speed_expr().value_expr());
            uniformMotionModule.put("initial_speed", String.valueOf(initialSpeed));
            identifiers.put("initial_speed", initialSpeed);
        }

        simulation.put("uniform_motion", uniformMotionModule);
        return uniformMotionModule;
    }

    @Override
    public Object visitMover_expr(GravITyParser.Mover_exprContext ctx) {
        return visit(ctx.mover_basic_properties());
    }

    @Override
    public Object visitMover_basic_properties(GravITyParser.Mover_basic_propertiesContext ctx) {
        Map<String, Object> mover = new HashMap<>();

        if (ctx.radius_expr() != null) {
            Double radius = evaluateValueExpr(ctx.radius_expr().value_expr());
            mover.put("radius", String.valueOf(radius));
            identifiers.put("radius", radius);
        }

        if (ctx.color_expr() != null) {
            // Store color components as Strings for main's parsing
            Map<String, String> color = new HashMap<>();

            if (ctx.color_expr().red_value_expr() != null) {
                Double redValue = evaluateValueExpr(ctx.color_expr().red_value_expr().value_expr());
                color.put("red_value", String.valueOf((int) Math.round(redValue)));
                identifiers.put("mover_red_value", redValue);
            }

            if (ctx.color_expr().green_value_expr() != null) {
                Double greenValue = evaluateValueExpr(ctx.color_expr().green_value_expr().value_expr());
                color.put("green_value", String.valueOf((int) Math.round(greenValue)));
                identifiers.put("mover_green_value", greenValue);
            }

            if (ctx.color_expr().blue_value_expr() != null) {
                Double blueValue = evaluateValueExpr(ctx.color_expr().blue_value_expr().value_expr());
                color.put("blue_value", String.valueOf((int) Math.round(blueValue)));
                identifiers.put("mover_blue_value", blueValue);
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
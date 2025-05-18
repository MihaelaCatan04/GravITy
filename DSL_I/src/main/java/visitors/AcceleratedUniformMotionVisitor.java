package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class AcceleratedUniformMotionVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();
    private Map<String, Double> identifiers = new HashMap<>(); // Store declared identifiers and their values
    private ConditionalValueEvaluator conditionalEvaluator = new ConditionalValueEvaluator();
    private LoopValueEvaluator loopEvaluator = new LoopValueEvaluator();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {
        return visit(ctx.simulation_body());
    }

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        // Visit the first physics module (assuming accelerated_motion is there)
        return visit(ctx.physics_module());
    }

    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.accelerated_motion() != null) {
            return visit(ctx.accelerated_motion());
        }
        return null;
    }

    @Override
    public Object visitAccelerated_motion(GravITyParser.Accelerated_motionContext ctx) {
        Map<String, Object> acceleratedMotionModule = new HashMap<>();

        // Handle the mover expression
        Map<String, Object> mover = (Map<String, Object>) visit(ctx.mover_expr());
        acceleratedMotionModule.put("mover", mover);

        // Handle initial speed
        if (ctx.initial_speed_expr() != null) {
            Double initialSpeed = evaluateValueExpr(ctx.initial_speed_expr().value_expr());
            acceleratedMotionModule.put("initial_speed", initialSpeed);
            identifiers.put("initial_speed", initialSpeed); // Store in identifiers
        }

        // Handle initial acceleration
        if (ctx.initial_acceleration_expr() != null) {
            Double initialAcceleration = evaluateValueExpr(ctx.initial_acceleration_expr().value_expr());
            acceleratedMotionModule.put("initial_acceleration", initialAcceleration);
            identifiers.put("initial_acceleration", initialAcceleration); // Store in identifiers
        }

        simulation.put("accelerated_motion", acceleratedMotionModule);
        return acceleratedMotionModule;
    }

    @Override
    public Object visitMover_expr(GravITyParser.Mover_exprContext ctx) {
        return visit(ctx.mover_basic_properties());
    }

    @Override
    public Object visitMover_basic_properties(GravITyParser.Mover_basic_propertiesContext ctx) {
        Map<String, Object> mover = new HashMap<>();

        // Process each property of the mover
        if (ctx.radius_expr() != null) {
            Double radius = evaluateValueExpr(ctx.radius_expr().value_expr());
            mover.put("radius", radius);
            identifiers.put("radius", radius); // Store radius
        }

        if (ctx.color_expr() != null) {
            Map<String, Integer> color = new HashMap<>();

            if (ctx.color_expr().red_value_expr() != null) {
                Double redValue = evaluateValueExpr(ctx.color_expr().red_value_expr().value_expr());
                color.put("red_value", (int) Math.round(redValue));
                identifiers.put("red_value", redValue);
            }

            if (ctx.color_expr().green_value_expr() != null) {
                Double greenValue = evaluateValueExpr(ctx.color_expr().green_value_expr().value_expr());
                color.put("green_value", (int) Math.round(greenValue));
                identifiers.put("green_value", greenValue);
            }

            if (ctx.color_expr().blue_value_expr() != null) {
                Double blueValue = evaluateValueExpr(ctx.color_expr().blue_value_expr().value_expr());
                color.put("blue_value", (int) Math.round(blueValue));
                identifiers.put("blue_value", blueValue);
            }

            mover.put("color", color);
        }

        return mover;
    }

    private Double evaluateValueExpr(GravITyParser.Value_exprContext ctx) {
        if (ctx.simple_value() != null) {
            return evaluateSimpleValue(ctx.simple_value());
        } else if (ctx.conditional_value() != null) {
            return conditionalEvaluator.evaluate(ctx.conditional_value(), identifiers);
        } else if (ctx.loop_value() != null) {
            return loopEvaluator.evaluate(ctx.loop_value());
        } else {
            return 0.0; // Or throw an exception for an unknown case
        }
    }

    private Double evaluateSimpleValue(GravITyParser.Simple_valueContext ctx) {
        if (ctx.NUMBER() != null) {
            return Double.parseDouble(ctx.NUMBER().getText());
        } else if (ctx.IDENTIFIER() != null) {
            String identifier = ctx.IDENTIFIER().getText().substring(1); // Remove the leading '_'
            if (identifiers.containsKey(identifier)) {
                return identifiers.get(identifier);
            } else {
                System.err.println("Warning: Identifier '" + ctx.IDENTIFIER().getText() + "' not found. Returning 0.0");
                return 0.0;
            }
        } else if (ctx.reference() != null) {
            // Handle references (object.property) - requires more context about your simulation objects
            // For now, return a default value
            return 0.0;
        } else {
            throw new IllegalArgumentException("Invalid simple value: " + ctx.getText());
        }
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }

}
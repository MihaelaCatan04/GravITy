package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class WaveVisitor extends GravITyBaseVisitor<Object> {
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
        return visit(ctx.physics_module());
    }

    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.wave() != null) {
            return visit(ctx.wave());
        }
        return null;
    }

    @Override
    public Object visitWave(GravITyParser.WaveContext ctx) {
        Map<String, Object> waveModule = new HashMap<>();

        if (ctx.start_angle_expr() != null) {
            Double startAngle = evaluateValueExpr(ctx.start_angle_expr().value_expr());
            waveModule.put("start_angle", startAngle);
            identifiers.put("start_angle", startAngle);
        }
        if (ctx.angle_velocity_expr() != null) {
            Double angleVelocity = evaluateValueExpr(ctx.angle_velocity_expr().value_expr());
            waveModule.put("angle_velocity", angleVelocity);
            identifiers.put("angle_velocity", angleVelocity);
        }
        if (ctx.amplitude_expr() != null) {
            Double amplitude = evaluateValueExpr(ctx.amplitude_expr().value_expr());
            waveModule.put("amplitude", amplitude);
            identifiers.put("amplitude", amplitude);
        }
        if (ctx.frequency_expr() != null) {
            Double frequency = evaluateValueExpr(ctx.frequency_expr().value_expr());
            waveModule.put("frequency", frequency);
            identifiers.put("frequency", frequency);
        }
        if (ctx.phase_shift_expr() != null) {
            Double phaseShift = evaluateValueExpr(ctx.phase_shift_expr().value_expr());
            waveModule.put("phase_shift", phaseShift);
            identifiers.put("phase_shift", phaseShift);
        }

        simulation.put("wave", waveModule);
        return waveModule;
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
            mover.put("radius", radius);
            identifiers.put("radius", radius);
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
            return 0.0;
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
            return 0.0; // Implement reference resolution logic if needed
        } else {
            throw new IllegalArgumentException("Invalid simple value: " + ctx.getText());
        }
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }
}
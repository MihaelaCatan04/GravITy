package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class PendulumVisitor extends GravITyBaseVisitor<Object> {

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
        GravITyParser.Physics_moduleContext moduleCtx = ctx.physics_module();
        if (moduleCtx.pendulum() != null) {
            return visit(moduleCtx.pendulum());
        }
        return null;
    }

    @Override
    public Object visitPendulum(GravITyParser.PendulumContext ctx) {
        Map<String, Object> pendulumModule = new HashMap<>();

        // Extract every available expression, evaluate, and add to the map as String
        if (ctx.length_expr() != null) {
            Double length = evaluateValueExpr(ctx.length_expr().value_expr());
            pendulumModule.put("length", String.valueOf(length));
            identifiers.put("length", length);
        }
        if (ctx.ball_radius_expr() != null) {
            Double ballRadius = evaluateValueExpr(ctx.ball_radius_expr().value_expr());
            pendulumModule.put("ball_radius", String.valueOf(ballRadius));
            identifiers.put("ball_radius", ballRadius);
        }
        if (ctx.initial_angle_expr() != null) {
            Double initialAngle = evaluateValueExpr(ctx.initial_angle_expr().value_expr());
            pendulumModule.put("initial_angle", String.valueOf(initialAngle));
            identifiers.put("initial_angle", initialAngle);
        }
        if (ctx.angular_velocity_expr() != null) {
            Double angularVelocity = evaluateValueExpr(ctx.angular_velocity_expr().value_expr());
            pendulumModule.put("angular_velocity", String.valueOf(angularVelocity));
            identifiers.put("angular_velocity", angularVelocity);
        }
        if (ctx.angular_acceleration_expr() != null) {
            Double angularAcceleration = evaluateValueExpr(ctx.angular_acceleration_expr().value_expr());
            pendulumModule.put("angular_acceleration", String.valueOf(angularAcceleration));
            identifiers.put("angular_acceleration", angularAcceleration);
        }
        if (ctx.air_resistance_expr() != null) {
            Double airResistance = evaluateValueExpr(ctx.air_resistance_expr().value_expr());
            pendulumModule.put("air_resistance", String.valueOf(airResistance));
            identifiers.put("air_resistance", airResistance);
        }

        simulation.put("pendulum", pendulumModule);
        return pendulumModule;
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
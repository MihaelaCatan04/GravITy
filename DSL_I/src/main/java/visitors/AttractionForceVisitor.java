package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class AttractionForceVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();
    private Map<String, Double> identifiers = new HashMap<>();
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
        if (ctx.attraction_force() != null) {
            return visit(ctx.attraction_force());
        }
        return null;
    }

    @Override
    public Object visitAttraction_force(GravITyParser.Attraction_forceContext ctx) {
        Map<String, Object> forceModule = new HashMap<>();

        Map<String, Object> mover1 = (Map<String, Object>) visit(ctx.mover1_expr());
        forceModule.put("mover1", mover1);

        Map<String, Object> mover2 = (Map<String, Object>) visit(ctx.mover2_expr());
        forceModule.put("mover2", mover2);

        simulation.put("attraction_force", forceModule);
        return forceModule;
    }

    @Override
    public Object visitMover1_expr(GravITyParser.Mover1_exprContext ctx) {
        return visit(ctx.mover_properties());
    }

    @Override
    public Object visitMover2_expr(GravITyParser.Mover2_exprContext ctx) {
        return visit(ctx.mover_properties());
    }

    @Override
    public Object visitMover_properties(GravITyParser.Mover_propertiesContext ctx) {
        Map<String, Object> mover = new HashMap<>();

        // radius
        float radius = evaluateValueExpr(ctx.radius_expr().value_expr()).floatValue();
        mover.put("radius", radius);
        identifiers.put("radius", (double) radius);

        // mass
        float mass = evaluateValueExpr(ctx.mass_expr().value_expr()).floatValue();
        mover.put("mass", mass);
        identifiers.put("mass", (double) mass);

        // position
        float[] position = new float[2];
        position[0] = evaluateValueExpr(ctx.position_expr().x_position_expr().value_expr()).floatValue();
        position[1] = evaluateValueExpr(ctx.position_expr().y_position_expr().value_expr()).floatValue();
        mover.put("position", position);
        identifiers.put("x_position", (double) position[0]);
        identifiers.put("y_position", (double) position[1]);

        // velocity
        float[] velocity = new float[2];
        velocity[0] = evaluateValueExpr(ctx.velocity_expr().x_velocity_expr().value_expr()).floatValue();
        velocity[1] = evaluateValueExpr(ctx.velocity_expr().y_velocity_expr().value_expr()).floatValue();
        mover.put("velocity", velocity);
        identifiers.put("x_velocity", (double) velocity[0]);
        identifiers.put("y_velocity", (double) velocity[1]);
        System.out.println(identifiers);
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
            String identifier = ctx.IDENTIFIER().getText().substring(1);
            if (identifiers.containsKey(identifier)) {
                return identifiers.get(identifier);
            } else {
                System.err.println("Warning: Identifier '" + identifier + "' not found. Returning 0.0");
                return 0.0;
            }
        } else if (ctx.reference() != null) {
            // Logica pentru referințe dacă este cazul
            return 0.0;
        } else {
            throw new IllegalArgumentException("Invalid simple value: " + ctx.getText());
        }
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }
}

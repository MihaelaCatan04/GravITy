package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.*;

public class CollisionVisitor extends GravITyBaseVisitor<Object> {
    private final Map<String, Object> simulation = new HashMap<>();
    private final Map<String, Double> identifiers = new HashMap<>();
    private final ConditionalValueEvaluator conditionalEvaluator = new ConditionalValueEvaluator();
    private final LoopValueEvaluator loopEvaluator = new LoopValueEvaluator();

    public Map<String, Object> getSimulation() {
        return simulation;
    }

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {
        return visit(ctx.simulation_body());
    }

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        GravITyParser.Physics_moduleContext moduleCtx = ctx.physics_module();
        visit(moduleCtx);
        return simulation;
    }

    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.collision() != null) {
            simulation.put("collision", visit(ctx.collision()));
        }
        return null;
    }

    @Override
    public Object visitCollision(GravITyParser.CollisionContext ctx) {
        List<Object> movers = new ArrayList<>();
        for (GravITyParser.MoverContext moverCtx : ctx.movers_list().mover()) {
            movers.add(visit(moverCtx));
        }

        Map<String, Object> module = new HashMap<>();
        module.put("movers", movers);
        return module;
    }

    @Override
    public Object visitMover(GravITyParser.MoverContext ctx) {
        return visit(ctx.mover_properties());
    }

    @Override
    public Object visitMover_properties(GravITyParser.Mover_propertiesContext ctx) {
        Map<String, Object> mover = new HashMap<>();

        // Radius
        if (ctx.radius_expr() != null) {
            float radius = evaluateValueExpr(ctx.radius_expr().value_expr()).floatValue();
            mover.put("radius", radius);
            identifiers.put("radius", (double) radius);
        }

        // Mass
        if (ctx.mass_expr() != null) {
            float mass = evaluateValueExpr(ctx.mass_expr().value_expr()).floatValue();
            mover.put("mass", mass);
            identifiers.put("mass", (double) mass);
        }

        // Velocity
        if (ctx.velocity_expr() != null) {
            float[] velocity = new float[2];
            velocity[0] = evaluateValueExpr(ctx.velocity_expr().x_velocity_expr().value_expr()).floatValue();
            velocity[1] = evaluateValueExpr(ctx.velocity_expr().y_velocity_expr().value_expr()).floatValue();
            mover.put("velocity", velocity);
            identifiers.put("x_velocity", (double) velocity[0]);
            identifiers.put("y_velocity", (double) velocity[1]);
        }

        // Position
        if (ctx.position_expr() != null) {
            float[] position = new float[2];
            position[0] = evaluateValueExpr(ctx.position_expr().x_position_expr().value_expr()).floatValue();
            position[1] = evaluateValueExpr(ctx.position_expr().y_position_expr().value_expr()).floatValue();
            mover.put("position", position);
            identifiers.put("x_position", (double) position[0]);
            identifiers.put("y_position", (double) position[1]);
        }

        // Color
        if (ctx.color_expr() != null) {
            float[] color = new float[3];
            color[0] = evaluateValueExpr(ctx.color_expr().red_value_expr().value_expr()).floatValue();
            color[1] = evaluateValueExpr(ctx.color_expr().green_value_expr().value_expr()).floatValue();
            color[2] = evaluateValueExpr(ctx.color_expr().blue_value_expr().value_expr()).floatValue();
            mover.put("color", color);
            identifiers.put("red_value", (double) color[0]);
            identifiers.put("green_value", (double) color[1]);
            identifiers.put("blue_value", (double) color[2]);
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
            String id = ctx.IDENTIFIER().getText().substring(1); // Remove $
            return identifiers.getOrDefault(id, 0.0);
        } else if (ctx.reference() != null) {
            // Extend logic here for reference() if needed
            return 0.0;
        } else {
            throw new IllegalArgumentException("Invalid simple value: " + ctx.getText());
        }
    }
}

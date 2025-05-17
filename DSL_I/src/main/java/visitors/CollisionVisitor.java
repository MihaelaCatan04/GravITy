package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.*;

public class CollisionVisitor extends GravITyBaseVisitor<Object> {
    private final Map<String, Object> simulation = new HashMap<>();

    public Map<String, Object> getSimulation() {
        return simulation;
    }

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {
        return visit(ctx.simulation_body());
    }

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        // ctx.physics_module() returns a single Physics_moduleContext.
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

        if (ctx.radius_expr() != null) {
            mover.put("radius", ctx.radius_expr().value_expr().getText());
        }

        if (ctx.mass_expr() != null) {
            mover.put("mass", ctx.mass_expr().value_expr().getText());
        }

        if (ctx.velocity_expr() != null) {
            Map<String, String> velocity = new HashMap<>();
            velocity.put("x_velocity", ctx.velocity_expr().x_velocity_expr().value_expr().getText());
            velocity.put("y_velocity", ctx.velocity_expr().y_velocity_expr().value_expr().getText());
            mover.put("velocity", velocity);
        }

        if (ctx.position_expr() != null) {
            Map<String, String> position = new HashMap<>();
            position.put("x_position", ctx.position_expr().x_position_expr().value_expr().getText());
            position.put("y_position", ctx.position_expr().y_position_expr().value_expr().getText());
            mover.put("position", position);
        }

        if (ctx.color_expr() != null) {
            Map<String, String> color = new HashMap<>();
            color.put("red_value", ctx.color_expr().red_value_expr().value_expr().getText());
            color.put("green_value", ctx.color_expr().green_value_expr().value_expr().getText());
            color.put("blue_value", ctx.color_expr().blue_value_expr().value_expr().getText());
            mover.put("color", color);
        }

        return mover;
    }
}

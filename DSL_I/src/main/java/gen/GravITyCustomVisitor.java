package gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GravITyCustomVisitor extends GravITyBaseVisitor<Object> {

    private Map<String, Object> simulation = new HashMap<>();

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
        if (ctx.collision() != null) {
            return visit(ctx.collision());
        }
        return null;
    }

    @Override
    public Object visitCollision(GravITyParser.CollisionContext ctx) {
        Map<String, Object> collisionModule = new HashMap<>();

        List<Object> movers = (List<Object>) visit(ctx.movers_list());

        collisionModule.put("movers", movers);

        simulation.put("collision", collisionModule);

        return collisionModule;
    }

    @Override
    public Object visitMovers_list(GravITyParser.Movers_listContext ctx) {
        List<Object> movers = new ArrayList<>();

        for (GravITyParser.MoverContext moverCtx : ctx.mover()) {
            movers.add(visit(moverCtx));
        }

        return movers;
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
            velocity.put("x", ctx.velocity_expr().x_velocity_expr().value_expr().getText());
            velocity.put("y", ctx.velocity_expr().y_velocity_expr().value_expr().getText());
            mover.put("velocity", velocity);
        }

        if (ctx.position_expr() != null) {
            Map<String, String> position = new HashMap<>();
            position.put("x", ctx.position_expr().x_position_expr().value_expr().getText());
            position.put("y", ctx.position_expr().y_position_expr().value_expr().getText());
            mover.put("position", position);
        }

        if (ctx.color_expr() != null) {
            Map<String, String> color = new HashMap<>();
            color.put("r", ctx.color_expr().red_value_expr().value_expr().getText());
            color.put("g", ctx.color_expr().green_value_expr().value_expr().getText());
            color.put("b", ctx.color_expr().blue_value_expr().value_expr().getText());
            mover.put("color", color);
        }

        return mover;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }
}

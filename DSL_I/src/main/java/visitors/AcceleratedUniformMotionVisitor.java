package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class AcceleratedUniformMotionVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {
        return visit(ctx.simulation_body());
    }

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        // Visit the first physics module (assuming accelerated_motion is there)
        return visit(ctx.physics_module(0));
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
            acceleratedMotionModule.put("initial_speed", ctx.initial_speed_expr().value_expr().getText());
        }

        // Handle initial acceleration
        if (ctx.initial_acceleration_expr() != null) {
            acceleratedMotionModule.put("initial_acceleration", ctx.initial_acceleration_expr().value_expr().getText());
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

        // Process each property of the mover, using a similar pattern to GravITyCustomVisitor
        if (ctx.radius_expr() != null) {
            mover.put("radius", ctx.radius_expr().value_expr().getText());
        }

        if (ctx.color_expr() != null) {
            Map<String, Integer> color = new HashMap<>();

            if (ctx.color_expr().red_value_expr() != null) {
                color.put("red_value", Integer.parseInt(ctx.color_expr().red_value_expr().value_expr().getText()));
            }

            if (ctx.color_expr().green_value_expr() != null) {
                color.put("green_value", Integer.parseInt(ctx.color_expr().green_value_expr().value_expr().getText()));
            }

            if (ctx.color_expr().blue_value_expr() != null) {
                color.put("blue_value", Integer.parseInt(ctx.color_expr().blue_value_expr().value_expr().getText()));
            }

            mover.put("color", color);
        }

        return mover;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }

}

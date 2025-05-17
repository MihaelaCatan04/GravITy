package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class UniformMotionVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();

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
            uniformMotionModule.put("initial_speed", ctx.initial_speed_expr().value_expr().getText());
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

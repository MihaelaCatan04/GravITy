package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class CircularMotionVisitor extends GravITyBaseVisitor<Object>{
    private Map<String, Object> simulation = new HashMap<>();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {return visit(ctx.simulation_body());}

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        return visit(ctx.physics_module(0));
    }

    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.circular_motion() != null) {
            return visit(ctx.circular_motion());
        }
        return null;
    }
    @Override
    public Object visitBall_expr(GravITyParser.Ball_exprContext ctx) {
        return visit(ctx.mover_basic_properties());
    }

    @Override
    public Object visitCircular_motion(GravITyParser.Circular_motionContext ctx) {
        Map<String, Object> circularMotionModule = new HashMap<>();

        if (ctx.radius_expr() != null) {
            circularMotionModule.put("radius", ctx.radius_expr().value_expr().getText());
        }

        if (ctx.angular_speed_expr() != null) {
            circularMotionModule.put("angular_speed", ctx.angular_speed_expr().value_expr().getText());
        }

        Map<String, Object> mover = (Map<String, Object>) visit(ctx.ball_expr());
        circularMotionModule.put("ball", mover);

        simulation.put("circular_motion", circularMotionModule);
        return circularMotionModule;
    }

    @Override
    public Object visitMover_expr(GravITyParser.Mover_exprContext ctx) {
        return visit(ctx.mover_basic_properties());
    }

    @Override
    public Object visitMover_basic_properties(GravITyParser.Mover_basic_propertiesContext ctx) {
        Map<String, Object> ball = new HashMap<>();

        if (ctx.radius_expr() != null) {
            ball.put("radius", ctx.radius_expr().value_expr().getText());
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

            ball.put("color", color);
        }

        return ball;
    }
    public Map<String, Object> getSimulation() {
        return simulation;
    }

}

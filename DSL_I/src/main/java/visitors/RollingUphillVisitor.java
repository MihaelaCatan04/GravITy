package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class RollingUphillVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {return visit(ctx.simulation_body());}

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        return visit(ctx.physics_module(0));
    }

    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.rolling_uphill() != null) {
            return visit(ctx.rolling_uphill());
        }
        return null;
    }

    @Override
    public Object visitRolling_uphill(GravITyParser.Rolling_uphillContext ctx) {
        Map<String, Object> rollingUphillModule = new HashMap<>();

        if (ctx.gravitational_acceleration_expr() != null) {
            rollingUphillModule.put("gravitational_acceleration",
                    ctx.gravitational_acceleration_expr().value_expr().getText());
        }

        if (ctx.coefficient_of_friction_expr() != null) {
            rollingUphillModule.put("coefficient_of_friction",
                    ctx.coefficient_of_friction_expr().value_expr().getText());
        }

        if (ctx.bounciness_expr() != null) {
            rollingUphillModule.put("bounciness",
                    ctx.bounciness_expr().value_expr().getText());
        }

        if (ctx.angle_expr() != null) {
            rollingUphillModule.put("angle",
                    ctx.angle_expr().value_expr().getText());
        }

        if (ctx.velocity_along_incline_expr() != null) {
            rollingUphillModule.put("velocity_along_incline",
                    ctx.velocity_along_incline_expr().value_expr().getText());
        }

        if (ctx.ball_expr() != null) {
            Map<String, Object> ball = (Map<String, Object>) visit(ctx.ball_expr());
            rollingUphillModule.put("ball", ball);
        }

        simulation.put("rolling_uphill", rollingUphillModule);
        return rollingUphillModule;
    }

    @Override
    public Object visitBall_expr(GravITyParser.Ball_exprContext ctx) {
        return visit(ctx.mover_basic_properties());
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

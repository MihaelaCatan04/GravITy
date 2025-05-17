package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class SpringVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {return visit(ctx.simulation_body());}

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        return visit(ctx.physics_module(0));
    }

    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.spring() != null) {
            return visit(ctx.spring());
        }
        return null;
    }

    @Override
    public Object visitSpring(GravITyParser.SpringContext ctx) {
        Map<String, Object> springModule = new HashMap<>();

        if (ctx.spring_constant_expr() != null) {
            springModule.put("spring_constant", ctx.spring_constant_expr().value_expr().getText());
        }

        if (ctx.damping_expr() != null) {
            springModule.put("damping", ctx.damping_expr().value_expr().getText());
        }

        if (ctx.spring_rest_length_expr() != null) {
            springModule.put("spring_rest_length", ctx.spring_rest_length_expr().value_expr().getText());
        }

        if (ctx.floor_friction_expr() != null) {
            springModule.put("floor_friction", ctx.floor_friction_expr().value_expr().getText());
        }

        if (ctx.ball_expr() != null) {
            Map<String, Object> ballConfig = (Map<String, Object>) visit(ctx.ball_expr());
            springModule.put("ball", ballConfig);
        }

        if (ctx.spring_expr() != null) {
            Map<String, Object> springConfig = (Map<String, Object>) visit(ctx.spring_expr());
            springModule.put("spring", springConfig);
        }

        simulation.put("spring", springModule);

        return springModule;
    }

    @Override
    public Object visitSpring_expr(GravITyParser.Spring_exprContext ctx) {
        Map<String, Object> springConfig = new HashMap<>();

        if (ctx.x_anchor_position_expr() != null) {
            springConfig.put("x_anchor_position", ctx.x_anchor_position_expr().value_expr().getText());
        }

        if (ctx.y_anchor_position_expr() != null) {
            springConfig.put("y_anchor_position", ctx.y_anchor_position_expr().value_expr().getText());
        }

        if (ctx.num_coils_expr() != null) {
            springConfig.put("num_coils", ctx.num_coils_expr().value_expr().getText());
        }

        return springConfig;
    }

    @Override
    public Object visitBall_expr(GravITyParser.Ball_exprContext ctx) {
        Map<String, Object> ballConfig = new HashMap<>();

        if (ctx.mover_basic_properties().radius_expr() != null) {
            ballConfig.put("radius", ctx.mover_basic_properties().radius_expr().value_expr().getText());
        }


        if (ctx.mover_basic_properties().color_expr() != null) {
            Map<String, String> color = new HashMap<>();
            color.put("r", ctx.mover_basic_properties().color_expr().red_value_expr().value_expr().getText());
            color.put("g", ctx.mover_basic_properties().color_expr().green_value_expr().value_expr().getText());
            color.put("b", ctx.mover_basic_properties().color_expr().blue_value_expr().value_expr().getText());
            ballConfig.put("color", color);
        }

        return ballConfig;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }
}

package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class DragForceVisitor extends GravITyBaseVisitor<Object> {

    private Map<String, Object> simulation = new HashMap<>();

    public Map<String, Object> getSimulation() {
        return simulation;
    }

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
        if (ctx.drag_force() != null) {
            return visit(ctx.drag_force());
        }
        return null;
    }

    @Override
    public Object visitDrag_force(GravITyParser.Drag_forceContext ctx) {
        Map<String, Object> dragForceModule = new HashMap<>();

        if (ctx.drag_coefficient_expr() != null) {
            dragForceModule.put("drag_coefficient", visit(ctx.drag_coefficient_expr()));
        }

        if (ctx.mover_color_expr() != null) {
            dragForceModule.put("mover_color", visit(ctx.mover_color_expr()));
        }

        if (ctx.liquid_color_expr() != null) {
            dragForceModule.put("liquid_color", visit(ctx.liquid_color_expr()));
        }

        simulation.put("drag_force", dragForceModule);
        return dragForceModule;
    }

    @Override
    public Object visitMover_color_expr(GravITyParser.Mover_color_exprContext ctx) {
        Map<String, String> color = new HashMap<>();
        if (ctx.red_value_expr() != null) {
            color.put("red_value", ctx.red_value_expr().value_expr().getText());
        }
        if (ctx.green_value_expr() != null) {
            color.put("green_value", ctx.green_value_expr().value_expr().getText());
        }
        if (ctx.blue_value_expr() != null) {
            color.put("blue_value", ctx.blue_value_expr().value_expr().getText());
        }
        return color;
    }

    @Override
    public Object visitLiquid_color_expr(GravITyParser.Liquid_color_exprContext ctx) {
        Map<String, String> color = new HashMap<>();
        if (ctx.red_value_expr() != null) {
            color.put("red_value", ctx.red_value_expr().value_expr().getText());
        }
        if (ctx.green_value_expr() != null) {
            color.put("green_value", ctx.green_value_expr().value_expr().getText());
        }
        if (ctx.blue_value_expr() != null) {
            color.put("blue_value", ctx.blue_value_expr().value_expr().getText());
        }
        return color;
    }

    @Override
    public Object visitDrag_coefficient_expr(GravITyParser.Drag_coefficient_exprContext ctx) {
        return ctx.value_expr().getText();
    }
}
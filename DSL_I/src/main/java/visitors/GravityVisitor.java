package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class GravityVisitor extends GravITyBaseVisitor<Object> {

    private Map<String, Object> simulation = new HashMap<>();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {
        return visit(ctx.simulation_body());
    }

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        return visit(ctx.physics_module(0));
    }

    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.gravity() != null) {
            return visit(ctx.gravity());
        }
        return null;
    }

    @Override
    public Object visitGravity(GravITyParser.GravityContext ctx) {
        Map<String, Object> gravityModule = new HashMap<>();

        if (ctx.earth_expr() != null) {
            gravityModule.put("earth", visit(ctx.earth_expr()));
        }

        if (ctx.moon_expr() != null) {
            gravityModule.put("moon", visit(ctx.moon_expr()));
        }

        simulation.put("gravity", gravityModule);
        return gravityModule;
    }

    @Override
    public Object visitEarth_expr(GravITyParser.Earth_exprContext ctx) {
        Map<String, Object> earth = new HashMap<>();
        earth.put("position", visit(ctx.position_expr()));
        return earth;
    }

    @Override
    public Object visitMoon_expr(GravITyParser.Moon_exprContext ctx) {
        Map<String, Object> moon = new HashMap<>();
        moon.put("position", visit(ctx.position_expr()));
        return moon;
    }

    @Override
    public Object visitPosition_expr(GravITyParser.Position_exprContext ctx) {
        Map<String, String> position = new HashMap<>();
        position.put("x_position", ctx.x_position_expr().value_expr().getText());
        position.put("y_position", ctx.y_position_expr().value_expr().getText());
        return position;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }
}

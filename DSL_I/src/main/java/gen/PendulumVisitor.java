package gen;

import java.util.HashMap;
import java.util.Map;

public class PendulumVisitor extends GravITyBaseVisitor<Object> {

    private Map<String, Object> simulation = new HashMap<>();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {
        return visit(ctx.simulation_body());
    }

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        // Search Pendulum module
        for (GravITyParser.Physics_moduleContext moduleCtx : ctx.physics_module()) {
            if (moduleCtx.pendulum() != null) {
                return visit(moduleCtx.pendulum());
            }
        }
        return null;
    }

    @Override
    public Object visitPendulum(GravITyParser.PendulumContext ctx) {
        Map<String, Object> pendulumModule = new HashMap<>();

        // Extract every available expression and add it to the map
        if (ctx.length_expr() != null) {
            pendulumModule.put("length", ctx.length_expr().value_expr().getText());
        }
        if (ctx.ball_radius_expr() != null) {
            pendulumModule.put("ball_radius", ctx.ball_radius_expr().value_expr().getText());
        }
        if (ctx.initial_angle_expr() != null) {
            pendulumModule.put("initial_angle", ctx.initial_angle_expr().value_expr().getText());
        }
        if (ctx.angular_velocity_expr() != null) {
            pendulumModule.put("angular_velocity", ctx.angular_velocity_expr().value_expr().getText());
        }
        if (ctx.angular_acceleration_expr() != null) {
            pendulumModule.put("angular_acceleration", ctx.angular_acceleration_expr().value_expr().getText());
        }
        if (ctx.air_resistance_expr() != null) {
            pendulumModule.put("air_resistance", ctx.air_resistance_expr().value_expr().getText());
        }

        simulation.put("pendulum", pendulumModule);
        return pendulumModule;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }
}

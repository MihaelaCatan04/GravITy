package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class WaveVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {
        return visit(ctx.simulation_body());
    }

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        //  ctx.physics_module() returns a single Physics_moduleContext.
        GravITyParser.Physics_moduleContext moduleCtx = ctx.physics_module();
        if (moduleCtx.wave() != null) {
            return visit(moduleCtx.wave());
        }
        return null;
    }


    @Override
    public Object visitWave(GravITyParser.WaveContext ctx) {
        Map<String, Object> waveModule = new HashMap<>();

        if (ctx.start_angle_expr() != null) {
            waveModule.put("start_angle", ctx.start_angle_expr().value_expr().getText());
        }
        if (ctx.angle_velocity_expr() != null) {
            waveModule.put("angle_velocity", ctx.angle_velocity_expr().value_expr().getText());
        }
        if (ctx.amplitude_expr() != null) {
            waveModule.put("amplitude", ctx.amplitude_expr().value_expr().getText());
        }
        if (ctx.frequency_expr() != null) {
            waveModule.put("frequency", ctx.frequency_expr().value_expr().getText());
        }
        if (ctx.phase_shift_expr() != null) {
            waveModule.put("phase_shift", ctx.phase_shift_expr().value_expr().getText());
        }

        simulation.put("wave", waveModule);
        return waveModule;
    }
    public Map<String, Object> getSimulation() {
        return simulation;
    }
}

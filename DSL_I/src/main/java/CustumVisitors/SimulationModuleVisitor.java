package CustumVisitors;
import gen.GravITyBaseVisitor;
import gen.GravITyParser;

public class SimulationModuleVisitor extends GravITyBaseVisitor<String> {

    @Override
    public String visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.pendulum() != null) {
            return "pendulum";
        }
        if (ctx.collision() != null) {
            return "collision";
        }
        if (ctx.electrostatic_field() != null) {
            return "electrostatic_field";
        }
        if (ctx.drag_force() != null) {
            return "drag_force";
        }
        if (ctx.attraction_force() != null) {
            return "attraction_force";
        }
        if (ctx.wave() != null) {
            return "wave";
        }
        if (ctx.uniform_motion() != null) {
            return "uniform_motion";
        }
        if (ctx.accelerated_motion() != null) {
            return "accelerated_motion";
        }
        if (ctx.circular_motion() != null) {
            return "circular_motion";
        }
        if (ctx.gravity() != null) {
            return "gravity";
        }
        if (ctx.spring() != null) {
            return "spring";
        }
        if (ctx.rolling_downhill() != null) {
            return "rolling_downhill";
        }
        return "unknown";
    }
}

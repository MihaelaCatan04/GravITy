package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class AttractionForceVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();

    @Override
    public Object visitAttraction_force(GravITyParser.Attraction_forceContext ctx) {
        Map<String, Object> forceModule = new HashMap<>();

        // Process mover1
        Map<String, Object> mover1 = (Map<String, Object>) visit(ctx.mover1_expr());
        forceModule.put("mover1", mover1);

        // Process mover2
        Map<String, Object> mover2 = (Map<String, Object>) visit(ctx.mover2_expr());
        forceModule.put("mover2", mover2);

        simulation.put("attraction_force", forceModule);

        return forceModule;
    }

    @Override
    public Object visitMover1_expr(GravITyParser.Mover1_exprContext ctx) {
        return visit(ctx.mover_properties());
    }

    @Override
    public Object visitMover2_expr(GravITyParser.Mover2_exprContext ctx) {
        return visit(ctx.mover_properties());
    }

    @Override
    public Object visitMover_properties(GravITyParser.Mover_propertiesContext ctx) {
        Map<String, Object> mover = new HashMap<>();

        mover.put("radius", Float.parseFloat(ctx.radius_expr().value_expr().getText()));
        mover.put("mass", Float.parseFloat(ctx.mass_expr().value_expr().getText()));

        float[] position = new float[2];
        position[0] = Float.parseFloat(ctx.position_expr().x_position_expr().value_expr().getText());
        position[1] = Float.parseFloat(ctx.position_expr().y_position_expr().value_expr().getText());
        mover.put("position", position);

        float[] velocity = new float[2];
        velocity[0] = Float.parseFloat(ctx.velocity_expr().x_velocity_expr().value_expr().getText());
        velocity[1] = Float.parseFloat(ctx.velocity_expr().y_velocity_expr().getText());
        mover.put("velocity", velocity);

        return mover;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }
}

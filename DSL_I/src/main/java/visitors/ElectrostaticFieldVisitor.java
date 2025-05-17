package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class ElectrostaticFieldVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();

    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {return visit(ctx.simulation_body());}

    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        return visit(ctx.physics_module(0));
    }

    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        if (ctx.electrostatic_field() != null) {
            return visit(ctx.electrostatic_field());
        }
        return null;
    }

    @Override
    public Object visitElectrostatic_field(GravITyParser.Electrostatic_fieldContext ctx) {
        Map<String, Object> electrostaticField = new HashMap<>();

        if (ctx.particle_radius_expr() != null) {
            String radiusValue = ctx.particle_radius_expr().value_expr().getText();
            electrostaticField.put("particle_radius", radiusValue);
        }

        if (ctx.flux_resolution_expr() != null) {
            String fluxValue = ctx.flux_resolution_expr().value_expr().getText();
            electrostaticField.put("flux_resolution", fluxValue);
        }

        simulation.put("electrostatic_field", electrostaticField);
        return electrostaticField;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }
}
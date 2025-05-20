package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class ElectrostaticFieldVisitor extends GravITyBaseVisitor<Object> {
    private Map<String, Object> simulation = new HashMap<>();
    private Map<String, Double> identifiers = new HashMap<>();

    private ConditionalValueEvaluator conditionalEvaluator = new ConditionalValueEvaluator();
    private LoopValueEvaluator loopEvaluator = new LoopValueEvaluator();

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
        if (ctx.electrostatic_field() != null) {
            return visit(ctx.electrostatic_field());
        }
        return null;
    }

    @Override
    public Object visitElectrostatic_field(GravITyParser.Electrostatic_fieldContext ctx) {
        Map<String, Object> electrostaticField = new HashMap<>();

        if (ctx.particle_radius_expr() != null) {
            Double radiusValue = evaluateValueExpr(ctx.particle_radius_expr().value_expr());
            // Convert to int (rounding) and then to String for main's parseInt
            electrostaticField.put("particle_radius", String.valueOf((int) Math.round(radiusValue)));
            identifiers.put("particle_radius", radiusValue);
        }

        if (ctx.flux_resolution_expr() != null) {
            Double fluxValue = evaluateValueExpr(ctx.flux_resolution_expr().value_expr());
            // Convert to int (rounding) and then to String for main's parseInt
            electrostaticField.put("flux_resolution", String.valueOf((int) Math.round(fluxValue)));
            identifiers.put("flux_resolution", fluxValue);
        }

        simulation.put("electrostatic_field", electrostaticField);
        return electrostaticField;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }

    private Double evaluateValueExpr(GravITyParser.Value_exprContext ctx) {
        if (ctx.simple_value() != null) {
            return evaluateSimpleValue(ctx.simple_value());
        } else if (ctx.conditional_value() != null) {
            return conditionalEvaluator.evaluate(ctx.conditional_value(), identifiers);
        } else if (ctx.loop_value() != null) {
            return loopEvaluator.evaluate(ctx.loop_value());
        } else {
            System.err.println("Warning: Unhandled value expression type: " + ctx.getText());
            return 0.0;
        }
    }

    private Double evaluateSimpleValue(GravITyParser.Simple_valueContext ctx) {
        if (ctx.NUMBER() != null) {
            return Double.parseDouble(ctx.NUMBER().getText());
        } else if (ctx.IDENTIFIER() != null) {
            String identifier = ctx.IDENTIFIER().getText();
            if (identifier.startsWith("_")) {
                identifier = identifier.substring(1);
            }
            if (identifiers.containsKey(identifier)) {
                return identifiers.get(identifier);
            } else {
                System.err.println("Warning: Identifier '" + ctx.IDENTIFIER().getText() + "' not found. Returning 0.0");
                return 0.0;
            }
        } else if (ctx.reference() != null) {
            System.err.println("Warning: Reference '" + ctx.reference().getText() + "' handling not implemented. Returning 0.0");
            return 0.0;
        } else {
            throw new IllegalArgumentException("Invalid simple value: " + ctx.getText());
        }
    }
}
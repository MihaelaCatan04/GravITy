package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class DragForceVisitor extends GravITyBaseVisitor<Object> {

    private Map<String, Object> simulation = new HashMap<>();
    private Map<String, Double> identifiers = new HashMap<>(); // To store declared identifiers and their values

    private ConditionalValueEvaluator conditionalEvaluator = new ConditionalValueEvaluator();
    private LoopValueEvaluator loopEvaluator = new LoopValueEvaluator();


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
            Double dragCoefficient = evaluateValueExpr(ctx.drag_coefficient_expr().value_expr());
            dragForceModule.put("drag_coefficient", dragCoefficient);
            identifiers.put("drag_coefficient", dragCoefficient);
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
        // CHANGED: Map stores String values for color components
        Map<String, String> color = new HashMap<>();
        if (ctx.red_value_expr() != null) {
            Double redValue = evaluateValueExpr(ctx.red_value_expr().value_expr());
            // Store as String
            color.put("red_value", String.valueOf((int) Math.round(redValue)));
            identifiers.put("mover_red_value", redValue);
        }
        if (ctx.green_value_expr() != null) {
            Double greenValue = evaluateValueExpr(ctx.green_value_expr().value_expr());
            // Store as String
            color.put("green_value", String.valueOf((int) Math.round(greenValue)));
            identifiers.put("mover_green_value", greenValue);
        }
        if (ctx.blue_value_expr() != null) {
            Double blueValue = evaluateValueExpr(ctx.blue_value_expr().value_expr());
            // Store as String
            color.put("blue_value", String.valueOf((int) Math.round(blueValue)));
            identifiers.put("mover_blue_value", blueValue);
        }
        return color;
    }

    @Override
    public Object visitLiquid_color_expr(GravITyParser.Liquid_color_exprContext ctx) {
        // CHANGED: Map stores String values for color components
        Map<String, String> color = new HashMap<>();
        if (ctx.red_value_expr() != null) {
            Double redValue = evaluateValueExpr(ctx.red_value_expr().value_expr());
            // Store as String
            color.put("red_value", String.valueOf((int) Math.round(redValue)));
            identifiers.put("liquid_red_value", redValue);
        }
        if (ctx.green_value_expr() != null) {
            Double greenValue = evaluateValueExpr(ctx.green_value_expr().value_expr());
            // Store as String
            color.put("green_value", String.valueOf((int) Math.round(greenValue)));
            identifiers.put("liquid_green_value", greenValue);
        }
        if (ctx.blue_value_expr() != null) {
            Double blueValue = evaluateValueExpr(ctx.blue_value_expr().value_expr());
            // Store as String
            color.put("blue_value", String.valueOf((int) Math.round(blueValue)));
            identifiers.put("liquid_blue_value", blueValue);
        }
        return color;
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
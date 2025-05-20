package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class GravityVisitor extends GravITyBaseVisitor<Object> {

    private Map<String, Object> simulation = new HashMap<>();
    private Map<String, Double> identifiers = new HashMap<>(); // To store declared identifiers and their values

    // Assuming you have these evaluators available
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

        // Use evaluateValueExpr and store as String
        Double xValue = evaluateValueExpr(ctx.x_position_expr().value_expr());
        position.put("x_position", String.valueOf(xValue));
        identifiers.put("x_position", xValue); // Store in identifiers

        // Use evaluateValueExpr and store as String
        Double yValue = evaluateValueExpr(ctx.y_position_expr().value_expr());
        position.put("y_position", String.valueOf(yValue));
        identifiers.put("y_position", yValue); // Store in identifiers

        return position;
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }

    // --- Helper Methods for Value Evaluation ---

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
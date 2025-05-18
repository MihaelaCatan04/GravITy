package visitors;

import gen.GravITyParser;

import java.util.Map;

public class ConditionalValueEvaluator {

    public Double evaluate(GravITyParser.Conditional_valueContext ctx, Map<String, Double> identifiers) {
        GravITyParser.ConditionContext conditionContext = ctx.condition();
        GravITyParser.Simple_valueContext thenValueContext = ctx.simple_value(0);
        GravITyParser.Simple_valueContext elseValueContext = ctx.simple_value(1);

        boolean conditionResult = evaluateCondition(conditionContext, identifiers);

        if (conditionResult) {
            return evaluateSimpleValue(thenValueContext, identifiers);
        } else {
            return evaluateSimpleValue(elseValueContext, identifiers);
        }
    }

    private boolean evaluateCondition(GravITyParser.ConditionContext ctx, Map<String, Double> identifiers) {
        double leftValue = evaluateSimpleValue(ctx.simple_value(0), identifiers);
        double rightValue = evaluateSimpleValue(ctx.simple_value(1), identifiers);
        String comparator = ctx.comparator().getText();

        switch (comparator) {
            case ">":
                return leftValue > rightValue;
            case "<":
                return leftValue < rightValue;
            case "==":
                return leftValue == rightValue;
            case ">=":
                return leftValue >= rightValue;
            case "<=":
                return leftValue <= rightValue;
            case "!=":
                return leftValue != rightValue;
            default:
                throw new IllegalArgumentException("Unknown comparator: " + comparator);
        }
    }

    private double evaluateSimpleValue(GravITyParser.Simple_valueContext ctx, Map<String, Double> identifiers) {
        if (ctx.NUMBER() != null) {
            return Double.parseDouble(ctx.NUMBER().getText());
        } else if (ctx.IDENTIFIER() != null) {
            String identifier = ctx.IDENTIFIER().getText().substring(1); // Remove the leading '_'
            if (identifiers.containsKey(identifier)) {
                return identifiers.get(identifier);
            } else {
                System.err.println("Warning: Identifier '" + ctx.IDENTIFIER().getText() + "' not found. Returning 0.0");
                return 0.0;
            }
        } else if (ctx.reference() != null) {
            // Handle references (object.property) - requires more context about your simulation objects
            // For now, return a default value
            return 0.0;
        } else {
            throw new IllegalArgumentException("Invalid simple value: " + ctx.getText());
        }
    }
}
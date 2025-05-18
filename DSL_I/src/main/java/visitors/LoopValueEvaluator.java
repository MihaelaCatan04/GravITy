package visitors;

import gen.GravITyParser;

public class LoopValueEvaluator {

    public Double evaluate(GravITyParser.Loop_valueContext ctx) {
        double initialValue = evaluateSimpleValue(ctx.initial_value().getText());
        int repeatTimes = evaluateSimpleValueToInt(ctx.simple_value()); // First value_expr is repeat times
        double multiplier = evaluateSimpleValue(ctx.multiplier().getText());  // Second value_expr is multiplier
        System.out.println(ctx.simple_value());

        double result = initialValue;
        for (int i = 0; i < repeatTimes; i++) {
            result *= multiplier;
        }
        return result;
    }

    private int evaluateSimpleValueToInt(GravITyParser.Simple_valueContext ctx) {
        return (int) Math.floor(evaluateSimpleValue(ctx.getText()));
    }

    private double evaluateSimpleValue(String valueStr) {
        valueStr = valueStr.trim();

        // Try to parse as a number
        try {
            return Double.parseDouble(valueStr);
        } catch (NumberFormatException e) {
            // Not a number
        }
        throw new IllegalArgumentException("Invalid simple value: " + valueStr);
    }

}
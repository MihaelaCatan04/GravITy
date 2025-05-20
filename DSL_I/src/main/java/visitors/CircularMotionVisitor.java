package visitors;

import gen.GravITyBaseVisitor;
import gen.GravITyParser;

import java.util.HashMap;
import java.util.Map;

public class CircularMotionVisitor extends GravITyBaseVisitor<Object> {
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
        if (ctx.circular_motion() != null) {
            return visit(ctx.circular_motion());
        }
        return null;
    }

    @Override
    public Object visitCircular_motion(GravITyParser.Circular_motionContext ctx) {
        Map<String, Object> circularMotionModule = new HashMap<>();

        if (ctx.radius_expr() != null) {
            float radius = evaluateValueExpr(ctx.radius_expr().value_expr()).floatValue();
            circularMotionModule.put("radius", radius);
            identifiers.put("radius", (double) radius);
        }

        if (ctx.angular_speed_expr() != null) {
            float angularSpeed = evaluateValueExpr(ctx.angular_speed_expr().value_expr()).floatValue();
            circularMotionModule.put("angular_speed", angularSpeed);
            identifiers.put("angular_speed", (double) angularSpeed);
        }

        Map<String, Object> ball = (Map<String, Object>) visit(ctx.ball_expr());
        circularMotionModule.put("ball", ball);

        simulation.put("circular_motion", circularMotionModule);

        System.out.println(identifiers);
        return circularMotionModule;
    }

    @Override
    public Object visitBall_expr(GravITyParser.Ball_exprContext ctx) {
        return visit(ctx.mover_basic_properties());
    }

    @Override
    public Object visitMover_expr(GravITyParser.Mover_exprContext ctx) {
        return visit(ctx.mover_basic_properties());
    }

    @Override
    public Object visitMover_basic_properties(GravITyParser.Mover_basic_propertiesContext ctx) {
        Map<String, Object> ball = new HashMap<>();

        if (ctx.radius_expr() != null) {
            float radius = evaluateValueExpr(ctx.radius_expr().value_expr()).floatValue();
            ball.put("radius", radius);
            identifiers.put("ball_radius", (double) radius);// o sa trebuiasca de schimbat pe viitor
        }


        if (ctx.color_expr() != null) {
            Map<String, Integer> color = new HashMap<>();

            if (ctx.color_expr().red_value_expr() != null) {
                int red = evaluateValueExpr(ctx.color_expr().red_value_expr().value_expr()).intValue();
                color.put("red_value", red);
                identifiers.put("red_value", (double) red);
            }

            if (ctx.color_expr().green_value_expr() != null) {
                int green = evaluateValueExpr(ctx.color_expr().green_value_expr().value_expr()).intValue();
                color.put("green_value", green);
                identifiers.put("green_value", (double) green);
            }

            if (ctx.color_expr().blue_value_expr() != null) {
                int blue = evaluateValueExpr(ctx.color_expr().blue_value_expr().value_expr()).intValue();
                color.put("blue_value", blue);
                identifiers.put("blue_value", (double) blue);
            }

            ball.put("color", color);
        }

        return ball;
    }

    private Double evaluateValueExpr(GravITyParser.Value_exprContext ctx) {
        if (ctx.simple_value() != null) {
            return evaluateSimpleValue(ctx.simple_value());
        } else if (ctx.conditional_value() != null) {
            return conditionalEvaluator.evaluate(ctx.conditional_value(), identifiers);
        } else if (ctx.loop_value() != null) {
            return loopEvaluator.evaluate(ctx.loop_value());
        } else {
            return 0.0;
        }
    }

    private Double evaluateSimpleValue(GravITyParser.Simple_valueContext ctx) {
        if (ctx.NUMBER() != null) {
            return Double.parseDouble(ctx.NUMBER().getText());
        } else if (ctx.IDENTIFIER() != null) {
            String identifier = ctx.IDENTIFIER().getText().substring(1);
            if (identifiers.containsKey(identifier)) {
                return identifiers.get(identifier);
            } else {
                System.err.println("Warning: Identifier '" + identifier + "' not found. Returning 0.0");
                return 0.0;
            }
        } else if (ctx.reference() != null) {
            // Logică de referință — placeholder (poți extinde aici dacă ai nevoie)
            return 0.0;
        } else {
            throw new IllegalArgumentException("Invalid simple value: " + ctx.getText());
        }
    }

    public Map<String, Object> getSimulation() {
        return simulation;
    }
}

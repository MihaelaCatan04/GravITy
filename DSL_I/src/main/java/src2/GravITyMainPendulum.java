package src2;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import gen.*;

import java.util.*;

public class GravITyMainPendulum {
    public static void main(String[] args) {
        String input = """
                simulation{
                    pendulum{
                        length: 200
                        ball_radius: 20
                        initial_angle: 0.1
                        angular_velocity: 0
                        angular_acceleration: 0
                        air_resistance: 0
                    }
                }
                """;

        // Creăm lexer și parser
        CharStream charStream = CharStreams.fromString(input);
        GravITyLexer lexer = new GravITyLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GravITyParser parser = new GravITyParser(tokens);

        // Parsăm inputul
        ParseTree tree = parser.simulation();

        // Vizitatorul pentru pendulum
        PendulumVisitor visitor = new PendulumVisitor();
        visitor.visit(tree);

        Map<String, Object> sim = visitor.getSimulation();

        if (sim.containsKey("pendulum")) {
            Map<String, Object> p = (Map<String, Object>) sim.get("pendulum");

            // Parsăm valorile în float (valorile din DSL sunt stringuri)
            float length = Float.parseFloat(p.get("length").toString());
            float radius = Float.parseFloat(p.get("ball_radius").toString());
            float angle = Float.parseFloat(p.get("initial_angle").toString());
            float angleV = Float.parseFloat(p.get("angular_velocity").toString());
            float angleA = Float.parseFloat(p.get("angular_acceleration").toString());
            float airResistance = Float.parseFloat(p.get("air_resistance").toString());

            // Pornește simularea cu parametrii
            Pendulum.runPendulum(length, radius, angle, angleV, angleA, airResistance);
        }
    }
}

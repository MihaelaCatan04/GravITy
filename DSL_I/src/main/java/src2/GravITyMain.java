package src2;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import gen.*;
import processing.core.PApplet;

import java.util.*;

// this function is for collision simulations !!!
public class GravITyMain {
    public static void main(String[] args) {
        String input = """
                simulation{
                    pendulum{
                        length: 200
                        ball_radius: 20
                        initial_angle: 4
                        angular_velocity: 1
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

        // Vizitatorul custom
        GravITyCustomVisitor visitor = new GravITyCustomVisitor();
        visitor.visit(tree);

        // Obținem datele despre simulare
        Map<String, Object> simulation = visitor.getSimulation();

        System.out.println(simulation);

        // Extragem și afișăm datele despre collision și movers
        if (simulation.containsKey("collision")) {
            Map<String, Object> collision = (Map<String, Object>) simulation.get("collision");
            List<Map<String, Object>> movers = (List<Map<String, Object>>) collision.get("movers");

            for (Map<String, Object> mover : movers) {
                System.out.println("Mover Properties:");
                System.out.println("  Radius: " + mover.get("radius"));
                System.out.println("  Mass: " + mover.get("mass"));

                Map<String, String> velocity = (Map<String, String>) mover.get("velocity");
                System.out.println("  Velocity: x=" + velocity.get("x") + ", y=" + velocity.get("y"));

                Map<String, String> position = (Map<String, String>) mover.get("position");
                System.out.println("  Position: x=" + position.get("x") + ", y=" + position.get("y"));

                Map<String, String> color = (Map<String, String>) mover.get("color");
                System.out.println("  Color: R=" + color.get("r") + ", G=" + color.get("g") + ", B=" + color.get("b"));
            }
        }


        if (simulation.containsKey("collision")) {
            Map<String, Object> collision = (Map<String, Object>) simulation.get("collision");
            List<Map<String, Object>> movers = (List<Map<String, Object>>) collision.get("movers");

            // Construim argumentele pentru Processing
            List<String> argsList = new ArrayList<>();
            argsList.add("src2.Collision"); // numele clasei Processing

            for (Map<String, Object> mover : movers) {
                float radius = Float.parseFloat(mover.get("radius").toString());
                float mass = Float.parseFloat(mover.get("mass").toString());

                Map<String, String> velocity = (Map<String, String>) mover.get("velocity");
                Map<String, String> position = (Map<String, String>) mover.get("position");
                Map<String, String> color = (Map<String, String>) mover.get("color");

                argsList.add(radius + "," + mass + "," +
                        velocity.get("x") + "," + velocity.get("y") + "," +
                        position.get("x") + "," + position.get("y") + "," +
                        color.get("r") + "," + color.get("g") + "," + color.get("b"));
            }

            //System.out.println(argsList);
            processing.core.PApplet.main(argsList.toArray(new String[0]));
        }

    }
}


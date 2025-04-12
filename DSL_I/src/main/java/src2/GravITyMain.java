package src2;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import gen.*;

import java.util.*;

public class GravITyMain {
    public static void main(String[] args) {
        String input = """
            simulation {
                collision {
                    mover {
                        radius: 10
                        mass: 3
                        velocity { x_velocity: 2 y_velocity: 3 }
                        position { x_position: 50 y_position: 50 }
                        color { red_value: 255 green_value: 0 blue_value: 0 }
                    }
                    mover {
                        radius: 1
                        mass: 30
                        velocity { x_velocity: 20 y_velocity: 30 }
                        position { x_position: 50 y_position: 50 }
                        color { red_value: 255 green_value: 0 blue_value: 0 }
                    }
                }
            }""";

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
    }
}


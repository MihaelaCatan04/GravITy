package src;

import gen.GravITyLexer;
import gen.GravITyParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import processing.AcceleratedUniformMotion;
import visitors.AcceleratedUniformMotionVisitor;

import java.util.Map;

public class GravITyMainAcceleratedUniformMotion {
    public static void main(String[] args) {
        String input = """
                simulation {
                    accelerated_motion {
                        mover {
                            radius: 50
                            color {
                                red_value: 0
                                green_value: 150
                                blue_value: 255
                            }
                        }
                        initial_speed: 5 
                        initial_acceleration: 0.005
                    }
                }
                """;

        CharStream charStream = CharStreams.fromString(input);
        GravITyLexer lexer = new GravITyLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GravITyParser parser = new GravITyParser(tokens);
        ParseTree tree = parser.simulation();

        AcceleratedUniformMotionVisitor visitor = new AcceleratedUniformMotionVisitor();
        visitor.visit(tree);

        Map<String, Object> sim = visitor.getSimulation();

        if (sim.containsKey("accelerated_motion")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("accelerated_motion");

            // Debugging output to see what we're working with
            System.out.println("Simulation Map: " + sim);
            System.out.println("Module Map: " + module);

            float initialSpeed = 0;
            // Check if 'initial_speed' exists before accessing
            if (module.containsKey("initial_speed")) {
                initialSpeed = Float.parseFloat(module.get("initial_speed").toString());
            } else {
                System.err.println("Error: initial_speed is missing");
                return;
            }

            float initialAcceleration = 0;
            // Check if 'initial_acceleration' exists before accessing
            if (module.containsKey("initial_acceleration")) {
                initialAcceleration = Float.parseFloat(module.get("initial_acceleration").toString());
            } else {
                System.err.println("Error: initial_acceleration is missing");
                return;
            }

            // The mover should be a single object not a list in this implementation
            Map<String, Object> mover = (Map<String, Object>) module.get("mover");

            // Check if 'mover' and its properties exist
            if (mover != null && mover.containsKey("radius") && mover.containsKey("color")) {
                float radius = Float.parseFloat(mover.get("radius").toString());

                Map<String, Integer> color = (Map<String, Integer>) mover.get("color");
                if (color != null) {
                    int[] fillColor = {
                            color.get("red_value"),
                            color.get("green_value"),
                            color.get("blue_value")
                    };

                    AcceleratedUniformMotion.runAcceleratedUniformMotion(radius, fillColor, initialSpeed, initialAcceleration);
                } else {
                    System.err.println("Error: color information is missing");
                }
            } else {
                System.err.println("Error: mover or its properties are missing");
            }
        }
    }
}
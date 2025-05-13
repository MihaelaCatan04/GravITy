package src;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import gen.*;
import processing.*;
import visitors.*;

import java.util.*;

public class GravITyMain {
    public static void main(String[] args) {
        String input = """
                simulation {
                    uniform_motion {
                        mover {
                            radius: 20
                            color {
                                red_value: 50
                                green_value: 0
                                blue_value: 0
                            }
                        }
                        initial_speed: 4
                    }
                }
                """;

        // Create lexer and parser
        CharStream charStream = CharStreams.fromString(input);
        GravITyLexer lexer = new GravITyLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GravITyParser parser = new GravITyParser(tokens);

        // Parse input
        ParseTree tree = parser.simulation();

        // Create a null sim
        Map<String, Object> sim = null;

        // Choose a visitor based on the simulation type
        GravITyCustomVisitor visitor = null;
        if (input.contains("attraction_force")) {
            AttractionForceVisitor forceVisitor = new AttractionForceVisitor();
            forceVisitor.visit(tree);
            sim = forceVisitor.getSimulation();
        } else if (input.contains("pendulum")) {
            PendulumVisitor pendulumVisitor = new PendulumVisitor();
            pendulumVisitor.visit(tree);
            sim = pendulumVisitor.getSimulation();
        } else if (input.contains("accelerated_motion")) {
            AcceleratedUniformMotionVisitor motionVisitor = new AcceleratedUniformMotionVisitor();
            motionVisitor.visit(tree);
            sim = motionVisitor.getSimulation();
        } else if (input.contains("wave")) {
            WaveVisitor waveVisitor = new WaveVisitor();
            waveVisitor.visit(tree);
            sim = waveVisitor.getSimulation();
        } else if (input.contains("uniform_motion")) {
            UniformMotionVisitor motionVisitor = new UniformMotionVisitor();
            motionVisitor.visit(tree);
            sim = motionVisitor.getSimulation();
        } else {
            System.err.println("Error: Unsupported simulation type.");
            return;
        }

        // If value exists in the DSL, it is replaced with the actual value
        // Else if null, it is initialized with zero
        // Else throw an error in case of a typo
        if (sim.containsKey("pendulum")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("pendulum");

            float length = 0;
            if (module.containsKey("length")) {
                length = Float.parseFloat(module.get("length").toString());
            } else {
                System.err.println("Error: length is missing");
                return;
            }
            float radius = 0;
            if (module.containsKey("ball_radius")) {
                radius = Float.parseFloat(module.get("ball_radius").toString());
            } else {
                System.err.println("Error: ball_radius is missing");
                return;
            }
            float angle = 0;
            if (module.containsKey("initial_angle")) {
                angle = Float.parseFloat(module.get("initial_angle").toString());
            } else {
                System.err.println("Error: initial_angle is missing");
                return;
            }
            float angleV = 0;
            if (module.containsKey("angular_velocity")) {
                angleV = Float.parseFloat(module.get("angular_velocity").toString());
            } else {
                System.err.println("Error: angular_velocity is missing");
                return;
            }
            float angleA = 0;
            if (module.containsKey("angular_acceleration")) {
                angleA = Float.parseFloat(module.get("angular_acceleration").toString());
            } else {
                System.err.println("Error: angular_acceleration is missing");
                return;
            }
            float airResistance = 0;
            if (module.containsKey("air_resistance")) {
                airResistance = Float.parseFloat(module.get("air_resistance").toString());
            } else {
                System.err.println("Error: air_resistance is missing");
                return;
            }

            Pendulum.runPendulum(length, radius, angle, angleV, angleA, airResistance);
        }
        if (sim.containsKey("accelerated_motion")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("accelerated_motion");

            float initialSpeed = 0;
            if (module.containsKey("initial_speed")) {
                initialSpeed = Float.parseFloat(module.get("initial_speed").toString());
            } else {
                System.err.println("Error: initial_speed is missing");
                return;
            }

            float initialAcceleration = 0;
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
        if (sim.containsKey("attraction_force")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("attraction_force");
            // Mover 1
            Map<String, Object> mover1 = (Map<String, Object>) module.get("mover1");
            if (mover1 == null) {
                System.err.println("Error: mover1 is missing");
                return;
            }

            float radius1 = 0;
            if (mover1.containsKey("radius")) {
                radius1 = Float.parseFloat(mover1.get("radius").toString());
            } else {
                System.err.println("Error: radius for mover1 is missing");
                return;
            }

            float mass1 = 0;
            if (mover1.containsKey("mass")) {
                mass1 = Float.parseFloat(mover1.get("mass").toString());
            } else {
                System.err.println("Error: mass for mover1 is missing");
                return;
            }

            float[] position1 = {0, 0};
            if (mover1.containsKey("position")) {
                position1 = (float[]) mover1.get("position");
            } else {
                System.err.println("Error: position for mover1 is missing");
                return;
            }

            float[] velocity1 = {0, 0};
            if (mover1.containsKey("velocity")) {
                velocity1 = (float[]) mover1.get("velocity");
            } else {
                System.err.println("Error: velocity for mover1 is missing");
                return;
            }

            int[] color1 = {0, 100, 255}; // Default color
            if (mover1.containsKey("color")) {
                Map<String, Integer> color1Map = (Map<String, Integer>) mover1.get("color");
                if (color1Map != null) {
                    color1 = new int[]{
                            color1Map.getOrDefault("red_value", 0),
                            color1Map.getOrDefault("green_value", 100),
                            color1Map.getOrDefault("blue_value", 255)
                    };
                } else {
                    System.err.println("Error: color for mover1 is missing");
                    return;
                }
            }
            // Mover 2
            Map<String, Object> mover2 = (Map<String, Object>) module.get("mover2");
            if (mover2 == null) {
                System.err.println("Error: mover2 is missing");
                return;
            }

            float radius2 = 0;
            if (mover2.containsKey("radius")) {
                radius2 = Float.parseFloat(mover2.get("radius").toString());
            } else {
                System.err.println("Error: radius for mover2 is missing");
                return;
            }

            float mass2 = 0;
            if (mover2.containsKey("mass")) {
                mass2 = Float.parseFloat(mover2.get("mass").toString());
            } else {
                System.err.println("Error: mass for mover2 is missing");
                return;
            }

            float[] position2 = {0, 0};
            if (mover2.containsKey("position")) {
                position2 = (float[]) mover2.get("position");
            } else {
                System.err.println("Error: position for mover2 is missing");
                return;
            }

            float[] velocity2 = {0, 0};
            if (mover2.containsKey("velocity")) {
                velocity2 = (float[]) mover2.get("velocity");
            } else {
                System.err.println("Error: velocity for mover2 is missing");
                return;
            }

            int[] color2 = {255, 100, 0}; // Default color
            if (mover2.containsKey("color")) {
                Map<String, Integer> color2Map = (Map<String, Integer>) mover2.get("color");
                if (color2Map != null) {
                    color2 = new int[]{
                            color2Map.getOrDefault("red_value", 255),
                            color2Map.getOrDefault("green_value", 100),
                            color2Map.getOrDefault("blue_value", 0)
                    };
                } else {
                    System.err.println("Error: color for mover2 is missing");
                    return;
                }
            }

            // Run the simulation
            AttractionForce.runAttractionForce(
                    radius1, mass1, position1, velocity1, radius2,
                    mass2, position2, velocity2, color1, color2
            );
        }
        if (sim.containsKey("uniform_motion")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("uniform_motion");
            float initialSpeed = 0;
            if (module.containsKey("initial_speed")) {
                initialSpeed = Float.parseFloat(module.get("initial_speed").toString());
            } else {
                System.err.println("Error: initial_speed is missing");
                return;
            }

            Map<String, Object> mover = (Map<String, Object>) module.get("mover");
            if (mover == null) {
                System.err.println("Error: mover is missing");
                return;
            }

            // CRITICAL FIX: Extract and print radius for debugging
            float radius = 0;
            if (mover.containsKey("radius")) {
                radius = Float.parseFloat(mover.get("radius").toString());
                System.out.println("Extracted radius from DSL: " + radius);
            } else {
                System.err.println("Error: radius for mover is missing");
                return;
            }

            int[] color = {255, 100, 0};
            if (mover.containsKey("color")) {
                Map<String, Integer> colorMap = (Map<String, Integer>) mover.get("color");
                if (colorMap != null) {
                    color = new int[]{
                            colorMap.getOrDefault("red_value", 255),
                            colorMap.getOrDefault("green_value", 100),
                            colorMap.getOrDefault("blue_value", 0)
                    };
                    System.out.println("Extracted color from DSL: " + color[0] + " " + color[1] + " " + color[2]);
                } else {
                    System.err.println("Error: color for mover is missing");
                    return;
                }
            }

            // Print information before running the simulation
            System.out.println("Running UniformMotion with: radius=" + radius +
                    ", color=[" + color[0] + "," + color[1] + "," + color[2] +
                    "], speed=" + initialSpeed);

            // Run the simulation
            UniformMotion.runUniformMotion(radius, color, initialSpeed);
        }
    }
}

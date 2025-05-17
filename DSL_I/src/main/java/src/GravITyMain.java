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
                    electrostatic_field {
                        particle_radius: 35
                        flux_resolution: 15
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
        } else if (input.contains("circular_motion")) {
            CircularMotionVisitor circularMotionVisitor = new CircularMotionVisitor();
            circularMotionVisitor.visit(tree);
            sim = circularMotionVisitor.getSimulation();
        } else if (input.contains("gravity")) {
            GravityVisitor gravityVisitor = new GravityVisitor();
            gravityVisitor.visit(tree);
            sim = gravityVisitor.getSimulation();
        } else if (input.contains("drag_force")) {
            DragForceVisitor dragForceVisitor = new DragForceVisitor();
            dragForceVisitor.visit(tree);
            sim = dragForceVisitor.getSimulation();
        } else if (input.contains("spring")) {
            SpringVisitor springVisitor = new SpringVisitor();
            springVisitor.visit(tree);
            sim = springVisitor.getSimulation();
        } else if (input.contains("rolling_uphill")) {
            RollingUphillVisitor rollingUphillVisitor = new RollingUphillVisitor();
            rollingUphillVisitor.visit(tree);
            sim = rollingUphillVisitor.getSimulation();
        } else if (input.contains("electrostatic_field")) {
            ElectrostaticFieldVisitor electrostaticFieldVisitor = new ElectrostaticFieldVisitor();
            electrostaticFieldVisitor.visit(tree);
            sim = electrostaticFieldVisitor.getSimulation();
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

            float radius = 0;
            if (mover.containsKey("radius")) {
                radius = Float.parseFloat(mover.get("radius").toString());
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
                } else {
                    System.err.println("Error: color for mover is missing");
                    return;
                }
            }

            UniformMotion.runUniformMotion(radius, color, initialSpeed);
        }
        if (sim.containsKey("wave")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("wave");

            float start_angle = 0;
            if (module.containsKey("start_angle")) {
                start_angle = Float.parseFloat(module.get("start_angle").toString());
            } else {
                System.err.println("Error: start_angle is missing");
                return;
            }
            float angle_velocity = 0;
            if (module.containsKey("angle_velocity")) {
                angle_velocity = Float.parseFloat(module.get("angle_velocity").toString());
            } else {
                System.err.println("Error: angle_velocity is missing");
                return;
            }
            float amplitude = 0;
            if (module.containsKey("amplitude")) {
                amplitude = Float.parseFloat(module.get("amplitude").toString());
            } else {
                System.err.println("Error: amplitude is missing");
                return;
            }
            float frequency = 0;
            if (module.containsKey("frequency")) {
                frequency = Float.parseFloat(module.get("frequency").toString());
            } else {
                System.err.println("Error: frequency is missing");
                return;
            }
            float phase_shift = 0;
            if (module.containsKey("phase_shift")) {
                phase_shift = Float.parseFloat(module.get("phase_shift").toString());
            } else {
                System.err.println("Error: phase_shift is missing");
                return;
            }
            Wave.runWave(
                    start_angle, angle_velocity, amplitude, frequency, phase_shift
            );
        }
        if (sim.containsKey("circular_motion")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("circular_motion");
            float radius = 0;
            if (module.containsKey("radius")) {
                radius = Float.parseFloat(module.get("radius").toString());
            } else {
                System.err.println("Error: radius is missing");
            }
            float angular_speed = 0;
            if (module.containsKey("angular_speed")) {
                angular_speed = Float.parseFloat(module.get("angular_speed").toString());
            } else {
                System.err.println("Error: angular_speed is missing");
            }
            Map<String, Object> mover = (Map<String, Object>) module.get("ball");
            if (mover == null) {
                System.err.println("Error: ball is missing");
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
                } else {
                    System.err.println("Error: color for mover is missing");
                    return;
                }
                CircularMotion.runCircularMotion(
                        radius, angular_speed, color, radius
                );
            }
        }
        if (sim.containsKey("gravity")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("gravity");

            Map<String, Object> earth = (Map<String, Object>) module.get("earth");
            Map<String, Object> moon = (Map<String, Object>) module.get("moon");

            if (earth == null || moon == null) {
                System.err.println("Error: earth or moon position is missing");
                return;
            }

            Map<String, String> earthPos = (Map<String, String>) earth.get("position");
            Map<String, String> moonPos = (Map<String, String>) moon.get("position");

            if (earthPos == null || moonPos == null) {
                System.err.println("Error: position is missing for earth or moon");
                return;
            }

            float earthX = 0;
            if (earthPos.containsKey("x_position")) {
                earthX = Float.parseFloat(earthPos.get("x_position").toString());
            } else {
                System.err.println("Error: Earth x_position is missing");
                return;
            }
            float earthY = 0;
            if (earthPos.containsKey("y_position")) {
                earthY = Float.parseFloat(earthPos.get("y_position").toString());
            } else {
                System.err.println("Error: Earth y_position is missing");
                return;
            }
            float moonX = 0;
            if (moonPos.containsKey("x_position")) {
                moonX = Float.parseFloat(moonPos.get("x_position").toString());
            } else {
                System.err.println("Error: moon x_position is missing");
                return;
            }
            float moonY = 0;
            if (moonPos.containsKey("y_position")) {
                moonY = Float.parseFloat(moonPos.get("y_position").toString());
            } else {
                System.err.println("Error: moon y_position is missing");
                return;
            }

            Gravity.runGravity(earthX, earthY, moonX, moonY);

        }
        if (sim.containsKey("drag_force")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("drag_force");
            Map<String, Object> mover = (Map<String, Object>) module.get("mover_color");

            float dragCoefficient = 0;
            if (module.containsKey("drag_coefficient")) {
                dragCoefficient = Float.parseFloat(module.get("drag_coefficient").toString());
            } else {
                System.err.println("Error: drag_coefficient is missing");
                return;
            }

            Map<String, String> moverColor = (Map<String, String>) module.get("mover_color");
            if (moverColor == null) {
                System.err.println("Error: mover_color is missing");
                return;
            }

            int[] mColor = {0, 0, 0};
            if (moverColor.containsKey("red_value")) {
                mColor[0] = Integer.parseInt(moverColor.get("red_value"));
            } else {
                System.err.println("Error: mover_color red_value is missing");
                return;
            }

            if (moverColor.containsKey("green_value")) {
                mColor[1] = Integer.parseInt(moverColor.get("green_value"));
            } else {
                System.err.println("Error: mover_color green_value is missing");
                return;
            }

            if (moverColor.containsKey("blue_value")) {
                mColor[2] = Integer.parseInt(moverColor.get("blue_value"));
            } else {
                System.err.println("Error: mover_color blue_value is missing");
                return;
            }

            Map<String, String> liquidColor = (Map<String, String>) module.get("liquid_color");
            if (liquidColor == null) {
                System.err.println("Error: liquid_color is missing");
                return;
            }

            int[] lColor = {0, 0, 0};

            if (liquidColor.containsKey("red_value")) {
                lColor[0] = Integer.parseInt(liquidColor.get("red_value"));
            } else {
                System.err.println("Error: liquid_color red_value is missing");
                return;
            }

            if (liquidColor.containsKey("green_value")) {
                lColor[1] = Integer.parseInt(liquidColor.get("green_value"));
            } else {
                System.err.println("Error: liquid_color green_value is missing");
                return;
            }

            if (liquidColor.containsKey("blue_value")) {
                lColor[2] = Integer.parseInt(liquidColor.get("blue_value"));
            } else {
                System.err.println("Error: liquid_color blue_value is missing");
                return;
            }

            DragForce.runDragForce(mColor, dragCoefficient, lColor);
        }
        if (sim.containsKey("spring")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("spring");

            float springConstant = 0;
            if (module.containsKey("spring_constant")) {
                springConstant = Float.parseFloat(module.get("spring_constant").toString());
            } else {
                System.err.println("Error: spring_constant is missing");
                return;
            }

            float damping = 0;
            if (module.containsKey("damping")) {
                damping = Float.parseFloat(module.get("damping").toString());
            } else {
                System.err.println("Error: damping is missing");
                return;
            }

            float restLength = 0;
            if (module.containsKey("spring_rest_length")) {
                restLength = Float.parseFloat(module.get("spring_rest_length").toString());
            } else {
                System.err.println("Error: spring_rest_length is missing");
                return;
            }

            float floorFriction = 0;
            if (module.containsKey("floor_friction")) {
                floorFriction = Float.parseFloat(module.get("floor_friction").toString());
            } else {
                System.err.println("Error: floor_friction is missing");
                return;
            }

            Map<String, Object> ball = (Map<String, Object>) module.get("ball");
            if (ball == null) {
                System.err.println("Error: ball properties are missing");
                return;
            }

            float ballRadius = 0;
            if (ball.containsKey("radius")) {
                ballRadius = Float.parseFloat(ball.get("radius").toString());
            } else {
                System.err.println("Error: ball radius is missing");
                return;
            }

            int[] fillColor = {0, 0, 0};
            if (ball.containsKey("color")) {
                Map<String, String> colorMap = (Map<String, String>) ball.get("color");
                if (colorMap != null) {
                    fillColor = new int[] {
                            Integer.parseInt(colorMap.get("r")),
                            Integer.parseInt(colorMap.get("g")),
                            Integer.parseInt(colorMap.get("b"))
                    };
                } else {
                    System.err.println("Error: ball color is missing");
                    return;
                }
            }

            Map<String, Object> springConfig = (Map<String, Object>) module.get("spring");
            if (springConfig == null) {
                System.err.println("Error: spring properties are missing");
                return;
            }

            float x_anchor_position = 0;
            if (springConfig.containsKey("x_anchor_position")) {
                x_anchor_position = Float.parseFloat(springConfig.get("x_anchor_position").toString());
            } else {
                System.err.println("Error: x_anchor_position is missing");
                return;
            }

            float y_anchor_position = 0;
            if (springConfig.containsKey("y_anchor_position")) {
                y_anchor_position = Float.parseFloat(springConfig.get("y_anchor_position").toString());
            } else {
                System.err.println("Error: y_anchor_position is missing");
                return;
            }

            int numCoils = 0;
            if (springConfig.containsKey("num_coils")) {
                numCoils = Integer.parseInt(springConfig.get("num_coils").toString());
            }

            Spring.runSpring(
                    springConstant,
                    damping,
                    restLength,
                    floorFriction,
                    ballRadius,
                    fillColor,
                    x_anchor_position,
                    y_anchor_position,
                    numCoils
            );
        }
        if (sim.containsKey("rolling_uphill")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("rolling_uphill");

            float gravitationalAcceleration = 9.8f;
            if (module.containsKey("gravitational_acceleration")) {
                gravitationalAcceleration = Float.parseFloat(module.get("gravitational_acceleration").toString());
            } else {
                System.err.println("Error: gravitational_acceleration is missing");
            }

            float friction = 0.0f;
            if (module.containsKey("coefficient_of_friction")) {
                friction = Float.parseFloat(module.get("coefficient_of_friction").toString());
            } else {
                System.err.println("Error: coefficient_of_friction is missing");
            }

            float bounciness = 0.0f;
            if (module.containsKey("bounciness")) {
                bounciness = Float.parseFloat(module.get("bounciness").toString());
            } else {
                System.err.println("Error: bounciness is missing");
            }

            float angle = 0.0f;
            if (module.containsKey("angle")) {
                angle = Float.parseFloat(module.get("angle").toString());
            } else {
                System.err.println("Error: angle is missing");
            }

            float velocity = 0.0f;
            if (module.containsKey("velocity_along_incline")) {
                velocity = Float.parseFloat(module.get("velocity_along_incline").toString());
            } else {
                System.err.println("Error: velocity_along_incline is missing");
            }

            Map<String, Object> ball = (Map<String, Object>) module.get("ball");
            if (ball == null) {
                System.err.println("Error: ball is missing");
                return;
            }

            float radius = 10;
            if (ball.containsKey("radius")) {
                radius = Float.parseFloat(ball.get("radius").toString());
            } else {
                System.err.println("Error: radius is missing in ball");
            }

            int[] color = {0, 0, 0};
            if (ball.containsKey("color")) {
                Map<String, Integer> colorMap = (Map<String, Integer>) ball.get("color");
                if (colorMap != null) {
                    color = new int[]{
                            colorMap.getOrDefault("red_value", 255),
                            colorMap.getOrDefault("green_value", 100),
                            colorMap.getOrDefault("blue_value", 0)
                    };
                } else {
                    System.err.println("Error: color map is invalid");
                }
            }

            RollingUphill.runRollingUphill(
                    gravitationalAcceleration,
                    friction,
                    bounciness,
                    angle,
                    radius,
                    velocity,
                    color
            );
        }
        if (sim.containsKey("electrostatic_field")) {
            Map<String, Object> module = (Map<String, Object>) sim.get("electrostatic_field");

            float particle_radius = 0;
            if (module.containsKey("particle_radius")) {
                particle_radius = Float.parseFloat(module.get("particle_radius").toString());
            } else {
                System.err.println("Error: particle_radius is missing");
            }

            int flux_resolution = 0;
            if (module.containsKey("flux_resolution")) {
                flux_resolution = Integer.parseInt(module.get("flux_resolution").toString());
            } else {
                System.err.println("Error: flux_resolution is missing");
            }


            ElectrostaticField.runElectrostaticField(
                    particle_radius, flux_resolution
            );
        }

    }
}

package oop.practice;

import gen.MyDSLLexer;
import gen.MyDSLParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import processing.core.PApplet;

public class SimulationDSLInterpreter {
    public static void main(String[] args) throws Exception {
        // Pornim thread-ul pentru interfața Processing
        Thread processingThread = new Thread(() -> PApplet.main("oop.practice.SimulationDSLProcessingInterface"));
        processingThread.start();

        // Exemplu de input pentru simulare
        String input = """
            simulation {
                collision {
                    mover {
                        radius: 10;
                        mass: 5;
                        velocity { x_velocity: 2; y_velocity: 3; }
                        position { x_position: 50; y_position: 50; }
                        color { red_value: 255; green_value: 0; blue_value: 0; }
                    }
                }
            }
            """;

        // Crearea Lexer-ului și Parser-ului pentru ANTLR
        MyDSLLexer lexer = new MyDSLLexer(CharStreams.fromString(input));
        MyDSLParser parser = new MyDSLParser(new CommonTokenStream(lexer));

        // Parsăm inputul și obținem AST-ul
        ParseTree tree = parser.simulation();

        // Creăm visitor-ul și rulăm interpretarea
        MyDSLVisitorImpl visitor = new MyDSLVisitorImpl();
        visitor.visit(tree);
    }
}

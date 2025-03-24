package oop.practice;
import gen.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Input text to be parsed
        String input = """
                simulation {
                collision {
                    mover {
                        radius: 10
                        mass: 5
                        velocity { x_velocity: 2 y_velocity: 3 }
                        position { x_position: 50 y_position: 50 }
                        color { red_value: 255 green_value: 0 blue_value: 0 }
                    }
                }
            }""";

        // Create a lexer and parser
        MyDSLLexer lexer = new MyDSLLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MyDSLParser parser = new MyDSLParser(tokens);

        // Start parsing from the 'program' rule
        ParseTree tree = parser.simulation();

        // Print the parse tree (for debugging)
        System.out.println(tree.toStringTree(parser));
    }
}


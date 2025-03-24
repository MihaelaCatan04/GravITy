package oop.practice;
import gen.*;

import org.antlr.v4.runtime.tree.ParseTree;

public class DSLInterpreter extends MyDSLBaseVisitor<Object> {
    /**
     * Metodă care afișează structura arborelui de parsare în consolă.
     * @param tree Arborele de parsare generat de ANTLR
     * @param level Nivelul de indentare pentru afișarea ierarhiei nodurilor
     */
    public void printParseTree(ParseTree tree, int level) {
        // Creăm indentarea bazată pe nivel
        String indent = " ".repeat(level * 2);

        // Afișăm tipul nodului și textul său
        System.out.println(indent + tree.getClass().getSimpleName() + ": " + tree.getText());

        // Iterăm prin toți copiii nodului și îi vizităm recursiv
        for (int i = 0; i < tree.getChildCount(); i++) {
            printParseTree(tree.getChild(i), level + 1);
        }
    }
}


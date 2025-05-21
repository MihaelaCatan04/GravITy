package src;

import javax.swing.*;

class TextAreaOutputStream extends java.io.OutputStream {
    private JTextArea textArea;

    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws java.io.IOException {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GravITyIDE ide = new GravITyIDE();
                    ide.setVisible(true);
                    System.out.println("IDE started successfully");
                } catch (Exception e) {
                    System.err.println("Error starting IDE: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}
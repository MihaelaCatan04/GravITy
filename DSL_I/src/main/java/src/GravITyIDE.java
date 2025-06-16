package src;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.PrintStream;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import gen.*;

import java.awt.geom.Point2D;

import visitors.*;

public class GravITyIDE extends JFrame {

    private JTextArea codeArea;
    private JPanel simulationPanel;
    private JButton runButton;
    private JTextArea outputArea;
    private JSplitPane mainSplitPane;
    private JSplitPane rightSplitPane;
    private VideoDialog videoDialog;


    private Timer animationTimer;

    public GravITyIDE() {
        setTitle("GravITy Physics Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        codeArea = new JTextArea();
        codeArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        JPanel editorPanel = createEditorPanel();

        JPanel displayPanel = createDisplayPanel();

        mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, editorPanel, displayPanel);
        mainSplitPane.setResizeWeight(0.5);
        mainSplitPane.setDividerLocation(600);

        add(mainSplitPane, BorderLayout.CENTER);

        JToolBar toolBar = createToolBar();
        add(toolBar, BorderLayout.NORTH);

        JPanel statusBar = createStatusBar();
        add(statusBar, BorderLayout.SOUTH);

        videoDialog = new VideoDialog(this);

        setDefaultCode();
    }

    private JPanel createEditorPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "GravITy Code",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)
        ));

        JScrollPane scrollPane = new JScrollPane(codeArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JTextArea lineNumbers = new JTextArea("1");
        lineNumbers.setBackground(new Color(240, 240, 240));
        lineNumbers.setEditable(false);
        lineNumbers.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        codeArea.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            private void updateLineNumbers() {
                SwingUtilities.invokeLater(() -> {
                    int lines = codeArea.getLineCount();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i <= lines; i++) {
                        sb.append(i).append("\n");
                    }
                    lineNumbers.setText(sb.toString());
                });
            }
        });

        scrollPane.setRowHeaderView(lineNumbers);

        return panel;
    }

    private JPanel createDisplayPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        simulationPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 16));
                FontMetrics fm = g.getFontMetrics();
                String message = "Simulation output";
                int x = (getWidth() - fm.stringWidth(message)) / 2;
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g.drawString(message, x, y);
            }
        };
        simulationPanel.setBackground(Color.WHITE);
        JPanel simulationWrapper = new JPanel(new BorderLayout());
        simulationWrapper.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Visualization",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)
        ));
        simulationWrapper.add(simulationPanel, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Errors/Results",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)
        ));
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputPanel.add(outputScroll, BorderLayout.CENTER);

        rightSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, simulationWrapper, outputPanel);
        rightSplitPane.setResizeWeight(0.7);
        rightSplitPane.setDividerLocation(500);

        panel.add(rightSplitPane, BorderLayout.CENTER);

        return panel;
    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        runButton = new JButton("Run Simulation");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSimulation();
            }
        });
        toolBar.add(runButton);

        toolBar.addSeparator();

        JButton newButton = new JButton("New");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codeArea.setText("");
            }
        });
        toolBar.add(newButton);

        JButton exampleButton = new JButton("Load Example");
        exampleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadExample();
            }
        });
        toolBar.add(exampleButton);

        return toolBar;
    }

    private JPanel createStatusBar() {
        JPanel statusBar = new JPanel(new BorderLayout());
        statusBar.setBorder(BorderFactory.createEtchedBorder());

        JLabel statusLabel = new JLabel(" ┌( ͝° ͜ʖ͡°)=ε/̵͇̿̿/'̿'̿ ̿‍");
        statusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        statusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showVideoDialog();
            }
        });
        statusBar.add(statusLabel, BorderLayout.WEST);

        return statusBar;
    }

    private void showVideoDialog() {
        if (videoDialog == null) {
            videoDialog = new VideoDialog(this);
        }
        videoDialog.setVisible(true);
    }

    private class VideoDialog extends JDialog {

        public VideoDialog(JFrame parent) {
            super(parent, "Surprise Video", true);
            setSize(640, 480);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

            JPanel panel = new JPanel(new BorderLayout());

            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setEditable(false);


            String htmlContent = "<html><body style='text-align:center;'>" +
                    "<h2>GravITy Physics Simulator</h2>" +
                    "<p>Enjoy this surprise video!</p>" +
                    "<p><a href='https://www.youtube.com/watch?v=dQw4w9WgXcQ'>Click here to watch the video</a></p>" +
                    "</body></html>";

            editorPane.setText(htmlContent);

            editorPane.addHyperlinkListener(e -> {
                if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        Desktop.getDesktop().browse(e.getURL().toURI());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(
                                VideoDialog.this,
                                "Could not open the video link. Please try manually: " + e.getURL(),
                                "Error Opening Link",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            });

            JScrollPane scrollPane = new JScrollPane(editorPane);
            panel.add(scrollPane, BorderLayout.CENTER);

            try {
                JPanel mediaPanel = new JPanel();
                mediaPanel.setPreferredSize(new Dimension(640, 240));
                mediaPanel.setBackground(Color.BLACK);

                JLabel mediaLabel = new JLabel("Media Player Placeholder");
                mediaLabel.setForeground(Color.WHITE);
                mediaLabel.setHorizontalAlignment(JLabel.CENTER);
                mediaPanel.add(mediaLabel);

                panel.add(mediaPanel, BorderLayout.SOUTH);

                JLabel infoLabel = new JLabel("<html><p style='text-align:center'>.</p></html>");
                infoLabel.setHorizontalAlignment(JLabel.CENTER);
                panel.add(infoLabel, BorderLayout.NORTH);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(
                        this,
                        "Could not initialize media player: " + e.getMessage(),
                        "Media Player Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> setVisible(false));
            panel.add(closeButton, BorderLayout.SOUTH);

            setContentPane(panel);
        }
    }

    private void setDefaultCode() {
        String defaultCode = "simulation {\n" +
                "    drag_force {\n" +
                "        mover_color {\n" +
                "            red_value: 100\n" +
                "            green_value: 0\n" +
                "            blue_value: 75\n" +
                "        }\n" +
                "        drag_coefficient: 0.1\n" +
                "        liquid_color {\n" +
                "            red_value: 50\n" +
                "            green_value: 100\n" +
                "            blue_value: 150\n" +
                "        }\n" +
                "    }\n" +
                "}";

        codeArea.setText(defaultCode);
    }

    private void loadExample() {
        String[] examples = {
                "Accelerated Motion",
                "Attraction Force",
                "Circular Motion",
                "Collision",
                "Drag Force",
                "Electrostatic Field",
                "Gravity",
                "Pendulum",
                "Rolling Downhill",
                "Uniform Motion",
                "Wave",
        };

        String selected = (String) JOptionPane.showInputDialog(
                this,
                "Choose an example simulation:",
                "Load Example",
                JOptionPane.QUESTION_MESSAGE,
                null,
                examples,
                examples[0]
        );

        if (selected != null) {
            String code = getExampleCode(selected);
            codeArea.setText(code);
        }
    }

    private String getExampleCode(String example) {
        switch (example) {
            case "Accelerated Motion":
                return "simulation {\n" +
                        "    accelerated_motion {\n" +
                        "        mover {\n" +
                        "            radius: 25\n" +
                        "            color {\n" +
                        "                red_value: 0\n" +
                        "                green_value: 100\n" +
                        "                blue_value: 255\n" +
                        "            }\n" +
                        "        }\n" +
                        "        initial_speed: 2.0\n" +
                        "        initial_acceleration: 0.05\n" +
                        "    }\n" +
                        "}";
            case "Drag Force":
                return "simulation {\n" +
                        "    drag_force {\n" +
                        "        mover_color {\n" +
                        "            red_value: 100\n" +
                        "            green_value: 0\n" +
                        "            blue_value: 75\n" +
                        "        }\n" +
                        "        drag_coefficient: 0.1\n" +
                        "        liquid_color {\n" +
                        "            red_value: 50\n" +
                        "            green_value: 100\n" +
                        "            blue_value: 150\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
            case "Pendulum":
                return "simulation {\n" +
                        "    pendulum {\n" +
                        "        length: 175\n" +
                        "        ball_radius: 20\n" +
                        "        initial_angle: 45\n" +
                        "        angular_velocity: 0\n" +
                        "        angular_acceleration: 0\n" +
                        "        air_resistance: 0.01\n" +
                        "    }\n" +
                        "}";
            case "Gravity":
                return "simulation {\n" +
                        "    gravity {\n" +
                        "        earth {\n" +
                        "            position {\n" +
                        "                x_position: 400\n" +
                        "                y_position: 300\n" +
                        "            }\n" +
                        "        }\n" +
                        "        moon {\n" +
                        "            position {\n" +
                        "                x_position: 250\n" +
                        "                y_position: 150\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
            case "Uniform Motion":
                return "simulation {\n" +
                        "    uniform_motion {\n" +
                        "        mover {\n" +
                        "            radius: 30\n" +
                        "            color {\n" +
                        "                red_value: 0\n" +
                        "                green_value: 100\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
                        "        initial_speed: 2.5\n" +
                        "    }\n" +
                        "}";
            case "Wave":
                return "simulation {\n" +
                        "    wave {\n" +
                        "        start_angle: 0\n" +
                        "        angle_velocity: 0.05\n" +
                        "        amplitude: 75\n" +
                        "        frequency: 2\n" +
                        "        phase_shift: 0\n" +
                        "    }\n" +
                        "}";
            case "Circular Motion":
                return "simulation {\n" +
                        "    circular_motion {\n" +
                        "        radius: 67\n" +
                        "        angular_speed: 0.2\n" +
                        "        ball {\n" +
                        "            radius: 8\n" +
                        "            color {\n" +
                        "                red_value: 22\n" +
                        "                green_value: 255\n" +
                        "                blue_value: 45\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
            case "Attraction Force":
                return "simulation {\n" +
                        "    attraction_force {\n" +
                        "        mover1 {\n" +
                        "            radius: 10\n" +
                        "            mass: 3.5\n" +
                        "            velocity {\n" +
                        "                x_velocity: 1\n" +
                        "                y_velocity: 1\n" +
                        "            }\n" +
                        "            position {\n" +
                        "                x_position: 100\n" +
                        "                y_position: 150\n" +
                        "            }\n" +
                        "            color {\n" +
                        "                red_value: 255\n" +
                        "                green_value: 0\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
                        "        mover2 {\n" +
                        "            radius: 15\n" +
                        "            mass: 4.0\n" +
                        "            velocity {\n" +
                        "                x_velocity: 1\n" +
                        "                y_velocity: 5\n" +
                        "            }\n" +
                        "            position {\n" +
                        "                x_position: 300\n" +
                        "                y_position: 200\n" +
                        "            }\n" +
                        "            color {\n" +
                        "                red_value: 255\n" +
                        "                green_value: 0\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
            case "Collision":
                return "simulation {\n" +
                        "    collision {\n" +
                        "        mover {\n" +
                        "            radius: 15\n" +
                        "            mass: 10\n" +
                        "            velocity {\n" +
                        "                x_velocity: 2\n" +
                        "                y_velocity: 1\n" +
                        "            }\n" +
                        "            position {\n" +
                        "                x_position: 100\n" +
                        "                y_position: 150\n" +
                        "            }\n" +
                        "            color {\n" +
                        "                red_value: 255\n" +
                        "                green_value: 0\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
                        "        mover {\n" +
                        "            radius: 20\n" +
                        "            mass: 15\n" +
                        "            velocity {\n" +
                        "                x_velocity: -1\n" +
                        "                y_velocity: 2\n" +
                        "            }\n" +
                        "            position {\n" +
                        "                x_position: 300\n" +
                        "                y_position: 200\n" +
                        "            }\n" +
                        "            color {\n" +
                        "                red_value: 0\n" +
                        "                green_value: 255\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
                        "        mover {\n" +
                        "            radius: 25\n" +
                        "            mass: 20\n" +
                        "            velocity {\n" +
                        "                x_velocity: -2\n" +
                        "                y_velocity: -1\n" +
                        "            }\n" +
                        "            position {\n" +
                        "                x_position: 500\n" +
                        "                y_position: 100\n" +
                        "            }\n" +
                        "            color {\n" +
                        "                red_value: 0\n" +
                        "                green_value: 0\n" +
                        "                blue_value: 255\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
            case "Spring":
                return "simulation {\n" +
                        "    spring {\n" +
                        "        spring_constant: 0.15\n" +
                        "        damping: 0.02\n" +
                        "        spring_rest_length: 120\n" +
                        "        floor_friction: 0.05\n" +
                        "        ball {\n" +
                        "            radius: 25\n" +
                        "            color {\n" +
                        "                red_value: 255\n" +
                        "                green_value: 100\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
                        "        spring {\n" +
                        "            x_anchor_position: 300\n" +
                        "            y_anchor_position: 50\n" +
                        "            num_coils: 15\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";

            case "Rolling Downhill":
                return "simulation {\n" +
                        "    rolling_downhill {\n" +
                        "        gravitational_acceleration: 9.8\n" +
                        "        coefficient_of_friction: 0.1\n" +
                        "        bounciness: 0.7\n" +
                        "        angle: 30\n" +
                        "        ball {\n" +
                        "            radius: 25\n" +
                        "            color {\n" +
                        "                red_value: 255\n" +
                        "                green_value: 150\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
                        "        velocity_along_incline: 5\n" +
                        "    }\n" +
                        "}";
            case "Electrostatic Field":
                return "simulation {\n" +
                        "    electrostatic_field {\n" +
                        "        particle_radius: 25\n" +
                        "        flux_resolution: 20\n" +
                        "    }\n" +
                        "}";
            default:
                return "";
        }
    }

    private void runSimulation() {
        try {
            if (animationTimer != null && animationTimer.isRunning()) {
                animationTimer.stop();
            }

            outputArea.setText("");
            outputArea.append("Starting simulation...\n");

            String code = codeArea.getText();

            TextAreaOutputStream outputStream = new TextAreaOutputStream(outputArea);
            PrintStream printStream = new PrintStream(outputStream);

            PrintStream oldOut = System.out;
            PrintStream oldErr = System.err;
            System.setOut(printStream);
            System.setErr(printStream);

            try {
                CharStream charStream = CharStreams.fromString(code);
                GravITyLexer lexer = new GravITyLexer(charStream);

                lexer.removeErrorListeners();
                lexer.addErrorListener(new GravITyErrorListener());

                CommonTokenStream tokens = new CommonTokenStream(lexer);
                GravITyParser parser = new GravITyParser(tokens);

                parser.removeErrorListeners();
                parser.addErrorListener(new GravITyErrorListener());

                ParseTree tree = null;
                try {
                    tree = parser.simulation();
                } catch (Exception e) {
                    outputArea.append("ERROR parsing simulation: " + e.getMessage() + "\n");
                    e.printStackTrace();
                }

                if (tree == null) {
                    outputArea.append("ERROR: Failed to parse the simulation code. Please check the syntax.\n");
                    return;
                }

                if (code.contains("drag_force")) {
                    outputArea.append("DEBUG: Detected drag_force in code\n");
                    handleDragForceSimulation(tree, code);
                } else if (code.contains("pendulum")) {
                    handlePendulumSimulation(tree, code);
                } else if (code.contains("accelerated_motion")) {
                    handleAcceleratedMotionSimulation2(tree, code);
                } else if (code.contains("wave")) {
                    handleWaveSimulation(tree, code);
                } else if (code.contains("uniform_motion")) {
                    handleUniformMotionSimulation(tree, code);
                } else if (code.contains("circular_motion")) {
                    handleCircularMotionSimulation(tree, code);
                } else if (code.contains("gravity")) {
                    handleGravitySimulation(tree, code);
                } else if (code.contains("attraction_force")) {
                    handleAttractionForceSimulation(tree, code);
                } else if (code.contains("collision")) {
                    handleCollisionSimulation(tree, code);
                } else if (code.contains("spring")) {
                    handleSpringSimulation(tree, code);
                } else if (code.contains("rolling_downhill")) {
                    handleRollingDownhillSimulation(tree, code);
                } else if (code.contains("electrostatic_field")) {
                    handleElectrostaticFieldSimulation(tree, code);
                } else {
                    outputArea.append("ERROR: Unsupported simulation type.\n");
                }

            } finally {
                System.setOut(oldOut);
                System.setErr(oldErr);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    this,
                    "Critical Error: " + ex.getMessage(),
                    "Application Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void handleAcceleratedMotionSimulation2(ParseTree tree, String code) {
        outputArea.append("Detected accelerated motion simulation\n");
        try {
            AcceleratedUniformMotionVisitor motionVisitor = new AcceleratedUniformMotionVisitor();

            motionVisitor.visit(tree);

            Map<String, Object> sim = motionVisitor.getSimulation();

            outputArea.append("DEBUG: Full simulation map: " + sim + "\n");

            float initialSpeed = 2.5f;
            float acceleration = 0.05f;
            float radius = 30f;
            int[] color = {0, 100, 255};

            if (sim != null && sim.containsKey("accelerated_motion")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("accelerated_motion");

                outputArea.append("DEBUG: Accelerated motion module found: " + module + "\n");

                if (module != null) {
                    if (module.containsKey("initial_speed")) {
                        Object speedObj = module.get("initial_speed");
                        outputArea.append("DEBUG: Raw initial speed value: " + speedObj + "\n");
                        try {
                            initialSpeed = Float.parseFloat(speedObj.toString());
                            outputArea.append("DEBUG: Successfully extracted initial speed: " + initialSpeed + "\n");
                        } catch (NumberFormatException e) {
                            outputArea.append("DEBUG: Error parsing initial speed: " + speedObj + " - " + e.getMessage() + "\n");
                        }
                    }

                    if (module.containsKey("initial_acceleration")) {
                        Object accelObj = module.get("initial_acceleration");
                        outputArea.append("DEBUG: Raw acceleration value: " + accelObj + "\n");
                        try {
                            acceleration = Float.parseFloat(accelObj.toString());
                            outputArea.append("DEBUG: Successfully extracted acceleration: " + acceleration + "\n");
                        } catch (NumberFormatException e) {
                            outputArea.append("DEBUG: Error parsing acceleration: " + accelObj + " - " + e.getMessage() + "\n");
                        }
                    }

                    if (module.containsKey("mover")) {
                        Object moverObj = module.get("mover");
                        outputArea.append("DEBUG: Mover object found: " + moverObj + "\n");

                        if (moverObj instanceof Map) {
                            @SuppressWarnings("unchecked")
                            Map<String, Object> mover = (Map<String, Object>) moverObj;

                            if (mover.containsKey("radius")) {
                                Object radiusObj = mover.get("radius");
                                try {
                                    radius = Float.parseFloat(radiusObj.toString());
                                    outputArea.append("DEBUG: Successfully extracted radius: " + radius + "\n");
                                } catch (NumberFormatException e) {
                                    outputArea.append("DEBUG: Error parsing radius: " + radiusObj + " - " + e.getMessage() + "\n");
                                }
                            }

                            if (mover.containsKey("color")) {
                                Object colorObj = mover.get("color");
                                outputArea.append("DEBUG: Color object found: " + colorObj + "\n");

                                if (colorObj instanceof Map) {
                                    @SuppressWarnings("unchecked")
                                    Map<String, Object> colorMap = (Map<String, Object>) colorObj;

                                    try {
                                        if (colorMap.containsKey("red_value") &&
                                                colorMap.containsKey("green_value") &&
                                                colorMap.containsKey("blue_value")) {

                                            Object redObj = colorMap.get("red_value");
                                            Object greenObj = colorMap.get("green_value");
                                            Object blueObj = colorMap.get("blue_value");

                                            if (redObj instanceof Integer) {
                                                color[0] = (Integer) redObj;
                                                color[1] = (Integer) greenObj;
                                                color[2] = (Integer) blueObj;
                                            } else {
                                                color[0] = Integer.parseInt(redObj.toString());
                                                color[1] = Integer.parseInt(greenObj.toString());
                                                color[2] = Integer.parseInt(blueObj.toString());
                                            }

                                            outputArea.append("DEBUG: Successfully extracted color: RGB(" +
                                                    color[0] + ", " + color[1] + ", " + color[2] + ")\n");
                                        }
                                    } catch (Exception e) {
                                        outputArea.append("DEBUG: Error parsing color values: " + e.getMessage() + "\n");
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                outputArea.append("DEBUG: No accelerated_motion module found in simulation map\n");
                if (sim != null) {
                    outputArea.append("DEBUG: Available keys in simulation map: " + sim.keySet() + "\n");
                }
            }

            outputArea.append("=== FINAL PARSED PARAMETERS ===\n");
            outputArea.append("Initial Speed: " + initialSpeed + "\n");
            outputArea.append("Acceleration: " + acceleration + "\n");
            outputArea.append("Radius: " + radius + "\n");
            outputArea.append("Ball color: RGB(" + color[0] + ", " + color[1] + ", " + color[2] + ")\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            AcceleratedMotionPanel2 panel = new AcceleratedMotionPanel2(radius, color, initialSpeed, acceleration);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing accelerated motion simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            AcceleratedMotionPanel2 panel = new AcceleratedMotionPanel2(30f, new int[]{0, 100, 255}, 2.5f, 0.05f);
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleDragForceSimulation(ParseTree tree, String code) {
        outputArea.append("Detected drag force simulation\n");
        try {
            DragForceVisitor dragForceVisitor = new DragForceVisitor();
            dragForceVisitor.visit(tree);
            Map<String, Object> sim = dragForceVisitor.getSimulation();

            int[] defaultMoverColor = {100, 0, 75};
            float defaultDragCoefficient = 0.1f;
            int[] defaultLiquidColor = {50, 100, 150};

            int[] mColor = defaultMoverColor;
            float dragCoefficient = defaultDragCoefficient;
            int[] lColor = defaultLiquidColor;

            if (sim != null && sim.containsKey("drag_force")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("drag_force");

                if (module != null) {
                    Object moverColorObj = module.get("mover_color");
                    if (moverColorObj != null) {
                        mColor = getColor(moverColorObj);
                    }

                    Object dragCoefficientObj = module.get("drag_coefficient");
                    if (dragCoefficientObj != null) {
                        dragCoefficient = Float.parseFloat(dragCoefficientObj.toString());
                    }

                    Object liquidColorObj = module.get("liquid_color");
                    if (liquidColorObj != null) {
                        lColor = getColor(liquidColorObj);
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Drag Coefficient: " + dragCoefficient + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            DragForcePanel panel = new DragForcePanel(mColor, dragCoefficient, lColor);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing drag force simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            DragForcePanel panel = new DragForcePanel(
                    new int[]{100, 0, 75}, 0.1f, new int[]{50, 100, 150});
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handlePendulumSimulation(ParseTree tree, String code) {
        outputArea.append("Detected pendulum simulation\n");
        try {
            PendulumVisitor pendulumVisitor = new PendulumVisitor();
            pendulumVisitor.visit(tree);
            Map<String, Object> sim = pendulumVisitor.getSimulation();

            float length = 175f;
            float radius = 20f;
            float angle = 45f;
            float angleV = 0f;
            float angleA = 0f;
            float airResistance = 0.01f;

            if (sim != null && sim.containsKey("pendulum")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("pendulum");

                if (module != null) {
                    if (module.containsKey("length")) {
                        length = Float.parseFloat(module.get("length").toString());
                    }
                    if (module.containsKey("ball_radius")) {
                        radius = Float.parseFloat(module.get("ball_radius").toString());
                    }
                    if (module.containsKey("initial_angle")) {
                        angle = Float.parseFloat(module.get("initial_angle").toString());
                    }
                    if (module.containsKey("angular_velocity")) {
                        angleV = Float.parseFloat(module.get("angular_velocity").toString());
                    }
                    if (module.containsKey("angular_acceleration")) {
                        angleA = Float.parseFloat(module.get("angular_acceleration").toString());
                    }
                    if (module.containsKey("air_resistance")) {
                        airResistance = Float.parseFloat(module.get("air_resistance").toString());
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Pendulum Length: " + length + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            PendulumPanel panel = new PendulumPanel(
                    length, radius, angle, angleV, angleA, airResistance
            );
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing pendulum simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            PendulumPanel panel = new PendulumPanel(175f, 20f, 45f, 0f, 0f, 0.01f);
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleWaveSimulation(ParseTree tree, String code) {
        outputArea.append("Detected wave simulation\n");
        try {
            WaveVisitor waveVisitor = new WaveVisitor();
            waveVisitor.visit(tree);
            Map<String, Object> sim = waveVisitor.getSimulation();

            float startAngle = 0f;
            float angleVelocity = 0.05f;
            float amplitude = 75f;
            float frequency = 2f;
            float phaseShift = 0f;

            if (sim != null && sim.containsKey("wave")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("wave");

                if (module != null) {
                    if (module.containsKey("start_angle")) {
                        startAngle = Float.parseFloat(module.get("start_angle").toString());
                    }
                    if (module.containsKey("angle_velocity")) {
                        angleVelocity = Float.parseFloat(module.get("angle_velocity").toString());
                    }
                    if (module.containsKey("amplitude")) {
                        amplitude = Float.parseFloat(module.get("amplitude").toString());
                    }
                    if (module.containsKey("frequency")) {
                        frequency = Float.parseFloat(module.get("frequency").toString());
                    }
                    if (module.containsKey("phase_shift")) {
                        phaseShift = Float.parseFloat(module.get("phase_shift").toString());
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Wave Amplitude: " + amplitude + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            WavePanel panel = new WavePanel(startAngle, angleVelocity, amplitude, frequency, phaseShift);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing wave simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            WavePanel panel = new WavePanel(0f, 0.05f, 75f, 2f, 0f);
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleUniformMotionSimulation(ParseTree tree, String code) {
        outputArea.append("Detected uniform motion simulation\n");
        try {
            UniformMotionVisitor motionVisitor = new UniformMotionVisitor();
            motionVisitor.visit(tree);
            Map<String, Object> sim = motionVisitor.getSimulation();

            float initialSpeed = 2.5f;
            float radius = 30f;
            int[] color = {255, 100, 0};

            if (sim != null && sim.containsKey("uniform_motion")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("uniform_motion");

                if (module != null) {
                    if (module.containsKey("initial_speed")) {
                        initialSpeed = Float.parseFloat(module.get("initial_speed").toString());
                    }

                    @SuppressWarnings("unchecked")
                    Map<String, Object> mover = (Map<String, Object>) module.get("mover");
                    if (mover != null) {
                        if (mover.containsKey("radius")) {
                            radius = Float.parseFloat(mover.get("radius").toString());
                        }

                        @SuppressWarnings("unchecked")
                        Map<String, Object> colorMap = (Map<String, Object>) mover.get("color");
                        if (colorMap != null) {
                            int[] extractedColor = getColor(colorMap);
                            if (extractedColor != null) {
                                color = extractedColor;
                            }
                        }
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Initial Speed: " + initialSpeed + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            UniformMotionPanel panel = new UniformMotionPanel(radius, color, initialSpeed);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing uniform motion simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            UniformMotionPanel panel = new UniformMotionPanel(30f, new int[]{255, 100, 0}, 2.5f);
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleCircularMotionSimulation(ParseTree tree, String code) {
        outputArea.append("Detected circular motion simulation\n");
        try {
            CircularMotionVisitor circularMotionVisitor = new CircularMotionVisitor();
            circularMotionVisitor.visit(tree);
            Map<String, Object> sim = circularMotionVisitor.getSimulation();

            float radius = 100f;
            float angularSpeed = 0.05f;
            int[] color = {255, 100, 0};
            float ballRadius = 20f;

            if (sim != null && sim.containsKey("circular_motion")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("circular_motion");

                if (module != null) {
                    if (module.containsKey("radius")) {
                        radius = Float.parseFloat(module.get("radius").toString());
                    }

                    if (module.containsKey("angular_speed")) {
                        angularSpeed = Float.parseFloat(module.get("angular_speed").toString());
                    }

                    @SuppressWarnings("unchecked")
                    Map<String, Object> ball = (Map<String, Object>) module.get("ball");
                    if (ball != null) {
                        if (ball.containsKey("radius")) {
                            ballRadius = Float.parseFloat(ball.get("radius").toString());
                        }

                        @SuppressWarnings("unchecked")
                        Map<String, Object> colorMap = (Map<String, Object>) ball.get("color");
                        if (colorMap != null) {
                            int[] extractedColor = getColor(colorMap);
                            if (extractedColor != null) {
                                color = extractedColor;
                            }
                        }
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Orbit Radius: " + radius + "\n");
            outputArea.append("Angular Speed: " + angularSpeed + "\n");
            outputArea.append("Ball Radius: " + ballRadius + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            CircularMotionPanel panel = new CircularMotionPanel(radius, angularSpeed, color, ballRadius);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing circular motion simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            CircularMotionPanel panel = new CircularMotionPanel(100f, 0.05f, new int[]{255, 100, 0}, 20f);
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleGravitySimulation(ParseTree tree, String code) {
        outputArea.append("Detected gravity simulation\n");
        try {
            GravityVisitor gravityVisitor = new GravityVisitor();
            gravityVisitor.visit(tree);
            Map<String, Object> sim = gravityVisitor.getSimulation();

            float earthX = 400f;
            float earthY = 300f;
            float moonX = 250f;
            float moonY = 150f;

            if (sim != null && sim.containsKey("gravity")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("gravity");

                if (module != null) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> earth = (Map<String, Object>) module.get("earth");
                    @SuppressWarnings("unchecked")
                    Map<String, Object> moon = (Map<String, Object>) module.get("moon");

                    if (earth != null && moon != null) {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> earthPos = (Map<String, Object>) earth.get("position");
                        @SuppressWarnings("unchecked")
                        Map<String, Object> moonPos = (Map<String, Object>) moon.get("position");

                        if (earthPos != null && moonPos != null) {
                            if (earthPos.containsKey("x_position")) {
                                earthX = Float.parseFloat(earthPos.get("x_position").toString());
                            }
                            if (earthPos.containsKey("y_position")) {
                                earthY = Float.parseFloat(earthPos.get("y_position").toString());
                            }
                            if (moonPos.containsKey("x_position")) {
                                moonX = Float.parseFloat(moonPos.get("x_position").toString());
                            }
                            if (moonPos.containsKey("y_position")) {
                                moonY = Float.parseFloat(moonPos.get("y_position").toString());
                            }
                        }
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Earth Position: (" + earthX + ", " + earthY + ")\n");
            outputArea.append("Moon Position: (" + moonX + ", " + moonY + ")\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            GravityPanel panel = new GravityPanel(earthX, earthY, moonX, moonY);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing gravity simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            GravityPanel panel = new GravityPanel(400f, 300f, 250f, 150f);
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleAttractionForceSimulation(ParseTree tree, String code) {
        outputArea.append("Detected attraction force simulation\n");
        try {
            AttractionForceVisitor forceVisitor = new AttractionForceVisitor();
            forceVisitor.visit(tree);
            Map<String, Object> sim = forceVisitor.getSimulation();

            float radius1 = 30f;
            float mass1 = 50f;
            float[] position1 = {200f, 200f};
            float[] velocity1 = {0f, 0f};
            int[] color1 = {0, 100, 255};

            float radius2 = 20f;
            float mass2 = 25f;
            float[] position2 = {400f, 300f};
            float[] velocity2 = {1f, -1f};
            int[] color2 = {255, 100, 0};

            if (sim != null && sim.containsKey("attraction_force")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("attraction_force");

                if (module != null) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> mover1 = (Map<String, Object>) module.get("mover1");
                    if (mover1 != null) {
                        if (mover1.containsKey("radius")) {
                            radius1 = Float.parseFloat(mover1.get("radius").toString());
                        }
                        if (mover1.containsKey("mass")) {
                            mass1 = Float.parseFloat(mover1.get("mass").toString());
                        }
                        float[] extractedPosition = getPosition(mover1);
                        if (extractedPosition != null) {
                            position1 = extractedPosition;
                        }
                        float[] extractedVelocity = getVelocity(mover1);
                        if (extractedVelocity != null) {
                            velocity1 = extractedVelocity;
                        }

                        @SuppressWarnings("unchecked")
                        Map<String, Object> colorMap = (Map<String, Object>) mover1.get("color");
                        if (colorMap != null) {
                            int[] extractedColor = getColor(colorMap);
                            if (extractedColor != null) {
                                color1 = extractedColor;
                            }
                        }
                    }

                    @SuppressWarnings("unchecked")
                    Map<String, Object> mover2 = (Map<String, Object>) module.get("mover2");
                    if (mover2 != null) {
                        if (mover2.containsKey("radius")) {
                            radius2 = Float.parseFloat(mover2.get("radius").toString());
                        }
                        if (mover2.containsKey("mass")) {
                            mass2 = Float.parseFloat(mover2.get("mass").toString());
                        }
                        float[] extractedPosition = getPosition(mover2);
                        if (extractedPosition != null) {
                            position2 = extractedPosition;
                        }
                        float[] extractedVelocity = getVelocity(mover2);
                        if (extractedVelocity != null) {
                            velocity2 = extractedVelocity;
                        }

                        @SuppressWarnings("unchecked")
                        Map<String, Object> colorMap = (Map<String, Object>) mover2.get("color");
                        if (colorMap != null) {
                            int[] extractedColor = getColor(colorMap);
                            if (extractedColor != null) {
                                color2 = extractedColor;
                            }
                        }
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Mover1 Mass: " + mass1 + ", Mover2 Mass: " + mass2 + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            AttractionForcePanel panel = new AttractionForcePanel(
                    radius1, mass1, position1, velocity1,
                    radius2, mass2, position2, velocity2,
                    color1, color2
            );
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing attraction force simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            AttractionForcePanel panel = new AttractionForcePanel(
                    30f, 50f, new float[]{200f, 200f}, new float[]{0f, 0f},
                    20f, 25f, new float[]{400f, 300f}, new float[]{1f, -1f},
                    new int[]{0, 100, 255}, new int[]{255, 100, 0}
            );
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleCollisionSimulation(ParseTree tree, String code) {
        outputArea.append("Detected collision simulation\n");
        try {
            CollisionVisitor collisionVisitor = new CollisionVisitor();
            collisionVisitor.visit(tree);
            Map<String, Object> sim = collisionVisitor.getSimulation();

            List<CollisionMover> movers = new ArrayList<>();

            if (sim != null && sim.containsKey("collision")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("collision");

                if (module != null) {
                    @SuppressWarnings("unchecked")
                    List<Map<String, Object>> moversData = (List<Map<String, Object>>) module.get("movers");

                    if (moversData != null) {
                        for (Map<String, Object> moverData : moversData) {
                            CollisionMover mover = createMoverFromData(moverData);
                            movers.add(mover);
                        }
                    }
                }
            }

            if (movers.isEmpty()) {
                movers = createDefaultMovers();
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Number of movers: " + movers.size() + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            CollisionPanel panel = new CollisionPanel(movers);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing collision simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            CollisionPanel panel = new CollisionPanel(createDefaultMovers());
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleSpringSimulation(ParseTree tree, String code) {
        outputArea.append("Detected spring simulation\n");
        outputArea.append("DEBUG: Input code:\n" + code + "\n");

        try {
            SpringVisitor springVisitor = new SpringVisitor();
            springVisitor.visit(tree);
            Map<String, Object> sim = springVisitor.getSimulation();
            outputArea.append("DEBUG: Parsed simulation map: " + sim + "\n");

            float springConstant = 0.1f;
            float damping = 0.01f;
            float restLength = 100f;
            float floorFriction = 0.05f;
            float ballRadius = 20f;
            int[] ballColor = {255, 0, 0};
            float xAnchor = 300f;
            float yAnchor = 50f;
            int numCoils = 12;

            if (sim != null && sim.containsKey("spring")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("spring");

                if (module != null) {
                    if (module.containsKey("spring_constant")) {
                        String springConstantStr = module.get("spring_constant").toString();
                        springConstant = Float.parseFloat(springConstantStr);
                        outputArea.append("DEBUG: Extracted spring constant: " + springConstant + "\n");
                    }
                    if (module.containsKey("damping")) {
                        damping = Float.parseFloat(module.get("damping").toString());
                    }
                    if (module.containsKey("spring_rest_length")) {
                        restLength = Float.parseFloat(module.get("spring_rest_length").toString());
                    }
                    if (module.containsKey("floor_friction")) {
                        floorFriction = Float.parseFloat(module.get("floor_friction").toString());
                    }

                    @SuppressWarnings("unchecked")
                    Map<String, Object> ball = (Map<String, Object>) module.get("ball");
                    if (ball != null) {
                        if (ball.containsKey("radius")) {
                            ballRadius = Float.parseFloat(ball.get("radius").toString());
                        }
                        Object colorObj = ball.get("color");
                        if (colorObj instanceof Map) {
                            @SuppressWarnings("unchecked")
                            Map<String, Object> colorMap = (Map<String, Object>) colorObj;

                            if (colorMap.containsKey("red_value")) {
                                ballColor[0] = Integer.parseInt(colorMap.get("red_value").toString());
                                ballColor[1] = Integer.parseInt(colorMap.get("green_value").toString());
                                ballColor[2] = Integer.parseInt(colorMap.get("blue_value").toString());
                            } else if (colorMap.containsKey("r")) {
                                ballColor[0] = Integer.parseInt(colorMap.get("r").toString());
                                ballColor[1] = Integer.parseInt(colorMap.get("g").toString());
                                ballColor[2] = Integer.parseInt(colorMap.get("b").toString());
                            }
                        }
                    }

                    @SuppressWarnings("unchecked")
                    Map<String, Object> spring = (Map<String, Object>) module.get("spring");
                    if (spring != null) {
                        if (spring.containsKey("x_anchor_position")) {
                            xAnchor = Float.parseFloat(spring.get("x_anchor_position").toString());
                        }
                        if (spring.containsKey("y_anchor_position")) {
                            yAnchor = Float.parseFloat(spring.get("y_anchor_position").toString());
                        }
                        if (spring.containsKey("num_coils")) {
                            numCoils = Integer.parseInt(spring.get("num_coils").toString());
                        }
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Spring Constant: " + springConstant + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            SpringPanel panel = new SpringPanel(springConstant, damping, restLength,
                    floorFriction, ballRadius, ballColor,
                    xAnchor, yAnchor, numCoils);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing spring simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            SpringPanel panel = new SpringPanel(0.1f, 0.01f, 100f, 0.05f, 20f,
                    new int[]{255, 0, 0}, 300f, 50f, 12);
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleRollingDownhillSimulation(ParseTree tree, String code) {
        outputArea.append("Detected rolling downhill simulation\n");
        try {
            RollingDownhillVisitor rollingVisitor = new RollingDownhillVisitor();

            rollingVisitor.visit(tree);

            Map<String, Object> sim = rollingVisitor.getSimulation();

            outputArea.append("DEBUG: Full simulation map: " + sim + "\n");

            float gravitationalAcceleration = 9.8f;
            float friction = 0.1f;
            float bounciness = 0.7f;
            float angle = 30f;
            float velocity = 5f;
            float ballRadius = 20f;
            int[] ballColor = {255, 100, 0};

            if (sim != null && sim.containsKey("rolling_downhill")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("rolling_downhill");

                outputArea.append("DEBUG: Rolling downhill module found: " + module + "\n");

                if (module != null) {
                    if (module.containsKey("gravitational_acceleration")) {
                        Object gravObj = module.get("gravitational_acceleration");
                        outputArea.append("DEBUG: Raw gravity value: " + gravObj + " (type: " + gravObj.getClass().getSimpleName() + ")\n");
                        try {
                            gravitationalAcceleration = Float.parseFloat(gravObj.toString());
                            outputArea.append("DEBUG: Successfully extracted gravity: " + gravitationalAcceleration + "\n");
                        } catch (NumberFormatException e) {
                            outputArea.append("DEBUG: Error parsing gravity: " + gravObj + " - " + e.getMessage() + "\n");
                        }
                    }

                    if (module.containsKey("coefficient_of_friction")) {
                        Object frictionObj = module.get("coefficient_of_friction");
                        outputArea.append("DEBUG: Raw friction value: " + frictionObj + " (type: " + frictionObj.getClass().getSimpleName() + ")\n");
                        try {
                            friction = Float.parseFloat(frictionObj.toString());
                            outputArea.append("DEBUG: Successfully extracted friction: " + friction + "\n");
                        } catch (NumberFormatException e) {
                            outputArea.append("DEBUG: Error parsing friction: " + frictionObj + " - " + e.getMessage() + "\n");
                        }
                    }

                    if (module.containsKey("bounciness")) {
                        Object bouncinessObj = module.get("bounciness");
                        outputArea.append("DEBUG: Raw bounciness value: " + bouncinessObj + " (type: " + bouncinessObj.getClass().getSimpleName() + ")\n");
                        try {
                            bounciness = Float.parseFloat(bouncinessObj.toString());
                            outputArea.append("DEBUG: Successfully extracted bounciness: " + bounciness + "\n");
                        } catch (NumberFormatException e) {
                            outputArea.append("DEBUG: Error parsing bounciness: " + bouncinessObj + " - " + e.getMessage() + "\n");
                        }
                    }

                    if (module.containsKey("angle")) {
                        Object angleObj = module.get("angle");
                        outputArea.append("DEBUG: Raw angle value: " + angleObj + " (type: " + angleObj.getClass().getSimpleName() + ")\n");
                        try {
                            angle = Float.parseFloat(angleObj.toString());
                            outputArea.append("DEBUG: Successfully extracted angle: " + angle + "\n");
                        } catch (NumberFormatException e) {
                            outputArea.append("DEBUG: Error parsing angle: " + angleObj + " - " + e.getMessage() + "\n");
                        }
                    }

                    if (module.containsKey("velocity_along_incline")) {
                        Object velocityObj = module.get("velocity_along_incline");
                        outputArea.append("DEBUG: Raw velocity value: " + velocityObj + " (type: " + velocityObj.getClass().getSimpleName() + ")\n");
                        try {
                            velocity = Float.parseFloat(velocityObj.toString());
                            outputArea.append("DEBUG: Successfully extracted velocity: " + velocity + "\n");
                        } catch (NumberFormatException e) {
                            outputArea.append("DEBUG: Error parsing velocity: " + velocityObj + " - " + e.getMessage() + "\n");
                        }
                    }

                    if (module.containsKey("ball")) {
                        Object ballObj = module.get("ball");
                        outputArea.append("DEBUG: Ball object found: " + ballObj + " (type: " + ballObj.getClass().getSimpleName() + ")\n");

                        if (ballObj instanceof Map) {
                            @SuppressWarnings("unchecked")
                            Map<String, Object> ball = (Map<String, Object>) ballObj;

                            if (ball.containsKey("radius")) {
                                Object radiusObj = ball.get("radius");
                                outputArea.append("DEBUG: Raw radius value: " + radiusObj + " (type: " + radiusObj.getClass().getSimpleName() + ")\n");
                                try {
                                    ballRadius = Float.parseFloat(radiusObj.toString());
                                    outputArea.append("DEBUG: Successfully extracted ball radius: " + ballRadius + "\n");
                                } catch (NumberFormatException e) {
                                    outputArea.append("DEBUG: Error parsing ball radius: " + radiusObj + " - " + e.getMessage() + "\n");
                                }
                            }

                            if (ball.containsKey("color")) {
                                Object colorObj = ball.get("color");
                                outputArea.append("DEBUG: Color object found: " + colorObj + " (type: " + colorObj.getClass().getSimpleName() + ")\n");

                                if (colorObj instanceof Map) {
                                    @SuppressWarnings("unchecked")
                                    Map<String, Object> colorMap = (Map<String, Object>) colorObj;

                                    try {
                                        if (colorMap.containsKey("red_value") &&
                                                colorMap.containsKey("green_value") &&
                                                colorMap.containsKey("blue_value")) {

                                            Object redObj = colorMap.get("red_value");
                                            Object greenObj = colorMap.get("green_value");
                                            Object blueObj = colorMap.get("blue_value");

                                            outputArea.append("DEBUG: Raw color values - R: " + redObj +
                                                    ", G: " + greenObj + ", B: " + blueObj + "\n");

                                            if (redObj instanceof Integer) {
                                                ballColor[0] = (Integer) redObj;
                                                ballColor[1] = (Integer) greenObj;
                                                ballColor[2] = (Integer) blueObj;
                                            } else {
                                                ballColor[0] = Integer.parseInt(redObj.toString());
                                                ballColor[1] = Integer.parseInt(greenObj.toString());
                                                ballColor[2] = Integer.parseInt(blueObj.toString());
                                            }

                                            outputArea.append("DEBUG: Successfully extracted color: RGB(" +
                                                    ballColor[0] + ", " + ballColor[1] + ", " + ballColor[2] + ")\n");
                                        } else {
                                            outputArea.append("DEBUG: Color map missing expected keys. Available keys: " + colorMap.keySet() + "\n");
                                        }
                                    } catch (Exception e) {
                                        outputArea.append("DEBUG: Error parsing color values: " + e.getMessage() + "\n");
                                        e.printStackTrace();
                                    }
                                } else {
                                    outputArea.append("DEBUG: Color object is not a Map: " + colorObj + "\n");
                                }
                            } else {
                                outputArea.append("DEBUG: Ball object doesn't contain 'color' key. Available keys: " + ball.keySet() + "\n");
                            }
                        } else {
                            outputArea.append("DEBUG: Ball object is not a Map: " + ballObj + "\n");
                        }
                    } else {
                        outputArea.append("DEBUG: Module doesn't contain 'ball' key. Available keys: " + module.keySet() + "\n");
                    }
                } else {
                    outputArea.append("DEBUG: Rolling downhill module is null\n");
                }
            } else {
                outputArea.append("DEBUG: No rolling_downhill module found in simulation map\n");
                if (sim != null) {
                    outputArea.append("DEBUG: Available keys in simulation map: " + sim.keySet() + "\n");
                } else {
                    outputArea.append("DEBUG: Simulation map is null\n");
                }
            }

            outputArea.append("=== FINAL PARSED PARAMETERS ===\n");
            outputArea.append("Gravitational acceleration: " + gravitationalAcceleration + "\n");
            outputArea.append("Coefficient of friction: " + friction + "\n");
            outputArea.append("Bounciness: " + bounciness + "\n");
            outputArea.append("Angle: " + angle + " degrees\n");
            outputArea.append("Velocity along incline: " + velocity + "\n");
            outputArea.append("Ball radius: " + ballRadius + "\n");
            outputArea.append("Ball color: RGB(" + ballColor[0] + ", " + ballColor[1] + ", " + ballColor[2] + ")\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            RollingDownhillPanel panel = new RollingDownhillPanel(
                    gravitationalAcceleration,
                    friction,
                    bounciness,
                    angle,
                    velocity,
                    ballRadius,
                    ballColor
            );
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing rolling downhill simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            RollingDownhillPanel panel = new RollingDownhillPanel(9.8f, 0.1f, 0.7f, 30f, 5f, 20f,
                    new int[]{255, 100, 0});
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleElectrostaticFieldSimulation(ParseTree tree, String code) {
        outputArea.append("Detected electrostatic field simulation\n");
        try {
            ElectrostaticFieldVisitor electrostaticVisitor = new ElectrostaticFieldVisitor();
            electrostaticVisitor.visit(tree);
            Map<String, Object> sim = electrostaticVisitor.getSimulation();

            float particleRadius = 20f;
            int fluxResolution = 16;

            if (sim != null && sim.containsKey("electrostatic_field")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> module = (Map<String, Object>) sim.get("electrostatic_field");

                if (module != null) {
                    if (module.containsKey("particle_radius")) {
                        particleRadius = Float.parseFloat(module.get("particle_radius").toString());
                    }
                    if (module.containsKey("flux_resolution")) {
                        fluxResolution = Integer.parseInt(module.get("flux_resolution").toString());
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Particle Radius: " + particleRadius + "\n");
            outputArea.append("Flux Resolution: " + fluxResolution + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            ElectrostaticFieldPanel panel = new ElectrostaticFieldPanel(particleRadius, fluxResolution);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing electrostatic field simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            ElectrostaticFieldPanel panel = new ElectrostaticFieldPanel(20f, 16);
            replaceSimulationPanel(panel);
            startAnimation(panel);
        }
    }

    private void handleAcceleratedMotionSimulation(ParseTree tree, String code) {
        outputArea.append("Detected accelerated motion simulation\n");
        try {
            outputArea.append("Using default parameters for accelerated motion.\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            UniformMotionPanel panel = new UniformMotionPanel(30f, new int[]{255, 100, 0}, 5.0f);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing accelerated motion simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
    }

    private CollisionMover createMoverFromData(Map<String, Object> moverData) {
        float radius = 20f;
        float mass = 10f;
        float[] position = {100f, 100f};
        float[] velocity = {0f, 0f};
        int[] color = {255, 0, 0};

        try {
            if (moverData.containsKey("radius")) {
                radius = Float.parseFloat(moverData.get("radius").toString());
            }
            if (moverData.containsKey("mass")) {
                mass = Float.parseFloat(moverData.get("mass").toString());
            }

            Object posObj = moverData.get("position");
            if (posObj instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> posMap = (Map<String, Object>) posObj;
                if (posMap.containsKey("x_position") && posMap.containsKey("y_position")) {
                    position[0] = Float.parseFloat(posMap.get("x_position").toString());
                    position[1] = Float.parseFloat(posMap.get("y_position").toString());
                }
            }

            Object velObj = moverData.get("velocity");
            if (velObj instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> velMap = (Map<String, Object>) velObj;
                if (velMap.containsKey("x_velocity") && velMap.containsKey("y_velocity")) {
                    velocity[0] = Float.parseFloat(velMap.get("x_velocity").toString());
                    velocity[1] = Float.parseFloat(velMap.get("y_velocity").toString());
                }
            }

            Object colorObj = moverData.get("color");
            if (colorObj instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> colorMap = (Map<String, Object>) colorObj;
                if (colorMap.containsKey("red_value") && colorMap.containsKey("green_value") && colorMap.containsKey("blue_value")) {
                    color[0] = Integer.parseInt(colorMap.get("red_value").toString());
                    color[1] = Integer.parseInt(colorMap.get("green_value").toString());
                    color[2] = Integer.parseInt(colorMap.get("blue_value").toString());
                }
            }
        } catch (Exception e) {
            outputArea.append("Warning: Error parsing mover data, using defaults: " + e.getMessage() + "\n");
        }

        return new CollisionMover(radius, mass, position, velocity, color);
    }

    private List<CollisionMover> createDefaultMovers() {
        List<CollisionMover> movers = new ArrayList<>();

        movers.add(new CollisionMover(15f, 10f, new float[]{100f, 150f}, new float[]{2f, 1f}, new int[]{255, 0, 0}));
        movers.add(new CollisionMover(20f, 15f, new float[]{300f, 200f}, new float[]{-1f, 2f}, new int[]{0, 255, 0}));
        movers.add(new CollisionMover(25f, 20f, new float[]{500f, 100f}, new float[]{-2f, -1f}, new int[]{0, 0, 255}));

        return movers;
    }

    private float[] getPosition(Map<String, Object> mover) {
        try {
            Object pos = mover.get("position");
            if (pos instanceof float[]) {
                return (float[]) pos;
            }
        } catch (Exception e) {
        }
        return new float[]{200f, 200f};
    }

    private float[] getVelocity(Map<String, Object> mover) {
        try {
            Object vel = mover.get("velocity");
            if (vel instanceof float[]) {
                return (float[]) vel;
            }
        } catch (Exception e) {
        }
        return new float[]{0f, 0f};
    }

    private int[] getColor(Object obj) {
        try {
            if (obj instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> colorMap = (Map<String, Object>) obj;

                if (colorMap.containsKey("red_value") && colorMap.containsKey("green_value") && colorMap.containsKey("blue_value")) {
                    int r = Integer.parseInt(colorMap.get("red_value").toString());
                    int g = Integer.parseInt(colorMap.get("green_value").toString());
                    int b = Integer.parseInt(colorMap.get("blue_value").toString());
                    return new int[]{r, g, b};
                }
            }
        } catch (Exception e) {
            outputArea.append("Error extracting color: " + e.getMessage() + "\n");
        }

        return new int[]{255, 0, 0};
    }

    private class GravITyErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                int line, int charPositionInLine, String msg, RecognitionException e) {
            outputArea.append("Syntax Error at line " + line + ":" + charPositionInLine + " - " + msg + "\n");
        }
    }

    private static class CollisionMover {
        float radius, mass;
        float[] position;
        float[] velocity;
        int[] color;

        public CollisionMover(float radius, float mass, float[] position, float[] velocity, int[] color) {
            this.radius = radius;
            this.mass = mass;
            this.position = position.clone();
            this.velocity = velocity.clone();
            this.color = color.clone();
        }
    }

    private interface AnimatedPanel {
        void update();

        default boolean handleMousePressed(MouseEvent e) {
            return false;
        }

        default void handleMouseDragged(MouseEvent e) {
        }

        default void handleMouseReleased(MouseEvent e) {
        }
    }

    private void replaceSimulationPanel(JPanel newPanel) {
        Container parent = simulationPanel.getParent();

        parent.remove(simulationPanel);

        newPanel.setBackground(Color.WHITE);
        parent.add(newPanel, BorderLayout.CENTER);

        simulationPanel = newPanel;

        if (newPanel instanceof AnimatedPanel) {
            newPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    ((AnimatedPanel) newPanel).handleMousePressed(e);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    ((AnimatedPanel) newPanel).handleMouseReleased(e);
                }
            });

            newPanel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    ((AnimatedPanel) newPanel).handleMouseDragged(e);
                }
            });
        }

        parent.revalidate();
        parent.repaint();
    }

    private void startAnimation(JPanel panel) {
        if (animationTimer != null && animationTimer.isRunning()) {
            animationTimer.stop();
        }

        animationTimer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel instanceof AnimatedPanel) {
                    ((AnimatedPanel) panel).update();
                }
                panel.repaint();
            }
        });
        animationTimer.start();
    }

    private class GravityPanel extends JPanel implements AnimatedPanel {
        private float earthX, earthY, moonX, moonY;
        private float angle = 0;
        private float orbitRadius;
        private int frameCount = 0;
        private boolean draggingEarth = false;
        private boolean draggingMoon = false;

        public GravityPanel(float earthX, float earthY, float moonX, float moonY) {
            this.earthX = earthX;
            this.earthY = earthY;
            this.moonX = moonX;
            this.moonY = moonY;

            float dx = moonX - earthX;
            float dy = moonY - earthY;
            this.orbitRadius = (float) Math.sqrt(dx * dx + dy * dy);

            this.angle = (float) Math.atan2(dy, dx);

            setBackground(Color.BLACK);

            updateSimulationData();
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            int earthRadius = 30;
            int moonRadius = 15;

            if (distance(e.getX(), e.getY(), earthX, earthY) <= earthRadius) {
                draggingEarth = true;
                return true;
            }

            if (distance(e.getX(), e.getY(), moonX, moonY) <= moonRadius) {
                draggingMoon = true;
                return true;
            }

            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (draggingEarth) {
                earthX = e.getX();
                earthY = e.getY();

                float dx = moonX - earthX;
                float dy = moonY - earthY;
                orbitRadius = (float) Math.sqrt(dx * dx + dy * dy);
                angle = (float) Math.atan2(dy, dx);

                updateSimulationData();
            } else if (draggingMoon) {
                moonX = e.getX();
                moonY = e.getY();

                float dx = moonX - earthX;
                float dy = moonY - earthY;
                orbitRadius = (float) Math.sqrt(dx * dx + dy * dy);
                angle = (float) Math.atan2(dy, dx);

                updateSimulationData();
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            draggingEarth = false;
            draggingMoon = false;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final float vx = -orbitRadius * (float) Math.sin(angle) * 0.02f;
            final float vy = orbitRadius * (float) Math.cos(angle) * 0.02f;
            final float velocity = (float) Math.sqrt(vx * vx + vy * vy);
            final float currentAngle = angle;
            final float currentOrbitRadius = orbitRadius;
            final float currentEarthX = earthX;
            final float currentEarthY = earthY;
            final float currentMoonX = moonX;
            final float currentMoonY = moonY;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Gravity Simulation Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Earth Position: (").append(String.format("%.1f", currentEarthX)).append(", ")
                        .append(String.format("%.1f", currentEarthY)).append(")\n");
                newOutput.append("Moon Position: (").append(String.format("%.1f", currentMoonX)).append(", ")
                        .append(String.format("%.1f", currentMoonY)).append(")\n");
                newOutput.append("Orbit Radius: ").append(String.format("%.1f", currentOrbitRadius)).append("\n");
                newOutput.append("Current Angle: ").append(String.format("%.2f", currentAngle * 180 / Math.PI)).append(" degrees\n");
                newOutput.append("Moon Velocity: ").append(String.format("%.2f", velocity)).append("\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            if (!draggingMoon) {
                angle += 0.02;
                moonX = earthX + orbitRadius * (float) Math.cos(angle);
                moonY = earthY + orbitRadius * (float) Math.sin(angle);
            }

            frameCount++;
            if (frameCount % 10 == 0) {
                updateSimulationData();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(new Color(80, 80, 80));
            g.drawOval((int) (earthX - orbitRadius), (int) (earthY - orbitRadius),
                    (int) (orbitRadius * 2), (int) (orbitRadius * 2));

            g.setColor(new Color(70, 130, 180));
            int earthRadius = 30;
            g.fillOval((int) earthX - earthRadius, (int) earthY - earthRadius,
                    earthRadius * 2, earthRadius * 2);

            g.setColor(new Color(200, 200, 200));
            int moonRadius = 15;
            g.fillOval((int) moonX - moonRadius, (int) moonY - moonRadius,
                    moonRadius * 2, moonRadius * 2);

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 200, 60);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Gravity Simulation", 20, 30);
            g.drawString("Earth-Moon System", 20, 50);
        }
    }

    private class PendulumPanel extends JPanel implements AnimatedPanel {
        private float length;
        private float radius;
        private float angle;
        private float angleV;
        private float angleA;
        private float airResistance;
        private float gravity = 0.5f;
        private int originX, originY;
        private int frameCount = 0;
        private boolean dragging = false;

        public PendulumPanel(float length, float radius, float angle, float angleV, float angleA, float airResistance) {
            this.length = length;
            this.radius = radius;
            this.angle = (float) Math.toRadians(angle);
            this.angleV = angleV;
            this.angleA = angleA;
            this.airResistance = airResistance;
            setBackground(Color.WHITE);

            updateSimulationData();
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            int bobX = originX + (int) (length * Math.sin(angle));
            int bobY = originY + (int) (length * Math.cos(angle));

            if (distance(e.getX(), e.getY(), bobX, bobY) <= radius) {
                dragging = true;
                return true;
            }

            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (dragging) {
                float dx = e.getX() - originX;
                float dy = e.getY() - originY;

                float newLength = (float) Math.sqrt(dx * dx + dy * dy);
                float ratio = length / newLength;

                int newX = originX + (int) (dx * ratio);
                int newY = originY + (int) (dy * ratio);

                angle = (float) Math.atan2(newX - originX, newY - originY);

                angleV = 0;

                updateSimulationData();
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            dragging = false;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final float angleDegrees = (float) Math.toDegrees(angle);
            final float currentAngleV = angleV;
            final float currentAngleA = angleA;
            final float currentLength = length;
            final float currentAirResistance = airResistance;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Pendulum Simulation Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Length: ").append(String.format("%.1f", currentLength)).append("\n");
                newOutput.append("Angle: ").append(String.format("%.2f", angleDegrees)).append(" degrees\n");
                newOutput.append("Angular Velocity: ").append(String.format("%.4f", currentAngleV)).append("\n");
                newOutput.append("Angular Acceleration: ").append(String.format("%.4f", currentAngleA)).append("\n");
                newOutput.append("Air Resistance: ").append(String.format("%.4f", currentAirResistance)).append("\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            if (!dragging) {
                angleA = -gravity * (float) Math.sin(angle) / length;

                angleV = angleV * (1 - airResistance);

                angleV += angleA;

                angle += angleV;
            }

            frameCount++;
            if (frameCount % 10 == 0) {
                updateSimulationData();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            originX = getWidth() / 2;
            originY = 50;

            int bobX = originX + (int) (length * Math.sin(angle));
            int bobY = originY + (int) (length * Math.cos(angle));

            g.setColor(Color.BLACK);
            g.drawLine(originX, originY, bobX, bobY);

            g.setColor(new Color(200, 0, 0));
            g.fillOval(bobX - (int) radius, bobY - (int) radius, (int) radius * 2, (int) radius * 2);

            g.setColor(Color.BLACK);
            g.fillOval(originX - 5, originY - 5, 10, 10);

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 200, 80);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Pendulum Simulation", 20, 30);
            g.drawString("Length: " + String.format("%.1f", length), 20, 50);
            g.drawString("Air Resistance: " + String.format("%.3f", airResistance), 20, 70);
        }
    }

    private class WavePanel extends JPanel implements AnimatedPanel {
        private float startAngle;
        private float angleVelocity;
        private float amplitude;
        private float frequency;
        private float phaseShift;
        private float currentAngle;
        private int frameCount = 0;
        private boolean dragging = false;
        private int dragPoint = -1;

        public WavePanel(float startAngle, float angleVelocity, float amplitude, float frequency, float phaseShift) {
            this.startAngle = startAngle;
            this.angleVelocity = angleVelocity;
            this.amplitude = amplitude;
            this.frequency = frequency;
            this.phaseShift = phaseShift;
            this.currentAngle = startAngle;
            setBackground(Color.WHITE);

            updateSimulationData();
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            int centerY = getHeight() / 2;

            for (int x = 0; x < getWidth(); x += 10) {
                float angle = currentAngle + (x * frequency / 100) + phaseShift;
                int y = centerY - (int) (amplitude * Math.sin(angle));

                if (distance(e.getX(), e.getY(), x, y) < 20) {
                    dragPoint = x;
                    dragging = true;
                    return true;
                }
            }

            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (dragging && dragPoint >= 0) {
                int centerY = getHeight() / 2;
                int deltaY = centerY - e.getY();

                amplitude = Math.abs(deltaY);

                updateSimulationData();
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            dragging = false;
            dragPoint = -1;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final float currentAmplitude = amplitude;
            final float currentFrequency = frequency;
            final float currentAngleVelocity = angleVelocity;
            final float currentStartAngle = currentAngle;
            final float currentPhaseShift = phaseShift;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Wave Simulation Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Amplitude: ").append(String.format("%.1f", currentAmplitude)).append("\n");
                newOutput.append("Frequency: ").append(String.format("%.2f", currentFrequency)).append("\n");
                newOutput.append("Angle Velocity: ").append(String.format("%.4f", currentAngleVelocity)).append("\n");
                newOutput.append("Current Angle: ").append(String.format("%.2f", currentStartAngle)).append("\n");
                newOutput.append("Phase Shift: ").append(String.format("%.2f", currentPhaseShift)).append("\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            currentAngle += angleVelocity;

            frameCount++;
            if (frameCount % 10 == 0) {
                updateSimulationData();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.LIGHT_GRAY);
            int centerY = getHeight() / 2;
            g.drawLine(0, centerY, getWidth(), centerY);

            g.setColor(Color.BLUE);
            int lastX = 0;
            int lastY = centerY;

            for (int x = 0; x < getWidth(); x += 2) {
                float angle = currentAngle + (x * frequency / 100) + phaseShift;
                int y = centerY - (int) (amplitude * Math.sin(angle));

                if (x > 0) {
                    g.drawLine(lastX, lastY, x, y);
                }

                lastX = x;
                lastY = y;
            }

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 200, 80);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Wave Simulation", 20, 30);
            g.drawString("Amplitude: " + String.format("%.1f", amplitude), 20, 50);
            g.drawString("Frequency: " + String.format("%.2f", frequency), 20, 70);
        }
    }

    private class UniformMotionPanel extends JPanel implements AnimatedPanel {
        private float radius;
        private int[] color;
        private float speed;
        private float x = 0;
        private int frameCount = 0;
        private boolean dragging = false;

        public UniformMotionPanel(float radius, int[] color, float speed) {
            this.radius = radius;
            this.color = color;
            this.speed = speed;
            setBackground(Color.WHITE);

            updateSimulationData();
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            int groundY = getHeight() - 50;
            int y = groundY - (int) radius;

            if (distance(e.getX(), e.getY(), x, y) <= radius) {
                dragging = true;
                return true;
            }

            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (dragging) {
                x = e.getX();
                updateSimulationData();
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            dragging = false;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final float distance = x % getWidth();
            final float currentSpeed = speed;
            final float currentRadius = radius;
            final float totalDistance = x;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Uniform Motion Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Speed: ").append(String.format("%.2f", currentSpeed)).append(" units/frame\n");
                newOutput.append("Position X: ").append(String.format("%.1f", distance)).append("\n");
                newOutput.append("Radius: ").append(String.format("%.1f", currentRadius)).append("\n");
                newOutput.append("Distance traveled: ").append(String.format("%.1f", totalDistance)).append(" units\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            if (!dragging) {
                x += speed;
                if (x > getWidth() + radius) {
                    x = -radius;
                }
            }

            frameCount++;
            if (frameCount % 10 == 0) {
                updateSimulationData();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.BLACK);
            int groundY = getHeight() - 50;
            g.drawLine(0, groundY, getWidth(), groundY);

            g.setColor(new Color(color[0], color[1], color[2]));
            int y = groundY - (int) radius;
            g.fillOval((int) x - (int) radius, y - (int) radius, (int) radius * 2, (int) radius * 2);

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 200, 60);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Uniform Motion Simulation", 20, 30);
            g.drawString("Speed: " + String.format("%.2f", speed), 20, 50);
        }
    }

    private class CircularMotionPanel extends JPanel implements AnimatedPanel {
        private float radius;
        private float angularSpeed;
        private int[] color;
        private float ballRadius = 20f;
        private float angle = 0;
        private int centerX, centerY;
        private int frameCount = 0;
        private boolean dragging = false;

        public CircularMotionPanel(float radius, float angularSpeed, int[] color, float ballRadius) {
            this.radius = radius;
            this.angularSpeed = angularSpeed;
            this.color = color;
            this.ballRadius = ballRadius;
            setBackground(Color.WHITE);

            updateSimulationData();
        }

        public CircularMotionPanel(float radius, float angularSpeed, int[] color) {
            this(radius, angularSpeed, color, 20f);
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            int ballX = centerX + (int) (radius * Math.cos(angle));
            int ballY = centerY + (int) (radius * Math.sin(angle));

            if (distance(e.getX(), e.getY(), ballX, ballY) <= ballRadius) {
                dragging = true;
                return true;
            }

            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (dragging) {
                float dx = e.getX() - centerX;
                float dy = e.getY() - centerY;

                angle = (float) Math.atan2(dy, dx);

                float newRadius = (float) Math.sqrt(dx * dx + dy * dy);
                radius = newRadius;

                updateSimulationData();
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            dragging = false;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            centerX = getWidth() / 2;
            centerY = getHeight() / 2;
            final float x = centerX + radius * (float) Math.cos(angle);
            final float y = centerY + radius * (float) Math.sin(angle);

            final float vx = -radius * angularSpeed * (float) Math.sin(angle);
            final float vy = radius * angularSpeed * (float) Math.cos(angle);
            final float velocity = (float) Math.sqrt(vx * vx + vy * vy);

            final float currentAngle = angle;
            final float currentRadius = radius;
            final float currentAngularSpeed = angularSpeed;
            final float currentBallRadius = ballRadius;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Circular Motion Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Orbit Radius: ").append(String.format("%.1f", currentRadius)).append("\n");
                newOutput.append("Angular Speed: ").append(String.format("%.4f", currentAngularSpeed)).append(" rad/frame\n");
                newOutput.append("Ball Radius: ").append(String.format("%.1f", currentBallRadius)).append("\n");
                newOutput.append("Current Angle: ").append(String.format("%.2f", currentAngle * 180 / Math.PI)).append(" degrees\n");
                newOutput.append("Position: (").append(String.format("%.1f", x)).append(", ")
                        .append(String.format("%.1f", y)).append(")\n");
                newOutput.append("Tangential Velocity: ").append(String.format("%.2f", velocity)).append("\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            if (!dragging) {
                angle += angularSpeed;
                if (angle > Math.PI * 2) {
                    angle -= Math.PI * 2;
                }
            }

            frameCount++;
            if (frameCount % 10 == 0) {
                updateSimulationData();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            centerX = getWidth() / 2;
            centerY = getHeight() / 2;

            g.setColor(Color.LIGHT_GRAY);
            g.drawOval(centerX - (int) radius, centerY - (int) radius, (int) radius * 2, (int) radius * 2);

            int ballX = centerX + (int) (radius * Math.cos(angle));
            int ballY = centerY + (int) (radius * Math.sin(angle));

            g.setColor(Color.BLACK);
            g.drawLine(centerX, centerY, ballX, ballY);

            g.fillOval(centerX - 5, centerY - 5, 10, 10);

            g.setColor(new Color(color[0], color[1], color[2]));
            int ballR = (int) ballRadius;
            g.fillOval(ballX - ballR, ballY - ballR, ballR * 2, ballR * 2);

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 200, 80);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Circular Motion Simulation", 20, 30);
            g.drawString("Radius: " + String.format("%.1f", radius), 20, 50);
            g.drawString("Angular Speed: " + String.format("%.4f", angularSpeed), 20, 70);
        }
    }

    private class AttractionForcePanel extends JPanel implements AnimatedPanel {
        private float radius1, mass1;
        private float[] position1, velocity1;
        private float radius2, mass2;
        private float[] position2, velocity2;
        private int[] color1, color2;
        private float g = 0.1f;
        private int frameCount = 0;
        private boolean draggingMover1 = false;
        private boolean draggingMover2 = false;

        public AttractionForcePanel(float radius1, float mass1, float[] position1, float[] velocity1,
                                    float radius2, float mass2, float[] position2, float[] velocity2,
                                    int[] color1, int[] color2) {
            this.radius1 = radius1;
            this.mass1 = mass1;
            this.position1 = position1.clone();
            this.velocity1 = velocity1.clone();
            this.radius2 = radius2;
            this.mass2 = mass2;
            this.position2 = position2.clone();
            this.velocity2 = velocity2.clone();
            this.color1 = color1;
            this.color2 = color2;
            setBackground(Color.BLACK);

            updateSimulationData();
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            if (distance(e.getX(), e.getY(), position1[0], position1[1]) <= radius1) {
                draggingMover1 = true;
                velocity1[0] = 0;
                velocity1[1] = 0;
                return true;
            }

            if (distance(e.getX(), e.getY(), position2[0], position2[1]) <= radius2) {
                draggingMover2 = true;
                velocity2[0] = 0;
                velocity2[1] = 0;
                return true;
            }

            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (draggingMover1) {
                position1[0] = e.getX();
                position1[1] = e.getY();
                velocity1[0] = 0;
                velocity1[1] = 0;
                updateSimulationData();
            } else if (draggingMover2) {
                position2[0] = e.getX();
                position2[1] = e.getY();
                velocity2[0] = 0;
                velocity2[1] = 0;
                updateSimulationData();
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            draggingMover1 = false;
            draggingMover2 = false;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final float dx = position2[0] - position1[0];
            final float dy = position2[1] - position1[1];
            final float distance = (float) Math.sqrt(dx * dx + dy * dy);

            final float distSq = Math.max(distance * distance, 0.0001f);
            final float force = g * (mass1 * mass2) / distSq;

            final float velocity1Mag = (float) Math.sqrt(velocity1[0] * velocity1[0] + velocity1[1] * velocity1[1]);
            final float velocity2Mag = (float) Math.sqrt(velocity2[0] * velocity2[0] + velocity2[1] * velocity2[1]);

            final float currentMass1 = mass1;
            final float currentMass2 = mass2;
            final float[] currentPos1 = position1.clone();
            final float[] currentPos2 = position2.clone();
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Attraction Force Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Object 1: Mass=").append(String.format("%.1f", currentMass1))
                        .append(", Position=(").append(String.format("%.1f", currentPos1[0])).append(", ")
                        .append(String.format("%.1f", currentPos1[1])).append(")\n");
                newOutput.append("Object 2: Mass=").append(String.format("%.1f", currentMass2))
                        .append(", Position=(").append(String.format("%.1f", currentPos2[0])).append(", ")
                        .append(String.format("%.1f", currentPos2[1])).append(")\n");
                newOutput.append("Distance: ").append(String.format("%.2f", distance)).append("\n");
                newOutput.append("Force: ").append(String.format("%.4f", force)).append("\n");
                newOutput.append("Velocity 1: ").append(String.format("%.2f", velocity1Mag)).append("\n");
                newOutput.append("Velocity 2: ").append(String.format("%.2f", velocity2Mag)).append("\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            if (!draggingMover1 && !draggingMover2) {
                float dx = position2[0] - position1[0];
                float dy = position2[1] - position1[1];
                float distSq = dx * dx + dy * dy;
                float dist = (float) Math.sqrt(distSq);

                dist = Math.max(dist, radius1 + radius2);

                float force = g * (mass1 * mass2) / distSq;

                float fx = force * dx / dist;
                float fy = force * dy / dist;

                velocity1[0] += fx / mass1;
                velocity1[1] += fy / mass1;
                velocity2[0] -= fx / mass2;
                velocity2[1] -= fy / mass2;

                position1[0] += velocity1[0];
                position1[1] += velocity1[1];
                position2[0] += velocity2[0];
                position2[1] += velocity2[1];

                checkBoundary(position1, velocity1, radius1);
                checkBoundary(position2, velocity2, radius2);
            }

            frameCount++;
            if (frameCount % 10 == 0) {
                updateSimulationData();
            }
        }

        private void checkBoundary(float[] position, float[] velocity, float radius) {
            if (position[0] - radius < 0) {
                position[0] = radius;
                velocity[0] *= -0.9f;
            } else if (position[0] + radius > getWidth()) {
                position[0] = getWidth() - radius;
                velocity[0] *= -0.9f;
            }

            if (position[1] - radius < 0) {
                position[1] = radius;
                velocity[1] *= -0.9f;
            } else if (position[1] + radius > getHeight()) {
                position[1] = getHeight() - radius;
                velocity[1] *= -0.9f;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.WHITE);
            g.drawLine((int) position1[0], (int) position1[1], (int) position2[0], (int) position2[1]);

            g.setColor(new Color(color1[0], color1[1], color1[2]));
            g.fillOval((int) (position1[0] - radius1), (int) (position1[1] - radius1),
                    (int) (radius1 * 2), (int) (radius1 * 2));

            g.setColor(new Color(color2[0], color2[1], color2[2]));
            g.fillOval((int) (position2[0] - radius2), (int) (position2[1] - radius2),
                    (int) (radius2 * 2), (int) (radius2 * 2));

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 200, 80);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Attraction Force Simulation", 20, 30);
            g.drawString("G: " + String.format("%.2f", this.g), 20, 50);
            g.drawString("Mass Ratio: " + String.format("%.1f", mass1 / mass2), 20, 70);
        }
    }

    private class DragForcePanel extends JPanel implements AnimatedPanel {
        private int[] moverColor;
        private float dragCoefficient;
        private int[] liquidColor;
        private float[][] positions;
        private float[][] velocities;
        private float[] radii;
        private int numMovers = 9;
        private float gravity = 0.2f;
        private int liquidLevel;
        private int frameCount = 0;
        private int selectedMover = -1;

        public DragForcePanel(int[] moverColor, float dragCoefficient, int[] liquidColor) {
            this.moverColor = moverColor;
            this.dragCoefficient = dragCoefficient;
            this.liquidColor = liquidColor;

            positions = new float[numMovers][2];
            velocities = new float[numMovers][2];
            radii = new float[numMovers];

            resetSimulation();

            setBackground(Color.WHITE);

            updateSimulationData();
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            for (int i = 0; i < numMovers; i++) {
                if (distance(e.getX(), e.getY(), positions[i][0], positions[i][1]) <= radii[i]) {
                    selectedMover = i;
                    velocities[i][0] = 0;
                    velocities[i][1] = 0;
                    return true;
                }
            }

            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (selectedMover >= 0) {
                positions[selectedMover][0] = e.getX();
                positions[selectedMover][1] = e.getY();
                velocities[selectedMover][0] = 0;
                velocities[selectedMover][1] = 0;
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            selectedMover = -1;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private int countMoversAboveLiquid() {
            int count = 0;
            for (int i = 0; i < numMovers; i++) {
                if (positions[i][1] + radii[i] < liquidLevel) {
                    count++;
                }
            }
            return count;
        }

        private int countMoversBelowLiquid() {
            int count = 0;
            for (int i = 0; i < numMovers; i++) {
                if (positions[i][1] + radii[i] >= liquidLevel) {
                    count++;
                }
            }
            return count;
        }

        private float calculateAverageSpeed() {
            float totalSpeed = 0;
            for (int i = 0; i < numMovers; i++) {
                float speed = (float) Math.sqrt(velocities[i][0] * velocities[i][0] +
                        velocities[i][1] * velocities[i][1]);
                totalSpeed += speed;
            }
            return totalSpeed / numMovers;
        }

        private void updateSimulationData() {
            final int moversAboveCount = countMoversAboveLiquid();
            final int moversBelowCount = countMoversBelowLiquid();
            final float avgSpeedValue = calculateAverageSpeed();
            final int currentFrameCount = frameCount;
            final float currentDragCoefficient = dragCoefficient;
            final int currentNumMovers = numMovers;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Drag Force Simulation Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Drag Coefficient: ").append(String.format("%.2f", currentDragCoefficient)).append("\n");
                newOutput.append("Number of Movers: ").append(currentNumMovers).append("\n");
                newOutput.append("Movers above liquid: ").append(moversAboveCount).append("\n");
                newOutput.append("Movers below liquid: ").append(moversBelowCount).append("\n");
                newOutput.append("Average speed: ").append(String.format("%.2f", avgSpeedValue)).append("\n");

                outputArea.setText(newOutput.toString());
            });
        }

        private void resetSimulation() {
            for (int i = 0; i < numMovers; i++) {
                radii[i] = 10 + (float) (Math.random() * 20);
                positions[i][0] = (float) (Math.random() * 600);
                positions[i][1] = (float) (Math.random() * 150);
                velocities[i][0] = -1 + (float) (Math.random() * 2);
                velocities[i][1] = (float) (Math.random() * 2);
            }
            frameCount = 0;
        }

        @Override
        public void update() {
            liquidLevel = getHeight() * 2 / 3;

            for (int i = 0; i < numMovers; i++) {
                if (i == selectedMover) continue; // Skip the mover being dragged

                boolean inLiquid = positions[i][1] + radii[i] > liquidLevel;

                velocities[i][1] += gravity;

                if (inLiquid) {
                    float speed = (float) Math.sqrt(velocities[i][0] * velocities[i][0] +
                            velocities[i][1] * velocities[i][1]);
                    float dragMagnitude = dragCoefficient * speed * speed;

                    float dragForceX = -dragMagnitude * velocities[i][0] / (speed + 0.0001f);
                    float dragForceY = -dragMagnitude * velocities[i][1] / (speed + 0.0001f);

                    velocities[i][0] += dragForceX;
                    velocities[i][1] += dragForceY;
                }

                positions[i][0] += velocities[i][0];
                positions[i][1] += velocities[i][1];

                if (positions[i][0] - radii[i] < 0) {
                    positions[i][0] = radii[i];
                    velocities[i][0] *= -0.9f;
                } else if (positions[i][0] + radii[i] > getWidth()) {
                    positions[i][0] = getWidth() - radii[i];
                    velocities[i][0] *= -0.9f;
                }

                if (positions[i][1] - radii[i] < 0) {
                    positions[i][1] = radii[i];
                    velocities[i][1] *= -0.9f;
                } else if (positions[i][1] + radii[i] > getHeight()) {
                    positions[i][1] = getHeight() - radii[i];
                    velocities[i][1] *= -0.9f;
                }
            }

            frameCount++;
            if (frameCount % 10 == 0) {
                updateSimulationData();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(new Color(liquidColor[0], liquidColor[1], liquidColor[2], 128));
            g.fillRect(0, liquidLevel, getWidth(), getHeight() - liquidLevel);

            g.setColor(new Color(liquidColor[0], liquidColor[1], liquidColor[2]));
            g.drawLine(0, liquidLevel, getWidth(), liquidLevel);

            for (int i = 0; i < numMovers; i++) {
                g.setColor(new Color(moverColor[0], moverColor[1], moverColor[2]));
                g.fillOval((int) (positions[i][0] - radii[i]),
                        (int) (positions[i][1] - radii[i]),
                        (int) (radii[i] * 2),
                        (int) (radii[i] * 2));
            }

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 200, 80);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Liquid Simulator", 20, 30);
            g.drawString("Drag Coefficient: " + dragCoefficient, 20, 50);
            g.drawString("Number of Movers: " + numMovers, 20, 70);
        }

        {
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    // Only reset if not dragging a mover
                    if (selectedMover < 0) {
                        resetSimulation();
                        updateSimulationData();

                        outputArea.append("Simulation reset!\n");
                    }
                }
            });
        }
    }

    private class CollisionPanel extends JPanel implements AnimatedPanel {
        private List<CollisionMover> movers;
        private float coefficientOfRestitution = 1f;
        private float friction = 1f;
        private int frameCount = 0;
        private int selectedMover = -1;

        public CollisionPanel(List<CollisionMover> movers) {
            this.movers = new ArrayList<>(movers);
            setBackground(Color.BLACK);
            updateSimulationData();
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            for (int i = 0; i < movers.size(); i++) {
                CollisionMover mover = movers.get(i);
                if (distance(e.getX(), e.getY(), mover.position[0], mover.position[1]) <= mover.radius) {
                    selectedMover = i;
                    mover.velocity[0] = 0;
                    mover.velocity[1] = 0;
                    return true;
                }
            }
            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (selectedMover >= 0 && selectedMover < movers.size()) {
                CollisionMover mover = movers.get(selectedMover);
                mover.position[0] = e.getX();
                mover.position[1] = e.getY();
                mover.velocity[0] = 0;
                mover.velocity[1] = 0;
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            selectedMover = -1;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final int numMovers = movers.size();
            final float totalKineticEnergy = calculateTotalKineticEnergy();
            final float averageSpeed = calculateAverageSpeed();
            final int currentFrameCount = frameCount;
            final float currentCoR = coefficientOfRestitution;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Collision Simulation Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Number of Movers: ").append(numMovers).append("\n");
                newOutput.append("Total Kinetic Energy: ").append(String.format("%.2f", totalKineticEnergy)).append("\n");
                newOutput.append("Average Speed: ").append(String.format("%.2f", averageSpeed)).append("\n");
                newOutput.append("Coefficient of Restitution: ").append(String.format("%.2f", currentCoR)).append("\n");

                for (int i = 0; i < movers.size(); i++) {
                    CollisionMover mover = movers.get(i);
                    float speed = (float) Math.sqrt(mover.velocity[0] * mover.velocity[0] + mover.velocity[1] * mover.velocity[1]);
                    newOutput.append("Mover ").append(i + 1).append(": Mass=").append(String.format("%.1f", mover.mass))
                            .append(", Speed=").append(String.format("%.2f", speed)).append("\n");
                }

                outputArea.setText(newOutput.toString());
            });
        }

        private float calculateTotalKineticEnergy() {
            float total = 0;
            for (CollisionMover mover : movers) {
                float speedSquared = mover.velocity[0] * mover.velocity[0] + mover.velocity[1] * mover.velocity[1];
                total += 0.5f * mover.mass * speedSquared;
            }
            return total;
        }

        private float calculateAverageSpeed() {
            float totalSpeed = 0;
            for (CollisionMover mover : movers) {
                totalSpeed += Math.sqrt(mover.velocity[0] * mover.velocity[0] + mover.velocity[1] * mover.velocity[1]);
            }
            return totalSpeed / movers.size();
        }

        @Override
        public void update() {
            for (int i = 0; i < movers.size(); i++) {
                if (i == selectedMover) continue;

                CollisionMover mover = movers.get(i);

                mover.position[0] += mover.velocity[0];
                mover.position[1] += mover.velocity[1];

                mover.velocity[0] *= friction;
                mover.velocity[1] *= friction;

                if (mover.position[0] - mover.radius <= 0) {
                    mover.position[0] = mover.radius;
                    mover.velocity[0] *= -coefficientOfRestitution;
                } else if (mover.position[0] + mover.radius >= getWidth()) {
                    mover.position[0] = getWidth() - mover.radius;
                    mover.velocity[0] *= -coefficientOfRestitution;
                }

                if (mover.position[1] - mover.radius <= 0) {
                    mover.position[1] = mover.radius;
                    mover.velocity[1] *= -coefficientOfRestitution;
                } else if (mover.position[1] + mover.radius >= getHeight()) {
                    mover.position[1] = getHeight() - mover.radius;
                    mover.velocity[1] *= -coefficientOfRestitution;
                }
            }

            for (int i = 0; i < movers.size(); i++) {
                for (int j = i + 1; j < movers.size(); j++) {
                    if (i == selectedMover || j == selectedMover) continue;

                    CollisionMover m1 = movers.get(i);
                    CollisionMover m2 = movers.get(j);

                    float dx = m2.position[0] - m1.position[0];
                    float dy = m2.position[1] - m1.position[1];
                    float distance = (float) Math.sqrt(dx * dx + dy * dy);

                    if (distance < m1.radius + m2.radius) {
                        // Collision detected, resolve it
                        resolveCollision(m1, m2, dx, dy, distance);
                    }
                }
            }

            frameCount++;
            if (frameCount % 15 == 0) {
                updateSimulationData();
            }
        }

        private void resolveCollision(CollisionMover m1, CollisionMover m2, float dx, float dy, float distance) {
            float nx = dx / distance;
            float ny = dy / distance;

            float overlap = (m1.radius + m2.radius) - distance;
            float totalMass = m1.mass + m2.mass;
            m1.position[0] -= nx * overlap * (m2.mass / totalMass);
            m1.position[1] -= ny * overlap * (m2.mass / totalMass);
            m2.position[0] += nx * overlap * (m1.mass / totalMass);
            m2.position[1] += ny * overlap * (m1.mass / totalMass);

            float dvx = m2.velocity[0] - m1.velocity[0];
            float dvy = m2.velocity[1] - m1.velocity[1];

            float dvn = dvx * nx + dvy * ny;

            if (dvn > 0) return;

            float impulse = 2 * dvn / totalMass * coefficientOfRestitution;

            m1.velocity[0] += impulse * m2.mass * nx;
            m1.velocity[1] += impulse * m2.mass * ny;
            m2.velocity[0] -= impulse * m1.mass * nx;
            m2.velocity[1] -= impulse * m1.mass * ny;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            for (int i = 0; i < movers.size(); i++) {
                CollisionMover mover = movers.get(i);

                if (i == selectedMover) {
                    g.setColor(Color.WHITE);
                    g.drawOval((int) (mover.position[0] - mover.radius - 2),
                            (int) (mover.position[1] - mover.radius - 2),
                            (int) (mover.radius * 2 + 4),
                            (int) (mover.radius * 2 + 4));
                }

                g.setColor(new Color(mover.color[0], mover.color[1], mover.color[2]));
                g.fillOval((int) (mover.position[0] - mover.radius),
                        (int) (mover.position[1] - mover.radius),
                        (int) (mover.radius * 2),
                        (int) (mover.radius * 2));

                g.setColor(Color.YELLOW);
                int endX = (int) (mover.position[0] + mover.velocity[0] * 5);
                int endY = (int) (mover.position[1] + mover.velocity[1] * 5);
                g.drawLine((int) mover.position[0], (int) mover.position[1], endX, endY);
            }

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 220, 100);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Collision Simulation", 20, 30);
            g.drawString("Movers: " + movers.size(), 20, 50);
            g.drawString("Kinetic Energy: " + String.format("%.1f", calculateTotalKineticEnergy()), 20, 70);
            g.drawString("Drag to move objects", 20, 90);
        }
    }

    private class SpringPanel extends JPanel implements AnimatedPanel {
        private float springConstant, damping, restLength, floorFriction;
        private float ballRadius;
        private int[] ballColor;
        private float xAnchor, yAnchor;
        private int numCoils;

        private float ballX, ballY;
        private float velocityX, velocityY;
        private float gravity = 0.3f;
        private int frameCount = 0;
        private boolean dragging = false;

        public SpringPanel(float springConstant, float damping, float restLength,
                           float floorFriction, float ballRadius, int[] ballColor,
                           float xAnchor, float yAnchor, int numCoils) {
            this.springConstant = springConstant;
            this.damping = damping;
            this.restLength = restLength;
            this.floorFriction = floorFriction;
            this.ballRadius = ballRadius;
            this.ballColor = ballColor.clone();
            this.xAnchor = xAnchor;
            this.yAnchor = yAnchor;
            this.numCoils = numCoils;

            this.ballX = xAnchor;
            this.ballY = yAnchor + restLength;
            this.velocityX = 0;
            this.velocityY = 0;

            setBackground(Color.WHITE);
            updateSimulationData();
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            if (distance(e.getX(), e.getY(), ballX, ballY) <= ballRadius) {
                dragging = true;
                return true;
            }
            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (dragging) {
                ballX = e.getX();
                ballY = e.getY();
                velocityX = 0;
                velocityY = 0;
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            dragging = false;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final float currentLength = distance(ballX, ballY, xAnchor, yAnchor);
            final float extension = currentLength - restLength;
            final float springForce = springConstant * extension;
            final float currentSpringConstant = springConstant;
            final float currentDamping = damping;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Spring Simulation Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Spring Constant: ").append(String.format("%.3f", currentSpringConstant)).append("\n");
                newOutput.append("Damping: ").append(String.format("%.3f", currentDamping)).append("\n");
                newOutput.append("Current Length: ").append(String.format("%.1f", currentLength)).append("\n");
                newOutput.append("Extension: ").append(String.format("%.1f", extension)).append("\n");
                newOutput.append("Spring Force: ").append(String.format("%.2f", springForce)).append("\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            if (!dragging) {
                float dx = ballX - xAnchor;
                float dy = ballY - yAnchor;
                float currentLength = (float) Math.sqrt(dx * dx + dy * dy);
                float extension = currentLength - restLength;

                if (currentLength > 0) {
                    float springForceX = -springConstant * extension * (dx / currentLength);
                    float springForceY = -springConstant * extension * (dy / currentLength);

                    velocityX *= (1 - damping);
                    velocityY *= (1 - damping);

                    velocityX += springForceX;
                    velocityY += springForceY;

                    velocityY += gravity;

                    ballX += velocityX;
                    ballY += velocityY;

                    if (ballY > getHeight() - ballRadius) {
                        ballY = getHeight() - ballRadius;
                        velocityY *= -0.8f; // Bounce
                        velocityX *= (1 - floorFriction); // Friction
                    }

                    if (ballX < ballRadius) {
                        ballX = ballRadius;
                        velocityX *= -0.8f;
                    } else if (ballX > getWidth() - ballRadius) {
                        ballX = getWidth() - ballRadius;
                        velocityX *= -0.8f;
                    }

                    if (ballY < ballRadius) {
                        ballY = ballRadius;
                        velocityY *= -0.8f;
                    }
                }
            }

            frameCount++;
            if (frameCount % 15 == 0) {
                updateSimulationData();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            drawSpring(g);

            g.setColor(Color.BLACK);
            g.fillOval((int) xAnchor - 5, (int) yAnchor - 5, 10, 10);

            g.setColor(new Color(ballColor[0], ballColor[1], ballColor[2]));
            g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
                    (int) (ballRadius * 2), (int) (ballRadius * 2));


            float currentLength = distance(ballX, ballY, xAnchor, yAnchor);
            float extension = currentLength - restLength;
            float springForce = springConstant * Math.abs(extension);

            g.setColor(Color.BLUE);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));

            float restX = xAnchor;
            float restY = yAnchor + restLength;
            g.drawLine((int) xAnchor, (int) yAnchor, (int) restX, (int) restY);

            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Rest Length", (int) restX + 10, (int) restY);

            g.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(3));

            float dx = ballX - xAnchor;
            float dy = ballY - yAnchor;
            float length = (float) Math.sqrt(dx * dx + dy * dy);

            if (length > 0) {
                float forceX = -dx / length;
                float forceY = -dy / length;

                float arrowLength = Math.min(60f, springForce * 20f);
                int endX = (int) (ballX + forceX * arrowLength);
                int endY = (int) (ballY + forceY * arrowLength);

                g.drawLine((int) ballX, (int) ballY, endX, endY);

                drawForceArrowHead(g, (int) ballX, (int) ballY, endX, endY);

                g.drawString("Spring Force", endX + 5, endY);
            }

            g2d.setStroke(new BasicStroke(1));

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 220, 120);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Spring Simulation", 20, 30);
            g.drawString("Spring Constant: " + String.format("%.3f", springConstant), 20, 50);
            g.drawString("Damping: " + String.format("%.3f", damping), 20, 70);
            g.drawString("Rest Length: " + String.format("%.1f", restLength), 20, 90);
            g.drawString("Spring Energy: " + String.format("%.1f", currentLength * springConstant), 20, 110);
        }

        private void drawForceArrowHead(Graphics g, int x1, int y1, int x2, int y2) {
            int arrowLength = 10;
            double angle = Math.atan2(y2 - y1, x2 - x1);

            int x3 = (int) (x2 - arrowLength * Math.cos(angle - Math.PI / 6));
            int y3 = (int) (y2 - arrowLength * Math.sin(angle - Math.PI / 6));
            int x4 = (int) (x2 - arrowLength * Math.cos(angle + Math.PI / 6));
            int y4 = (int) (y2 - arrowLength * Math.sin(angle + Math.PI / 6));

            g.drawLine(x2, y2, x3, y3);
            g.drawLine(x2, y2, x4, y4);
        }

        private void drawSpring(Graphics g) {
            g.setColor(Color.DARK_GRAY);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));

            float springLength = distance(ballX, ballY, xAnchor, yAnchor);
            float amplitude = 15f; // Increased amplitude for more visible coils

            float dx = ballX - xAnchor;
            float dy = ballY - yAnchor;
            float length = (float) Math.sqrt(dx * dx + dy * dy);

            if (length > 0) {
                float ux = dx / length;
                float uy = dy / length;

                float perpX = -uy;
                float perpY = ux;

                int totalPoints = numCoils * 4;
                float[] xPoints = new float[totalPoints + 2];
                float[] yPoints = new float[totalPoints + 2];

                xPoints[0] = xAnchor;
                yPoints[0] = yAnchor;

                for (int i = 0; i < totalPoints; i++) {
                    float t = (float) i / totalPoints;
                    float coilPhase = (float) (i * Math.PI / 2);

                    float baseX = xAnchor + t * dx;
                    float baseY = yAnchor + t * dy;

                    float displacement = amplitude * (float) Math.sin(coilPhase);
                    xPoints[i + 1] = baseX + displacement * perpX;
                    yPoints[i + 1] = baseY + displacement * perpY;
                }

                xPoints[totalPoints + 1] = ballX;
                yPoints[totalPoints + 1] = ballY;

                for (int i = 0; i < totalPoints + 1; i++) {
                    g.drawLine((int) xPoints[i], (int) yPoints[i],
                            (int) xPoints[i + 1], (int) yPoints[i + 1]);
                }
            }
        }
    }

    private class RollingDownhillPanel extends JPanel implements AnimatedPanel {
        private float gravitationalAcceleration;
        private float friction;
        private float bounciness;
        private float angle; // in degrees
        private float velocity;
        private float ballRadius;
        private int[] ballColor;

        private float ballX, ballY;
        private float velocityX, velocityY;
        private float angleRad;
        private int frameCount = 0;
        private boolean dragging = false;

        private float inclineStartX, inclineStartY;
        private float inclineEndX, inclineEndY;

        public RollingDownhillPanel(float gravitationalAcceleration, float friction,
                                  float bounciness, float angle, float velocity,
                                  float ballRadius, int[] ballColor) {
            this.gravitationalAcceleration = gravitationalAcceleration * 0.1f;
            this.friction = friction;
            this.bounciness = bounciness;
            this.angle = angle;
            this.velocity = velocity;
            this.ballRadius = ballRadius;
            this.ballColor = ballColor.clone();
            this.angleRad = (float) Math.toRadians(angle);

            if (Math.abs(this.angleRad) < 0.01f) {
                this.angleRad = 0.01f;
            }

            setBackground(Color.LIGHT_GRAY);
            initializeSimulation();
            updateSimulationData();
        }

        private void initializeSimulation() {
            inclineStartX = 50;
            inclineStartY = getHeight() > 0 ? getHeight() - 100 : 400;
            inclineEndX = getWidth() > 0 ? getWidth() - 50 : 600;
            inclineEndY = inclineStartY - (inclineEndX - inclineStartX) * (float) Math.tan(angleRad);

            if (inclineEndY > inclineStartY - 10) {
                inclineEndY = inclineStartY - 10; // Minimum 10 pixel height difference
            }

            if (inclineEndY < 50) {
                inclineEndY = 50;
                inclineEndX = inclineStartX + (inclineStartY - inclineEndY) / (float) Math.tan(angleRad);
            }

            if (frameCount == 0) {
                ballX = getHeight() + ballRadius;
                ballY = getWidth() - ballRadius;

                velocityX = velocity * (float) Math.cos(angleRad);
                velocityY = -velocity * (float) Math.sin(angleRad);
            }
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            if (distance(e.getX(), e.getY(), ballX, ballY) <= ballRadius) {
                dragging = true;
                return true;
            }
            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (dragging) {
                ballX = e.getX();
                ballY = e.getY();
                velocityX = 0;
                velocityY = 0;
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            dragging = false;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final float speed = (float) Math.sqrt(velocityX * velocityX + velocityY * velocityY);
            final float currentAngle = angle;
            final float currentFriction = friction;
            final float currentBounciness = bounciness;
            final float currentGravity = gravitationalAcceleration;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Rolling Downhill Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Incline Angle: ").append(String.format("%.1f", currentAngle)).append(" degrees\n");
                newOutput.append("Gravity: ").append(String.format("%.2f", currentGravity)).append("\n");
                newOutput.append("Friction: ").append(String.format("%.3f", currentFriction)).append("\n");
                newOutput.append("Bounciness: ").append(String.format("%.2f", currentBounciness)).append("\n");
                newOutput.append("Ball Speed: ").append(String.format("%.2f", speed)).append("\n");
                newOutput.append("Ball Position: (").append(String.format("%.1f", ballX))
                        .append(", ").append(String.format("%.1f", ballY)).append(")\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            if (!dragging) {
                float gravityX = gravitationalAcceleration * (float) Math.sin(angleRad);
                float gravityY = gravitationalAcceleration * (float) Math.cos(angleRad);

                float speed = (float) Math.sqrt(velocityX * velocityX + velocityY * velocityY);
                if (speed > 0) {
                    float frictionX = -friction * gravitationalAcceleration * (velocityX / speed);
                    float frictionY = -friction * gravitationalAcceleration * (velocityY / speed);
                    velocityX += frictionX;
                    velocityY += frictionY;
                }

                velocityX -= gravityX;
                velocityY += gravityY;

                ballX += velocityX;
                ballY += velocityY;

                float inclineY = getInclineYAtX(ballX);
                if (ballY > inclineY - ballRadius) {
                    ballY = inclineY - ballRadius;

                    float normalX = -(float) Math.sin(angleRad);
                    float normalY = -(float) Math.cos(angleRad);

                    float dotProduct = velocityX * normalX + velocityY * normalY;
                    velocityX -= 2 * dotProduct * normalX * bounciness;
                    velocityY -= 2 * dotProduct * normalY * bounciness;
                }

                if (ballX < ballRadius) {
                    ballX = ballRadius;
                    velocityX *= -bounciness;
                } else if (ballX > getWidth() - ballRadius) {
                    ballX = getWidth() - ballRadius;
                    velocityX *= -bounciness;
                }

                if (ballY > getHeight() - ballRadius) {
                    ballY = getHeight() - ballRadius;
                    velocityY *= -bounciness;
                }

                if (ballY < ballRadius) {
                    ballY = ballRadius;
                    velocityY *= -bounciness;
                }

                if (ballX - ballRadius <= 0) {
                    velocityY = 0;
                    velocityX = 0;
                }

            }

            frameCount++;
            if (frameCount % 15 == 0) {
                updateSimulationData();
            }
        }

        private float getInclineYAtX(float x) {
            if (x < inclineStartX) return inclineStartY;
            if (x > inclineEndX) return inclineEndY;

            float t = (x - inclineStartX) / (inclineEndX - inclineStartX);
            return inclineStartY + t * (inclineEndY - inclineStartY);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (frameCount == 0 || inclineEndX == 0) {
                initializeSimulation();
            }

            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());

            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(8));
            g.setColor(Color.DARK_GRAY);
            g.drawLine((int) inclineStartX, (int) inclineStartY, (int) inclineEndX, (int) inclineEndY);

            g.setColor(new Color(100, 100, 100));
            int[] xPoints = {(int) inclineStartX, (int) inclineEndX, getWidth(), 0};
            int[] yPoints = {(int) inclineStartY, (int) inclineEndY, getHeight(), getHeight()};
            g.fillPolygon(xPoints, yPoints, 4);

            g2d.setStroke(new BasicStroke(5));
            g.setColor(Color.BLACK);
            g.drawLine((int) inclineStartX, (int) inclineStartY, (int) inclineEndX, (int) inclineEndY);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString(String.format("%.1f°", angle), (int) inclineStartX + 30, (int) inclineStartY - 30);

            g.setColor(new Color(ballColor[0], ballColor[1], ballColor[2]));
            g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
                    (int) (ballRadius * 2), (int) (ballRadius * 2));

            g.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g.drawOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
                    (int) (ballRadius * 2), (int) (ballRadius * 2));

            g.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(3));
            int endX = (int) (ballX + velocityX * 10);
            int endY = (int) (ballY + velocityY * 10);
            g.drawLine((int) ballX, (int) ballY, endX, endY);

            drawArrowHead(g, (int) ballX, (int) ballY, endX, endY);

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 220, 120);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Rolling Downhill Simulation", 20, 30);
            g.drawString("Angle: " + String.format("%.1f", angle) + "°", 20, 50);
            g.drawString("Friction: " + String.format("%.3f", friction), 20, 70);
            g.drawString("Bounciness: " + String.format("%.2f", bounciness), 20, 90);
            g.drawString("Speed: " + String.format("%.2f", Math.sqrt(velocityX * velocityX + velocityY * velocityY)), 20, 110);
        }

        private void drawArrowHead(Graphics g, int x1, int y1, int x2, int y2) {
            int arrowLength = 8;
            double angle = Math.atan2(y2 - y1, x2 - x1);

            int x3 = (int) (x2 - arrowLength * Math.cos(angle - Math.PI / 6));
            int y3 = (int) (y2 - arrowLength * Math.sin(angle - Math.PI / 6));
            int x4 = (int) (x2 - arrowLength * Math.cos(angle + Math.PI / 6));
            int y4 = (int) (y2 - arrowLength * Math.sin(angle + Math.PI / 6));

            g.drawLine(x2, y2, x3, y3);
            g.drawLine(x2, y2, x4, y4);
        }
    }

    private class AcceleratedMotionPanel2 extends JPanel implements AnimatedPanel {
        private float radius;
        private int[] color;
        private float initialSpeed;
        private float acceleration;
        private float currentSpeed;
        private float x = 0;
        private int frameCount = 0;
        private boolean dragging = false;

        public AcceleratedMotionPanel2(float radius, int[] color, float initialSpeed, float acceleration) {
            this.radius = radius;
            this.color = color;
            this.initialSpeed = initialSpeed;
            this.acceleration = acceleration;
            this.currentSpeed = initialSpeed;
            setBackground(Color.WHITE);

            updateSimulationData();
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            int groundY = getHeight() - 50;
            int y = groundY - (int) radius;

            if (distance(e.getX(), e.getY(), x, y) <= radius) {
                dragging = true;
                return true;
            }

            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (dragging) {
                x = e.getX();
                updateSimulationData();
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            dragging = false;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final float distance = x % getWidth();
            final float currentSpeedValue = currentSpeed;
            final float currentAcceleration = acceleration;
            final float currentRadius = radius;
            final float totalDistance = x;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Accelerated Motion Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Initial Speed: ").append(String.format("%.2f", initialSpeed)).append(" units/frame\n");
                newOutput.append("Current Speed: ").append(String.format("%.2f", currentSpeedValue)).append(" units/frame\n");
                newOutput.append("Acceleration: ").append(String.format("%.4f", currentAcceleration)).append(" units/frame²\n");
                newOutput.append("Position X: ").append(String.format("%.1f", distance)).append("\n");
                newOutput.append("Radius: ").append(String.format("%.1f", currentRadius)).append("\n");
                newOutput.append("Distance traveled: ").append(String.format("%.1f", totalDistance)).append(" units\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            if (!dragging) {
                currentSpeed += acceleration;

                x += currentSpeed;

                if (x > getWidth() + radius) {
                    x = -radius;
                }
            }

            frameCount++;
            if (frameCount % 10 == 0) {
                updateSimulationData();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.BLACK);
            int groundY = getHeight() - 50;
            g.drawLine(0, groundY, getWidth(), groundY);

            g.setColor(new Color(color[0], color[1], color[2]));
            int y = groundY - (int) radius;
            g.fillOval((int) x - (int) radius, y - (int) radius, (int) radius * 2, (int) radius * 2);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(3));
            g.setColor(Color.RED);

            float arrowLength = Math.min(100f, Math.abs(currentSpeed) * 20f);
            int endX = (int) (x + arrowLength);
            int endY = y;

            g.drawLine((int) x, y, endX, endY);

            int arrowSize = 8;
            g.drawLine(endX, endY, endX - arrowSize, endY - arrowSize / 2);
            g.drawLine(endX, endY, endX - arrowSize, endY + arrowSize / 2);

            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("v = " + String.format("%.2f", currentSpeed), endX + 5, endY - 5);

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 200, 100);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Accelerated Motion", 20, 30);
            g.drawString("Initial Speed: " + String.format("%.2f", initialSpeed), 20, 50);
            g.drawString("Acceleration: " + String.format("%.4f", acceleration), 20, 70);
            g.drawString("Current Speed: " + String.format("%.2f", currentSpeed), 20, 90);
        }
    }

    private class ElectrostaticFieldPanel extends JPanel implements AnimatedPanel {
        private float particleRadius;
        private int fluxResolution;
        private List<Charge> charges;
        private float fieldStrength = 100f;
        private int frameCount = 0;
        private int selectedCharge = -1;
        private long lastClickTime = 0;
        private int lastClickX = 0, lastClickY = 0;

        private List<AnimatedFieldLine> animatedLines;
        private int animationFrame = 0;
        private boolean showAnimation = true;
        private int maxLineLength = 150; // Maximum steps per line before starting new one

        private static class Charge {
            float x, y;
            float charge;
            Color color;

            public Charge(float x, float y, float charge) {
                this.x = x;
                this.y = y;
                this.charge = charge;
                this.color = charge > 0 ? Color.RED : Color.BLUE;
            }
        }

        private static class AnimatedFieldLine {
            List<Point2D.Float> points;
            float currentX, currentY;
            float directionX, directionY;
            boolean isComplete;
            int stepsDrawn;
            Color lineColor;

            public AnimatedFieldLine(float startX, float startY, double initialAngle) {
                points = new ArrayList<>();
                currentX = startX;
                currentY = startY;
                directionX = (float) Math.cos(initialAngle);
                directionY = (float) Math.sin(initialAngle);
                isComplete = false;
                stepsDrawn = 0;
                lineColor = new Color(255, 255, 0, 200);
            }
        }

        public ElectrostaticFieldPanel(float particleRadius, int fluxResolution) {
            this.particleRadius = particleRadius;
            this.fluxResolution = fluxResolution;
            this.charges = new ArrayList<>();
            this.animatedLines = new ArrayList<>();

            charges.add(new Charge(250f, 300f, 1.0f));
            charges.add(new Charge(450f, 300f, -1.0f));

            setBackground(Color.BLACK);
            initializeAnimatedLines();
            updateSimulationData();
        }

        private void initializeAnimatedLines() {
            animatedLines.clear();
            animationFrame = 0;

            for (Charge charge : charges) {
                if (charge.charge > 0) {
                    int numLines = fluxResolution;
                    for (int i = 0; i < numLines; i++) {
                        double angle = 2 * Math.PI * i / numLines;
                        float startX = charge.x + (float) (Math.cos(angle) * (particleRadius + 5));
                        float startY = charge.y + (float) (Math.sin(angle) * (particleRadius + 5));
                        animatedLines.add(new AnimatedFieldLine(startX, startY, angle));
                    }
                }
            }

            if (animatedLines.isEmpty()) {
                createEdgeLines();
            }
        }

        private void createEdgeLines() {
            int spacing = 60;

            for (int x = spacing; x < getWidth(); x += spacing) {
                animatedLines.add(new AnimatedFieldLine(x, 0, Math.PI / 2));
            }

            for (int x = spacing; x < getWidth(); x += spacing) {
                animatedLines.add(new AnimatedFieldLine(x, getHeight(), -Math.PI / 2));
            }

            for (int y = spacing; y < getHeight(); y += spacing) {
                animatedLines.add(new AnimatedFieldLine(0, y, 0));
            }

            for (int y = spacing; y < getHeight(); y += spacing) {
                animatedLines.add(new AnimatedFieldLine(getWidth(), y, Math.PI));
            }
        }

        @Override
        public boolean handleMousePressed(MouseEvent e) {
            long currentTime = System.currentTimeMillis();
            boolean isDoubleClick = (currentTime - lastClickTime) < 300 &&
                    Math.abs(e.getX() - lastClickX) < 10 &&
                    Math.abs(e.getY() - lastClickY) < 10;

            lastClickTime = currentTime;
            lastClickX = e.getX();
            lastClickY = e.getY();

            for (int i = 0; i < charges.size(); i++) {
                Charge charge = charges.get(i);
                if (distance(e.getX(), e.getY(), charge.x, charge.y) <= particleRadius) {
                    if (isDoubleClick) {
                        charges.remove(i);
                        initializeAnimatedLines(); // Restart animation
                        updateSimulationData();
                        return true;
                    } else {
                        selectedCharge = i;
                        return true;
                    }
                }
            }

            if (!isDoubleClick) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    charges.add(new Charge(e.getX(), e.getY(), 1.0f));
                    initializeAnimatedLines();
                    updateSimulationData();
                    return true;
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    charges.add(new Charge(e.getX(), e.getY(), -1.0f));
                    initializeAnimatedLines();
                    updateSimulationData();
                    return true;
                }
            }

            return false;
        }

        @Override
        public void handleMouseDragged(MouseEvent e) {
            if (selectedCharge >= 0 && selectedCharge < charges.size()) {
                Charge charge = charges.get(selectedCharge);
                charge.x = e.getX();
                charge.y = e.getY();
            }
        }

        @Override
        public void handleMouseReleased(MouseEvent e) {
            if (selectedCharge >= 0) {
                initializeAnimatedLines();
            }
            selectedCharge = -1;
        }

        private float distance(float x1, float y1, float x2, float y2) {
            float dx = x1 - x2;
            float dy = y1 - y2;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        private void updateSimulationData() {
            final int numCharges = charges.size();
            final float currentFieldStrength = fieldStrength;
            final int currentFluxResolution = fluxResolution;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Electrostatic Field Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Number of Charges: ").append(numCharges).append("\n");
                newOutput.append("Field Strength: ").append(String.format("%.1f", currentFieldStrength)).append("\n");
                newOutput.append("Animated Lines: ").append(animatedLines.size()).append("\n");
                newOutput.append("Left click: Add +, Right click: Add -\n");
                newOutput.append("Double click: Remove charge\n");

                for (int i = 0; i < charges.size(); i++) {
                    Charge c = charges.get(i);
                    newOutput.append("Charge ").append(i + 1).append(": ")
                            .append(c.charge > 0 ? "+" : "").append(String.format("%.1f", c.charge))
                            .append(" at (").append(String.format("%.0f", c.x)).append(", ")
                            .append(String.format("%.0f", c.y)).append(")\n");
                }

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            updateAnimatedLines();

            frameCount++;
            if (frameCount % 30 == 0) {
                updateSimulationData();
            }
        }

        private void updateAnimatedLines() {
            animationFrame++;

            float stepSize = 2.0f;

            for (AnimatedFieldLine line : animatedLines) {
                if (!line.isComplete && line.stepsDrawn < maxLineLength) {
                    float[] field = calculateElectricField(line.currentX, line.currentY);
                    float fieldMag = (float) Math.sqrt(field[0] * field[0] + field[1] * field[1]);

                    if (fieldMag > 0.001f) {
                        line.directionX = field[0] / fieldMag;
                        line.directionY = field[1] / fieldMag;
                    }

                    line.points.add(new Point2D.Float(line.currentX, line.currentY));

                    float nextX = line.currentX + line.directionX * stepSize;
                    float nextY = line.currentY + line.directionY * stepSize;

                    for (Charge charge : charges) {
                        if (charge.charge < 0) {
                            float dist = distance(nextX, nextY, charge.x, charge.y);
                            if (dist < particleRadius + 5) {
                                line.points.add(new Point2D.Float(charge.x, charge.y));
                                line.isComplete = true;
                                return;
                            }
                        }
                    }

                    if (nextX < 0 || nextX > getWidth() || nextY < 0 || nextY > getHeight()) {
                        line.points.add(new Point2D.Float(
                                Math.max(0, Math.min(getWidth(), nextX)),
                                Math.max(0, Math.min(getHeight(), nextY))
                        ));
                        line.isComplete = true;
                    } else {
                        line.currentX = nextX;
                        line.currentY = nextY;
                        line.stepsDrawn++;
                    }
                }
            }

            boolean allComplete = animatedLines.stream().allMatch(line -> line.isComplete);
            if (allComplete && animationFrame > 60) { // Wait a bit before restarting
                initializeAnimatedLines();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));

            for (AnimatedFieldLine line : animatedLines) {
                if (line.points.size() > 1) {
                    g.setColor(line.lineColor);

                    for (int i = 0; i < line.points.size() - 1; i++) {
                        Point2D.Float p1 = line.points.get(i);
                        Point2D.Float p2 = line.points.get(i + 1);
                        g.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
                    }

                    for (int i = 5; i < line.points.size(); i += 15) {
                        Point2D.Float p1 = line.points.get(i - 1);
                        Point2D.Float p2 = line.points.get(i);
                        float dx = p2.x - p1.x;
                        float dy = p2.y - p1.y;
                        float mag = (float) Math.sqrt(dx * dx + dy * dy);
                        if (mag > 0) {
                            drawAnimatedArrow(g, p1.x, p1.y, dx / mag, dy / mag);
                        }
                    }

                    if (!line.isComplete && line.points.size() > 0) {
                        Point2D.Float tip = line.points.get(line.points.size() - 1);
                        g.setColor(Color.WHITE);
                        g.fillOval((int) tip.x - 3, (int) tip.y - 3, 6, 6);
                    }
                }
            }

            drawFieldVectors(g);

            for (int i = 0; i < charges.size(); i++) {
                Charge charge = charges.get(i);

                if (i == selectedCharge) {
                    g.setColor(Color.WHITE);
                    g.drawOval((int) (charge.x - particleRadius - 3),
                            (int) (charge.y - particleRadius - 3),
                            (int) (particleRadius * 2 + 6),
                            (int) (particleRadius * 2 + 6));
                }

                g.setColor(charge.color);
                g.fillOval((int) (charge.x - particleRadius),
                        (int) (charge.y - particleRadius),
                        (int) (particleRadius * 2),
                        (int) (particleRadius * 2));

                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 16));
                String sign = charge.charge > 0 ? "+" : "-";
                FontMetrics fm = g.getFontMetrics();
                int textX = (int) (charge.x - fm.stringWidth(sign) / 2);
                int textY = (int) (charge.y + fm.getAscent() / 2);
                g.drawString(sign, textX, textY);
            }

            g.setColor(new Color(50, 50, 50, 200));
            g.fillRect(10, 10, 280, 80);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Electrostatic Field", 20, 30);
            g.drawString("Left: Add +, Right: Add -, Double: Remove", 20, 50);
            g.drawString("Charges: " + charges.size(), 20, 70);
        }

        private void drawAnimatedArrow(Graphics g, float x, float y, float fx, float fy) {
            int arrowLength = 8;
            double arrowAngle = Math.PI / 6;

            double angle = Math.atan2(fy, fx);

            int x1 = (int) (x - arrowLength * Math.cos(angle - arrowAngle));
            int y1 = (int) (y - arrowLength * Math.sin(angle - arrowAngle));
            int x2 = (int) (x - arrowLength * Math.cos(angle + arrowAngle));
            int y2 = (int) (y - arrowLength * Math.sin(angle + arrowAngle));

            g.drawLine((int) x, (int) y, x1, y1);
            g.drawLine((int) x, (int) y, x2, y2);
        }

        private void drawFieldVectors(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(1));

            int step = 60;

            for (int x = step; x < getWidth(); x += step) {
                for (int y = step; y < getHeight(); y += step) {
                    boolean tooClose = false;
                    for (Charge charge : charges) {
                        if (distance(x, y, charge.x, charge.y) < particleRadius + 30) {
                            tooClose = true;
                            break;
                        }
                    }

                    if (tooClose) continue;

                    float[] field = calculateElectricField(x, y);
                    float fieldMag = (float) Math.sqrt(field[0] * field[0] + field[1] * field[1]);

                    if (fieldMag > 0.1f) {
                        float scale = Math.min(step * 0.3f, fieldMag * 0.3f);
                        float fx = field[0] / fieldMag * scale;
                        float fy = field[1] / fieldMag * scale;

                        float intensity = Math.min(0.3f, fieldMag / 5.0f); // More transparent
                        g.setColor(new Color(intensity, intensity, intensity));

                        int endX = (int) (x + fx);
                        int endY = (int) (y + fy);
                        g.drawLine(x, y, endX, endY);

                        drawFieldArrow(g, x, y, endX, endY);
                    }
                }
            }
        }

        private float[] calculateElectricField(float x, float y) {
            float ex = 0, ey = 0;

            for (Charge charge : charges) {
                float dx = x - charge.x;
                float dy = y - charge.y;
                float r2 = dx * dx + dy * dy;
                float r = (float) Math.sqrt(r2);

                if (r > particleRadius) {
                    float k = fieldStrength * charge.charge / (r2 * r);
                    ex += k * dx;
                    ey += k * dy;
                }
            }

            return new float[]{ex, ey};
        }

        private void drawFieldArrow(Graphics g, int x1, int y1, int x2, int y2) {
            int arrowLength = 4;
            double angle = Math.atan2(y2 - y1, x2 - x1);

            int x3 = (int) (x2 - arrowLength * Math.cos(angle - Math.PI / 6));
            int y3 = (int) (y2 - arrowLength * Math.sin(angle - Math.PI / 6));
            int x4 = (int) (x2 - arrowLength * Math.cos(angle + Math.PI / 6));
            int y4 = (int) (y2 - arrowLength * Math.sin(angle + Math.PI / 6));

            g.drawLine(x2, y2, x3, y3);
            g.drawLine(x2, y2, x4, y4);
        }
    }

    private class TextAreaOutputStream extends java.io.OutputStream {
        private JTextArea textArea;

        public TextAreaOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws java.io.IOException {
            textArea.append(String.valueOf((char) b));
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
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


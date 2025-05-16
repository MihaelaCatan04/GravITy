package src;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Map;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import gen.*;
import processing.*;
import visitors.*;

public class GravITyIDE extends JFrame {

    private JTextArea codeArea;
    private JPanel simulationPanel;
    private JButton runButton;
    private JTextArea outputArea;
    private JSplitPane mainSplitPane;
    private JSplitPane rightSplitPane;

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

        setDefaultCode();
    }

    private JPanel createEditorPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Codul scris",
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
            public void changedUpdate(DocumentEvent e) { updateLineNumbers(); }
            public void insertUpdate(DocumentEvent e) { updateLineNumbers(); }
            public void removeUpdate(DocumentEvent e) { updateLineNumbers(); }

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
                String message = "Simulation output will appear here";
                int x = (getWidth() - fm.stringWidth(message)) / 2;
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g.drawString(message, x, y);
            }
        };
        simulationPanel.setBackground(Color.WHITE);
        JPanel simulationWrapper = new JPanel(new BorderLayout());
        simulationWrapper.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Afisare",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)
        ));
        simulationWrapper.add(simulationPanel, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Erori/Rezultate",
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

        JLabel statusLabel = new JLabel(" Ready");
        statusBar.add(statusLabel, BorderLayout.WEST);

        return statusBar;
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
                "Drag Force",
                "Pendulum",
                "Gravity",
                "Uniform Motion",
                "Wave",
                "Circular Motion",
                "Attraction Force"
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
                        "        initial_speed: 2.5\n" +
                        "        mover {\n" +
                        "            radius: 30\n" +
                        "            color {\n" +
                        "                red_value: 255\n" +
                        "                green_value: 100\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
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
                        "        radius: 100\n" +
                        "        angular_speed: 0.05\n" +
                        "        ball {\n" +
                        "            color {\n" +
                        "                red_value: 255\n" +
                        "                green_value: 100\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
            case "Attraction Force":
                return "simulation {\n" +
                        "    attraction_force {\n" +
                        "        mover1 {\n" +
                        "            radius: 30\n" +
                        "            mass: 50\n" +
                        "            position: [200, 200]\n" +
                        "            velocity: [0, 0]\n" +
                        "            color {\n" +
                        "                red_value: 0\n" +
                        "                green_value: 100\n" +
                        "                blue_value: 255\n" +
                        "            }\n" +
                        "        }\n" +
                        "        mover2 {\n" +
                        "            radius: 20\n" +
                        "            mass: 25\n" +
                        "            position: [400, 300]\n" +
                        "            velocity: [1, -1]\n" +
                        "            color {\n" +
                        "                red_value: 255\n" +
                        "                green_value: 100\n" +
                        "                blue_value: 0\n" +
                        "            }\n" +
                        "        }\n" +
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
                    handleAcceleratedMotionSimulation(tree, code);
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
                        int[] extractedColor = getColor(mover);
                        if (extractedColor != null) {
                            color = extractedColor;
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
                        int[] extractedColor = getColor(ball);
                        if (extractedColor != null) {
                            color = extractedColor;
                        }
                    }
                }
            }

            outputArea.append("Simulation parameters extracted successfully.\n");
            outputArea.append("Radius: " + radius + "\n");
            outputArea.append("Angular Speed: " + angularSpeed + "\n");
            outputArea.append("Simulation started. Check the display panel for visual output.\n");

            CircularMotionPanel panel = new CircularMotionPanel(radius, angularSpeed, color);
            replaceSimulationPanel(panel);
            startAnimation(panel);

        } catch (Exception ex) {
            outputArea.append("ERROR processing circular motion simulation: " + ex.getMessage() + "\n");
            ex.printStackTrace();

            CircularMotionPanel panel = new CircularMotionPanel(100f, 0.05f, new int[]{255, 100, 0});
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
                        int[] extractedColor = getColor(mover1);
                        if (extractedColor != null) {
                            color1 = extractedColor;
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
                        int[] extractedColor = getColor(mover2);
                        if (extractedColor != null) {
                            color2 = extractedColor;
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

    private float[] getPosition(Map<String, Object> mover) {
        try {
            Object pos = mover.get("position");
            if (pos instanceof float[]) {
                return (float[]) pos;
            }
        } catch (Exception e) {
        }
        return new float[] {200f, 200f};
    }

    private float[] getVelocity(Map<String, Object> mover) {
        try {
            Object vel = mover.get("velocity");
            if (vel instanceof float[]) {
                return (float[]) vel;
            }
        } catch (Exception e) {
        }
        return new float[] {0f, 0f};
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
                    return new int[] {r, g, b};
                }
            }
        } catch (Exception e) {
            outputArea.append("Error extracting color: " + e.getMessage() + "\n");
        }

        return new int[] {255, 0, 0};
    }

    private class GravITyErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                int line, int charPositionInLine, String msg, RecognitionException e) {
            outputArea.append("Syntax Error at line " + line + ":" + charPositionInLine + " - " + msg + "\n");
        }
    }

    private void replaceSimulationPanel(JPanel newPanel) {
        Container parent = simulationPanel.getParent();

        parent.remove(simulationPanel);

        newPanel.setBackground(Color.WHITE);
        parent.add(newPanel, BorderLayout.CENTER);

        simulationPanel = newPanel;

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

    private interface AnimatedPanel {
        void update();
    }

    private class GravityPanel extends JPanel implements AnimatedPanel {
        private float earthX, earthY, moonX, moonY;
        private float angle = 0;
        private float orbitRadius;
        private int frameCount = 0;

        public GravityPanel(float earthX, float earthY, float moonX, float moonY) {
            this.earthX = earthX;
            this.earthY = earthY;
            this.moonX = moonX;
            this.moonY = moonY;

            float dx = moonX - earthX;
            float dy = moonY - earthY;
            this.orbitRadius = (float) Math.sqrt(dx*dx + dy*dy);

            this.angle = (float) Math.atan2(dy, dx);

            setBackground(Color.BLACK);

            updateSimulationData();
        }

        private void updateSimulationData() {
            final float vx = -orbitRadius * (float) Math.sin(angle) * 0.02f;
            final float vy = orbitRadius * (float) Math.cos(angle) * 0.02f;
            final float velocity = (float) Math.sqrt(vx*vx + vy*vy);
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
            angle += 0.02;
            moonX = earthX + orbitRadius * (float) Math.cos(angle);
            moonY = earthY + orbitRadius * (float) Math.sin(angle);

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
            g.drawOval((int)(earthX - orbitRadius), (int)(earthY - orbitRadius),
                    (int)(orbitRadius * 2), (int)(orbitRadius * 2));

            g.setColor(new Color(70, 130, 180));
            int earthRadius = 30;
            g.fillOval((int)earthX - earthRadius, (int)earthY - earthRadius,
                    earthRadius * 2, earthRadius * 2);

            g.setColor(new Color(200, 200, 200));
            int moonRadius = 15;
            g.fillOval((int)moonX - moonRadius, (int)moonY - moonRadius,
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
            angleA = -gravity * (float) Math.sin(angle) / length;

            angleV = angleV * (1 - airResistance);

            angleV += angleA;

            angle += angleV;

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

            int bobX = originX + (int)(length * Math.sin(angle));
            int bobY = originY + (int)(length * Math.cos(angle));

            g.setColor(Color.BLACK);
            g.drawLine(originX, originY, bobX, bobY);

            g.setColor(new Color(200, 0, 0));
            g.fillOval(bobX - (int)radius, bobY - (int)radius, (int)radius * 2, (int)radius * 2);

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
                int y = centerY - (int)(amplitude * Math.sin(angle));

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

        public UniformMotionPanel(float radius, int[] color, float speed) {
            this.radius = radius;
            this.color = color;
            this.speed = speed;
            setBackground(Color.WHITE);

            updateSimulationData();
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
            x += speed;
            if (x > getWidth() + radius) {
                x = -radius;
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
            int y = groundY - (int)radius;
            g.fillOval((int)x - (int)radius, y - (int)radius, (int)radius * 2, (int)radius * 2);

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
        private float angle = 0;
        private int centerX, centerY;
        private int frameCount = 0;

        public CircularMotionPanel(float radius, float angularSpeed, int[] color) {
            this.radius = radius;
            this.angularSpeed = angularSpeed;
            this.color = color;
            setBackground(Color.WHITE);

            updateSimulationData();
        }

        private void updateSimulationData() {
            centerX = getWidth() / 2;
            centerY = getHeight() / 2;
            final float x = centerX + radius * (float) Math.cos(angle);
            final float y = centerY + radius * (float) Math.sin(angle);

            final float vx = -radius * angularSpeed * (float) Math.sin(angle);
            final float vy = radius * angularSpeed * (float) Math.cos(angle);
            final float velocity = (float) Math.sqrt(vx*vx + vy*vy);

            final float currentAngle = angle;
            final float currentRadius = radius;
            final float currentAngularSpeed = angularSpeed;
            final int currentFrameCount = frameCount;

            SwingUtilities.invokeLater(() -> {
                String existingOutput = outputArea.getText();
                String[] lines = existingOutput.split("\n");
                StringBuilder newOutput = new StringBuilder();

                for (int i = 0; i < Math.min(4, lines.length); i++) {
                    newOutput.append(lines[i]).append("\n");
                }

                newOutput.append("------ Circular Motion Data (Frame ").append(currentFrameCount).append(") ------\n");
                newOutput.append("Radius: ").append(String.format("%.1f", currentRadius)).append("\n");
                newOutput.append("Angular Speed: ").append(String.format("%.4f", currentAngularSpeed)).append(" rad/frame\n");
                newOutput.append("Current Angle: ").append(String.format("%.2f", currentAngle * 180 / Math.PI)).append(" degrees\n");
                newOutput.append("Position: (").append(String.format("%.1f", x)).append(", ")
                        .append(String.format("%.1f", y)).append(")\n");
                newOutput.append("Tangential Velocity: ").append(String.format("%.2f", velocity)).append("\n");

                outputArea.setText(newOutput.toString());
            });
        }

        @Override
        public void update() {
            angle += angularSpeed;
            if (angle > Math.PI * 2) {
                angle -= Math.PI * 2;
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
            g.drawOval(centerX - (int)radius, centerY - (int)radius, (int)radius * 2, (int)radius * 2);

            int ballX = centerX + (int)(radius * Math.cos(angle));
            int ballY = centerY + (int)(radius * Math.sin(angle));

            g.setColor(Color.BLACK);
            g.drawLine(centerX, centerY, ballX, ballY);

            g.fillOval(centerX - 5, centerY - 5, 10, 10);

            g.setColor(new Color(color[0], color[1], color[2]));
            int ballRadius = 20;
            g.fillOval(ballX - ballRadius, ballY - ballRadius, ballRadius * 2, ballRadius * 2);

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

        private void updateSimulationData() {
            final float dx = position2[0] - position1[0];
            final float dy = position2[1] - position1[1];
            final float distance = (float) Math.sqrt(dx*dx + dy*dy);

            final float distSq = Math.max(distance * distance, 0.0001f);
            final float force = g * (mass1 * mass2) / distSq;

            final float velocity1Mag = (float) Math.sqrt(velocity1[0]*velocity1[0] + velocity1[1]*velocity1[1]);
            final float velocity2Mag = (float) Math.sqrt(velocity2[0]*velocity2[0] + velocity2[1]*velocity2[1]);

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
            g.drawLine((int)position1[0], (int)position1[1], (int)position2[0], (int)position2[1]);

            g.setColor(new Color(color1[0], color1[1], color1[2]));
            g.fillOval((int)(position1[0] - radius1), (int)(position1[1] - radius1),
                    (int)(radius1 * 2), (int)(radius1 * 2));

            g.setColor(new Color(color2[0], color2[1], color2[2]));
            g.fillOval((int)(position2[0] - radius2), (int)(position2[1] - radius2),
                    (int)(radius2 * 2), (int)(radius2 * 2));

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
                radii[i] = 10 + (float)(Math.random() * 20);
                positions[i][0] = (float)(Math.random() * 600);
                positions[i][1] = (float)(Math.random() * 150);
                velocities[i][0] = -1 + (float)(Math.random() * 2);
                velocities[i][1] = (float)(Math.random() * 2);
            }
            frameCount = 0;
        }

        @Override
        public void update() {
            liquidLevel = getHeight() * 2 / 3;

            for (int i = 0; i < numMovers; i++) {
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
                g.fillOval((int)(positions[i][0] - radii[i]),
                        (int)(positions[i][1] - radii[i]),
                        (int)(radii[i] * 2),
                        (int)(radii[i] * 2));
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
                    resetSimulation();
                    updateSimulationData();

                    outputArea.append("Simulation reset!\n");
                }
            });
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
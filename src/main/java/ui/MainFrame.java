package ui;

import javax.swing.*;

import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame() {
        super("Swing component tester");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setResizable(false);

        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this);

        add(controlPanel, NORTH);
        add(designPanel, CENTER);
    }
}

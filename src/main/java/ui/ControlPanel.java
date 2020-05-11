package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JLabel classNameLabel;
    JTextField classNameField;
    JLabel textLabel;
    JTextField textField;
    JLabel widthLabel;
    JSpinner widthField;
    JLabel heightLabel;
    JSpinner heightField;
    JLabel xPosLabel;
    JSpinner xPosField;
    JLabel yPosLabel;
    JSpinner yPosField;

    JButton addButton;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(800, 100));

        classNameLabel = new JLabel("class name");
        classNameField = new JTextField(30);
        textLabel = new JLabel("text");
        textField = new JTextField(30);
        widthLabel = new JLabel("width");
        widthField = new JSpinner(new SpinnerNumberModel(50, 50, 400, 1));
        heightLabel = new JLabel("height");
        heightField = new JSpinner(new SpinnerNumberModel(50, 50, 200, 1));
        xPosLabel = new JLabel("x pos");
        xPosField = new JSpinner(new SpinnerNumberModel(50, 50, 750, 1));
        yPosLabel = new JLabel("y pos");
        yPosField = new JSpinner(new SpinnerNumberModel(150, 50, 500, 1));

        addButton = new JButton("add");

        add(classNameLabel);
        add(classNameField);
        add(textLabel);
        add(textField);
        add(widthLabel);
        add(widthField);
        add(heightLabel);
        add(heightField);
        add(xPosLabel);
        add(xPosField);
        add(yPosLabel);
        add(yPosField);
        add(addButton);
        addButton.addActionListener(this::add);
    }

    private void add(ActionEvent e) {
        try {
            frame.designPanel.addComponent(
                    classNameField.getText(),
                    textField.getText(),
                    (int) widthField.getValue(),
                    (int) heightField.getValue(),
                    (int) xPosField.getValue(),
                    (int) yPosField.getValue()
            );
        } catch (ClassNotFoundException classNotFoundException) {
            classNameLabel.setForeground(Color.RED);
            repaint();
            Timer timer = new Timer(500, this::makeBlack);
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void makeBlack(ActionEvent e) {
        if (classNameLabel.getForeground() == Color.RED) {
            classNameLabel.setForeground(Color.BLACK);
            repaint();
        }
    }
}

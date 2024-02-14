import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLight extends JFrame implements ActionListener {
    private JButton startButton;
    private JPanel lightPanel;

    public TrafficLight() {
        setTitle("Traffic Light");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton = new JButton("Start");
        startButton.addActionListener(this);
        add(startButton, BorderLayout.NORTH);

        lightPanel = new JPanel();
        lightPanel.setLayout(new GridLayout(3, 1));
        lightPanel.setBackground(Color.BLACK);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        lightPanel.add(redPanel);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.BLACK);
        lightPanel.add(yellowPanel);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.BLACK);
        lightPanel.add(greenPanel);

        add(lightPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Timer timer = new Timer(2000, new ActionListener() {
            int count = 0;

            public void actionPerformed(ActionEvent e) {
                if (count % 3 == 0) {
                    lightPanel.getComponent(0).setBackground(Color.RED);
                    lightPanel.getComponent(1).setBackground(Color.BLACK);
                    lightPanel.getComponent(2).setBackground(Color.BLACK);
                } else if (count % 3 == 1) {
                    lightPanel.getComponent(0).setBackground(Color.BLACK);
                    lightPanel.getComponent(1).setBackground(Color.YELLOW);
                    lightPanel.getComponent(2).setBackground(Color.BLACK);
                } else {
                    lightPanel.getComponent(0).setBackground(Color.BLACK);
                    lightPanel.getComponent(1).setBackground(Color.BLACK);
                    lightPanel.getComponent(2).setBackground(Color.GREEN);
                }
                count++;
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}

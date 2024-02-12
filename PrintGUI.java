import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PrintThread extends Thread {
    private String message;
    private int count;

    public PrintThread(String message, int count) {
        this.message = message;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
            try {
                Thread.sleep(100); // Sleep for a short duration to simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PrintGUI {
    private JFrame frame;
    private JTextField countField;

    public PrintGUI() {
        frame = new JFrame("Print Thread Demo");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(2, 2));

        JLabel countLabel = new JLabel("Enter count:");
        panel.add(countLabel);

        countField = new JTextField();
        panel.add(countField);

        JButton printButton = new JButton("PRINT");
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(countField.getText());

                // Without synchronization
                /*
                PrintThread t1 = new PrintThread("Thrikkakara", count);
                PrintThread t2 = new PrintThread("Kochi", count);

                t1.start();
                t2.start();
                */
                // With synchronization
                PrintThread t1 = new PrintThread("Thrikkakara", count);
                PrintThread t2 = new PrintThread("Kochi", count);

                synchronized (t1) {
                    t1.start();
                    try {
                        t1.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                synchronized (t2) {
                    t2.start();
                }
                
            }
        });
        panel.add(printButton);
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        PrintGUI printGUI = new PrintGUI();
        printGUI.display();
    }
}

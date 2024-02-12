

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivisionCalculator extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField, remarksField;
    private JButton divideButton;

    public DivisionCalculator() {
        setTitle("Division Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2));

        JLabel num1Label = new JLabel("Enter Num1:");
        num1Field = new JTextField();
        mainPanel.add(num1Label);
        mainPanel.add(num1Field);

        JLabel num2Label = new JLabel("Enter Num2:");
        num2Field = new JTextField();
        mainPanel.add(num2Label);
        mainPanel.add(num2Field);

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);
        mainPanel.add(resultLabel);
        mainPanel.add(resultField);

        JLabel remarksLabel = new JLabel("Remarks:");
        remarksField = new JTextField();
        remarksField.setEditable(false);
        mainPanel.add(remarksLabel);
        mainPanel.add(remarksField);

        divideButton = new JButton("Divide");
        divideButton.addActionListener(this);
        mainPanel.add(divideButton);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == divideButton) {
            try {
                float num1 = Float.parseFloat(num1Field.getText());
                float num2 = Float.parseFloat(num2Field.getText());
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                float result = num1 / num2;
                resultField.setText(String.valueOf(result));
                remarksField.setText("");
            } catch (NumberFormatException ex) {
                remarksField.setText("NumberFormatException: Invalid input!");
            } catch (ArithmeticException ex) {
                remarksField.setText("ArithmeticException: Division by zero!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DivisionCalculator());
    }
}

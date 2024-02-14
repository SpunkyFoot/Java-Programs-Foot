import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;

    private String operator;
    private double firstOperand;
    private boolean isFirstInput;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize variables
        operator = "";
        firstOperand = 0;
        isFirstInput = true;

        // Create display field
        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        // Create buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        add(buttonPanel, BorderLayout.CENTER);

        // Initialize number buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(this);
            buttonPanel.add(numberButtons[i]);
        }

        // Initialize operation buttons
        operationButtons = new JButton[4];
        operationButtons[0] = new JButton("+");
        operationButtons[1] = new JButton("-");
        operationButtons[2] = new JButton("*");
        operationButtons[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            operationButtons[i].addActionListener(this);
            buttonPanel.add(operationButtons[i]);
        }

        // Initialize equals and clear buttons
        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            String buttonText = button.getText();

            if (buttonText.equals("C")) {
                clearDisplay();
            } else if (buttonText.equals("=")) {
                calculateResult();
            } else if (isNumeric(buttonText)) {
                updateDisplay(buttonText);
            } else {
                setOperator(buttonText);
            }
        }
    }

    private void clearDisplay() {
        displayField.setText("");
        operator = "";
        firstOperand = 0;
        isFirstInput = true;
    }

    private void calculateResult() {
        if (!operator.isEmpty()) {
            double secondOperand = Double.parseDouble(displayField.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: Division by zero");
                        return;
                    }
                    break;
            }

            displayField.setText(Double.toString(result));
            operator = "";
            firstOperand = 0;
            isFirstInput = true;
        }
    }

    private void updateDisplay(String buttonText) {
        if (isFirstInput) {
            displayField.setText(buttonText);
            isFirstInput = false;
        } else {
            displayField.setText(displayField.getText() + buttonText);
        }
    }

    private void setOperator(String buttonText) {
        if (!isFirstInput) {
            firstOperand = Double.parseDouble(displayField.getText());
            operator = buttonText;
            isFirstInput = true;
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

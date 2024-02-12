import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonExample extends JFrame implements ActionListener {
    private JRadioButton bit1RadioButton;
    private JRadioButton bit0RadioButton;
    private JTextField resultTextField;
    private JButton button;

    public RadioButtonExample() {
        setTitle("Radio Button Example");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create radio buttons
        bit1RadioButton = new JRadioButton("Bit 1");
        bit0RadioButton = new JRadioButton("Bit 0");

       /*  // Create button group and add radio buttons to it
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(bit1RadioButton);
        buttonGroup.add(bit0RadioButton);
        */
        // Create text field
        resultTextField = new JTextField(1);
        resultTextField.setEditable(false);

        // Create button
        button = new JButton("Display");
        button.addActionListener(this);

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(bit1RadioButton);
        panel.add(bit0RadioButton);
        panel.add(resultTextField);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (bit1RadioButton.isSelected() && bit0RadioButton.isSelected()) {
            resultTextField.setText("3");
        } else if (bit1RadioButton.isSelected()) {
            resultTextField.setText("2");
        } else if (bit0RadioButton.isSelected()) {
            resultTextField.setText("1");
        } else {
            resultTextField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RadioButtonExample example = new RadioButtonExample();
            example.setVisible(true);
        });
    }
}

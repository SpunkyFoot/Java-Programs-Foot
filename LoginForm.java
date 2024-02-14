import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm {
    private JFrame frame = new JFrame();
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        frame.setTitle("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create labels
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        // Create text fields
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Create login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
        
                // Check login credentials (example: hardcoded values)
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(LoginForm.this.frame, "Login Successful!");
                    // Perform actions after successful login
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this.frame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create panel to hold components
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        // Add panel to the frame
        frame.add(panel);

        // Set frame properties
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create and display the login form
        new LoginForm();
    }
}

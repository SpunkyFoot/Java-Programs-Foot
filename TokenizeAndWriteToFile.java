import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TokenizeAndWriteToFile {
    private JFrame frame;
    private JTextField textField;

    public TokenizeAndWriteToFile() {
        frame = new JFrame("Tokenize and Write to File");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(3, 1));

        JLabel promptLabel = new JLabel("Enter a sentence:");
        panel.add(promptLabel);

        textField = new JTextField();
        panel.add(textField);

        JButton readButton = new JButton("Read");
        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tokenizeAndWriteToFile();
            }
        });
        panel.add(readButton);
    }

    public void display() {
        frame.setVisible(true);
    }

    private void tokenizeAndWriteToFile() {
        String sentence = textField.getText();
        String[] tokens = sentence.split(" ");
        
        // Writing to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tokens.txt"))) {
            writer.write("=============================================\n");
            writer.write("Sl.No\t\t\t\tToken\n");
            writer.write("=============================================\n");

            int slNo = 111;
            for (String token : tokens) {
                writer.write(slNo + "\t\t\t\t" + token + "\n");
                slNo++;
            }

            writer.close();
            JOptionPane.showMessageDialog(frame, "Tokens written to tokens.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TokenizeAndWriteToFile app = new TokenizeAndWriteToFile();
        app.display();
    }
}

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextFileAnalyzer extends Frame implements ActionListener {
    private TextArea textArea;
    private Button saveButton;

    public TextFileAnalyzer() {
        setTitle("Text File Analyzer");
        setSize(400, 300);
        setLayout(new BorderLayout());

        textArea = new TextArea();
        add(textArea, BorderLayout.CENTER);

        saveButton = new Button("Save");
        saveButton.addActionListener(this);
        add(saveButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String text = textArea.getText();
            try (PrintWriter writer = new PrintWriter("inputdata.txt")) {
                writer.println(text);
                System.out.println("Text saved to inputdata.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new TextFileAnalyzer();
        analyzeFile();
    }

    public static void analyzeFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("inputdata.txt"))) {
            String line;
            int wordCount = 0;
            int vowelCount = 0;
            int consonantCount = 0;
            int specialCharCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;

                // Equivalent code using normal for loops
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    char[] chars = word.toLowerCase().toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        char c = chars[j];
                        if (Character.isLetter(c)) {
                            if ("aeiou".indexOf(c) != -1) {
                                    vowelCount++;
                            } else {
                                    consonantCount++;
                            }
                        } else {
                            specialCharCount++;
                        }
                    }
                }
            }

            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of vowels: " + vowelCount);
            System.out.println("Number of consonants: " + consonantCount);
            System.out.println("Number of special characters: " + specialCharCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

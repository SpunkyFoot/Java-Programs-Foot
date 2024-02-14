import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class StudentDatabaseApp extends JFrame {
    private JTextField nameField, idField, gradeField, searchField;
    private JButton addButton, generateButton, searchButton;
    private JTextArea displayArea;
    private FileWriter writer;
    private File file;

    public StudentDatabaseApp() {
        setTitle("Student Database Application");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Grade:"));
        gradeField = new JTextField();
        inputPanel.add(gradeField);
        inputPanel.add(new JLabel("Search ID:"));
        searchField = new JTextField();
        inputPanel.add(searchField);

        addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        generateButton = new JButton("Generate Report");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });

        searchButton = new JButton("Search Student");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(generateButton);
        buttonPanel.add(searchButton);

        displayArea = new JTextArea();

         setLayout(new BorderLayout());
         add(inputPanel, BorderLayout.NORTH);
         add(buttonPanel, BorderLayout.CENTER);
         add(displayArea, BorderLayout.SOUTH);

        file = new File("student_report.txt");
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addStudent() {
        String name = nameField.getText();
        String id = idField.getText();
        String grade = gradeField.getText();

        String studentInfo = name + "," + id + "," + grade;
        displayArea.append("Added Student: " + studentInfo + "\n");

        try {
            writer.write(studentInfo + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        nameField.setText("");
        idField.setText("");
        gradeField.setText("");
    }

    private void generateReport() {
        displayArea.append("\nReport generated. Check student_report.txt\n");
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchStudent() {
        String searchID = searchField.getText();
        boolean found = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[1].equals(searchID)) {
                    displayArea.append("Found Student: " + line + "\n");
                    found = true;
                    break;
                }
            }
            reader.close();
            if (!found) {
                displayArea.append("Student with ID " + searchID + " not found.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentDatabaseApp().setVisible(true);
            }
        });
    }
}

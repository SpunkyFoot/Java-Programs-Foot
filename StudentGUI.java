import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Student {
    private int rollNo;
    private String name;
    private int mark1;
    private int mark2;

    public Student(int rollNo, String name, int mark1, int mark2) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }
}

public class StudentGUI {
    private JFrame frame;
    private JTextField rollNoField;
    private JTextField nameField;
    private JTextField mark1Field;
    private JTextField mark2Field;
    private JTextField totalMarksField;

    private Student student;

    public StudentGUI() {
        frame = new JFrame("Student Details");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(6, 2));

        JLabel rollNoLabel = new JLabel("Roll No:");
        panel.add(rollNoLabel);

        rollNoField = new JTextField();
        panel.add(rollNoField);

        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel);

        nameField = new JTextField();
        panel.add(nameField);

        JLabel mark1Label = new JLabel("Mark 1:");
        panel.add(mark1Label);

        mark1Field = new JTextField();
        panel.add(mark1Field);

        JLabel mark2Label = new JLabel("Mark 2:");
        panel.add(mark2Label);

        mark2Field = new JTextField();
        panel.add(mark2Field);

        JButton importButton = new JButton("Import Data");
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                importData();
            }
        });
        panel.add(importButton);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotalMarks();
            }
        });
        panel.add(calculateButton);

        JLabel totalMarksLabel = new JLabel("Total Marks:");
        panel.add(totalMarksLabel);

        totalMarksField = new JTextField();
        totalMarksField.setEditable(false);
        panel.add(totalMarksField);
    }

    public void display() {
        frame.setVisible(true);
    }

    private void importData() {
        try (BufferedReader br = new BufferedReader(new FileReader("student_data.txt"))) {
            String line = br.readLine(); // Skipping header line
            line = br.readLine(); // Reading data line
            String[] data = line.split("\\s+");
            int rollNo = Integer.parseInt(data[0]);
            String name = data[1];
            int mark1 = Integer.parseInt(data[2]);
            int mark2 = Integer.parseInt(data[3]);
            student = new Student(rollNo, name, mark1, mark2);
            displayStudentDetails();
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error reading data from file: " + e.getMessage());
        }
    }

    private void displayStudentDetails() {
        rollNoField.setText(String.valueOf(student.getRollNo()));
        nameField.setText(student.getName());
        mark1Field.setText(String.valueOf(student.getMark1()));
        mark2Field.setText(String.valueOf(student.getMark2()));
    }

    private void calculateTotalMarks() {
        if (student != null) {
            int totalMarks = student.getMark1() + student.getMark2();
            totalMarksField.setText(String.valueOf(totalMarks));
        } else {
            JOptionPane.showMessageDialog(frame, "No student data imported.");
        }
    }

    public static void main(String[] args) {
        StudentGUI studentGUI = new StudentGUI();
        studentGUI.display();
    }
}

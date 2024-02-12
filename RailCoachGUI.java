import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Compartment {
    protected int totalSeats;
    protected int availableSeats;

    public Compartment(int totalSeats) {
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public abstract boolean bookTicket();

    public abstract boolean cancelTicket();

    public abstract void notice();
}

class FirstClass extends Compartment {
    public FirstClass(int totalSeats) {
        super(totalSeats);
    }

    @Override
    public boolean bookTicket() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean cancelTicket() {
        if (availableSeats < totalSeats) {
            availableSeats++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void notice() {
        System.out.println("First class: " + availableSeats + " seats available.");
    }
}

class GeneralClass extends Compartment {
    public GeneralClass(int totalSeats) {
        super(totalSeats);
    }

    @Override
    public boolean bookTicket() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean cancelTicket() {
        if (availableSeats < totalSeats) {
            availableSeats++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void notice() {
        System.out.println("General class: " + availableSeats + " seats available.");
    }
}

public class RailCoachGUI {
    private JFrame frame;
    private JTextField textField;
    private JLabel label;
    private JLabel firstClassLabel;
    private JLabel generalClassLabel;

    private FirstClass firstClass;
    private GeneralClass generalClass;

    public RailCoachGUI() {
        frame = new JFrame("Rail Coach Booking");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        textField = new JTextField();
        textField.setBounds(100, 20, 165, 25);
        panel.add(textField);

        JRadioButton firstClassButton = new JRadioButton("First Class");
        firstClassButton.setBounds(10, 50, 120, 25);
        panel.add(firstClassButton);

        JRadioButton generalClassButton = new JRadioButton("General Class");
        generalClassButton.setBounds(140, 50, 120, 25);
        panel.add(generalClassButton);

        ButtonGroup classGroup = new ButtonGroup();
        classGroup.add(firstClassButton);
        classGroup.add(generalClassButton);

        JButton bookButton = new JButton("Book Ticket");
        bookButton.setBounds(10, 80, 120, 25);
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTicket(firstClassButton.isSelected());
            }
        });
        panel.add(bookButton);

        JButton cancelButton = new JButton("Cancel Ticket");
        cancelButton.setBounds(140, 80, 120, 25);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelTicket(firstClassButton.isSelected());
            }
        });
        panel.add(cancelButton);

        label = new JLabel("");
        label.setBounds(10, 110, 300, 25);
        panel.add(label);

        firstClassLabel = new JLabel("");
        firstClassLabel.setBounds(10, 140, 300, 25);
        panel.add(firstClassLabel);

        generalClassLabel = new JLabel("");
        generalClassLabel.setBounds(10, 170, 300, 25);
        panel.add(generalClassLabel);

        firstClass = new FirstClass(50);
        generalClass = new GeneralClass(100);
        updateLabels();
    }

    public void display() {
        frame.setVisible(true);
    }

    private void updateLabels() {
        firstClassLabel.setText("First Class: " + firstClass.availableSeats + " seats available.");
        generalClassLabel.setText("General Class: " + generalClass.availableSeats + " seats available.");
    }

    private void bookTicket(boolean isFirstClass) {
        if (isFirstClass) {
            if (firstClass.bookTicket()) {
                label.setText("Ticket booked successfully in First Class.");
            } else {
                label.setText("No seats available in First Class.");
            }
        } else {
            if (generalClass.bookTicket()) {
                label.setText("Ticket booked successfully in General Class.");
            } else {
                label.setText("No seats available in General Class.");
            }
        }
        updateLabels();
    }

    private void cancelTicket(boolean isFirstClass) {
        if (isFirstClass) {
            if (firstClass.cancelTicket()) {
                label.setText("Ticket canceled successfully in First Class.");
            } else {
                label.setText("No tickets to cancel in First Class.");
            }
        } else {
            if (generalClass.cancelTicket()) {
                label.setText("Ticket canceled successfully in General Class.");
            } else {
                label.setText("No tickets to cancel in General Class.");
            }
        }
        updateLabels();
    }

    public static void main(String[] args) {
        RailCoachGUI railCoachGUI = new RailCoachGUI();
        railCoachGUI.display();
    }
}

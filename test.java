import java.io.*;
import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class pInterface{
    JFrame frame;
    JPanel panel;
    public pInterface(){
        frame = new JFrame("Check Palindrome");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));

        JLabel iString = new JLabel("Enter the String");
        JTextField iStringF = new JTextField();

        panel.add(iString);
        panel.add(iStringF);

        JLabel Remark = new JLabel("Remark");
        JTextField RemarkF = new JTextField();
        RemarkF.setEditable(false);

        panel.add(Remark);
        panel.add(RemarkF);
        JButton Check = new JButton("Check If Palindrome");
        Check.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String Str = iStringF.getText();
                isP q = new isP();

                if(q.isPalindrome(Str))
                    RemarkF.setText("String is A Palindrome");
                else
                    RemarkF.setText("String is Not A Palindrome");
            }
        });
        panel.add(Check);

        JButton Clear = new JButton("Clear");
        Clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                RemarkF.setText("");
            }
        });
        panel.add(Clear);

        frame.add(panel);
        frame.setVisible(true);
    }
}
class isP{
    public boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }

}


class test{
    public static void main(String args[])
    {
            /*Scanner sc = new Scanner(System.in);
            isP ptr = new isP();
            System.out.println("Enter the String:");
            String str = sc.nextLine();
            if(ptr.isPalindrome(str))
                System.out.println("String is A Palindrome");
            else
                System.out.println("String is Not A Palindrome");*/
        pInterface p = new pInterface();
    }
}
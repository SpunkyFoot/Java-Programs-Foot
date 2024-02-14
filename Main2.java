import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Find and replace palindrome substring with asterisks
        String modifiedString = replacePalindromeWithAsterisks(input);
        
        // Write modified line to file
        try {
            FileWriter writer = new FileWriter("modified_line.txt");
            writer.write(modifiedString);
            writer.close();
            System.out.println("Modified line written to file 'modified_line.txt'");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        
        scanner.close();
    }
    
    public static String replacePalindromeWithAsterisks(String input) {
        String modifiedString = input;
        int length = input.length();
        
        // Check each substring for palindrome
        for (int i = 0; i < length; i++) {
            for (int j = i + 2; j <= length; j++) {
                String substring = input.substring(i, j);
                if (isPalindrome(substring)) {
                    // Replace palindrome substring with asterisks
                    modifiedString = modifiedString.replace(substring, "**");
                }
            }
        }
        return modifiedString;
    }
    
    public static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

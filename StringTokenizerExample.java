import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String text = "This is a sample text, with some words separated by spaces and commas.";

        // Create a StringTokenizer object with space and comma as delimiters
        StringTokenizer tokenizer = new StringTokenizer(text, " ,");

        // Iterate through the tokens and print them
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
    }
}

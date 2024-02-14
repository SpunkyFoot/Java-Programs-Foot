import java.io.*;
import java.util.Random;

class NumberGenerator extends Thread {
    private Random random;
    private BufferedWriter evenWriter;
    private BufferedWriter oddWriter;

    public NumberGenerator(String evenFileName, String oddFileName) {
        this.random = new Random();
        try {
            this.evenWriter = new BufferedWriter(new FileWriter(evenFileName));
            this.oddWriter = new BufferedWriter(new FileWriter(oddFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(10); // Generate a random number between 0 and 99
            try {
                if (number % 2 == 0) {
                    synchronized (evenWriter) {
                        evenWriter.write(number + "\t");
                    }
                } else {
                    synchronized (oddWriter) {
                        oddWriter.write(number + "\t");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            evenWriter.close();
            oddWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        // Create number generator thread
        NumberGenerator generator = new NumberGenerator("Even.txt", "Odd.txt");
        generator.start();

        try {
            generator.join(); // Wait for the number generator thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Read and print even numbers from Even.txt
        System.out.println("Even Numbers:");
        printFileContent("Even.txt");

        // Read and print odd numbers from Odd.txt
        System.out.println("Odd Numbers:");
        printFileContent("Odd.txt");
    }

    private static void printFileContent(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

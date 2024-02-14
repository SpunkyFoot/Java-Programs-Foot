import java.io.*;
import java.util.Random;

class Global {
    static int num;
}

class ThreadA extends Thread {
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            synchronized (Global.class) {
                Global.num = random.nextInt(10); // Generate a random number between 0 and 99
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadB extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Global.class) {
                if (Global.num % 2 == 0) {
                    try (FileWriter fw = new FileWriter("Even.txt", true)) {
                        fw.write(Global.num + "\t");
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class ThreadC extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Global.class) {
                if (Global.num % 2 != 0) {
                    try (FileWriter fw = new FileWriter("Odd.txt", true)) {
                        fw.write(Global.num + "\t");
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
    }
}

public class test1 {
    public static void main(String[] args) {
        // Create threads
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();

        // Start threads
        a.start();
        b.start();
        c.start();

        // Wait for threads to finish
        try {
            a.join();
            b.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Read and print even numbers from Even.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("Even.txt"))) {
            System.out.println("Even Numbers:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read and print odd numbers from Odd.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("Odd.txt"))) {
            System.out.println("Odd Numbers:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

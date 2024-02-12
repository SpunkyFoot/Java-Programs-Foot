import java.util.Scanner;

class ReaderThread extends Thread {
    private SharedData sharedData;

    public ReaderThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a string: ");
            String userInput = scanner.nextLine();
            sharedData.setString(userInput);
        }
    }
}

class PrinterThread extends Thread {
    private SharedData sharedData;

    public PrinterThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            String strToPrint = sharedData.getString();
            System.out.println(strToPrint);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SharedData {
    private String str = "hello world";

    public synchronized String getString() {
        return str;
    }

    public synchronized void setString(String newStr) {
        str = newStr;
    }
}

public class StringReaderPrinter {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        PrinterThread printerThread = new PrinterThread(sharedData);
        ReaderThread readerThread = new ReaderThread(sharedData);

        printerThread.start();
        readerThread.start();
    }
}

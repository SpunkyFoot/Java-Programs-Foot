import java.util.Scanner;

abstract class Bank {
    protected double balance;

    public abstract void creditAmount(double amount);

    public abstract void debitAmount(double amount);

    public double getBalance() {
        return balance;
    }
}

class SBI extends Bank {
    public SBI() {
        balance = 0;
    }

    public void creditAmount(double amount) {
        balance += amount;
    }

    public void debitAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class Federal extends Bank {
    public Federal() {
        balance = 0;
    }

    public void creditAmount(double amount) {
        balance += amount;
    }

    public void debitAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class Canara extends Bank {
    public Canara() {
        balance = 0;
    }

    public void creditAmount(double amount) {
        balance += amount;
    }

    public void debitAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SBI sbi = new SBI();
        Federal federal = new Federal();
        Canara canara = new Canara();
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create SBI account");
            System.out.println("2. Create Federal account");
            System.out.println("3. Create Canara account");
            System.out.println("4. Credit amount");
            System.out.println("5. Debit amount");
            System.out.println("6. Get balance");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("SBI account created");
                    break;
                case 2:
                    System.out.println("Federal account created");
                    break;
                case 3:
                    System.out.println("Canara account created");
                    break;
                case 4:
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = scanner.nextDouble();
                    sbi.creditAmount(creditAmount);
                    federal.creditAmount(creditAmount);
                    canara.creditAmount(creditAmount);
                    System.out.println("Amount credited successfully to all accounts");
                    break;
                case 5:
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = scanner.nextDouble();
                    sbi.debitAmount(debitAmount);
                    federal.debitAmount(debitAmount);
                    canara.debitAmount(debitAmount);
                    System.out.println("Amount debited successfully from all accounts");
                    break;
                case 6:
                    System.out.println("SBI balance: " + sbi.getBalance());
                    System.out.println("Federal balance: " + federal.getBalance());
                    System.out.println("Canara balance: " + canara.getBalance());
                    break;
                case 7:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 7);
        scanner.close();
    }
}

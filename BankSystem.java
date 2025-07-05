import java.util.Scanner;

class Account {
    private String ownerName;
    private String accountNumber;
    private double balance;

    public Account(String ownerName, String accountNumber) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: Rs. " + balance);
    }

    public void showDetails() {
        System.out.println("Account Holder: " + ownerName);
        System.out.println("Account Number: " + accountNumber);
        checkBalance();
    }
}

public class BankSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = input.nextLine();

        System.out.print("Enter account number: ");
        String accNum = input.nextLine();

        Account user = new Account(name, accNum);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = input.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = input.nextDouble();
                    user.withdraw(withdrawAmount);
                    break;
                case 3:
                    user.checkBalance();
                    break;
                case 4:
                    user.showDetails();
                    break;
                case 5:
                    System.out.println("Thank you for using our bank system.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);

        input.close();
    }
}

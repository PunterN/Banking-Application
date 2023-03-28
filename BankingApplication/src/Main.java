import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        while (true) {
            System.out.println("\nSelect option:");
            System.out.println("1. Create account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account name: ");
                    String name = scanner.next();
                    System.out.print("Enter initial balance: ");
                    int balance = scanner.nextInt();
                    Account newAccount = new Account(name, balance);
                    accounts.add(newAccount);
                    System.out.println("Account created");
                    break;
                case 2:
                    System.out.print("Enter account name: ");
                    name = scanner.next();
                    Account withdrawAccount = selectAccount(accounts, name);
                    if (withdrawAccount == null) {
                        System.out.println("Account doesnt exist");
                    } else {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = scanner.nextDouble();
                        withdrawAccount.withdraw(amount);

                    }
                    break;
                case 3:

                    System.out.print("Enter accounts name: ");
                    name = scanner.next();
                    Account depositAccount = selectAccount(accounts, name);
                    if (depositAccount == null) {
                        System.out.println("Account doesnt exist");
                    } else {
                        System.out.print("Deposit amount: ");
                        int amount = scanner.nextInt();
                        depositAccount.deposit(amount);
                        System.out.println("Deposit successful");
                        System.out.println("New balance: " + depositAccount.getBalance());

                    }
                    break;
                case 4:
                    System.out.print("Enter sender name: ");
                    String sender = scanner.next();
                    Account senderAcc = selectAccount(accounts, sender);
                    if (senderAcc == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.print("Enter receiver name: ");
                    String receiver = scanner.next();
                    Account receiverAcc = selectAccount(accounts, receiver);
                    if (receiverAcc == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    boolean transferSuccessful = senderAcc.transfer(receiverAcc, transferAmount);

                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static Account selectAccount(ArrayList<Account> accounts, String name) {
        for (Account account : accounts) {
            if (account.getName().equals(name)) {
                return account;
            }
        }
        return null;
    }
}

class Account {
    private String name;
    private double funds;

    public Account(String name, double funds) {
        this.name = name;
        this.funds = funds;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return funds;
    }

    public void deposit(double amount) {
        funds += amount;
    }

    public void withdraw(double amount) {
        if (funds < amount) {
            System.out.println("Insufficient funds");
        } else {
            funds -= amount;
            System.out.println("Withdrawal successful");
            System.out.println("New balance is " + funds);

        }
    }
    public boolean transfer(Account toAcc, double amount) {
        if (funds < amount) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            if (funds < amount) {
            } else {
                funds -= amount;

            }
            toAcc.deposit(amount);
            System.out.println("Transfer success");
            System.out.println("Updated balance in " + getName() + " is " + funds);
            System.out.println("New balance in " + toAcc.getName() + " is " + toAcc.getBalance());
            return true;
        }



    }

}

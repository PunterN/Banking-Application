import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> bankAccounts = new ArrayList<>();

        while (true) {
            System.out.println("\n/--------------------/");
            System.out.println("Select option:");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Show Account Details");
            System.out.println("6. Exit");

            int selectOption = scanner.nextInt();

            switch (selectOption) {
                case 1:
                    System.out.print("Enter account name: ");
                    String name = scanner.next();
                    System.out.print("Enter initial balance: £");
                    double balance = scanner.nextDouble();
                    Account newAccount = new Account(name, balance);
                    bankAccounts.add(newAccount);
                    System.out.println("Account created");
                    break;
                case 2:
                    System.out.print("Enter account name: ");
                    name = scanner.next();
                    Account withdrawAccount = selectAccount(bankAccounts, name);
                    if (withdrawAccount == null) {
                        System.out.println("Account doesnt exist");
                    } else {
                        System.out.print("Enter withdrawal amount: £");
                        double amount = scanner.nextDouble();
                        withdrawAccount.withdraw(amount);

                    }
                    break;
                case 3:

                    System.out.print("Enter accounts name: ");
                    name = scanner.next();
                    Account depositAccount = selectAccount(bankAccounts, name);
                    if (depositAccount == null) {
                        System.out.println("Account doesnt exist");
                    } else {
                        System.out.print("Deposit amount: £");
                        double amount = scanner.nextDouble();
                        depositAccount.deposit(amount);
                        System.out.println("Deposit successful");
                        System.out.println("New balance: £" + depositAccount.getBalance());

                    }
                    break;
                case 4:
                    System.out.print("Enter sender name: ");
                    String sender = scanner.next();
                    Account senderAcc = selectAccount(bankAccounts, sender);
                    if (senderAcc == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.print("Enter receiver name: ");
                    String receiver = scanner.next();
                    Account receiverAcc = selectAccount(bankAccounts, receiver);
                    if (receiverAcc == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.print("Enter transfer amount: £");
                    double transferAmount = scanner.nextDouble();
                    boolean transferSuccessful = senderAcc.transfer(receiverAcc, transferAmount);

                    break;

                case 5:
                    System.out.print("Enter account name: ");
                    name = scanner.next();
                    Account account = selectAccount(bankAccounts, name);
                    if (account == null) {
                        System.out.println("Account doesn't exist");
                    } else {
                        System.out.println("Name: " + account.getName());
                        System.out.println("Balance: £" + account.getBalance());
                    }
                    break;
                case 6:
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
            System.out.println("New balance is £" + funds);

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
            System.out.println("Updated balance in " + getName() + " is £" + funds);
            System.out.println("New balance in " + toAcc.getName() + " is £" + toAcc.getBalance());
            return true;
        }



    }

}

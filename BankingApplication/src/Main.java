import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        System.out.print("Enter initial account name: ");
        String name = scanner.nextLine();
        account.setName(name);

        System.out.print("Please enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        account.setBalance(initialDeposit);

        System.out.println("Account created");
        System.out.println("Account name: " + account.getName());
        System.out.println("Initial balance: £" + account.getBalance());

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View balance");
            System.out.println("4. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Please enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    System.out.println("Balance after deposit: £" + account.getBalance());
                    break;

                case 2:
                    System.out.println("Balance available for withdrawl: £" + account.getBalance());
                    System.out.print("Please enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.println("Withdrawal successful.");
                    System.out.println("Balance after withdrawal: £" + account.getBalance());
                    break;

                case 3:
                    System.out.println("Balance: £" + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the banking application!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class Account {
    private String name;
    private double balance;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
        }
    }
}

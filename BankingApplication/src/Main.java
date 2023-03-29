import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        // ArrayList to store bank accounts
        ArrayList<Account> bankAccounts = new ArrayList<>();
        // Scanner object to get user inputs
        Scanner scanner = new Scanner(System.in);

        // Infinite loop so user can keep in the application until using exit
        while (true)
        {
            // User UI
            System.out.println("\n/--------------------/");
            System.out.println("--- Banking Portal ---");
            System.out.println("/--------------------/");
            System.out.println("Select option:");
            System.out.println("1. Create Account");
            System.out.println("2. Show Account Details");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer");

            System.out.println("6. Exit");
            // Read user option input
            int selectOption = scanner.nextInt();

            switch (selectOption)
            {
                //Create account object by adding name and balance to arraylist
                case 1:
                    System.out.print("Enter account name: ");
                    String name = scanner.next();
                    System.out.print("Enter initial balance: £");
                    double balance = scanner.nextDouble();
                    Account newAccount = new Account(name, balance);
                    bankAccounts.add(newAccount);
                    System.out.println("Account created");
                    break;

                // Enter account name in order to user selectAccount() to find the intended account
                case 2:
                    System.out.print("Enter account name: ");
                    name = scanner.next();
                    Account account = selectAccount(bankAccounts, name);
                    if (account == null)
                    {
                        System.out.println("Account doesn't exist");
                    } else
                    {
                        System.out.println("Name: " + account.retrieveName());
                        System.out.println("Balance: £" + account.retrieveBalance());
                    }
                    break;
                /* Withdraw from account, use selectAccount() to search for intended account
                    use withdraw() to update account balance */
                case 3:
                    System.out.print("Enter account name to withdraw from: ");
                    name = scanner.next();
                    Account withdrawAccount = selectAccount(bankAccounts, name);
                    if (withdrawAccount == null)
                    {
                        System.out.println("Account doesnt exist");
                    } else {
                        System.out.print("Enter withdrawal amount: £");
                        double amount = scanner.nextDouble();
                        withdrawAccount.withdraw(amount);

                    }
                    break;
                /* Deposit money into the account, use selectAccount() to search for intended account
                    then deposit() updates the account balance
                 */
                case 4:
                    System.out.print("Enter accounts name to deposit to: ");
                    name = scanner.next();
                    Account depositAccount = selectAccount(bankAccounts, name);
                    if (depositAccount == null)
                    {
                        System.out.println("Account doesnt exist");
                    } else
                    {
                        System.out.print("Deposit amount: £");
                        double amount = scanner.nextDouble();
                        depositAccount.deposit(amount);
                        System.out.println("Deposit successful");
                        System.out.println("New balance: £" + depositAccount.retrieveBalance());

                    }
                    break;
                /* Transfer between accounts, use selectAccount() to make sender account object,
                 *  then make receiver object in the same way then transfer() updatees each account accordingly */
                case 5:
                    System.out.print("Enter senders account name: ");
                    String sender = scanner.next();
                    Account senderAcc = selectAccount(bankAccounts, sender);
                    if (senderAcc == null)
                    {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.print("Enter receivers account name: ");
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

                /* System.exit(0) is used just to exit the program in its intended manner */
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
    /* Searches for an account in the list by name, 'ArrayList<Account>' is the list to search through,
    'name' is the name of the account to search for, then returns account if exists otherwise return null
     */
    public static Account selectAccount(ArrayList<Account> accounts, String name)
    {
        for (Account account:accounts)
        {
            // retrieveName() method gets the name of the account then equals() checks if it matches the name passed in the method
            if (account.retrieveName().equals(name))
            {
                return account;
            }
        }
        return null;
    }
}



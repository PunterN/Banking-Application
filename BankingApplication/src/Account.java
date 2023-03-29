class Account {
    private String name;
    private double funds;
    // Intitialize account with a user inputted name and funds
    public Account(String name, double funds)
    {
        this.name = name;
        this.funds = funds;
    }
    // Retrieves account name
    public String retrieveName()
    {
        return name;
    }
    // Retrieves accounts balance
    public double retrieveBalance()
    {
        return funds;
    }
    // Adds amount to total account funds
    public void deposit(double amount)
    {
        funds += amount;
    }
    // Checks if theres enough funds in the account then takes the intended amount away from total funds
    public void withdraw(double amount)
    {
        if (funds >= amount)
        {
            funds -= amount;
            System.out.println("Successful withdrawal");
            System.out.println("New balance is £" + funds);
        } else
        {

            System.out.println("Insufficient funds");

        }
    }
    // Used to transfer funds in a similar way to withdraw() by checking for whether theres enough funds
    public boolean transfer(Account toAcc, double amount)
    {
        if (funds >= amount)
        {
            funds -= amount;

            // Uses deposit to update the funds of the receivers account
            toAcc.deposit(amount);
            System.out.println("Transfer success");
            System.out.println(retrieveName() +" balance is now £" + funds);
            System.out.println(toAcc.retrieveName() + " balance is now £" + toAcc.retrieveBalance());
            return true;

        } else
        {
            System.out.println("Insufficient funds");
            return false;


        }

    }
}
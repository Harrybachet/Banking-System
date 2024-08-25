
// This is an Account class that extends the Customer class //
public class Account extends Customer {

    // making balance and accNumber private //
    private int balance;
    private int accountNumber;


    // An account constructor where we have to add the firstName, LastName, balance, accNumber if we create an account object //
    public Account(String firstName, String lastName, int balance, int accountNumber) {
        super(firstName, lastName);
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    // returning balance of the user //
    public int getBalance() {
        return balance;
    }

    // returning account number of the user //
    public int getAccountNum() {
        return accountNumber;
    }

    // This is me adding the amount to the balance if someone wants to deposit some amount, then we add that amount to balance //
    public void deposit(int amount) {
        balance += amount;
    }

    // This is me withdrawing the balance to the amount if someone wants to withdraw some amount, then we subtract that amount to balance //
    public void withdraw(int amount) {
        balance -= amount;
//        if(balance < 0){
//            System.out.println("no money");
//        }
    }
}

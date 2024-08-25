public class Transaction {

    public void transfer(Account sourceAccount, Account destinationAccount, int amount) {
        sourceAccount.withdraw(amount);
        destinationAccount.deposit(amount);
    }
}
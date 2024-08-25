import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        char dash1 = '-';

        int j = 70;
        String dash = String.valueOf(dash1).repeat(j);

        Account account1 = new Account("Jeffrey", "Ting", 2000, 1);
        Account account2 = new Account("Hiran", "Patel", 1000, 2);


        String officialAppHeader = "-".repeat(70) + "\n" + "-".repeat(20) +
                " Banking Management System " + "-".repeat(23) + "\n" + "-".repeat(70) + "\n" +
                " ".repeat(44) + " powered by Ronak Basnet";

        System.out.println(officialAppHeader + "\n");


        System.out.println(dash);
        System.out.println("|           Your original balance on account1 is: " + "$" + account1.getBalance() + "              |");
        System.out.println(dash);

        System.out.println("|           Your original balance on account2 is: " + "$" +account2.getBalance() + "              |");
        System.out.println(dash);

        account1.deposit(250);
        System.out.println("|  You have deposited money on account1. Your balance is now: " + "$" + account1.getBalance() + "  |");
        System.out.println(dash);

        account2.withdraw(500);
        System.out.println("|  You have withdrawn money on account2. Your balance is now: " + "$" +account2.getBalance() + "   |");
        System.out.println(dash);

        Transaction t = new Transaction();
        t.transfer(account1, account2, 250);

        System.out.println("|     Your final balance in account1 after transaction: " + "$" +account1.getBalance() + "        |");
        System.out.println(dash);

        System.out.println("|     Your final balance in account2 after transaction: " + "$" + account2.getBalance() + "         |");
        System.out.println(dash);

        System.out.println("\n--------------------------------------------------------------------------");
        System.out.println("| Just checking the CSV file to see if it prints to the terminal or not  |");
        System.out.println("--------------------------------------------------------------------------");

        ReadAccounts readAccounts = new ReadAccounts("src\\Accounts.csv");

        LinkedList<String> firstNames = readAccounts.getFirstNames();
        LinkedList<String> lastNames = readAccounts.getLastNames();
        LinkedList<Integer> accountList = readAccounts.getAccounts();
        LinkedList<Integer> balanceList = readAccounts.getBalances();

        readAccounts.readFile(firstNames, lastNames, accountList, balanceList);
        System.out.println("--------------------------------------------------------------------------");



        LinkedList<Account> accounts = new LinkedList<>();


        // The for loop for the account details //
        for (int i = 0; i < firstNames.size(); i++) {
            String firstName = firstNames.get(i);
            String lastName = lastNames.get(i);
            int accountNumber = accountList.get(i);
            int balance = balanceList.get(i);

            // Create a new Account object and add it to the account list //
            accounts.add(new Account(firstName, lastName, balance, accountNumber));
        }


        System.out.println();
        // This for loop will make me grab each account //

        for (Account account : accounts) {
            char myDash = '-';
            int n = 120;
            String repeatDash = String.valueOf(myDash).repeat(n);
            System.out.println(repeatDash);
            System.out.println("Account created: |Your account number is: " + account.getAccountNum()
                    + "| " + "|First name: " + account.getFirstName()
                    + "|" + " |Last name: " + account.getLastName()
                    + "|" + " |Your balance is: $" + account.getBalance() + "|");
            System.out.println(repeatDash);
        }



        new GUI();






    }
}



   import java.util.Date;

    public class Main {
        public static void main(String[] args) {
            // Create a new customer with name, account number, initial checking, and savings balance
            Customer customer = new Customer("John Doe", 12345, 1000.0, 2000.0);


            // Print initial balances
            System.out.println("Initial Balances:");
            System.out.println("Checking Balance: $" + customer.getCheckBalance());
            System.out.println("Savings Balance: $" + customer.getSavingBalance());

            // Make deposits and withdrawals
            Date date = new Date(); // Get the current date (you can set it as needed)
            customer.deposit(500.0, date, Customer.CHECKING);
            customer.withdraw(200.0, date, Customer.SAVING);
            customer.withdraw(1500.0, date, Customer.CHECKING);

            // Print updated balances
            System.out.println("\nUpdated Balances:");
            System.out.println("Checking Balance: $" + customer.getCheckBalance());
            System.out.println("Savings Balance: $" + customer.getSavingBalance());

            // Display deposit and withdrawal history
            System.out.println("\nDeposit History:");
            customer.displayDeposits();

            System.out.println("\nWithdrawal History:");
            customer.displayWithdraws();
        }
    }


import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this();
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
    }

    public double deposit(double amt, Date date, String account){
        //your code here
        if (amt <= 0) {
            System.out.println("Invalid deposit amount");
        return 0;
    }

        Deposit deposit = new Deposit(amt, date, account);

        if (account.equals(CHECKING)) {
            checkBalance += amt;
            deposits.add(deposit);
            return checkBalance;
        } else if (account.equals(SAVING)) {
            savingBalance += amt;
            deposits.add(deposit);
            return savingBalance;
        } else {
            System.out.println("Invalid account type");
            return 0;
        }
    }

    public double withdraw(double amt, Date date, String account){
        //your code here
        if (amt <= 0) {
            System.out.println("Invalid withdrawal amount");
        return 0;
    }

        Withdraw withdrawal = new Withdraw(amt, date, account);

        if (account.equals(CHECKING)) {
            if (checkOverdraft(amt, CHECKING)) {
                System.out.println("Withdrawal exceeds overdraft limit");
                return checkBalance;
            }
            checkBalance -= amt;
            withdraws.add(withdrawal);
            return checkBalance;
        } else if (account.equals(SAVING)) {
            if (savingBalance - amt >= 0) {
                savingBalance -= amt;
                withdraws.add(withdrawal);
                return savingBalance;
            } else {
                System.out.println("Insufficient balance in savings account");
                return savingBalance;
            }
        } else {
            System.out.println("Invalid account type");
            return 0;
        }
    }

    public double getCheckBalance() {
        this.checkBalance = checkBalance;
        return 0;
    }

    public double getSavingBalance() {
        this.savingBalance = savingBalance;
        return 0;
    }

    private boolean checkOverdraft(double amt, String account){
        //your code here
        if (account.equals(CHECKING)) {
            return (checkBalance - amt) < OVERDRAFT;
        }
                return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}

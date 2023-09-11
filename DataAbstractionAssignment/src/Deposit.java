import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //your code here
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Construct a string representation of the deposit
        String depositInfo = "Deposit of $" + amount + " on " + dateFormat.format(date) + " to " + account + " account";

        return depositInfo;
    }
}

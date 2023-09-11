import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //your code here
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Construct a string representation of the withdrawal
        String withdrawalInfo = "Withdrawal of $" + amount + " on " + dateFormat.format(date) + " from " + account + " account";

        return withdrawalInfo;
    }
}

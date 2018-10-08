import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    //Requires: amt >= 0
    //Modifies: this
    //Effects: Builds Withdraw object with given parameters
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: Returns String with relevant info to withdrawal
    public String toString(){
        //your code here
        return "Withdrawal of: $" + amount + " Date: " + date + " from account: " + account;
    }
}

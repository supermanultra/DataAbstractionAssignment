import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    //Requires: amt >= 0
    //Modifies: this
    //Effects: Builds Deposit object with given parameters
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: Returns string with relevant info to deposit
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
    }
}

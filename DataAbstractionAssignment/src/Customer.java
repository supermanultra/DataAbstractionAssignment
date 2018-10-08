import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;

    //Getters for ArrayLists
    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //Requires: nothing
    //Modifies: this
    //Effects: Builds default Customer object
    Customer(){
        //create default constructor
        this.name = "Unknown";
        this.accountNumber = 0;
        this.checkBalance = 0;
        this.savingBalance = 0;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();

    }
    //Requires: checkDeposit >= 0, savingDeposit >= 0
    //Modifies: this
    //Effects: Builds Customer object with given parameters
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        Deposit firstCheck = new Deposit(checkDeposit, new Date(), CHECKING);
        Deposit firstSaving = new Deposit(savingDeposit, new Date(), SAVING);
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
        this.deposits.add(firstCheck);
        this.deposits.add(firstSaving);
    }

    //Requires: amt >= 0, account = Customer.CHECKING or Customer.SAVING
    //Modifies: this
    //Effects: Adds amt to balance of given account, records deposit, and returns balance
    public double deposit(double amt, Date date, String account){
        //your code here
        if (account.equals(CHECKING)) {
            Deposit d = new Deposit(amt, date, account);
            deposits.add(d);
            checkBalance += amt;
            return checkBalance;
        }
        else if (account.equals(SAVING)){
            deposits.add(new Deposit(amt,date, account));
            savingBalance += amt;
            return savingBalance;
        }
        return 0;
    }

    //Requires: amt >= 0, account = Customer.CHECKING or Customer.SAVING
    //Modifies: this
    //Effects: Decreases balance of given account by amt, records withdrawal, and returns balance
    public double withdraw(double amt, Date date, String account){
        //your code here
        if (account.equals(CHECKING) || account.equals(SAVING)){
            if (!checkOverdraft(amt, account)) {
                withdraws.add(new Withdraw(amt,date, account));
                if (account.equals(CHECKING)){
                    checkBalance -= amt;
                    return checkBalance;
                }
                else {
                    savingBalance -= amt;
                    return savingBalance;
                }
            }
        }
        return 0;
    }

    //Requires: amt >= 0, account = Customer.CHECKING or Customer.SAVING
    //Modifies: this
    //Effects: Makes sure withdrawal amt does not put given account into overdraft
    private boolean checkOverdraft(double amt, String account){
        //your code here
        if (account.equals(CHECKING)) {
            return (checkBalance - amt <= OVERDRAFT);
            }

        else if (account.equals(SAVING)){
            return (savingBalance - amt <= OVERDRAFT);
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

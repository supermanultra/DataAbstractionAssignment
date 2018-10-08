import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String args[]) {
        Customer Tom = new Customer("Tom", 1, 400, 330);
        Date currentDate = new Date();
        System.out.println(Tom.getDeposits().size());



    }
}

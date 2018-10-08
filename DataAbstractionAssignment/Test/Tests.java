import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Tests {
    Customer testCustomer;
    Deposit testCheckingDeposit;
    Withdraw testCheckingWithdraw;
    Deposit testSavingDeposit;
    Withdraw testSavingWithdraw;
    Date newDate;


    @Before
    public void setup() {
        newDate = new Date();
        testCustomer = new Customer("Thomas Jefferson", 1, 0.0, 0.0);
        testCheckingDeposit = new Deposit(100.0, newDate, Customer.CHECKING);
        testCheckingWithdraw = new Withdraw(100.0, newDate, Customer.CHECKING);
        testSavingDeposit = new Deposit(100.0,newDate, Customer.SAVING);
        testSavingWithdraw = new Withdraw(100.0, newDate, Customer.SAVING);



    }

    @Test
    public void testDepositString() {
        //Checks output of deposit into checking account
        assertEquals("Deposit of: $" + 100.0 + " Date: " + newDate + " into account: Checking", testCheckingDeposit.toString());
        //Checks output of deposit into saving account
        assertEquals("Deposit of: $" + 100.0 + " Date: " + newDate + " into account: Saving", testSavingDeposit.toString());
    }

    @Test
    public void testWithdrawString() {
        //Check output of withdraw from checking account
        assertEquals("Withdrawal of: $" + 100.0 + " Date: " + newDate + " from account: Checking", testCheckingWithdraw.toString());
        //Check output of withdraw from saving account
        assertEquals("Withdrawal of: $" + 100.0 + " Date: " + newDate + " from account: Saving", testSavingWithdraw.toString());

    }

    @Test
    public void testDeposit() {
        //Checks initial size of "deposits" ArrayList is 2
        assertEquals(2,testCustomer.getDeposits().size());
        //Checks depositing 0 into checking/saving doesn't change balance
        assertEquals(0, testCustomer.deposit(0,newDate,Customer.CHECKING), 0);
        assertEquals(0,testCustomer.deposit(0,newDate, Customer.SAVING),0);
        //Checks "deposits" ArrayList elements has increased by 2 (one for each deposit)
        assertEquals(4, testCustomer.getDeposits().size());
        //Checks depositing 100 into checking/saving increases balance by 100
        assertEquals(100, testCustomer.deposit(100.0, newDate, Customer.CHECKING), 0);
        assertEquals(100, testCustomer.deposit(100, newDate, Customer.SAVING),0);

    }

    @Test
    public void testWithdraw() {
        //Checks initial size of "withdraws" ArrayList is 0
        assertEquals(0,testCustomer.getWithdraws().size());
        //Checks withdrawing 0 from checking/saving doesn't change balance
        assertEquals(0, testCustomer.withdraw(0,newDate,Customer.CHECKING), 0);
        assertEquals(0, testCustomer.withdraw(0,newDate,Customer.SAVING), 0);
        //Checks "withdraw" ArrayList elements has increased by 2 (one for each withdraw)
        assertEquals(2,testCustomer.getWithdraws().size());
        //Checks withdrawing 50 from checking/saving decreases balance by 50
        assertEquals(-50, testCustomer.withdraw(50, newDate, Customer.CHECKING), 0);
        assertEquals(-50, testCustomer.withdraw(50, newDate, Customer.SAVING), 0);
        //Checks withdrawing 500 (would put balance past -100/overdraft) is impossible
        assertEquals(0, testCustomer.withdraw(500,newDate,Customer.CHECKING),0);
        assertEquals(0, testCustomer.withdraw(500,newDate,Customer.SAVING),0);
    }
}

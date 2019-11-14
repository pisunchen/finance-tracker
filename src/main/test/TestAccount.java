package test;

import expense.Account;
import expense.Balance;
import expense.CheckingsAccount;
import expense.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAccount {

    Account moneyAccount;
    Account noMoneyAccount;
    SavingsAccount savingsAccount;

    @BeforeEach
    public void runBefore() {
        moneyAccount = new CheckingsAccount("Sam",1200);
        noMoneyAccount = new CheckingsAccount("Ryan",0);
        savingsAccount = new SavingsAccount("Bryan",300);
    }

    @Test
    public void testPassword() {
        assertEquals(moneyAccount.accessAccount("Sam"),1200);
        assertEquals(noMoneyAccount.accessAccount("Ryan"),0);
    }

    @Test
    public void testGetID() {
        assertEquals(moneyAccount.getID(),123);
    }

    @Test
    public void testInterestRate() {
        assertEquals(savingsAccount.calculateInterestTotal(), savingsAccount.getBalance() * savingsAccount.getInterest());
    }


}

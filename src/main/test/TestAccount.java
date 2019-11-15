package test;

import expense.Account;
import expense.Balance;
import expense.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccount {

    Account moneyAccount;
    Account noMoneyAccount;
    Account moneyAccount2;
    SavingsAccount savingsAccount;

    @BeforeEach
    public void runBefore() {
        moneyAccount = new SavingsAccount("Jimmy", new Balance(1200));
        moneyAccount2 = new SavingsAccount("Jimmy", new Balance(1200));
        noMoneyAccount = new SavingsAccount("Ryan", new Balance(0));
        savingsAccount = new SavingsAccount("Bryan", new Balance(300));
    }

    @Test
    public void testInterestRate() {
        assertEquals(savingsAccount.calculateInterestTotal(), (300 * savingsAccount.getInterest()));
    }

    @Test
    public void testGetID() {
        assertEquals(moneyAccount.getID(), "Jimmy");
    }

    @Test
    public void testDuplicateAccount() {
        assertTrue(moneyAccount.equals(moneyAccount2));
        assertFalse(moneyAccount.equals(noMoneyAccount));
    }


}

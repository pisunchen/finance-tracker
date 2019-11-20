package test;

import expense.Account;
import expense.Balance;
import expense.Bank;
import expense.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccount {

    private Account moneyAccount;
    private Account noMoneyAccount;
    private Account moneyAccount2;
    private SavingsAccount savingsAccount;
    private Bank bank;
    private Bank bank2;

    @BeforeEach
    public void runBefore() {
        moneyAccount = new SavingsAccount("Jimmy", new Balance(1200));
        moneyAccount2 = new SavingsAccount("Jimmy", new Balance(1200));
        noMoneyAccount = new SavingsAccount("Ryan", new Balance(0));
        savingsAccount = new SavingsAccount("Bryan", new Balance(300));
        bank = new Bank();
        bank2 = new Bank();
    }

    @Test
    public void testInterestRate() {
        assertEquals(savingsAccount.calculateInterestTotal(), (300 * savingsAccount.getInterest()));
    }

    @Test
    public void getBalance() {
        assertEquals(moneyAccount.getBalance().getInitialBudget(),1200);
    }


    @Test
    public void testGetID() {
        assertEquals(moneyAccount.getID(), "Jimmy");
    }

    @Test
    public void testDuplicateAccount() {
        assertTrue(moneyAccount.equals(moneyAccount2));
        assertFalse(moneyAccount.equals(noMoneyAccount));
        assertFalse(moneyAccount.equals(null));
        assertTrue(moneyAccount.equals(moneyAccount));
    }

    @Test
    public void testSetBank() {
        moneyAccount.setBank(bank);
        assertEquals(moneyAccount.getBank(), bank);
        moneyAccount.setBank(bank2);
        assertEquals(moneyAccount.getBank(), bank2);
    }

    @Test
    public void testRemoveAccount() {
        moneyAccount.setBank(bank);
        assertEquals(moneyAccount.getBank(), bank);
        bank.removeAccount(moneyAccount);
    }


}

package test;

import exceptions.NoNegBalanceException;
import exceptions.SpentAlotException;
import expense.Account;
import expense.Balance;
import expense.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBalance {

    Balance noMoney;
    Balance withMoney;
    Balance lotsMoney;
    Account account;

    @BeforeEach
    public void runBefore() {
        noMoney = new Balance(0);
        withMoney = new Balance(2000);
        lotsMoney = new Balance(30000);
        account = new SavingsAccount("Jimmy", noMoney);
    }

    @Test
    public void testSetInitialBudget() {
        assertEquals(noMoney.setInitialBudget(2000),2000);
    }

    @Test
    public void testGetBalance() {
        assertEquals(withMoney.getInitialBudget(),2000);
    }

    @Test
    public void testAddBalance() throws NoNegBalanceException {
        assertEquals(noMoney.addBalance(2000),2000);
        assertEquals(withMoney.addBalance(2000),4000);
    }

    @Test
    public void testAddNegativeBalance() {
        try {
            assertEquals(lotsMoney.addBalance(-200),30000);
        } catch (NoNegBalanceException e) {
            System.out.println("test passed");
        }
    }

    @Test
    public void testSubtractNegativeBalance() {
        try {
            assertEquals(lotsMoney.subBalance(15000),45000);
        } catch (SpentAlotException e) {
            System.out.println("success");
        }
    }

    @Test
    public void testSaveLoad() throws IOException {
        noMoney.save(5000);
        assertEquals(5000, noMoney.load());
    }

    @Test
    public void testSubBalance() throws SpentAlotException {
        assertEquals(withMoney.subBalance(1000), 1000);
        assertEquals(noMoney.subBalance(385),-385);
    }
}

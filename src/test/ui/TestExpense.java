package ui;

import exceptions.NoNegBalanceException;
import exceptions.SpentAlotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import expense.ExpenseTracker;
import expense.Expense;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestExpense {
    private ExpenseTracker noCash;
    private ExpenseTracker withCash;
    private ExpenseTracker lotsCash;

    @BeforeEach
    void runBefore() {
        noCash = new Expense(0);
        withCash = new Expense(2000);
        lotsCash = new Expense(30000);
    }

    @Test
    void testSaveBudget() throws IOException {
        noCash.save(100);
        assertEquals(100, noCash.load());
    }

    @Test
    void testSaveAnotherBudget() throws IOException {
        noCash.save(1000);
        assertEquals(1000, noCash.load());
    }

    @Test
    void budgetIncrease() {
        withCash.setSelection(300);
        assertEquals(withCash.updatePosBalance(), 2300);
    }

    @Test
    void withBudgetDecrease() {
        withCash.setSelection(500);
        assertEquals(withCash.updateNegBalance(), 1500);
    }

    @Test
    void lotsBudgetDecrease() {
        lotsCash.setSelection(800);
        assertEquals(lotsCash.updateNegBalance(), 29200);
    }

    @Test
    void testNegativeNumCatch() {
        withCash.setKey("-300");
        withCash.negativeException();
        assertEquals(withCash.getBalance(),2000);
    }

    @Test
    void testUpdateBalanceNoCatch() {
        withCash.setKey("500");
        withCash.negativeException();
        assertEquals(withCash.getBalance(), 2500);
    }

    @Test
    void testSpentLotsCatch() {
        lotsCash.setKey("15000");
        lotsCash.spentAlotException();
        assertEquals(lotsCash.getBalance(), 15000);
    }

    @Test
    void testSpentLotsNoCatch() {
        lotsCash.setKey("200");
        try {
            lotsCash.subBalance();
        } catch (SpentAlotException e) {
            fail("Not meant to be caught");
        }
        assertEquals(lotsCash.getBalance(), 29800);
    }

//    @Test
//    void testSelect() throws IOException {
//        noCash.setKey("2");
//        noCash.selectionFunction();
//    }


}
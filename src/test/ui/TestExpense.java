package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import expense.ExpenseTracker;
import expense.Expense;


import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TestExpense {
    public ExpenseTracker noCash;
    public ExpenseTracker withCash;
    public ExpenseTracker lotsCash;

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
    void withBudgetDecrese() {
        withCash.setSelection(500);
        assertEquals(withCash.updateNegBalance(), 1500);
    }

    @Test
    void lotsBudgetDecrease() {
        lotsCash.setSelection(800);
        assertEquals(lotsCash.updateNegBalance(), 29200);
    }
}
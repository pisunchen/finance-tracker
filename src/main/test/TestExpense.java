//package test;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import expense.ExpenseTracker;
//
//import java.io.IOException;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//public class TestExpense {
//
//    ExpenseTracker noCash;
//    ExpenseTracker withCash;
//    ExpenseTracker lostCash;
//
//    @BeforeEach
//    void runBefore() {
//        noCash = new ExpenseTracker(0);
//        withCash = new ExpenseTracker(2000);
//        lostCash = new ExpenseTracker(30000);
//    }
//
//    @Test
//    void testSaveBudget() throws IOException {
//        noCash.save(100);
//        assertEquals(100, noCash.load());
//    }
//
//    @Test
//    void testSaveAnotherBudget() throws IOException {
//        noCash.save(1000);
//        assertEquals(1000, noCash.load());
//    }
//
//    @Test
//    void budgetIncrease() {
//        withCash.setSelection(300);
//        assertEquals(withCash.updatePosBalance(), 2300);
//    }
//
////    @Test
////    void noNegativeAddition() {
////        withCash.setSelection(-500);
////        assertFalse(withCash.updatePosBalance());
////    }
//
//    @Test
//    void budgetDecrease() {
//        withCash.setSelection(500);
//        assertEquals(withCash.updateNegBalance(), 1500);
//    }
//}
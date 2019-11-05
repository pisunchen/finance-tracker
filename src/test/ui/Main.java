package ui;

import exceptions.NoNegBalanceException;
import expense.Expense;
import expense.ExpenseFunctions;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, NoNegBalanceException {
        System.out.println("Welcome to the expense tracker, what is your current budget? ");
        Scanner user = new Scanner(System.in);
        int reader = Integer.parseInt(user.nextLine());
        ExpenseFunctions e = new Expense(reader);
        e.beginExpenseTracker();
    }

}

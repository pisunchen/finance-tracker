package expense;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker implements ExpenseFunctions, IntroScreen {
    int initialBudget;
    int selection;
    int select;
    Scanner user;

    public ExpenseTracker(int e) {
        initialBudget = e;
    }

    public void scannerSetup() {
        user = new Scanner(System.in);
    }

    public void userFeedback() {
        selection = Integer.parseInt(user.nextLine());
    }

    @Override
    public void prompt() {
        System.out.println("Press [1] to add an expense, [2] to add money to budget, [3] to quit, [9] original budget");
    }

    @Override
    public void addExpense() {
        System.out.println("How much money have you spent today?");
    }

    @Override
    public void addBudget() {
        System.out.println("How much money do you want to add to your budget?");
    }

    @Override
    public void transaction() {
        System.out.println("Your current balance: " + initialBudget);
    }

    @Override
    public void noNegativeMoney() {
        System.out.println("Cannot add negative money!");
    }

    @Override
    public void noNegativeExpense() {
        System.out.println("Cannot have a negative expense!");
    }

    @Override
    public void endProgram() {
        System.out.println("Thank you for using our services, goodbye!");
    }

    @Override
    public void beginExpenseTracker() throws IOException {
        save(initialBudget);
        scannerSetup();
        while (true) {
            prompt();
            userFeedback();
            if (selection == 1) {
                subBalance();
            } else if (selection == 2) {
                plusBalance();
            } else if (selection == 3) {
                endProgram();
                break;
            } else if (selection == 9) {
                lastBudget();
            }
        }
    }

    public void lastBudget() throws IOException {
        System.out.println("Your previous budget " + load());
    }

    public void subBalance() {
        addExpense();
        selection = Integer.parseInt(user.nextLine());
        if (selection < 0) {
            noNegativeExpense();
        } else updateNegBalance();
        transaction();
    }

    public void setSelection(int select) {
        selection = select;
    }

    public int getSelection() {
        return selection;
    }

    public void plusBalance() {
        addBudget();
        userFeedback();
        if (selection < 0) {
            noNegativeMoney();
        } else updatePosBalance();
        transaction();
    }

    public int updateNegBalance() {
        return initialBudget = initialBudget - selection;
    }

    public int updatePosBalance() {
        return initialBudget = initialBudget + selection;
    }


    @Override
    public void save(int initialBudget) throws IOException {
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        writer.println(initialBudget);
        writer.close();
    }

    @Override
    public int load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        String s = lines.get(0);
        return Integer.parseInt(s);
    }


}

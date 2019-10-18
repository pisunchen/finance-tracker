package expense;

import exceptions.NoNegBalanceException;
import exceptions.SpentAlotException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public abstract class ExpenseTracker implements ExpenseFunctions, IntroScreen {

    private int initialBudget;
    private int selection;
    private Scanner user;

    ExpenseTracker(int e) {
        initialBudget = e;
    }

    protected void scannerSetup() {
        user = new Scanner(System.in);
    }

    protected void userFeedback() {
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

    private void lastBudget() throws IOException {
        System.out.println("Your previous budget " + load());
    }

    private void subBalance() {
        addExpense();
        selection = Integer.parseInt(user.nextLine());
        if (selection < 0) {
            noNegativeExpense();
        } else if (selection > 1000) {
            try {
                throw new SpentAlotException();
            } catch (SpentAlotException e) {
                System.out.println("You spent a lot! Watchout next time!");
                updateNegBalance();
                transaction();
            }
        } else {
            updateNegBalance();
            transaction();
        }
    }

    public void setSelection(int select) {
        selection = select;
    }

    public int getSelection() {
        return selection;
    }

    private void plusBalance() {
        addBudget();
        userFeedback();
        if (selection < 0) {
            try {
                throw new NoNegBalanceException();
            } catch (NoNegBalanceException noNegativeBalance) {
                noNegativeMoney();
            } finally {
                System.out.println("Only positive numbers are allowed for adding to your budget");
            }
        } else {
            updatePosBalance();
            transaction();
        }
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

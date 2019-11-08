package expense;

import exceptions.NoNegBalanceException;
import exceptions.SpentAlotException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public abstract class ExpenseTracker implements ExpenseFunctions, IntroScreen {

    private int initialBudget;
    private int selection;
    private Scanner user;
    public String key = "";


    ExpenseTracker(int e) {  //CONSTRUCTOR
        initialBudget = e;
    }

    public void scannerSetup() {
        user = new Scanner(System.in);
    }

    public void userFeedback(String input) {
        if (input.equals("")) {
            setSelection(Integer.parseInt(user.nextLine()));
        } else {
            setSelection(Integer.parseInt(input));
        }
    }

    public void setKey(String value) {
        key = value;

    }

    @Override
    public void msgHowMuchSpent() {
        System.out.println("How much money have you spent today?");
    }

    @Override
    public void beginExpenseTracker() throws IOException {
        save(initialBudget);
        scannerSetup();
        selectionFunction();
    }

    @Override
    public void msgAddBudget() {
        System.out.println("How much money do you want to add to your budget?");
    }


    @Override
    public void msgTransaction() {
        System.out.println("Your current balance: " + initialBudget);
    }

//    Map<String,Integer> expenseMap = new HashMap<>();

    public void selectionFunction() {
        while (true) {
            System.out.println("Select [1] to add an expense");
            System.out.println("       [2] to add money to your budget");
            System.out.println("       [3] to quit the program");
            System.out.println("       [8] to see the previous amount you added to your balance");
            System.out.println("       [9] to see the previous transaction done");
            userFeedback(key);
            if (selection == 1) {
                spentAlotException();
            } else if (selection == 2) {
                negativeException();
            } else if (selection == 3) {
                System.out.println("Thank you for using our services, goodbye!");
                break;
//            } else if (selection == 9) {
//                System.out.println(expenseMap.get("expenses"));
//            } else if (selection == 8) {
//                System.out.println(expenseMap.get("moneyAdded"));
            }
        }
    }

    public void negativeException() {
        try {
            plusBalance();
        } catch (NoNegBalanceException e) {
            System.out.println("No negative input for balance!");
        } finally {
            System.out.println("Transaction recorded");
        }
    }

    public void spentAlotException() {
        try {
            subBalance();
        } catch (SpentAlotException e) {
            System.out.println("You spent a lot! Be considerate next time!");
            updateNegBalance();
            msgTransaction();
        } finally {
            System.out.println("Transaction recorded");
        }
    }

    public int getBalance() {
        return initialBudget;
    }

    public void subBalance() throws SpentAlotException {
        msgHowMuchSpent();
        userFeedback(key);
//        expenseMap.put("expenses",selection);
        if (selection < 0) {
            System.out.println("Cannot have a negative expense!");
        } else if (selection > 10000) {
            throw new SpentAlotException();
        } else {
            updateNegBalance();
            msgTransaction();
        }
    }

    public void setSelection(int select) {
        selection = select;
    }

    public void plusBalance() throws NoNegBalanceException {
        msgAddBudget();
        userFeedback(key);
//        expenseMap.put("moneyAdded",selection);
        if (selection < 0) {
            throw new NoNegBalanceException();
        } else {
            updatePosBalance();
            msgTransaction();
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

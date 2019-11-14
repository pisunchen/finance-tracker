package ui;

import exceptions.NoNegBalanceException;
import exceptions.SpentAlotException;
import expense.Account;
import expense.Balance;

import java.util.Scanner;

public class Main {
    private static Balance balance;
    private static Scanner user;
    private static Account myAccount;

    public static void main(String[] args) {
        init();
        processProgram();
    }

    public static void init() {
        myAccount = new Account(382, 1200, "bulldog2");
    }

    public static void processProgram() {
        user = new Scanner(System.in);

        System.out.println("Welcome to the expense tracker, what is your initial budget?");
        balance = new Balance(Integer.parseInt(user.nextLine()));

        while (true) {
            initialScreen();
            int selection = Integer.parseInt(user.nextLine());
            if (selection == 1) {
                addExpense();
            }
            if (selection == 2) {
                addMoney();
            }
            if (selection == 3) {
                break;
            }
            if (selection == 9) {
                checkAccount();
            }
        }
    }

    public static void initialScreen() {
        System.out.println("Select [1] to add an expense");
        System.out.println("       [2] to add money to your budget");
        System.out.println("       [3] to quit the program");
//        System.out.println("       [8] to see the previous amount you added to your balance");
        System.out.println("       [9] to see current funds in a saved account");
    }

    public static void checkAccount() {
        System.out.println("Please enter your ID and password");
        String selection = user.nextLine();
        System.out.println(myAccount.accessAccount(selection));
    }

    public static void addExpense() {
        System.out.println("How much money have you spent today? ");
        int selection = Integer.parseInt(user.nextLine());
        try {
            balance.subBalance(selection);
            msgCurrentStatus();
        } catch (SpentAlotException e) {
            System.out.println("You spent a lot! Be considerate next time!");
            balance.updateNegBalance();
            msgCurrentStatus();
        }
    }

    public static void addMoney() {
        System.out.println("How much money would you like to add? ");
        int selection = Integer.parseInt(user.nextLine());
        try {
            balance.addBalance(selection);
            msgCurrentStatus();
        } catch (NoNegBalanceException e) {
            System.out.println("Cannot add negative money!");
            msgCurrentStatus();
        }
    }

    private static void msgCurrentStatus() {
        System.out.println("Your current balance: " + balance.getInitialBudget());
    }


}

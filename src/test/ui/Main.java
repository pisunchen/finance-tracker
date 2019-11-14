package ui;

import exceptions.NoNegBalanceException;
import exceptions.SpentAlotException;
import expense.Account;
import expense.Balance;
import expense.SavingsAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Balance balance;
    private static Scanner user;
    private static SavingsAccount account;
    private HashMap<Integer, Integer> accountMap = new HashMap<>();

    public static void main(String[] args) {
        processProgram();
    }


    public static void processProgram() {
        user = new Scanner(System.in);

        System.out.println("Welcome to the expense tracker, what is your initial budget?");
        balance = new Balance(Integer.parseInt(user.nextLine()));
        account = new SavingsAccount("test", balance.getInitialBudget());

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
//            if (selection == 4) {
//                checkAccount();
//            }
            if (selection == 5) {
                System.out.println(account.calculateInterestTotal());
            }
//            if (selection == 9) {
//                checkDuplicate();
            }
        }


    public static void initialScreen() {
        System.out.println("Select [1] to add an expense");
        System.out.println("       [2] to add money to your budget");
        System.out.println("       [3] to quit the program");
//        System.out.println("       [4] to see balances by inputting id ");
        System.out.println("       [5] to see the total value after one year (with interest)");
//        System.out.println("       [9] to see if you have another parallel account");
    }

//    public static void checkAccount() {
//        System.out.println("Please enter id");
//        int selection = Integer.parseInt(user.nextLine());
//        System.out.println(account.retrieveAccount(selection));
//    }

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

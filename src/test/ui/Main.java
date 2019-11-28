package ui;

import exceptions.NoNegBalanceException;
import exceptions.SpentAlotException;
import expense.Account;
import expense.Balance;
import expense.Bank;
import expense.SavingsAccount;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    private static Balance balance;
    private static Scanner user;
    private static AccountGUI das;
    private static Bank bank;


    public static void main(String[] args) {
//        ui = new BalanceGUI();
        das = new AccountGUI();
        SwingUtilities.invokeLater(das);
        processProgram();
    }


    public static void processProgram() {
        user = new Scanner(System.in);
        bank = new Bank();

        System.out.println("Welcome to the expense tracker");
        balance = new Balance(0);
        SavingsAccount account = new SavingsAccount("Pisun", balance);
        Account account2 = new SavingsAccount("Patrick", new Balance(2300));
        bank.addAccount(account);
        bank.addAccount(account2);

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
            if (selection == 4) {
                System.out.println(account.calculateInterestTotal());
            }
            if (selection == 9) {
                bank.printAccounts(bank.getAccounts());
            }
        }
    }


    private static void initialScreen() {
        System.out.println("Select [1] to add an expense");
        System.out.println("       [2] to add money to your budget");
        System.out.println("       [3] to quit the program");
        System.out.println("       [4] to see the total value after one year (with interest)");
        System.out.println("       [9] to see all accounts present within the system");
    }


    private static void addExpense() {
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

    private static void addMoney() {
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

package ui;

import expense.Account;
import expense.Balance;
import expense.Bank;
import expense.SavingsAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccountAction implements ActionListener {

    private JTextField name;
    private JTextField balance;
    private Bank bank;
    private JTextArea textAccount;

    AccountAction(JTextField name, JTextField balance, JTextArea textAccount) {
        bank = new Bank();
        this.name = name;
        this.balance = balance;
        this.textAccount = textAccount;
    }

    private void revertBack() {
        this.name.setText("");
        this.balance.setText("0");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (name.getText().equals("") && Double.parseDouble(balance.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "ERROR: Please enter all fields to continue");
            revertBack();
        } else {
            Account user = new SavingsAccount(name.getText(), new Balance(Double.parseDouble(balance.getText())));
            bank.addAccount(user);
            int g = bank.getAccounts().size();
            ArrayList<Account> accounts = bank.getAccounts();
            textAccount.setText(textAccount.getText() + bank.printAccount(accounts.get(g - 1)));
        }
    }
}


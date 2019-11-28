package ui;

import expense.Account;
import expense.Balance;
import expense.Bank;
import expense.SavingsAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountAction implements ActionListener {

    private JTextField name;
    private JTextField balance;
    private Bank bank = new Bank();

    public AccountAction(JTextField name, JTextField balance) {
        this.name = name;
        this.balance = balance;
    }

    public void revertBack() {
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
            bank.printAccounts(bank.getAccounts());
        }
    }
}

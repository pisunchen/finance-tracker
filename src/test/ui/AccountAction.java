package ui;

import expense.Account;
import expense.Balance;
import expense.SavingsAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AccountAction implements ActionListener {

    private JTextField name;
    private JTextField balance;
    private List<Account> accountList;
    private Account account;

    public AccountAction(JTextField name, JTextField balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}

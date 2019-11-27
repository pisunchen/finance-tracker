package gui;

import expense.Account;
import expense.Balance;
import org.junit.jupiter.engine.JupiterTestEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceAction implements ActionListener {

    private JTextField input1;
    private JTextField input2;
    public int bal;

    protected BalanceAction(JTextField input1, JTextField input2) {
        this.input1 = input1;
        this.input2 = input2;
        Balance balance = new Balance(0);
        bal = balance.getInitialBudget();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bal = bal - Integer.parseInt(input1.getText());
        bal = bal + Integer.parseInt(input2.getText());

        this.input1.setText("0");
        this.input2.setText("0");

        System.out.println("$" + bal);
        sendBal(bal);

    }

    int sendBal(int bal) {
        return bal;
    }


}

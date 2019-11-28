package ui;

import exceptions.NoNegBalanceException;
import expense.Balance;

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
        if (Integer.parseInt(input1.getText()) < 0 || Integer.parseInt(input2.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "ERROR: Cannot input a negative amount!");
        } else {
            bal = bal - Integer.parseInt(input1.getText());
            bal = bal + Integer.parseInt(input2.getText());
        }

        this.input1.setText("0");
        this.input2.setText("0");

        System.out.println("$" + bal);
    }
}

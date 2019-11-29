package ui;

import expense.Balance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceAction implements ActionListener {

    private JTextField input1;
    private JTextField input2;
    private JTextField input3;
    public double bal;

    BalanceAction(JTextField input1, JTextField input2, JTextField input3) {
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
    }

    private void revertBack() {
        this.input1.setText("0");
        this.input2.setText("0");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (Double.parseDouble(input1.getText()) == 0 && Double.parseDouble(input2.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "ERROR: Enter a valid value to continue");
        }
        if (Double.parseDouble(input1.getText()) < 0 || Double.parseDouble(input2.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "ERROR: Cannot input a negative amount!");
        }
        if (Double.parseDouble(input1.getText()) > 0) {
            double in = Double.parseDouble(input1.getText());
            bal = bal - in;
            JOptionPane.showMessageDialog(null, "Expense of: " + in + " recorded");
            revertBack();
        }
        else if (Double.parseDouble(input2.getText()) > 0) {
            double in = Double.parseDouble(input2.getText());
            bal = bal + in;
            JOptionPane.showMessageDialog(null, "Balance addition of : " + in + " recorded");
            revertBack();
        }
        revertBack();
        System.out.println("Your current balance: $" + Math.round(bal * 100.0) / 100.0);
        input3.setText("$" + Math.round(bal * 100.0) / 100.0);
    }
}

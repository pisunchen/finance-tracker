package ui;

import expense.Balance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetBalanceAction implements ActionListener{

    private JTextField input1;
    private JTextField input2;
    private JTextField input3;

    public ResetBalanceAction(JTextField input1, JTextField input2, JTextField input3) {
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.input1.setText("0");
        this.input2.setText("0");
        this.input3.setText("0");
    }
}

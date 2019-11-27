package gui;

import expense.Balance;

import javax.swing.*;
import java.awt.*;

public class BalanceGUI implements Runnable {

    private JFrame frame;
    private Balance balance;

    @Override
    public void run() {
        frame = new JFrame("Balance Tracker!");
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,3);
        container.setLayout(layout);

        JLabel label1 = new JLabel("Add Expense");
        JLabel label2 = new JLabel("Add Balance");
        JLabel label3 = new JLabel("Current Balance");
        JTextField text1 = new JTextField("0");
        JTextField text2 = new JTextField("0");
        JLabel text3 = new JLabel("0");
        JLabel text4 = new JLabel("INSTRUCTIONS: Enter values into cells");

        JButton button = new JButton("Calculate");

        BalanceAction calculate = new BalanceAction(text1,text2);

        text3.setText(Integer.toString(calculate.sendBal()));

        button.addActionListener(calculate);
        container.add(label1);
        container.add(label2);
        container.add(label3);
        container.add(text1);
        container.add(text2);
        container.add(text3);
        container.add(button);
        container.add(text4);
    }
}

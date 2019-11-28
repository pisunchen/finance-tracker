package ui;

import javax.swing.*;
import java.awt.*;

public class AccountGUI implements Runnable {

    private JFrame frame;
    final  int extraWindowWidth = 100;
    JTextField text1;
    JTextField text2;
    JButton button1;


    @Override
    public void run() {
        frame = new JFrame("Balance Tracker");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }


    public void createComponents(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel card1 = new JPanel();
        JPanel bottom = new JPanel(new GridLayout());

        card1.add(new JLabel("Add values into corresponding cells"));
        card1.add(new JLabel("Add Expense"));
        card1.add(text1 = new JTextField("0",12));
        text1.setPreferredSize(new Dimension(50,50));
        card1.add(new JLabel("Add Balance"));
        card1.add(text2 = new JTextField("0",12));
        text2.setPreferredSize(new Dimension(50,50));

        card1.add(new JLabel("Current Balance"));
        card1.add(new JTextField("0",12));
        card1.add(button1 = new JButton("Calculate"));

        JPanel card2 = new JPanel();
        card2.add(new JLabel("Insert information to add Account"));

        BalanceAction calculate = new BalanceAction(text1, text2);
        button1.addActionListener(calculate);

        tabbedPane.addTab("Balance Tracker", card1);
        tabbedPane.addTab("Add Account", card2);

        JPanel card3 = new JPanel();
        tabbedPane.addTab("Account List", card3);

        card2.add(new JLabel("ID (Name): "));
        card2.add(new JTextField("",12));
        card2.add(new JLabel("Balance: "));
        card2.add(new JTextField("",12));
        card2.add(new JButton("Add"));

        pane.add(tabbedPane, BorderLayout.CENTER);
        frame.setResizable(true);
    }

}


package ui;

import com.sun.tools.javac.comp.Flow;
import expense.Account;

import javax.swing.*;
import java.awt.*;

public class AccountGUI implements Runnable {

    private JFrame frame;
    private JTextField text1;
    private JTextField text2;
    private JButton button1;
    private final int ColumnCons = 12;
    private final String font = "Trebuchet MS";
    private final int charSize = 14;
    private JButton button2;
    private JTextField text3;
    private JTextField text4;
    private JTable table;


    @Override
    public void run() {
        frame = new JFrame("Balance Tracker");
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();

        frame.setVisible(true);
    }

    private void createComponents(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel card1 = new JPanel();

        card1.add(new JLabel("Add values into corresponding cells")).setFont(new Font("Helvetica", Font.BOLD,15));
        card1.add(new JLabel("Add Expense")).setFont(new Font(font, Font.PLAIN,charSize));
        card1.add(text1 = new JTextField("0",ColumnCons));
        text1.setPreferredSize(new Dimension(50,50));
        card1.add(new JLabel("Add Balance")).setFont(new Font(font, Font.PLAIN,charSize));

        card1.add(text2 = new JTextField("0",ColumnCons));
        text2.setPreferredSize(new Dimension(50,50));

        card1.add(new JLabel("Current Balance"));
        card1.add(new JTextField("0" ,ColumnCons));

        card1.add(button1 = new JButton("Calculate"));

        BalanceAction calculate = new BalanceAction(text1, text2);
        button1.addActionListener(calculate);

        JPanel card2 = new JPanel();
        card2.add(new JLabel("Insert information to add Account")).setFont(new Font("Helvetica", Font.BOLD,15));

        card2.add(new JLabel("ID (Name): ")).setFont(new Font(font, Font.PLAIN,charSize));
        card2.add(text1 = new JTextField("",ColumnCons));
        card2.add(new JLabel("Balance: ")).setFont(new Font(font, Font.PLAIN,charSize));
        card2.add(text2 = new JTextField("0",ColumnCons));
        card2.add(button2 = new JButton("Add")).setFont(new Font(font, Font.PLAIN,charSize));

        AccountAction acc = new AccountAction(text1,text2);
        button2.addActionListener(acc);

        tabbedPane.addTab("Balance Tracker", card1);
        tabbedPane.addTab("Add Account", card2);

        JPanel card3 = new JPanel();
        tabbedPane.addTab("Account List", card3);

        pane.add(tabbedPane, BorderLayout.CENTER);
        frame.setResizable(false);
    }

}


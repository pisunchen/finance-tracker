package ui;

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
    private JTextField sum;
    private JLabel addition;

    @Override
    public void run() {
        frame = new JFrame("Balance Tracker");
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setPreferredSize(new Dimension(275, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setResizable(true);
        frame.setBounds(new Rectangle(275, 400));

        frame.setVisible(true);
    }

    private Font regularFontSetUp() {
        return new Font(font, Font.PLAIN, charSize);
    }

    private Font titleFontSetUp() {
        return new Font("Helvetica", Font.BOLD, 15);
    }

    private Dimension setSizeBox() {
        return new Dimension(50, 50);
    }


    private void createComponents(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        // TODO:
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Add values into corresponding cells")).setFont(titleFontSetUp());
        card1.add(new JLabel("Add Expense")).setFont(regularFontSetUp());
        card1.add(text1 = new JTextField("0",ColumnCons)).setPreferredSize(setSizeBox());
        card1.add(new JLabel("Add Balance")).setFont(regularFontSetUp());

        card1.add(text2 = new JTextField("0",ColumnCons)).setPreferredSize(setSizeBox());
        card1.add(new JLabel("Current Balance"));
        card1.add(sum = new JTextField("0",8)).setPreferredSize(setSizeBox());
        sum.setEditable(false);

        card1.add(button1 = new JButton("Calculate"));
        card1.add(button2 = new JButton("Reset Balance"));

        BalanceAction calculate = new BalanceAction(text1, text2, sum);
        button1.addActionListener(calculate);

        ResetBalanceAction reset = new ResetBalanceAction(text1, text2, sum);
        button2.addActionListener(reset);


        //TODO:
        JPanel card2 = new JPanel();
        card2.add(new JLabel("Insert information to add Account")).setFont(titleFontSetUp());

        card2.add(new JLabel("ID (Name): ")).setFont(regularFontSetUp());
        card2.add(text1 = new JTextField("",ColumnCons));
        card2.add(new JLabel("Balance: ")).setFont(regularFontSetUp());
        card2.add(text2 = new JTextField("0",ColumnCons));
        card2.add(button2 = new JButton("Add")).setFont(regularFontSetUp());

        AccountAction acc = new AccountAction(text1,text2, addition);
        button2.addActionListener(acc);

        tabbedPane.addTab("Balance Tracker", card1);
        tabbedPane.addTab("Add Account", card2);

        // TODO
        JPanel card3 = new JPanel();
        tabbedPane.addTab("Account List", card3);

        JTextArea accountArea = new JTextArea(15,20);
        card3.add(accountArea,BorderLayout.CENTER);

        pane.add(tabbedPane, BorderLayout.CENTER);
        frame.setResizable(false);

    }

}


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
    private JButton button3;
    private JTextField sum;
    private JTextArea textAccount;

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
        return new Dimension(30, 30);
    }

    private void createComponents(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        // FIRST PANEL CONFIGURATIONS
        JPanel page1 = new JPanel();
        page1.add(new JLabel("Add values into corresponding cells")).setFont(titleFontSetUp());
        page1.add(new JLabel("Add Expense")).setFont(regularFontSetUp());
        page1.add(text1 = new JTextField("0",ColumnCons)).setPreferredSize(setSizeBox());
        page1.add(new JLabel("Add Balance")).setFont(regularFontSetUp());

        page1.add(text2 = new JTextField("0",ColumnCons)).setPreferredSize(setSizeBox());
        page1.add(new JLabel("Current Balance"));
        page1.add(sum = new JTextField("0",8)).setPreferredSize(setSizeBox());
        sum.setEditable(false);

        page1.add(button1 = new JButton("Calculate"));
        page1.add(button2 = new JButton("Reset Numbers"));

        BalanceAction calculate = new BalanceAction(text1, text2, sum);
        button1.addActionListener(calculate);

        ResetNumberAction reset = new ResetNumberAction(text1, text2, sum);
        button2.addActionListener(reset);

        // SECOND PANEL CONFIGURATIONS
        JPanel page2 = new JPanel();
        page2.add(new JLabel("Insert information to add Account")).setFont(titleFontSetUp());

        page2.add(new JLabel("ID (Name): ")).setFont(regularFontSetUp());
        page2.add(text1 = new JTextField("",ColumnCons));
        page2.add(new JLabel("Balance: ")).setFont(regularFontSetUp());
        page2.add(text2 = new JTextField("0",ColumnCons));
        page2.add(button3 = new JButton("Add")).setFont(regularFontSetUp());
        page2.add(textAccount = new JTextArea());
        textAccount.setLineWrap(true);
        textAccount.setPreferredSize(new Dimension(245,250));
        textAccount.setEditable(false);

        AccountAction acc = new AccountAction(text1,text2, textAccount);
        button3.addActionListener(acc);

        tabbedPane.addTab("Balance Tracker", page1);
        tabbedPane.addTab("Add Account", page2);

        pane.add(tabbedPane, BorderLayout.CENTER);
        frame.setResizable(false);

    }

}


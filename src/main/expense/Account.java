package expense;

public class Account {

    int accountID;
    int balance;
    String password;

    // CONSTRUCTS ACCOUNT WITH ID, BALANCE, AND A PASSWORD
    public Account(int accountID, int balance, String password) {
        this.accountID = accountID;
        this.password = password;
        this.balance = balance;
    }

    public void accessAccount(String password) {
    }
}

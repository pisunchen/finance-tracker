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

    public int accessAccount(String password) {
        if (password.equals(this.password)) {
            return this.balance;
        } else {
            System.out.println("Incorrect password, try again");
        }
        return 0;
    }

}

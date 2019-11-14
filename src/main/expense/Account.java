package expense;

import java.util.HashMap;
import java.util.Objects;

public abstract class Account {

    private String id;
    private int balance;
    private Balance bal;
    private HashMap<Integer, Integer> accountMap = new HashMap<>();

    // CONSTRUCTS ACCOUNT WITH ID, BALANCE, AND A PASSWORD
    public Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int setAccountBalance(int balance) {
        return this.balance = bal.getInitialBudget();
    }

    public int accessAccount(String id) {
        if (this.id.equals(id)) {
            return balance;
        } else {
            System.out.println("Incorrect id, try again");
        }
        return 0;
    }

    public int getBalance() {
        return balance;
    }


//    public void addAccount(int id, int balance) {
//        accountMap.put(id,balance);
//    }

    public String getID() {
        return this.id;
    }

    public int retrieveAccount(int id) {
        return accountMap.get(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

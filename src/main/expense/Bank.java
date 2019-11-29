package expense;

import observer.AccountObserver;
import observer.Subject;

import java.util.ArrayList;

public class Bank implements AccountObserver {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }


    // MODIFIES: accounts
    // EFFECTS: adds an account into the list of accounts
    public void addAccount(Account account) {
        if (!(accounts.contains(account))) {
            accounts.add(account);
            account.setBank(this);
        }
    }

    @Override
    public void update(AccountObserver accountObserver) {
        System.out.println("An account has been added");
    }


    // MODIFIES: accounts
    // EFFECTS: removes an account from the list of Accounts if its contained inside
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    // EFFECTS: prints all of the a accounts present
    public void printAccounts(ArrayList<Account> accounts) {
        for (Account a : accounts) {
            System.out.println(a.getID() + " has a balance of $" + a.getBalance().getInitialBudget());
        }
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

}

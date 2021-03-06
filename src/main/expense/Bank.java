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
    // EFFECTS: Whenever the observation occurs, it gives a message of an update
    public void update(AccountObserver accountObserver) {
        System.out.println("An account has been added");
    }


    // MODIFIES: this
    // EFFECTS: removes an account from the list of Accounts if its contained inside
    public void removeAccount(Account account) {
        accounts.remove(account);
    }


    // EFFECTS: prints all of the accounts present
    public void printAccounts(ArrayList<Account> accounts) {
        for (Account a : accounts) {
            System.out.println("Name: " + a.getID() + " ~  Balance: $" + a.getBalance().getInitialBudget());
        }
    }

    // EFFECTS: prints the information for an individual account
    public String printAccount(Account acc) {
        return "ID: " + acc.getID() + " ~ Balance: $" + acc.getBalance().getInitialBudget() + "\n";
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

}

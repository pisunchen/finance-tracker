package expense;

import observer.AccountObserver;
import observer.Subject;

import java.util.ArrayList;

public class Bank implements AccountObserver {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

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

    public void removeAccount(Account account) {
        if (accounts.contains(account)) {
            accounts.remove(account);
        }
    }

    public void printAccounts(ArrayList<Account> accounts) {
        for (Account a : accounts) {
            System.out.println(a.getID()  + " has an account with a balance of " + a.getBalance().getInitialBudget());
        }
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

}

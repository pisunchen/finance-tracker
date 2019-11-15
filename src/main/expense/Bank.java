package expense;

import java.util.ArrayList;

public class Bank {

    ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        if (!(accounts.contains(account))) {
            accounts.add(account);
            account.setBank(this);
        }
    }

    public void removeAccount(Account account) {
        if (accounts.contains(account)) {
            accounts.remove(account);
        }
    }
}

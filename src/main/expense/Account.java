package expense;

import observer.Subject;

import java.util.Objects;

public abstract class Account extends Subject {

    private String id;
    private Balance balance;
    private Bank bank;

    public Account(String id, Balance balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setBank(Bank bank) {
        addObserver(bank);
        if (this.bank == null) {
            this.bank = bank;
        }
        if (!(this.bank.equals(bank))) {
            this.bank.removeAccount(this);
            this.bank = bank;
            bank.addAccount(this);
        }
        notifyObserver(bank);
    }

    public Balance getBalance() {
        return balance;
    }

    public String getID() {
        return this.id;
    }

    public Bank getBank() {
        return bank;
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
        return id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

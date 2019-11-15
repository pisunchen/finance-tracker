package expense;

import java.util.Objects;

public abstract class Account {

    private String id;
    private Balance balance;
    private Bank bank;

    public Account(String id, Balance balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setBank(Bank bank) {
        if (this.bank == null) {
            this.bank = bank;
        }
        if (!(this.bank.equals(bank))) {
            this.bank.removeAccount(this);
            this.bank = bank;
            bank.addAccount(this);
        }
    }

    public Balance getBalance() {
        return balance;
    }

    public String getID() {
        return this.id;
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

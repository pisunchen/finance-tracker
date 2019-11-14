package expense;

public class SavingsAccount extends Account {

    public double interest = 1.15;

    public SavingsAccount(String id, int balance) {
        super(id, balance);
    }

    public double calculateInterestTotal() {
        return getBalance() * getInterest();
    }

    public double getInterest() {
        return this.interest;
    }

}

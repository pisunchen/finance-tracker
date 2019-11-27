package expense;

public class SavingsAccount extends Account {

    public double interest = 1.15;

    public SavingsAccount(String id, Balance balance) {
        super(id, balance);
    }

    // REQUIRES: Balance must be greater than 0
    // MODIFIES: this
    // EFFECTS: calculates the interest accumulated in a balance account
    public double calculateInterestTotal() {
        return getBalance().getInitialBudget() * getInterest();
    }

    public double getInterest() {
        return this.interest;
    }

}

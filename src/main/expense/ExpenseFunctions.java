package expense;

import exceptions.NoNegBalanceException;

import java.io.IOException;

public interface ExpenseFunctions {

    void beginExpenseTracker() throws IOException, NoNegBalanceException;

    void save(int initialBudget) throws IOException;

    int load() throws IOException;

}

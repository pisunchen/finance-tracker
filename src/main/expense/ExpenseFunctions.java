package expense;

import java.io.IOException;

public interface ExpenseFunctions {

    void beginExpenseTracker() throws IOException;

    void save(int initialBudget) throws IOException;

    int load() throws IOException;
}

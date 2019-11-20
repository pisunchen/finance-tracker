package expense;

import exceptions.NoNegBalanceException;
import exceptions.SpentAlotException;
import observer.Subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Balance extends Subject {

    private int initialBudget;
    private int value;

    public Balance(int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public int getInitialBudget() {
        return initialBudget;
    }

    public int setInitialBudget(int initialBudget) {
        return this.initialBudget = initialBudget;
    }

    public int subBalance(int value) throws SpentAlotException {
        this.value = value;
        if (value < 0) {
            System.out.println("Cannot have a negative expense!");
        } else if (value > 10000) {
            throw new SpentAlotException();
        }
        return initialBudget = initialBudget - value;
    }

    public int addBalance(int value) throws NoNegBalanceException {
        this.value = value;
        if (value < 0) {
            throw new NoNegBalanceException();
        } else {
            return initialBudget = initialBudget + value;
        }
    }

    public void updateNegBalance() {
        initialBudget = initialBudget - value;
    }

    public int load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        String s = lines.get(0);
        return Integer.parseInt(s);
    }

    public void save(int initialBudget) throws IOException {
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        writer.println(initialBudget);
        writer.close();
    }

}

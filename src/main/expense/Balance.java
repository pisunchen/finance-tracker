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

    private double initialBudget;
    private double value;

    public Balance(double initialBudget) {
        this.initialBudget = initialBudget;
    }

    public double getInitialBudget() {
        return initialBudget;
    }

    // MODIFIES: this
    // EFFECTS: Sets the current balance
    public double setInitialBudget(double initialBudget) {
        return this.initialBudget = initialBudget;
    }


    // MODIFIES: this
    // EFFECTS: deducts the current balance by the value amount, throws an exception according to values inputted
    public double subBalance(int value) throws SpentAlotException {
        this.value = value;
        if (value < 0) {
            System.out.println("Cannot have a negative expense!");
        } else if (value > 10000) {
            throw new SpentAlotException();
        }
        return initialBudget = initialBudget - value;
    }

    // MODIFIES: this
    // EFFECTS: adds the current balance by the value amount, throws an exception according to values inputted
    public double addBalance(int value) throws NoNegBalanceException {
        this.value = value;
        if (value < 0) {
            throw new NoNegBalanceException();
        } else {
            return initialBudget = initialBudget + value;
        }
    }

    // MODIFIES: this
    // EFFECTS: updates the negative balance
    public void updateNegBalance() {
        this.initialBudget = initialBudget - this.value;
    }


    // EFFECTS: loads the saved data
    public int load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        String s = lines.get(0);
        return Integer.parseInt(s);
    }

    // EFFECTS: saves data
    public void save(int initialBudget) throws IOException {
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        writer.println(initialBudget);
        writer.close();
    }



}

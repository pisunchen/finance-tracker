package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<AccountObserver> observers = new ArrayList<>();

    public void addObserver(AccountObserver accountObserver) {
        if (!observers.contains(accountObserver)) {
            observers.add(accountObserver);
        }
    }

    public void notifyObserver(AccountObserver accountObserver) {
        for (AccountObserver observer : observers) {
            observer.update(accountObserver);
        }
    }


}

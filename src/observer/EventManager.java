package observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager implements ISubject {
    // This class can be extended to manage different types of events, such as soldier death, soldier promotion, etc.
    private List<IObserver> observers = new ArrayList<>();

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String soldierName) {
        for (IObserver observer : observers) {
            observer.update(soldierName);
        }
    }
}
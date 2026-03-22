package observer;

// This observer will notify name of the soldier that died, send a email for family, etc. For now, it just prints a message to the console.
public class DeathNotifyObserver implements IObserver {
    @Override
    public void update(String soldierName) {
        System.out.println("Soldier " + soldierName + " has died. Notifying family...");
    }
}

package observer;

// This observer notifies the dead soldier name and simulates sending an apology email to their friends.
public class DeathNotifierObserver implements IObserver {
    private static final DeathNotifierObserver INSTANCE = new DeathNotifierObserver();

    private DeathNotifierObserver() {
    }

    public static DeathNotifierObserver getInstance() {
        return INSTANCE;
    }

    @Override
    public void update(String soldierName) {
        System.out.println("Soldier " + soldierName + " has died.");
        System.out.println("Sending apology email to " + soldierName + "'s friends...");
    }
}

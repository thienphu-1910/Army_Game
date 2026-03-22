package observer;

public class DeathCountObserver implements IObserver {
    private static final DeathCountObserver INSTANCE = new DeathCountObserver();

    private int deathCount = 0;

    private DeathCountObserver() {
    }

    public static DeathCountObserver getInstance() {
        return INSTANCE;
    }

    @Override
    public void update(String soldierName) {
        deathCount++;
        System.out.println("Death count updated: " + deathCount + " (last: " + soldierName + ")");
    }

    public int getDeathCount() {
        return deathCount;
    }
}

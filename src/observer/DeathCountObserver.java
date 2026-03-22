package observer;

public class DeathCountObserver implements IObserver {
    private int deathCount = 0;

    @Override
    public void update(String soldierName) {
        deathCount++;
        System.out.println("Death count updated: " + deathCount + " (last: " + soldierName + ")");
    }

    public int getDeathCount() {
        return deathCount;
    }
}

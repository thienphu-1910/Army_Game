package observer;

public class DeathCountObserver {
    private int deathCount = 0;

    public void update() {
        deathCount++;
        System.out.println("Death count updated: " + deathCount);
    }
}

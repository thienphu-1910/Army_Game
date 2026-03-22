import abstract_factory.SoldierFactories;
import abstract_factory.SoldierFactory;
import composite.Army;
import models.EquipmentType;
import visitor.CountVisitor;
import visitor.DisplayVisitor;
import models.SoldierEra;
import observer.DeathCountObserver;
import observer.DeathNotifyObserver;
import observer.EventManager;


public class App {
    public static void main(String[] args) {
        DeathCountObserver deathCountObserver = new DeathCountObserver();
        DeathNotifyObserver deathNotifyObserver = new DeathNotifyObserver();
        EventManager.getInstance().attach(deathCountObserver);
        EventManager.getInstance().attach(deathNotifyObserver);

        Army blueArmy = createBlueArmy();
        Army redArmy = createRedArmy();

        var countVisitor = new CountVisitor();
        blueArmy.accept(countVisitor);

        System.out.println("Blue Army total: " + countVisitor.getTotalSoldiers());
        System.out.println("Blue Army infantry: " + countVisitor.getTotalInfantryman());
        System.out.println("Blue Army horseman: " + countVisitor.getTotalHorseman());

        countVisitor = new CountVisitor();
        redArmy.accept(countVisitor);
        System.out.println("Red Army total: " + countVisitor.getTotalSoldiers());
        System.out.println("Red Army infantry: " + countVisitor.getTotalInfantryman());
        System.out.println("Red Army horseman: " + countVisitor.getTotalHorseman());

        var displayVisitor = new DisplayVisitor();
        blueArmy.accept(displayVisitor);
        redArmy.accept(displayVisitor);

        launch(blueArmy, redArmy);

        System.out.println("Total deaths in battle: " + deathCountObserver.getDeathCount());
    }

    private static Army createBlueArmy() {
        SoldierFactory medievalFactory = SoldierFactories.of(SoldierEra.MEDIEVAL);
        Army blueArmy = new Army("Blue Army");

        blueArmy.add(medievalFactory.createInfantryman("Blue-Infantry-1", EquipmentType.SWORD, EquipmentType.ARMOR));
        blueArmy.add(medievalFactory.createInfantryman("Blue-Infantry-2", EquipmentType.PIKE));
        blueArmy.add(medievalFactory.createHorseman("Blue-Horseman-1", EquipmentType.SWORD, EquipmentType.ARMOR));
        blueArmy.add(medievalFactory.createHorseman("Blue-Horseman-2", EquipmentType.PIKE));

        return blueArmy;
    }

    private static Army createRedArmy() {
        SoldierFactory worldWarFactory = SoldierFactories.of(SoldierEra.WORLD_WAR);
        Army redArmy = new Army("Red Army");

        redArmy.add(worldWarFactory.createInfantryman("Red-Infantry-1", EquipmentType.RIFLE, EquipmentType.HELMET));
        redArmy.add(worldWarFactory.createInfantryman("Red-Infantry-2", EquipmentType.GRENADE));
        redArmy.add(worldWarFactory.createHorseman("Red-Horseman-1", EquipmentType.RIFLE));
        redArmy.add(worldWarFactory.createHorseman("Red-Horseman-2", EquipmentType.HELMET, EquipmentType.GRENADE));

        return redArmy;
    }
    
    private static void launch(Army leftArmy, Army rightArmy) {
        System.out.println(" =======================================================");
        System.out.println("|                    LAUNCH BATTLE                      |");
        System.out.println(" =======================================================");

        int round = 1;
        while (leftArmy.isAlive() && rightArmy.isAlive()) {
            System.out.println("");
            System.out.println("======= ROUND " + round + " =======");
            System.out.println("");

            fight(leftArmy, rightArmy);

            if (rightArmy.isAlive()) {
                System.out.println("");
                System.out.println("======= COUNTER ROUND " + round + " =======");
                System.out.println("");
                fight(rightArmy, leftArmy);
            }

            round++;
        }

        if (leftArmy.isAlive()) {
            System.out.println("Winner: " + leftArmy.getName());
        } else {
            System.out.println("Winner: " + rightArmy.getName());
        }

    }
    
    private static void fight(Army attacker, Army defender) {
        int damage = attacker.hit();
        boolean isAlive = defender.wardOff(damage);

        System.out.println("==> " +
            attacker.getName() + " attacked " + defender.getName() +
            " with " + damage +
            " -> defenderAlive=" + isAlive
        );
    }
}
    
   ///

import core.Soldier;
import java.util.ArrayList;
import java.util.List;
import models.EquipmentType;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;

public class App {
    public static void main(String[] args) {
        // Two armies: blue and red
        List<Soldier> blueArmy = new ArrayList<>();
        List<Soldier> redArmy = new ArrayList<>();

        Soldier blue1 = new SoldierProxy(new Infantryman("Blue-Infantry-A"));
        blue1.addSword();
        blue1.addSword(); // test duplicate
        blue1.addShield();
        blueArmy.add(blue1);

        Soldier blue2 = new SoldierProxy(new Horseman("Blue-Horseman-A"));
        blue2.addEquipment(EquipmentType.SHIELD);
        blueArmy.add(blue2);

        Soldier red1 = new SoldierProxy(new Infantryman("Red-Infantry-A"));
        red1.addShield();
        redArmy.add(red1);

        Soldier red2 = new SoldierProxy(new Horseman("Red-Horseman-A"));
        red2.addSword();
        redArmy.add(red2);

        // remove comment section below to run battle simulation
        runBattle(blueArmy, redArmy); 
    }

    /*
    private static void runBattle(List<Soldier> leftArmy, List<Soldier> rightArmy) {
        int round = 1;

        while (hasAlive(leftArmy) && hasAlive(rightArmy)) {
            System.out.println("\n===== ROUND " + round + " =====");
            performAttacks(leftArmy, rightArmy);

            if (!hasAlive(rightArmy)) {
                break;
            }

            performAttacks(rightArmy, leftArmy);
            round++;
        }

        System.out.println("\n===== RESULT =====");
        if (hasAlive(leftArmy)) {
            System.out.println("Left army wins.");
        } else {
            System.out.println("Right army wins.");
        }
    }

    private static void performAttacks(List<Soldier> attackers, List<Soldier> defenders) {
        for (Soldier attacker : attackers) {
            if (!attacker.isAlive()) {
                continue;
            }

            Soldier defender = findFirstAlive(defenders);
            if (defender == null) {
                return;
            }

            int strength = attacker.hit();
            boolean alive = defender.wardOff(strength);

            System.out.println(
                attacker.getName() + " attacked " + defender.getName() +
                " with " + strength +
                " -> defenderAlive=" + alive
            );
        }
    }

    private static Soldier findFirstAlive(List<Soldier> army) {
        for (Soldier soldier : army) {
            if (soldier.isAlive()) {
                return soldier;
            }
        }
        return null;
    }

    private static boolean hasAlive(List<Soldier> army) {
        return findFirstAlive(army) != null;
    }
     */
}
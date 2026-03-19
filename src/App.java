import core.Soldier;
import java.util.ArrayList;
import java.util.List;

import composite.Army;
import models.EquipmentType;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;
import visitor.CountVisitor;
import visitor.DisplayVisitor;
import visitor.Visitor;

public class App {
    public static void main(String[] args) {
        Army blueArmy = generateArmy(new Army("Blue Army"), 2);
        Army redArmy = generateArmy(new Army("Red Army"), 3);

        var countVisitor = new CountVisitor();
        blueArmy.accept(countVisitor);

        System.out.println("Total: " + countVisitor.getTotalSoldiers());
        System.out.println("Infantryman: " + countVisitor.getTotalInfantryman());
        System.out.println("Horseman: " + countVisitor.getTotalHorseman());

        var DisplayVisitor = new DisplayVisitor();
        redArmy.accept(DisplayVisitor);

        launch(blueArmy, redArmy);
    }
    
    private static Army generateArmy(Army army, int groupQuantity) {
        if (groupQuantity == 1) {
            Soldier infantryman1 = new SoldierProxy(new Infantryman("Infantryman-A"));
            infantryman1.addShield();
            infantryman1.addSword();

            Soldier infantryman2 = new SoldierProxy(new Infantryman("Infantryman-B"));
            infantryman2.addShield();
            infantryman2.addShield(); // test duplication
            infantryman2.addSword();

            Soldier infantryman3 = new SoldierProxy(new Infantryman("Infantryman-C"));
            infantryman3.addSword();

            Soldier infantryman4 = new SoldierProxy(new Infantryman("Infantryman-D"));
            infantryman4.addSword();

            Soldier horseman1 = new SoldierProxy(new Horseman("Horseman-A"));
            horseman1.addShield();
            horseman1.addSword();

            Soldier horseman2 = new SoldierProxy(new Horseman("Horseman-B"));
            horseman2.addShield();
            horseman2.addSword();

            army.add(infantryman1);
            army.add(infantryman2);
            army.add(infantryman3);
            army.add(infantryman4);

            army.add(horseman1);
            army.add(horseman2);

            return army;
        }

        for (int i = 0; i < groupQuantity; ++i) {
            Army group = generateArmy(new Army(), groupQuantity - 1);
            army.add(group);
        }

        return army;
    }
    
    private static void launch(Army leftArmy, Army rightArmy) {
        System.out.println(" =======================================================");
        System.out.println("|                    LAUNCH BATTLE                      |");
        System.out.println(" =======================================================");

        
        while (leftArmy.isAlive() && rightArmy.isAlive()) {
            System.out.println("");
            System.out.println("=======New Turn=======");
            System.out.println("");
            // Left attack first
            fight(leftArmy, rightArmy);

            
            // Right turn
            if (rightArmy.isAlive()) {
                System.out.println("");
                System.out.println("=======New Turn=======");
                System.out.println("");
                fight(rightArmy, leftArmy);
            }
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

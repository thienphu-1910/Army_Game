package units;

import java.util.Collections;
import java.util.Set;

import core.Soldier;
import models.EquipmentType;
import models.SoldierKind;
import observer.EventManager;
import visitor.Visitor;

public class Infantryman implements Soldier {
    private static int sequence = 1;
    private static final int ARMOR = 2;

    private final String name;
    private int health = 32;
    private boolean deathNotified = false;

    public Infantryman() {
        this.name = "Infantry-" + sequence++;
    }

    public Infantryman(String name) {
        this.name = name;
    }

    @Override
    public int hit() {
        System.out.println("Infantryman.hit() -> " + name);
        return 10;
    }

    @Override
    public boolean wardOff(int strength) {
        boolean wasAlive = isAlive();
        int damage = Math.max(0, strength - ARMOR);
        health -= damage;

        System.out.println(
            "Infantryman.wardOff() -> " + name +
            " str=" + strength +
            " dmg=" + damage +
            " hp=" + Math.max(health, 0)
        );

        if (wasAlive && !isAlive() && !deathNotified) {
            deathNotified = true;
            EventManager.getInstance().notifyObservers(name);
        }

        return isAlive();
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public SoldierKind getKind() {
        return SoldierKind.INFANTRYMAN;
    }

    @Override
    public Set<EquipmentType> getEquipments() {
        return Collections.emptySet();
    }

    @Override
    public void addEquipment(EquipmentType equipmentType) {
        // proxy
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public void display() {
        System.out.print(this.name + " - " + SoldierKind.HORSEMAN.toString() + " - ");
    }

    @Override
    public void accept(Visitor v) {
        v.visitInfantryman(this);
    }
}
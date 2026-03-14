package units;

import java.util.Collections;
import java.util.Set;

import core.Soldier;
import models.EquipmentType;
import models.SoldierKind;

public class Horseman implements Soldier {
    private static int sequence = 1;
    private static final int ARMOR = 1;

    private final String name;
    private int health = 28;

    public Horseman() {
        this.name = "Horseman-" + sequence++;
    }

    public Horseman(String name) {
        this.name = name;
    }

    @Override
    public int hit() {
        System.out.println("Horseman.hit() -> " + name);
        return 15;
    }

    @Override
    public boolean wardOff(int strength) {
        int damage = Math.max(0, strength - ARMOR);
        health -= damage;

        System.out.println(
            "Horseman.wardOff() -> " + name +
            " str=" + strength +
            " dmg=" + damage +
            " hp=" + Math.max(health, 0)
        );

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
        return SoldierKind.HORSEMAN;
    }

    @Override
    public Set<EquipmentType> getEquipments() {
        return Collections.emptySet();
    }

    @Override
    public void addEquipment(EquipmentType equipmentType) {
        // proxy
    }
}
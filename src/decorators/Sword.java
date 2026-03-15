package decorators;

import core.Soldier;
import models.EquipmentType;

public class Sword extends EquipmentDecorator {
    private int durability = 5;

    public Sword(Soldier soldier) {
        super(soldier);
    }

    @Override
    public int hit() {
        int bonus = durability > 0 ? 5 : 2;

        if (durability > 0)
            durability--;

        System.out.println("Sword.hit() durability=" + durability);

        return soldier.hit() + bonus;
    }

    @Override
    protected EquipmentType getEquipmentType() {
        return EquipmentType.SWORD;
    }

}
package decorators;

import core.Soldier;
import models.EquipmentType;

public class Shield extends EquipmentDecorator {
    private int durability = 5;

    public Shield(Soldier soldier) {
        super(soldier);
    }

    @Override 
    public boolean wardOff(int strength) {
        int defense = durability > 0 ? 3 : 1;

        if (durability > 0)
            durability--;

        System.out.println("Shield.wardOff() durability=" + durability);

        return soldier.wardOff(strength - defense);
    }

    @Override
    protected EquipmentType getEquipmentType() {
        return EquipmentType.SHIELD;
    }

}
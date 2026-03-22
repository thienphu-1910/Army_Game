package decorators;

import core.Soldier;
import models.EquipmentType;

public class GenericEquipment extends EquipmentDecorator {
    private final EquipmentType equipmentType;
    private final int attackBonus;
    private final int defenseBonus;

    public GenericEquipment(
        Soldier soldier,
        EquipmentType equipmentType,
        int attackBonus,
        int defenseBonus
    ) {
        super(soldier);
        this.equipmentType = equipmentType;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
    }

    @Override
    public int hit() {
        return soldier.hit() + attackBonus;
    }

    @Override
    public boolean wardOff(int strength) {
        return soldier.wardOff(strength - defenseBonus);
    }

    @Override
    protected EquipmentType getEquipmentType() {
        return equipmentType;
    }
}

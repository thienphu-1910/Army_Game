package decorators;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import core.Soldier;
import models.EquipmentType;
import models.SoldierKind;

public abstract class EquipmentDecorator implements Soldier {
    protected Soldier soldier;

    protected EquipmentDecorator(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override 
    public int hit() {
        return soldier.hit();
    }

    @Override 
    public boolean wardOff(int strength) {
        return soldier.wardOff(strength);
    }

    @Override
    public boolean isAlive() {
        return soldier.isAlive();
    }

    @Override
    public String getName() {
        return soldier.getName();
    }

    @Override
    public SoldierKind getKind() {
        return soldier.getKind();
    }

    @Override
    public Set<EquipmentType> getEquipments() {
        Set<EquipmentType> all = new HashSet<>(soldier.getEquipments());
        all.add(getEquipmentType());
        return Collections.unmodifiableSet(all);
    }

    @Override 
    public void addEquipment(EquipmentType equipmentType) {
        soldier.addEquipment(equipmentType);
    }

    protected abstract EquipmentType getEquipmentType();
}
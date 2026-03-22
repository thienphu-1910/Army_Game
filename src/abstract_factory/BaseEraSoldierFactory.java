package abstract_factory;

import java.util.Set;

import core.Soldier;
import models.EquipmentType;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;

public abstract class BaseEraSoldierFactory implements SoldierFactory {
    protected abstract Set<EquipmentType> getAllowedEquipments();

    @Override
    public Soldier createInfantryman(String name, EquipmentType... equipments) {
        Soldier soldier = new SoldierProxy(new Infantryman(name));
        equipForEra(soldier, equipments);
        return soldier;
    }

    @Override
    public Soldier createHorseman(String name, EquipmentType... equipments) {
        Soldier soldier = new SoldierProxy(new Horseman(name));
        equipForEra(soldier, equipments);
        return soldier;
    }

    private void equipForEra(Soldier soldier, EquipmentType... equipments) {
        if (equipments == null) {
            return;
        }

        for (EquipmentType equipmentType : equipments) {
            if (!getAllowedEquipments().contains(equipmentType)) {
                throw new IllegalArgumentException(
                    "Equipment " + equipmentType + " is not allowed for era " + getEra()
                );
            }
            soldier.addEquipment(equipmentType);
        }
    }
}

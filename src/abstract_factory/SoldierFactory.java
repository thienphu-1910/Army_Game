package abstract_factory;

import java.util.Collections;
import java.util.Set;

import core.Soldier;
import models.EquipmentType;
import models.SoldierEra;

public interface SoldierFactory {
    Soldier createInfantryman(String name);

    Soldier createHorseman(String name);

    SoldierEra getEra();

    Set<EquipmentType> getAllowedEquipments();

    default void equip(Soldier soldier, EquipmentType equipmentType) {
        if (!getAllowedEquipments().contains(equipmentType)) {
            throw new IllegalArgumentException(
                "Equipment " + equipmentType + " is not allowed in era " + getEra()
            );
        }

        soldier.addEquipment(equipmentType);
    }

    default Set<EquipmentType> getAllowedEquipmentsView() {
        return Collections.unmodifiableSet(getAllowedEquipments());
    }
}

package abstract_factory;

import java.util.EnumSet;
import java.util.Set;

import models.EquipmentType;
import models.SoldierEra;

public class WorldWarSoldierFactory extends BaseEraSoldierFactory {
    private static final Set<EquipmentType> ALLOWED_EQUIPMENTS =
        EnumSet.of(EquipmentType.RIFLE, EquipmentType.GRENADE, EquipmentType.HELMET);

    @Override
    public SoldierEra getEra() {
        return SoldierEra.WORLD_WAR;
    }

    @Override
    protected Set<EquipmentType> getAllowedEquipments() {
        return ALLOWED_EQUIPMENTS;
    }
}

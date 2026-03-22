package abstract_factory;

import java.util.EnumSet;
import java.util.Set;

import models.EquipmentType;
import models.SoldierEra;

public class ScienceFictionSoldierFactory extends BaseEraSoldierFactory {
    private static final Set<EquipmentType> ALLOWED_EQUIPMENTS =
        EnumSet.of(EquipmentType.LASER_SWORD, EquipmentType.BIO_WEAPON, EquipmentType.NANO_ARMOR);

    @Override
    public SoldierEra getEra() {
        return SoldierEra.SCIENCE_FICTION;
    }

    @Override
    protected Set<EquipmentType> getAllowedEquipments() {
        return ALLOWED_EQUIPMENTS;
    }
}

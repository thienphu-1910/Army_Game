package abstract_factory;

import java.util.EnumSet;

import models.EquipmentType;
import models.SoldierEra;

public class ScienceFictionSoldierFactory extends BaseSoldierFactory {
    public ScienceFictionSoldierFactory() {
        super(
            SoldierEra.SCIENCE_FICTION,
            EnumSet.of(EquipmentType.LASER_SWORD, EquipmentType.BIO_WEAPON, EquipmentType.NANO_ARMOR)
        );
    }
}

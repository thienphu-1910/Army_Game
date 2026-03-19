package abstract_factory;

import java.util.EnumSet;

import models.EquipmentType;
import models.SoldierEra;

public class MedievalSoldierFactory extends BaseSoldierFactory {
    public MedievalSoldierFactory() {
        super(
            SoldierEra.MEDIEVAL,
            EnumSet.of(EquipmentType.SWORD, EquipmentType.PIKE, EquipmentType.ARMOR)
        );
    }
}

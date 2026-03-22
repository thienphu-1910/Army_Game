package abstract_factory;

import java.util.EnumSet;
import java.util.Set;

import models.EquipmentType;
import models.SoldierEra;

public class MedievalSoldierFactory extends BaseEraSoldierFactory {
    private static final Set<EquipmentType> ALLOWED_EQUIPMENTS =
        EnumSet.of(EquipmentType.SWORD, EquipmentType.PIKE, EquipmentType.ARMOR);

    @Override
    public SoldierEra getEra() {
        return SoldierEra.MEDIEVAL;
    }

    @Override
    protected Set<EquipmentType> getAllowedEquipments() {
        return ALLOWED_EQUIPMENTS;
    }
}

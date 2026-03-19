package abstract_factory;

import java.util.EnumSet;

import models.EquipmentType;
import models.SoldierEra;

public class WorldWarSoldierFactory extends BaseSoldierFactory {
    public WorldWarSoldierFactory() {
        super(
            SoldierEra.WORLD_WAR,
            EnumSet.of(EquipmentType.RIFLE, EquipmentType.GRENADE, EquipmentType.HELMET)
        );
    }
}

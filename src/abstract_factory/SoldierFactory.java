package abstract_factory;

import core.Soldier;
import models.EquipmentType;
import models.SoldierEra;

public interface SoldierFactory {
	SoldierEra getEra();

	Soldier createInfantryman(String name, EquipmentType... equipments);

	Soldier createHorseman(String name, EquipmentType... equipments);
}
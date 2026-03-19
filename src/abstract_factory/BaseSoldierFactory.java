package abstract_factory;

import java.util.EnumSet;
import java.util.Set;

import core.Soldier;
import models.EquipmentType;
import models.SoldierEra;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;

public abstract class BaseSoldierFactory implements SoldierFactory {
    private final SoldierEra era;
    private final Set<EquipmentType> allowedEquipments;

    protected BaseSoldierFactory(SoldierEra era, Set<EquipmentType> allowedEquipments) {
        this.era = era;
        this.allowedEquipments = EnumSet.copyOf(allowedEquipments);
    }

    @Override
    public Soldier createInfantryman(String name) {
        return new SoldierProxy(new Infantryman(name));
    }

    @Override
    public Soldier createHorseman(String name) {
        return new SoldierProxy(new Horseman(name));
    }

    @Override
    public SoldierEra getEra() {
        return era;
    }

    @Override
    public Set<EquipmentType> getAllowedEquipments() {
        return EnumSet.copyOf(allowedEquipments);
    }
}

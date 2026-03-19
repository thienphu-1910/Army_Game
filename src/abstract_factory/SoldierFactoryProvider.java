package abstract_factory;

import models.SoldierEra;

public final class SoldierFactoryProvider {
    private SoldierFactoryProvider() {
    }

    public static SoldierFactory fromEra(SoldierEra era) {
        return switch (era) {
            case MEDIEVAL -> new MedievalSoldierFactory();
            case WORLD_WAR -> new WorldWarSoldierFactory();
            case SCIENCE_FICTION -> new ScienceFictionSoldierFactory();
        };
    }
}

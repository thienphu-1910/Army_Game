package core;

import java.util.Set;

import models.EquipmentType;
import models.SoldierKind;
import visitor.Visitor;

public interface Soldier {
    int hit();
    boolean wardOff(int strength);

    boolean isAlive();
    String getName();
    SoldierKind getKind();
    Set<EquipmentType> getEquipments();

    void addEquipment(EquipmentType equipmentType);
    
    int count();

    void display();

    void accept(Visitor v);

    default void addShield() {
        addEquipment(EquipmentType.SHIELD);
    }

    default void addSword() {
        addEquipment(EquipmentType.SWORD);
    }
}

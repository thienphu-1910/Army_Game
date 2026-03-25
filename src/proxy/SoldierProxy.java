package proxy;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.UnaryOperator;

import core.Soldier;
import decorators.GenericEquipment;
import decorators.Shield;
import decorators.Sword;
import models.EquipmentType;
import models.SoldierKind;
import visitor.Visitor;

public class SoldierProxy implements Soldier {
    private static final Map<EquipmentType, UnaryOperator<Soldier>> EQUIPMENT_REGISTRY =
        new EnumMap<>(EquipmentType.class);

    static {
        registerEquipmentDecorator(EquipmentType.SHIELD, Shield::new);
        registerEquipmentDecorator(EquipmentType.SWORD, Sword::new);
        registerEquipmentDecorator(
            EquipmentType.PIKE,
            soldier -> new GenericEquipment(soldier, EquipmentType.PIKE, 4, 0)
        );
        registerEquipmentDecorator(
            EquipmentType.ARMOR,
            soldier -> new GenericEquipment(soldier, EquipmentType.ARMOR, 0, 4)
        );
        registerEquipmentDecorator(
            EquipmentType.RIFLE,
            soldier -> new GenericEquipment(soldier, EquipmentType.RIFLE, 7, 0)
        );
        registerEquipmentDecorator(
            EquipmentType.GRENADE,
            soldier -> new GenericEquipment(soldier, EquipmentType.GRENADE, 9, 0)
        );
        registerEquipmentDecorator(
            EquipmentType.HELMET,
            soldier -> new GenericEquipment(soldier, EquipmentType.HELMET, 0, 2)
        );
        registerEquipmentDecorator(
            EquipmentType.LASER_SWORD,
            soldier -> new GenericEquipment(soldier, EquipmentType.LASER_SWORD, 10, 0)
        );
        registerEquipmentDecorator(
            EquipmentType.BIO_WEAPON,
            soldier -> new GenericEquipment(soldier, EquipmentType.BIO_WEAPON, 8, 0)
        );
        registerEquipmentDecorator(
            EquipmentType.NANO_ARMOR,
            soldier -> new GenericEquipment(soldier, EquipmentType.NANO_ARMOR, 0, 6)
        );
    }

    private Soldier soldier;

    public SoldierProxy(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void addEquipment(EquipmentType equipmentType) {
        if (soldier.getEquipments().contains(equipmentType)) {
            System.out.println("Proxy: skip duplicate equipment " + equipmentType);
            return;
        }

        UnaryOperator<Soldier> decoratorFactory = EQUIPMENT_REGISTRY.get(equipmentType);
        if (decoratorFactory == null) {
            System.out.println("Proxy: equipment is not registered " + equipmentType);
            return;
        }

        soldier = decoratorFactory.apply(soldier);
        System.out.println("Proxy: equipped " + equipmentType + " for " + getName());
    }

    @Override
    public int hit() {
        return soldier.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return soldier.wardOff(strength);
    }

    // @Override
    // public boolean isAlive() {
    //     return soldier.isAlive();
    // }

    @Override
    public String getName() {
        return soldier.getName();
    }

    @Override
    public SoldierKind getKind() {
        return soldier.getKind();
    }

    @Override
    public Set<EquipmentType> getEquipments() {
        return soldier.getEquipments();
    }

    @Override
    public int count() {
        return soldier.count();
    }

    @Override
    public void display() {
        System.out.println();
    }

    @Override
    public void accept(Visitor v) {
        soldier.accept(v);
        v.visitSoldierProxy(this);
    }

    public static void registerEquipmentDecorator(
        EquipmentType equipmentType,
        UnaryOperator<Soldier> decoratorFactory
    ) {
        EQUIPMENT_REGISTRY.put(equipmentType, decoratorFactory);
    }
}
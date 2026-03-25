package composite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import models.SoldierKind;
import core.Soldier;
import models.EquipmentType;
import visitor.Visitor;

public class Army implements Soldier {
  private String name;
  private static int sequence = 1;
 // private boolean isAlive = true;

  protected ArrayList<Soldier> children = new ArrayList<>();

  public Army() {
    this.name = "Army " + sequence;
    sequence++;
  }

  public Army(String name) {
    this.name = name;
  }

  public void add(Soldier component) {
    children.add(component);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int hit() {
    int damage = 0;
    for (Soldier child : children) {
      damage += child.hit();
    }
    return damage;
  }

  @Override
  public boolean wardOff(int strength) {
    int quantity = children.size();
    if (quantity <= 0)
      return false;

    int childReceivedDamage = strength / quantity;
    boolean isSurvied = false;

    Iterator<Soldier> iterator = children.iterator();
    while (iterator.hasNext()) {
      Soldier child = iterator.next();

      if (child.wardOff(childReceivedDamage)) {
        isSurvied = true;
      } else {
        iterator.remove();
      }
    }

    return isSurvied;
  }

  @Override
  public void addEquipment(EquipmentType equipmentType) {
    for (Soldier child : children) {
      child.addEquipment(equipmentType);
    }
  }

  // @Override
  // public boolean isAlive() {
  //   for (Soldier child : children) {
  //     if (child.isAlive())
  //       return true;
  //   }

  //   return false;
  // }

  @Override
  public SoldierKind getKind() {
    return SoldierKind.ARMY_GROUP;
  }

  @Override
  public Set<EquipmentType> getEquipments() {
    Set<EquipmentType> equipmentTypes = new HashSet<>();

    for (Soldier child : children) {
      equipmentTypes.addAll(child.getEquipments());
    }

    return equipmentTypes;
  }

  @Override
  public int count() {
    int size = 0;
    for (Soldier child : children) {
      size += child.count();
    }

    return size;
  }

  @Override
  public void display() {
    System.out.println(this.name);
    for (Soldier child : children) {
      child.display();
    }
    System.out.println("");
  }

  @Override
  public void accept(Visitor v) {
    for (Soldier child : children) {
      child.accept(v);
    }
  }
}

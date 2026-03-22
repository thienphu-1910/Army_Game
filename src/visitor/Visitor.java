package visitor;

import composite.Army;
import decorators.EquipmentDecorator;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;

public interface Visitor {
  void visitArmy(Army army);

  void visitHorseman(Horseman h);

  void visitInfantryman(Infantryman i);

  void visitEquipmentDecorator(EquipmentDecorator ed);

  void visitSoldierProxy(SoldierProxy proxy);
}

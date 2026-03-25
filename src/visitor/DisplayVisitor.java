package visitor;

import composite.Army;
import decorators.EquipmentDecorator;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;

public class DisplayVisitor implements Visitor {
  @Override
  public void visitArmy(Army army) {
    army.display();
  }

  @Override
  public void visitHorseman(Horseman h) {
    h.display();
  }

  @Override
  public void visitInfantryman(Infantryman i) {
    i.display();
  }

  @Override
  public void visitEquipmentDecorator(EquipmentDecorator ed) {
    ed.display();
  }

  @Override
  public void visitSoldierProxy(SoldierProxy proxy) {
    proxy.display();
  }
  
}

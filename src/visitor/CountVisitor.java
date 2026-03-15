package visitor;

import composite.Army;
import decorators.EquipmentDecorator;
import proxy.SoldierProxy;
import units.Horseman;
import units.Infantryman;

public class CountVisitor implements Visitor {
  private int horsemans = 0;
  private int infantrymans = 0;

  @Override
  public void visitArmy(Army army) {
  }

  @Override
  public void visitHorseman(Horseman h) {
    this.horsemans += h.count();
  }

  @Override
  public void visitInfantryman(Infantryman i) {
    this.infantrymans += i.count();
  }

  @Override
  public void visitEquipmentDecorator(EquipmentDecorator ed) {
  }

  @Override
  public void visitSoldierProxy(SoldierProxy proxy) {
  }

  public int getTotalInfantryman() {
    return this.infantrymans;
  }

  public int getTotalHorseman() {
    return this.horsemans;
  }

  public int getTotalSoldiers() {
    return this.horsemans + this.infantrymans;
  }
}

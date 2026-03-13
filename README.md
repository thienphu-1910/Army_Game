# GA02 - Design Pattern - Army Game

A military game simulation project applying Design Patterns to build a flexible and scalable software architecture.

## 1. Team members

- Đặng Quang Hưng - 23127281
- Đặng Nghi Văn - 23127281
- Trương Công Thiên Phú - 23127455

## 2. Folder Structure

The project is organized into pattern-based packages to easily manage the source code:

```text
ArmyGameProject/
├── lib/                    # Contains external libraries (JavaFX, etc.)
├── bin/                    # Contains compiled .class files
└── src/
    ├── App.java            # Main entry point of the application
    ├── core/               # Core interfaces and base classes
    │   ├── Soldier.java    
    │   └── ArmyComponent.java
    ├── units/              # Specific soldier types
    │   ├── Infantryman.java
    │   └── Horseman.java
    ├── decorators/         # Pattern: Decorator (Weapons/Armor equipment)
    │   ├── EquipmentDecorator.java
    │   ├── Shield.java
    │   └── Sword.java
    ├── proxy/              # Pattern: Proxy (Duplicate equipment control)
    │   └── SoldierProxy.java
    ├── composite/          # Pattern: Composite (Squads, Army organization)
    │   ├── ArmyGroup.java
    │   └── Army.java
    ├── visitor/            # Pattern: Visitor (Traversing the army structure)
    │   ├── Visitor.java
    │   ├── DisplayVisitor.java
    │   └── CountVisitor.java
    ├── observer/           # Pattern: Observer (Tracking and notifying deaths)
    │   ├── Subject.java
    │   ├── DeathObserver.java
    │   ├── DeathCountObserver.java
    │   └── DeathNotifierObserver.java
    ├── factory/            # Pattern: Abstract Factory & Singleton (Generational creation)
    │   ├── SoldierFactory.java
    │   ├── MedievalFactory.java
    │   ├── WorldWarFactory.java
    │   └── ScienceFictionFactory.java
    └── models/             # Enums and helper data classes
        └── EquipmentType.java
package org.example.models.entity;

import org.example.models.properties.StatType;


public class Warrior extends Hero{


    public Warrior(String name) {
        super(name);
        getStatList().appendStat(StatType.strength, 5);
        getStatList().appendStat(StatType.vigor, 5);
        setHpSp();


        System.out.println("Warrior.Warrior");
        System.out.println(getStatList().getStats());
        System.out.println(getStatList().getStat(StatType.strength));
        System.out.println(getStatList().getStat(StatType.vigor));
        System.out.println(getStatList().getStat(StatType.hp));

    }

    @Override
    public void loot(Entity target) {
        System.out.println(getName() + " loot" );

    }

    @Override
    public void hit(Entity target) {
        getStrength();

    }
}

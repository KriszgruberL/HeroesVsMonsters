package org.example.models.entity;

import org.example.models.properties.StatType;

public class Magician extends Hero{

    public Magician(String name) {
        super(name);
        getStatList().appendStat(StatType.intelligence, 5);
        getStatList().appendStat(StatType.mind, 5);
        setHpSp();

        System.out.println("Magician.Magician");
        System.out.println(getStatList().getStats());
        System.out.println(getStatList().getStat(StatType.strength));
        System.out.println(getStatList().getStat(StatType.vigor));
        System.out.println(getStatList().getStat(StatType.hp));

    }

    @Override
    public void loot(Entity target) {

    }

    @Override
    public void hit(Entity target) {


    }
}

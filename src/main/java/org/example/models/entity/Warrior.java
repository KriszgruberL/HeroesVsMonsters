package org.example.models.entity;

import org.example.models.properties.StatType;
import org.example.utils.Dice;


public class Warrior extends Hero{


    public Warrior(String name) {
        super(name);
    }

    @Override
    public void hit(Entity target) {
//        Integer random = getStrength() / Dice.D4.throwDices(1);

        int damage = getStatList().modifier(StatType.strength) + Dice.D4.throwDice();

        System.out.println(getName() + " hit " + target.getName() + " who takes " + damage + " damages");
        target.takeDamage(damage);
        System.out.println(target.getName() + " : Hp left " + target.getCurrentHp());
    }

    @Override
    public void generate(){
        getStatList().appendStat(StatType.strength, 5);
        getStatList().appendStat(StatType.vigor, 5);
        super.generate();
    }
}

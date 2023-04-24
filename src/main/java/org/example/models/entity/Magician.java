package org.example.models.entity;

import org.example.models.properties.StatType;
import org.example.utils.Dice;

public class Magician extends Hero {

    public Magician(String name) {
        super(name);
    }



    @Override
    public void hit(Entity target) {
//        Integer random = this.getIntelligence() / Dice.D4.throwDices(1);

        int damage = getStatList().modifier(StatType.intelligence) + Dice.D4.throwDice();
        System.out.println(getName() + " hit " + target.getName() + " who takes " + damage + " damages");
        target.takeDamage(damage);
        System.out.println(target.getName() + " : Hp left " + target.getCurrentHp());

    }

    @Override
    public void generate(){
        getStatList().appendStat(StatType.intelligence, 5);
        getStatList().appendStat(StatType.mind, 5);
        super.generate();
    }
}

package org.example.models.entity;

import org.example.models.loots.Leather;
import org.example.models.properties.StatType;
import org.example.utils.Dice;

public class Wolf extends Monster implements Leather {

    private Integer leather;

    public Wolf(){
        leather = Dice.D6.throwDice();
    }

//        wolfLeather = Dice.D100.throwDices(5,2);


    @Override
    public void hit(Entity target) {
        int damage = getStatList().modifier(StatType.dexterity) + Dice.D4.throwDice();

    }

    @Override
    public void loot(Entity target) {
        System.out.println("Drop :" + leather + " wolf leather");

    }

    @Override
    public void generate(){
        getStatList().appendStat(StatType.dexterity,3);
        super.generate();
    }

    @Override
    public Integer getLeather() {
        return leather;
    }
}

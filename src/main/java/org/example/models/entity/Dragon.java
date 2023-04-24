package org.example.models.entity;

import org.example.models.loots.Gold;
import org.example.models.loots.Leather;
import org.example.models.properties.StatType;
import org.example.utils.Dice;

public class Dragon extends Monster implements Gold, Leather {


    private Integer gold;
    private Integer leather;

    public Dragon() {
        gold = Dice.D10.throwDice();
        leather = Dice.D10.throwDice();
    }

//    public Dragon(){
//        super();
//        getStatList().appendStat(StatType.dexterity,5);
//        gold = Dice.D20.throwDices(5,3);
//        dragonLeather = Dice.D4.throwDices(5,2);
//    }


    @Override
    public void hit(Entity target) {
        System.out.println(getName() + " hit " + target.getName());
        target.takeDamage(getStrength());

    }

    @Override
    public void loot(Entity target) {
        System.out.println("Drop :" + gold + "gold and "+ leather +" dragon leather");
    }

    @Override
    public String getName() {
        return null;
    }


    @Override
    public void generate(){
        getStatList().appendStat(StatType.intelligence,5);
        super.generate();
    }

    @Override
    public Integer getGold() {
        return gold;
    }

    @Override
    public Integer getLeather() {
        return leather;
    }
}

package org.example.models.entity;

import org.example.models.loots.Gold;
import org.example.models.properties.StatType;
import org.example.utils.Dice;

public class Troll extends Monster implements Gold {
    private Integer gold;

    public Troll(){
        gold = Dice.D10.throwDice();
    }

//    public Troll(String race) {
//        super(race);
//        getStatList().appendStat(StatType.dexterity,5);
//        gold = Dice.D20.throwDices(5,2);
//    }


    @Override
    public void hit(Entity target) {

    }


    @Override
    public void loot(Entity target) {

    }

    @Override
    public void generate(){
        getStatList().appendStat(StatType.strength,3);
        super.generate();
    }

    @Override
    public Integer getGold() {
        return gold;
    }
}

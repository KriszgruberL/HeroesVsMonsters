package be.technifutur.models.entity;

import be.technifutur.utils.Dice;
import be.technifutur.models.loots.Gold;
import be.technifutur.models.properties.StatType;

public class Troll extends Monster implements Gold {
    private Integer gold;

    public Troll(){
        gold = Dice.D10.throwDice();
    }




    @Override
    public void hit(Entity target) {
        int damage = getStatList().modifier(StatType.intelligence) + Dice.D4.throwDice();
        printDamage(target,damage);
    }


    @Override
    public void loot(Entity target) {
            System.out.println( gold + " gold");
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

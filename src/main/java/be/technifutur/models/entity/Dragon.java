package be.technifutur.models.entity;

import be.technifutur.utils.Dice;
import be.technifutur.models.loots.Gold;
import be.technifutur.models.loots.Leather;
import be.technifutur.models.properties.StatType;

public class Dragon extends Monster implements Gold, Leather {


    private Integer gold;
    private Integer leather;

    public Dragon() {
        gold = Dice.D10.throwDice();
        leather = Dice.D10.throwDice();
    }


    @Override
    public void hit(Entity target) {
        int damage = getStatList().modifier(StatType.intelligence) + Dice.D4.throwDice();
        printDamage(target, damage);
    }


    @Override
    public void loot(Entity target) {
        System.out.println( gold + " gold and "+ leather +" dragon leathers");
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

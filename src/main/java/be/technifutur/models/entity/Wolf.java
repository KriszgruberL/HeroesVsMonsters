package be.technifutur.models.entity;

import be.technifutur.utils.Dice;
import be.technifutur.models.loots.Leather;
import be.technifutur.models.properties.StatType;

public class Wolf extends Monster implements Leather {

    private Integer leather;


    public Wolf(){
        leather = Dice.D6.throwDice();

    }

//        wolfLeather = Dice.D100.throwDices(5,2);


    @Override
    public void hit(Entity target) {
        int damage = getStatList().modifier(StatType.intelligence) + Dice.D4.throwDice();
        printDamage(target,damage);

    }

    @Override
    public void loot(Entity target) {
            System.out.println( leather +" wolf leather");


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

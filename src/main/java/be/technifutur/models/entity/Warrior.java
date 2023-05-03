package be.technifutur.models.entity;

import be.technifutur.utils.Dice;
import be.technifutur.models.properties.StatType;


public class Warrior extends Hero{


    public Warrior(String name) {
        super(name);
    }

    @Override
    public void hit(Entity target) {
//        Integer random = getStrength() / Dice.D4.throwDices(1);

        int damage = getStatList().modifier(StatType.strength) + Dice.D4.throwDice();
        printDamage(target, damage);
    }


    @Override
    public void generate(){
        getStatList().appendStat(StatType.strength, 5);
        getStatList().appendStat(StatType.vigor, 5);
        super.generate();
    }
}

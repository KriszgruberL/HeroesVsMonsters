package be.technifutur.models.entity;

import be.technifutur.utils.Dice;
import be.technifutur.models.properties.StatType;

public class Magician extends Hero {

    public Magician(String name) {
        super(name);
    }

    @Override
    public void hit(Entity target) {
//        Integer random = this.getIntelligence() / Dice.D4.throwDices(1);

        int damage = getStatList().modifier(StatType.intelligence) + Dice.D4.throwDice();
        printDamage(target,damage);
    }

    @Override
    public void generate(){
        getStatList().appendStat(StatType.intelligence, 5);
        getStatList().appendStat(StatType.mind, 5);
        super.generate();
    }
}

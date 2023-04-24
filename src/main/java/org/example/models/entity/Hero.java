package org.example.models.entity;


import lombok.Getter;
import org.example.models.properties.StatType;
import org.example.utils.Dice;

@Getter
public abstract class Hero extends Entity{

    private String name;

    public Hero(String name) {
        this.name = name;
        for (StatType s: StatType.values()) {
            if (( s != StatType.hp) && (s != StatType.sp)){
                getStatList().appendStat(s, Dice.D6.throwDices(5,3));
            }
        }

    }

    public void setHpSp() {
        getStatList().appendStat(StatType.hp,getStrength() + getStatList().getStat(StatType.vigor));
        getStatList().appendStat(StatType.sp, getIntelligence()+ getStatList().getStat(StatType.mind));
    }

    public abstract void loot(Entity target);
}

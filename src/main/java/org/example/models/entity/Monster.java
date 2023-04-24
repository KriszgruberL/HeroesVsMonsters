package org.example.models.entity;

import org.example.models.properties.StatType;

public abstract class Monster extends Entity{

    private String race;

//    public Monster(String race){
//        this.race = race;
//        for (StatType s: StatType.values()) {
//            if (( s != StatType.hp) && (s != StatType.sp)){
//                getStatList().appendStat(s, Dice.D4.throwDices(5,3));
//            }
//        }
//    }

    public String getName() {
        return null;
    }

    public void setHpSp() {
        getStatList().appendStat(StatType.hp,getStrength() + getStatList().getStat(StatType.vigor));
        getStatList().appendStat(StatType.sp, getIntelligence()+ getStatList().getStat(StatType.mind));
    }


    public abstract void loot(Entity target);


}

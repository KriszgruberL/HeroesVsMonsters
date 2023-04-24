package org.example.models.entity;

import org.example.models.properties.Stat;
import org.example.models.properties.StatType;

public abstract class Entity {

    private Stat stats;

    private Integer currentHp;

    public Entity(){
        this.stats = new Stat();
    }

    public Stat getStatList() {
        return stats;
    }

    public Integer getCurrentHp(){
        return currentHp;
    }

    private void setCurrentHp(Integer value){
        currentHp = value < 0 ? 0 : Math.min(getHp(), value);
//        currentHp = value < 0 ? 0 : value > getHp() ? getHp() : value ;
    }

    public Integer getHp(){
        return stats.getStat(StatType.hp);
    }

    public Integer getStrength(){
        return stats.getStat(StatType.strength);
    }

    public Integer getIntelligence(){
        return stats.getStat(StatType.intelligence);
    }

    public abstract void hit(Entity target);
}

package org.example.models.properties;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Stat {

    @Getter
    private final Map<StatType, Integer> stats;

    public Stat() {
        this.stats = new HashMap<>();
    }

    public Integer getStat (StatType statType){
        if(!stats.containsKey(statType)) {
            return 0;
        }
        return stats.get(statType);
    }

    private void setStat(StatType statType, Integer value){
        stats.put(statType,value < 0 ? 0: value);
    }

    public void appendStat(StatType statType, Integer value){
        stats.put(statType, getStat(statType) + value);
    }
}

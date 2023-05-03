package be.technifutur.models.properties;

import be.technifutur.utils.Dice;
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

    public Integer modifier(StatType stat){
        if(getStat(stat) > 15){
            return 3;
        }
        if(getStat(stat) > 10){
            return 2;
        }
        if(getStat(stat) > 5){
            return 1;
        }
        return 0;
    }

    public void generate(Dice dice){
        for ( StatType s : StatType.values()){
            appendStat(s, dice.throwDices(5,3));
        }
        setStat(StatType.hp, getStat(StatType.strength) + getStat(StatType.vigor));
        setStat(StatType.sp, getStat(StatType.intelligence) + getStat(StatType.mind));
    }


}

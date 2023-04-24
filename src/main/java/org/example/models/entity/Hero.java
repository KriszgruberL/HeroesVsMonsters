package org.example.models.entity;


import org.example.models.loots.Gold;
import org.example.models.loots.Leather;

public abstract class Hero extends Entity implements Gold, Leather {

    private String name;
    private Integer gold = 0 ;
    private Integer leather = 0 ;

    public Hero(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public Integer getGold() {
        return gold;
    }

    @Override
    public Integer getLeather() {
        return leather;
    }

    public void loot(Entity target){
        if(target instanceof Gold g){
            gold += g.getGold();
        }
        if(target instanceof Leather g){
            gold += g.getLeather();
        }
        regen();
    }
}

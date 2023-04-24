package org.example.models.entity;

import org.example.models.properties.Stat;
import org.example.models.properties.StatType;
import org.example.utils.Dice;

public abstract class Entity {

    private Stat stats;
    private Integer currentHp;
    private Integer currentSp;


    public Entity(){
        this.stats = new Stat();
        generate();
        regen();
    }

    public Stat getStatList() {
        return stats;
    }

    public Integer getCurrentHp(){
        return currentHp;
    }

    public Integer getCurrentSp() {
        return currentSp;
    }

    public Integer getStrength(){
        return stats.getStat(StatType.strength);
    }

    public Integer getIntelligence(){
        return stats.getStat(StatType.intelligence);
    }

    public Integer getHp(){
        return stats.getStat(StatType.hp);
    }

    private Integer getSp() {
        return stats.getStat(StatType.sp);
    }

    private void setCurrentHp(Integer value){
        currentHp = value < 0 ? 0 : Math.min(getHp(), value);
//        currentHp = value < 0 ? 0 : value > getHp() ? getHp() : value ;
    }

    public void setCurrentSp(Integer currentSp) {
        this.currentSp = currentSp;
    }

    protected void takeDamage(Integer value){

        if (value < 0){
            return;
        }
        setCurrentHp(getCurrentHp()-value);
    }

    public boolean isAlive(){
        return getCurrentHp() > 0;
    }

    protected void regen(){
        setCurrentHp(getHp());
        setCurrentSp(getSp());
    }

    public void fight(Entity opponent1, Entity opponent2) {
        Integer cpt = 1;
        while ((opponent1.getCurrentHp() > 0) && (opponent2.getCurrentHp() > 0)) {
            opponent1.hit(opponent2);
            if (opponent2.getCurrentHp() > 0) {
                opponent2.hit(opponent1);
            }
            System.out.println("Turn " + cpt + " end ------------------- \n");
            cpt++;
        }

        if (opponent2.getCurrentHp() == 0) {
            System.out.println(opponent2.getName() + " died");
        } else {
            System.out.println(opponent1.getName() + " died");
        }
    }

    protected void generate(){
        if(this instanceof Hero){
            getStatList().generate(Dice.D6);
        }
        if(this instanceof Monster){
            getStatList().generate(Dice.D4);
        }
    }

    public abstract void hit(Entity target);

    public abstract void loot(Entity target);

    public abstract String getName();

}

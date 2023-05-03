package be.technifutur.models.entity;

import be.technifutur.utils.DieEventSubscriber;
import be.technifutur.utils.Dice;
import be.technifutur.models.properties.Stat;
import be.technifutur.models.properties.StatType;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    private final List<DieEventSubscriber> dieEventList = new ArrayList<>();

    private Stat stats;
    private Integer currentHp;
    private Integer currentSp;


    public Entity() {
        this.stats = new Stat();
        generate();
        regen();
    }

    public Stat getStatList() {
        return stats;
    }

    public Integer getCurrentHp() {
        return currentHp;
    }

    public Integer getCurrentSp() {
        return currentSp;
    }

    public Integer getStrength() {
        return stats.getStat(StatType.strength);
    }

    public Integer getIntelligence() {
        return stats.getStat(StatType.intelligence);
    }

    public Integer getHp() {
        return stats.getStat(StatType.hp);
    }

    private Integer getSp() {
        return stats.getStat(StatType.sp);
    }

    private void setCurrentHp(Integer value) {


        currentHp = value < 0 ? 0 : Math.min(getHp(), value);
//        currentHp = value < 0 ? 0 : value > getHp() ? getHp() : value ;
    }

    public void setCurrentSp(Integer currentSp) {
        this.currentSp = currentSp;
    }

    protected void takeDamage(Integer value) {

        if (value < 0) {
            return;
        }
        setCurrentHp(getCurrentHp() - value);
        if (!this.isAlive()) {
            raiseDieEvent();
        }
    }

    public boolean isAlive() {
        return getCurrentHp() > 0;
    }

    protected void regen() {
        setCurrentHp(getHp());
        setCurrentSp(getSp());
    }

    protected void generate() {
        if (this instanceof Hero) {
            getStatList().generate(Dice.D6);
        }
        if (this instanceof Monster) {
            getStatList().generate(Dice.D4);
        }
    }

    public void addDieEvent(DieEventSubscriber subscriber) {
        dieEventList.add(subscriber);
    }

    public void raiseDieEvent() {
        for (DieEventSubscriber subscriber : dieEventList) {
            subscriber.execute(this);
        }
    }

    public abstract void hit(Entity target);

    public abstract void loot(Entity target);

    public abstract String getName();

}

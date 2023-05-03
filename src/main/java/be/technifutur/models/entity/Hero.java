package be.technifutur.models.entity;


import be.technifutur.models.loots.Gold;
import be.technifutur.models.loots.Leather;

public abstract class Hero extends Entity implements Gold, Leather {

    private String name;
    private Integer gold = 0;
    private Integer leather = 0;

    public Hero(String name) {
        this.name = name;
    }

    protected void printDamage(Entity target, int damage) {
        System.out.println(getName() + " hit " + target.getName() + " who takes " + damage + " damages");
        target.takeDamage(damage);
        if (target.isAlive()){
            System.out.println(target.getName() + " : Hp left " + target.getCurrentHp());
        }
    }



    public String getName() {
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

    public void loot(Entity target) {

        System.out.printf("%s died and dropped : ", target.getName());
        if (target instanceof Monster m){
            m.loot(target);
        }
        if (target instanceof Gold g) {
            gold += g.getGold();

        }
        if (target instanceof Leather g) {
            leather += g.getLeather();
        }
        printInventory();
    }

    private void printInventory() {
        System.out.println("""
                
                +-----------+
                | Inventory |
                +-----------+
                """);

        System.out.printf("Current leather : %s leathers %n", leather);
        System.out.printf("Current gold : %s gold %n", gold);
        regen();
        System.out.printf("Regen of %s : %s HP & %s SP %n", getName(), getCurrentHp(), getCurrentSp());
    }
}


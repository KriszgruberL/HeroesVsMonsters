package be.technifutur.models.entity;


public abstract class Monster extends Entity {

    public String getName() {
        if (this instanceof Dragon) {
            return "Dragon";
        }
        if (this instanceof Troll) {
            return "Troll";
        }
        return "Wolf";
    }

    public abstract void loot(Entity target);

    protected void printDamage(Entity target, int damage) {
        System.out.println(getName() + " hit " + target.getName() + " who takes " + damage + " damages");
        target.takeDamage(damage);

        if (target.getCurrentHp() > 0){
            System.out.println(target.getName() + " : Hp left " + target.getCurrentHp());
        }
    }

}

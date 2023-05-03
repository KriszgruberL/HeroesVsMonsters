package be.technifutur.models;

import be.technifutur.models.entity.Entity;

public class Factory {

    public static void fight(Entity opponent1, Entity opponent2) {
        Integer cpt = 1;
        while ((opponent1.isAlive()) && (opponent2.isAlive())) {
            opponent1.hit(opponent2);
            if (opponent2.isAlive()) {
                opponent2.hit(opponent1);
            }
            System.out.println("Turn " + cpt + " end ------------------- \n");
            cpt++;
        }
    }

    public static void start(Entity opponent1, Entity opponent2) {
        opponent2.addDieEvent(i -> opponent1.loot(opponent2));
        fight(opponent1, opponent2);
    }
}

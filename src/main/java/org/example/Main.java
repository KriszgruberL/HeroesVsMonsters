package org.example;

import org.example.models.entity.*;

public class Main {
    public static void main(String[] args) {

        Warrior dude = new Warrior("Dude");
        Magician warlock = new Magician("Warwar the Magician");

        dude.loot(warlock);
        warlock.loot(dude);

        dude.fight(warlock, dude);

        Hero h = new Warrior("Dudette");
        Monster m = new Dragon();

        while (h.isAlive() && m.isAlive()){
            h.hit(m);
            if (m.isAlive()){
                m.hit(h);
            }
        }



    }

}
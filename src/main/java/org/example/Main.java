package org.example;

import org.example.models.entity.Entity;
import org.example.models.entity.Hero;
import org.example.models.entity.Magician;
import org.example.models.entity.Warrior;

public class Main {
    public static void main(String[] args) {

        Warrior dude = new Warrior("Dude");
        Entity warlock = new Magician("Warwar the Magician");

        dude.loot(warlock);





    }
}
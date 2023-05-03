package be.technifutur;

import be.technifutur.models.entity.*;

import static be.technifutur.models.Factory.start;


public class Main {
    public static void main(String[] args) {

        Hero warrior = new Warrior("Dudette");
        Magician warlock = new Magician("Warwar the Magician");



        Monster dragon = new Dragon();
        Monster wolf = new Wolf();
        Monster troll = new Troll();



        start(warrior, wolf);




    }


}
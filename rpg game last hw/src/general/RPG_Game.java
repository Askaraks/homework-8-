package general;

import players.*;
import players_general.Hero;
import players_general.SuperAbility;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int round_Number;

    public static void start(){
        Boss boss = new Boss(2000, 50);
        Warrior warrior = new Warrior(270,15, "Воин1");
        Medic doc = new Medic(220, 5, "Doc", 15);
        Magic magic = new Magic(240, 20, "magic");
        Bersek bersek = new Bersek(300, 20, "Bersek");
        Medic assistant = new Medic(250, 10, "assistant",5);
        Golem Golem = new Golem(500,50, SuperAbility.DEFEND, "Golem");

        Hero[] heroes = {warrior, doc,magic, bersek,assistant, Golem };

        printStatistics(heroes, boss);

        while(!isGameFinished(heroes,boss)){
            round(heroes,boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss){
        round_Number++;
        bossHits(heroes, boss);
        heroesHits(heroes, boss);
        applySuperAbility(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void printStatistics(Hero[] heroes, Boss boss){
        System.out.println("ROUND "+round_Number);
        System.out.println("Boss health: "+ boss.getHealth() + " ["+boss.getDamage()+"]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getHeroName()+" health: "+ heroes[i].getHealth()
                    + " ["+heroes[i].getDamage()+"]");
        }
    }

    private static void bossHits(Hero[] heroes, Boss boss){
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && boss.getHealth()>0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHits(Hero[] heroes, Boss boss){
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && boss.getHealth()>0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void applySuperAbility(Hero[] heroes, Boss boss){
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && boss.getHealth()>0) {
                heroes[i].applySuperAbility(heroes, boss);
            }
        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss boss){
        if(boss.getHealth() <= 0){
            System.out.println("Heroes win!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }
        if(allHeroesDead){
            System.out.println("Boss wins!");
        }
        return  allHeroesDead;
    }
}

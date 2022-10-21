package players;

import general.RPG_Game;
import players_general.Hero;
import players_general.SuperAbility;

import java.util.Random;

public class Magic extends Hero {

    public Magic(int health, int damage, String heroName) {
        super(health, damage, SuperAbility.BOOST, heroName);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int number = RPG_Game.random.nextInt(5) + 1;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this != heroes[i]) {
                heroes[i].setDamage(heroes[i].getDamage() + number);
                int isAvailable = new Random().nextInt(2);
                if (isAvailable == 1) {
                    int randomDamage = new Random().nextInt(50) + 25;
                    this.setDamage(this.getDamage() + randomDamage);
                    System.out.println("Magic boosted his damage on: " + randomDamage);
                }
            }
        }
    }

}

package players;

import players_general.Hero;
import players_general.SuperAbility;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage, String heroName) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, heroName);
    }


    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int damage = new Random().nextInt(2) + 2;
        this.setDamage(this.getDamage() * damage);
        System.out.println("Warrior used his Ability " + this.getDamage());

    }
}

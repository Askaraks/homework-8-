package players;

import players_general.Hero;
import players_general.SuperAbility;

public class Golem extends Hero {

    public Golem(int health, int damage, SuperAbility superAbility, String heroName) {
        super(health, damage, superAbility, heroName);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int damage = boss.getDamage() / 2;
        this.setDamage(this.getDamage() + damage);
        System.out.println("Golem used his Ability " + this.getDamage());

    }
}

package players;

import players_general.Hero;
import players_general.SuperAbility;

public class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, String heroName, int healPoints) {
        super(health, damage, SuperAbility.HEAL, heroName);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }


    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {

    }
}

package players;

import players_general.Hero;
import players_general.SuperAbility;

public class Bersek  extends Hero {
    public Bersek(int health, int damage, String heroName) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, heroName);
    }


    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {


    }
}

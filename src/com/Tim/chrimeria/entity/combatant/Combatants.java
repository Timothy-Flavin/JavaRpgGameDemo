package com.Tim.chrimeria.entity.combatant;

public class Combatants {
	
	public static Combatant getCombatant(int i, int l){
		switch (i) {
        case 1:  return new Accursed(l);
		case 2:  return new Archer(l);
		case 3:  return new BabyWyvern(l);
		case 4:  return new BlueSlime(l);
		case 5:  return new Bunny(l);
		case 6:  return new PinkSlime(l);
		case 7:  return new Voodoo(l);
		case 8:  return new Accursed(l);
		case 9:  return new MaeveSoldier(l);
		case 10: return new MaeveSoldier2(l);
		case 11: return new Accursed(l);
		case 12: return new Accursed(l);
		default: return null;
		
		}
	}
}

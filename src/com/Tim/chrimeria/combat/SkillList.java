package com.Tim.chrimeria.combat;

import com.Tim.chrimeria.entity.combatant.Combatant;

public class SkillList {
	public static Skill[] moveList = new Skill[]{
		new Attack(0, 35, 1, 0, "punch", "ad", "physical", "none"),
		new Attack(1, 45, 1, 0, "kick", "ad", "physical", "none"),
		new Attack(2, 55, 1, 0, "spear throw", "ad", "physical", "none"),	
		new Attack(3, 65, 1, 0, "spear jab", "ad", "physical", "none"),	
		new Attack(4, 75, 1, 0, "huge slash", "ad", "physical", "none"),
		new Attack(5, 35, 1, 0, "ember", "ap", "magical", "none"),	
		new Attack(6, 45, 1, 0, "spark", "ap", "magical", "none"),	
		new Attack(7, 55, 1, 0, "chill", "ap", "magical", "none"),
		new Heal(8, 20, 1, 0, "patch up", "ap", "none"),
		new Buff(9,20,1,0,"focus","ap","none"),
		new BattleRage(10,20,1,0,"b rage","ap","none"),
	};
	
	public static String getAttackName(int id){
		return moveList[id].name;
	}
	public static Skill getMove(int id){
		return moveList[id];
	}
	public static int getAttackDamage(int id, Combatant cbt){
		return moveList[id].multiplier*cbt.getAd()/100;
	}
}

package com.Tim.chrimeria.combat;

import com.Tim.chrimeria.entity.combatant.Combatant;

public class Heal extends Skill{
	
	public String statusEffect;
	
	public Heal(int ID, int multiplier, int numTargets, int cost, String name, String statUsed, String statusEffect) {
		super(ID, multiplier, numTargets, cost, name, statUsed, true);
		this.statusEffect = statusEffect;
		heal = true;
	}
	public void go(Combatant user, Combatant target){
		target.hp+=user.ap*multiplier/100;
		System.out.println("healed: " +user.ad*multiplier/100);
		if(target.hp>target.mhp)target.hp=target.mhp;
	}

}


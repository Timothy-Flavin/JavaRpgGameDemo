package com.Tim.chrimeria.combat;

import com.Tim.chrimeria.entity.combatant.Combatant;

public class Skill {
	public int ID, multiplier = 0, numTargets, cost;
	public String name, statUsed;
	public boolean heal = false;
	
	public Skill(int ID, int multiplier, int numTargets, int cost, String name, String statUsed, boolean heal){
		this.ID = ID;
		this.multiplier = multiplier;
		this.numTargets = numTargets;
		this.name = name;
		this.statUsed = statUsed;
		this.cost = cost;
	}
	public void go(Combatant user, Combatant target){
		target.hp-=user.tempAd*multiplier/100;
		System.out.println("did: " +user.tempAd*multiplier/100);
	}
}

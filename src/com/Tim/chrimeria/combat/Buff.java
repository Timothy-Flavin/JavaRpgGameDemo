package com.Tim.chrimeria.combat;

import com.Tim.chrimeria.entity.combatant.Combatant;

public class Buff extends Skill{
public String statusEffect;
	
	public Buff(int ID, int multiplier, int numTargets, int cost, String name, String statUsed, String statusEffect) {
		super(ID, multiplier, numTargets, cost, name, statUsed, true);
		this.statusEffect = statusEffect;
		heal = true;
	}
	public void go(Combatant user, Combatant target){
		target.tempAd+=5;
		System.out.println("buffed: " +5);
	}
}

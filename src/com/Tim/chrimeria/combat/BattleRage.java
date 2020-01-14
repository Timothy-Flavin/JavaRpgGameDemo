package com.Tim.chrimeria.combat;

import com.Tim.chrimeria.entity.combatant.Combatant;

public class BattleRage extends Buff{
	public BattleRage(int ID, int multiplier, int numTargets, int cost, String name, String statUsed, String statusEffect) {
		super(ID, multiplier, numTargets, cost, name, statUsed, statusEffect);
		this.statusEffect = statusEffect;
		heal = true;
	}
	public void go(Combatant user, Combatant target){
		user.hp/=2;
		user.tempAd*=2;
		System.out.println("buffed: " +user.tempAd+" "+user.ad);
	}
}

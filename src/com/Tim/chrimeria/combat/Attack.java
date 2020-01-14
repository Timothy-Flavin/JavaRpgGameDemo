package com.Tim.chrimeria.combat;

public class Attack extends Skill{
	
	public String damageType;
	public String statusEffect;
	
	public Attack(int ID, int multiplier, int numTargets, int cost, String name, String statUsed, String damageType, String statusEffect) {
		super(ID, multiplier, numTargets, cost, name, statUsed, false);
		this.damageType = damageType;
		this.statusEffect = statusEffect;
		heal = false;
	}

}

package com.Tim.chrimeria.entity.combatant;

import com.Tim.chrimeria.combat.Skill;
import com.Tim.chrimeria.combat.SkillList;
import com.Tim.chrimeria.graphics.Sprite;

public class Combatant {
	public int mhp = 10, hp = 10, ad = 0, ap = 0, mr = 0, ar = 0, sp = 0, lvl = 0, animationLength = 120, fps = 1, frame = 0, animationFrames = 1;
	protected int bhp, bad, bap, bmr, bar, bsp;
	public int[] skillIdList;
	protected boolean dead = false, turnChosen = false;
	public String name = "unnamed";
	public Sprite sprite, profile;
	public Sprite[] animation;
	public int x = 0, y = 0;
	public boolean ai = false;
	public Combatant target = null;
	public Skill move = null;
	public int tempAd=0;
	
	public Combatant(int lvl){
		this.lvl = lvl;
		skillIdList = new int[6];
		for(int i = 0; i < 6; i++){
			skillIdList[i] = i;
		}
		profile = Sprite.cuchulainProfile;
	}
	
	public void takeTurn(Combatant[] cb){
		target = cb[(int)(Math.random()*cb.length)];
	}
	
	public void chooseAttack(){
		move = SkillList.getMove(skillIdList[(int)(Math.random()*skillIdList.length)]);
	}
	
	public void die(){
		dead = true;
	}
	
	public void levelUp(){
		lvl++;
		mhp = bhp*lvl; ad = bad*lvl; ap = bap*lvl; mr = bmr*lvl; ar = bar*lvl; sp = bsp*lvl;
		tempAd=ad;
	}
	
	public boolean getDead(){
		return dead;
	}

	public void animate(){
		frame++;
		if(frame == animationLength){
			frame = 0;
		}
		sprite = animation[frame/(animationLength/animationFrames)];
	}
	public int getAd(){
		return ad;
	}

	public void setDead(boolean b) {
		// TODO Auto-generated method stub
		dead= b;
	}
}

package com.Tim.chrimeria.entity.combatant;

import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.graphics.SpriteSheet;

public class PinkSlime extends Slime{
	public PinkSlime(int lvl){
		super(lvl);
		name = "pinky";
		animation = new Sprite[]{
				new Sprite(32, 32, 0, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 1, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 2, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 3, 6, SpriteSheet.combatSprites)
		};
		sprite = animation[0];
		bhp = 5;
		bad = 5;
		bap = 2;
		bmr = 3;
		bar = 3;
		bsp = 5;
		mhp = bhp*lvl; hp = mhp; ad = bad*lvl; ap = bap*lvl; mr = bmr*lvl; ar = bar*lvl; sp = bsp*lvl;
	}
	
	public void takeTurn(){
		
	}
	public void animate(){
		super.animate();
	}
	public void die(){
		dead = true;
	}
	
	public void levelUp(){
	
	}
}

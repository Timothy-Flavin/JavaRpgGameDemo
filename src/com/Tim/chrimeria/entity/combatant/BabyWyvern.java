package com.Tim.chrimeria.entity.combatant;

import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.graphics.SpriteSheet;

public class BabyWyvern extends Combatant{
	
	public BabyWyvern(int lvl){
		super(lvl);
		name = "baby wyvern";
		animation = new Sprite[]{
				new Sprite(32, 32, 0, 4, SpriteSheet.combatSprites),
				new Sprite(32, 32, 1, 4, SpriteSheet.combatSprites),
				new Sprite(32, 32, 2, 4, SpriteSheet.combatSprites),
				new Sprite(32, 32, 3, 4, SpriteSheet.combatSprites),
				new Sprite(32, 32, 4, 4, SpriteSheet.combatSprites),
				new Sprite(32, 32, 5, 4, SpriteSheet.combatSprites),
				new Sprite(32, 32, 6, 4, SpriteSheet.combatSprites)
		};
		sprite = animation[0];
		animationFrames = 7;
		fps = 5;
		animationLength = animationFrames * (60/fps);
		bhp = 5;
		bad = 2;
		bap = 3;
		bmr = 3;
		bar = 3;
		bsp = 4;
		mhp = bhp*lvl; hp = mhp; ad = bad*lvl; ap = bap*lvl; mr = bmr*lvl; ar = bar*lvl; sp = bsp*lvl;
	}
	public void animate(){
		super.animate();
	}
	public void takeTurn(){
		
	}
	
	public void die(){
		dead = true;
	}
	
	public void levelUp(){
		
	}
}

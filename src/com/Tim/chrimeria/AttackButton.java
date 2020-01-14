package com.Tim.chrimeria;

import com.Tim.chrimeria.graphics.Sprite;

public class AttackButton extends MenuButton{
	String name;
	int id;
	public AttackButton(Sprite button, Sprite buttonPressed, int x, int y, String name, int id) {
		super(button, buttonPressed, x, y);
		this.name = name;
		this.id = id;
		/*Sprite buttonText = Font.makeSprite(title);
		//Sprite buttonPressedText = Font.makeSprite(title);
		
		int xOffset = (button.w-buttonText.w) / 2;
		int yOffset = (button.h-buttonText.h) / 2;
		for(int yi = 0; yi < button.h; yi++){
			for(int xi = 0; xi < button.w; xi++){
				if(xi >= xOffset && xi < xOffset+buttonText.w && yi >= yOffset && yi < yOffset+buttonText.h){
					button.pixels[xi + yi*button.w] = buttonText.pixels[xi-xOffset + (yi-yOffset)*buttonText.w];
				}
			}
		}*/
		// TODO Auto-generated constructor stub
	}

}

package com.Tim.chrimeria;

import java.awt.Image;

import javax.imageio.ImageIO;

import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.input.Mouse;

public class MenuButton{
	String path, pathPressed;
	public boolean pressed = false, clicked = false, mousedOver = false;
	private boolean sprite = false;
	private int width, height;
	private Image button, buttonPressed, current;
	private int x, y;
	Sprite sButton, sButtonPressed;
	public Sprite sCurrent;
	
	public MenuButton(String path, String pathPressed, int x, int y){
		try{
			button = ImageIO.read(MenuButton.class.getResource(path));
			button = button.getScaledInstance(button.getWidth(null)*Game.scale, button.getHeight(null)*Game.scale, Image.SCALE_SMOOTH);
			width = button.getWidth(null);
			height = button.getHeight(null);
			current = button;
			buttonPressed = ImageIO.read(MenuButton.class.getResource(pathPressed));
			buttonPressed = buttonPressed.getScaledInstance(buttonPressed.getWidth(null)*Game.scale, buttonPressed.getHeight(null)*Game.scale, Image.SCALE_SMOOTH);
		}catch(Exception e){
			System.out.println("Menu button class fucked up");
		}
		this.x = x-width/2;
		this.y = y-height/2;
		this.path = path;
		this.pathPressed = pathPressed;
		sprite = false;
	}
	public MenuButton(Sprite button, Sprite buttonPressed, int x, int y){
		width = button.w;
		height = button.h;
		this.x = x;
		this.y = y;
		sprite = true;
		this.sButton = button;
		this.sButtonPressed = buttonPressed;
		this.sCurrent = sButton;
	}

	public void resetScale(){
		button = button.getScaledInstance(button.getWidth(null)*Game.scale, button.getHeight(null)*Game.scale, Image.SCALE_SMOOTH);
		buttonPressed = buttonPressed.getScaledInstance(buttonPressed.getWidth(null)*Game.scale, buttonPressed.getHeight(null)*Game.scale, Image.SCALE_SMOOTH);
	}
	
	public void update(){
		if(sprite){
			if(Mouse.getButton() == 1){
				//System.out.println(Mouse.getX()/Game.scale + ", " + Mouse.getY()/Game.scale);
				if(Mouse.getX()/Game.scale > x && Mouse.getX()/Game.scale < x+width && Mouse.getY()/Game.scale > y && Mouse.getY()/Game.scale < y + height){
					pressed = true;
					//System.out.println("mousePressed");
				}
				else{
					sCurrent = sButton;
					pressed = false;
				}
			}
			if(Mouse.getButton() == -1){
				if(Mouse.getX()/Game.scale > x && Mouse.getX()/Game.scale < x+width && Mouse.getY()/Game.scale > y && Mouse.getY()/Game.scale < y + height){
					if(pressed){
						clicked = true;
						//System.out.println("clicked the button");
					}
					else{
						mousedOver = true;
					}
				}
				else{
					pressed = false;
					mousedOver = false;
				}
			}
		}
		else{
			if(Mouse.getButton() == 1){
				if(Mouse.getX() > x && Mouse.getX() < x+width && Mouse.getY() > y && Mouse.getY() < y + height){
					pressed = true;
				}
				else{
					current = button;
					pressed = false;
				}
			}
			if(Mouse.getButton() == -1){
				if(Mouse.getX() > x && Mouse.getX() < x+width && Mouse.getY() > y && Mouse.getY() < y + height){
					if(pressed){
						clicked = true;
					}
					else{
						mousedOver = true;
					}
				}
				else{
					pressed = false;
					mousedOver = false;
				}
			}
		}
		if(mousedOver){
			if(sprite){
				sCurrent = sButtonPressed;
			}
			else{
				current = buttonPressed;
			}
		}
		else{
			if(sprite){
				sCurrent = sButton;
			}
			else{
				current = button;
			}
		}
	}
	
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}
	
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	public Image getImage(){
		return current;
	}
	
	public boolean getClicked(){
		return clicked;
	}
	
	public void setClicked(boolean t){
		clicked = t;
	}
	public void setPressed(boolean t){
		pressed = t;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
}

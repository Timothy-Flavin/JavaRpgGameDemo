package com.Tim.chrimeria.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	private boolean[] keys = new boolean[120];
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean shift;
	public boolean escape;
	public boolean e;
	//make a separate update method for updating non movement based things
	public void update(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		shift = keys[KeyEvent.VK_SHIFT];
		escape = keys[KeyEvent.VK_ESCAPE];
		e = keys[KeyEvent.VK_E];
		//
		
		//if(escape)System.out.println(escape);
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	public void keyTyped(KeyEvent e) {
	}
}

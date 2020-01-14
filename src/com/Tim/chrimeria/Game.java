package com.Tim.chrimeria;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;

import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import com.Tim.chrimeria.dialogue.Dialogue;
import com.Tim.chrimeria.entity.combatant.Combatant;
import com.Tim.chrimeria.entity.mob.Player;
import com.Tim.chrimeria.graphics.Screen;
import com.Tim.chrimeria.input.Keyboard;
import com.Tim.chrimeria.input.Mouse;
import com.Tim.chrimeria.level.Fjord;
import com.Tim.chrimeria.level.Level;
import com.Tim.chrimeria.level.RandomLevel;
import com.Tim.chrimeria.level.SmallHouse;
import com.Tim.chrimeria.level.SmallHouse2;

public class Game extends Canvas implements Runnable{
	
	public static Clip clip;
	public static AudioInputStream gameTheme;
	public static AudioInputStream tuturialTownTheme, battleTheme;
	public static int soundCounter = 0;
	char dir = ' ', newDir = ' ';
	Sequencer sequencer;
	int x = 0, y = 0;
	private static final long serialVersionUID = 1L;
	private boolean resetFrame = true;
	
	public static int width = 480, height = width * 3 / 5;
	public static int scale = 3;//, speed = 1;
	//public static int frameNumber = 0;
	private Graphics g;
	private Thread thread;
	private boolean running = false, firstTimeStart=true;
	private Keyboard key;
	private static int levelNum = 0;
	public static Level[] level;
	private JFrame frame;
	private Screen screen;
	private String title = "Chrimeria";
	private Player player;
	private Menu mainMenu;
	private static BattleScreen battleScreen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	public static enum STATE{
		MENU,
		OVERWORLD,
		COMBAT
	};
	public static STATE State = STATE.MENU;
	
	public Game(){
		level = new Level[]{
				new Fjord("./res/levels/fjord0.txt","./res/levels/fjord1.txt", this),
				new SmallHouse("./res/levels/interior0.txt","./res/levels/interior1.txt", this),//RandomLevel(64, 64);
				new SmallHouse2("./res/levels/interior0.txt","./res/levels/interior1.txt", this),//RandomLevel(64, 64);
				new RandomLevel(3,3, this),
				new RandomLevel(4,4, this),
				new RandomLevel(5,5, this),
			};
		try {
	        gameTheme = AudioSystem.getAudioInputStream(new File("res/music/GameTheme.wav").getAbsoluteFile());
	        tuturialTownTheme = AudioSystem.getAudioInputStream(new File("res/music/TuturialTown.wav").getAbsoluteFile());
	        battleTheme = AudioSystem.getAudioInputStream(new File("res/music/battleMusic.wav").getAbsoluteFile());
	        
	        clip = AudioSystem.getClip();
	        clip.open(gameTheme);
	        soundCounter = clip.getFrameLength();
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double swidth = screenSize.getWidth();
		double sheight = screenSize.getHeight();
		scale = 1;
		while(swidth > width*(scale+1) && sheight > height*(scale+1)){
			scale++;
		}
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		mainMenu = new Menu();
		screen = new Screen(width, height);
		
		frame = new JFrame();
		key = new Keyboard();
		//int spawn = (int)(Math.random()*5);
		player = new Player(level[levelNum].spawnPoints[0].x(), level[levelNum].spawnPoints[0].y(), key); // SPAWN LOCATIONS 
		player.init(level[0]);
		
		battleScreen = new BattleScreen(width, height, player);
		
		//if(level[0] == null) System.out.println("dangit dud");
		Mouse mouse = new Mouse();
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);

	}
	
	public static Level getLevel(){
		return level[levelNum];
	}
	
	public static void switchMusic(String musicPath){
		clip.close();
		try{
			AudioInputStream song = AudioSystem.getAudioInputStream(new File(musicPath).getAbsoluteFile());
			clip.open(song);
			soundCounter = Game.clip.getFrameLength();
			clip.setFramePosition(0);
	        clip.start();
		}catch(Exception e){
			
		}
	}
	public static void switchState(STATE state){
		State = state;
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop(){
		try{
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				update();
				updates++;
				//frameNumber++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				if(clip.getFramePosition() >= soundCounter-1){
					clip.setFramePosition(0);
					clip.start();
					//System.out.println("hi the sound ended");
				}
				timer += 1000;
				//System.out.println(updates + " ups, " + frames + "fps");
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
				if(resetFrame){
					//frameNumber = 0;
					resetFrame = false;
				}
				else
					resetFrame = true;
			}
		}
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		g = bs.getDrawGraphics();
		//g.setColor(Color.BLACK);
		//g.setFont(new Font("Power clear", 0, 8*scale));
		//g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		////////////////////////////////////////////////////////////////////////////
		if(State == STATE.OVERWORLD){
			int xScroll = player.x - (screen.width/2 -16);
			int yScroll = player.y - (screen.height/2 -16);
			
			level[levelNum].render(xScroll, yScroll, screen); //remember this used to be level x and y
			player.render(screen);
			level[levelNum].renderFront(xScroll, yScroll, screen); 
			screen.renderMenu();
			screen.renderProfiles();
			screen.renderHealthBars(g);
			
			if(firstTimeStart){
				Dialogue.playConversation(TextToRender.getDialogueByName("intro").getTextArray());
				firstTimeStart=false;
			}
			for(int i = 0; i< pixels.length; i++){
				pixels[i] = screen.pixels[i];
			}
			
			
			//g.drawString("playerx" + player.x + "playery " + player.y, 100, 100);//temp
			//g.drawString("mouse x" + Mouse.getX() + "mouse y " +  Mouse.getY() + " mouse button" + Mouse.getButton(), 100, 120);
			//g.drawString("hp " + player.PCombatant.hp + "/" + player.PCombatant.mhp + ", ad " + player.PCombatant.ad+ ", ap " + player.PCombatant.ap + ", ar " + player.PCombatant.ar + ", mr " + player.PCombatant.mr+ ", sp " + player.PCombatant.sp, 100, 140);
			//g.drawString("encounter" + player.inEncounter, 100, 160);
		}
		else if(State == STATE.MENU){
			mainMenu.render(g);
		}
		else if(State == STATE.COMBAT){
			battleScreen.render(g);
			for(int i = 0; i< pixels.length; i++){
				pixels[i] = battleScreen.pixels[i];
			}
		}
		Dialogue.renderText(pixels);
		g.dispose();
		bs.show();
	}
	
	public void update(){
		if(State == STATE.OVERWORLD){
			key.update();
			player.update(screen);
			
			for(int i = 0; i < level[levelNum].spawnPoints.length; i++){
				//System.out.println(level.spawnPoints[0].x() + " " + level.spawnPoints[0].y());
				if(player.x == level[levelNum].spawnPoints[i].x() && player.y == level[levelNum].spawnPoints[i].y()&& player.getDir() == level[levelNum].spawnDirections[i]){
					player.go(player.getDir());
					int spl = level[levelNum].arrivalSpawn[i];
					levelNum = level[levelNum].arrivalLevel[i];
					
					player.init(level[levelNum]);
					
					System.out.println(spl);
					player.x = level[levelNum].spawnPoints[spl].x();
					player.y = level[levelNum].spawnPoints[spl].y();
					player.moved = false;
					//System.out.println(level.spawnPoints[0].x() + " in loop " + level.spawnPoints[0].y());
				}
			}
		}
		else if(State == STATE.COMBAT){
			battleScreen.animate();
		}
		/*else{
			player.setPathing(false);
		}*/
		Dialogue.updateText();
	}
	public static void quit(){
		System.exit(0);
	}
	
	public static BattleScreen getBattleScreen(){
		return battleScreen;
	}
	
	public static void enterCombat(){
		State = STATE.COMBAT;
		battleScreen.initBattle(level[levelNum]);
	}
	public static void enterCombat(Combatant[] cb, GameEvent e){
		State = STATE.COMBAT;
		battleScreen.initBattle(level[levelNum],cb, e);
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}

}

package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{
	
	// TILE SETTINGS
	private int originalTileSize = 16;
	private double scale = 3;
	private int tileSize = (int) (originalTileSize*scale);
	// SCREEN SETTINGS
	private final int maxScreenCol = 16;
	private final int maxScreenRow = 12;
	private final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	private final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	// GETTERS
	public int getTileSize() {return tileSize;}
	public int getScreenWidth() {return screenWidth;}
	public int getScreenHeight() {return screenHeight;}
	// GAME STUFF
	private KeyHandler keyH = new KeyHandler(this);
	public KeyHandler checkKeyH() {return keyH;}
	private Player player = new Player(this, keyH);
	public Player getPlayer() {return player;}
	private int FPS = 60;
	Thread gameThread;
	
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {

		double drawInterval = 1000000000 / (FPS);
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			

			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}

		}
	}
	public void update() {
		player.update();
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//draw go here
		player.draw(g2);
		g2.setColor(Color.gray);
		g2.fillRect(0, screenHeight-100, screenWidth, 200);
		
		g2.dispose();	
	}
}
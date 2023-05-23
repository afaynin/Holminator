package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	KeyHandler keyH;
	private final int screenX;
	private final int screenY;


	public int getScreenX() {
		return screenX;
	}

	public int getScreenY() {
		return screenY;
	}


	public Player(GamePanel gp, KeyHandler keyH) {

		super(gp);
		this.keyH = keyH;

		screenX = (gp.getScreenWidth() / 2) - (gp.getTileSize() / 2);
		screenY = (gp.getScreenHeight() / 2) - (gp.getTileSize() / 2);

		// HITBOX SETTINGS
		hitBox = new Rectangle();
		hitBox.x = 8;
		hitBox.y = 16;
		hitBoxDefaultX = hitBox.x;
		hitBoxDefaultY = hitBox.y;
		hitBox.width = 45;
		hitBox.height = 60;

		setDefaultValues();
		// getPlayerImage();

	}

	public void setDefaultValues() {
		worldX(gp.getTileSize() * 42);
		worldY(gp.getTileSize() * 154);
		health = 100;
		speed = 8;
		direction = "down";
		knockback = 100;
	}

	public int worldX(int xcoord) {
		return worldX = xcoord - gp.getTileSize();
	}

	public int worldY(int ycoord) {
		return worldY = ycoord - gp.getTileSize();
	}

	public void draw(Graphics2D g2) {
		g2.setColor(Color.red);
		g2.fillRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
	}

	public void update() {

		if (keyH.checkDownPressed()) {
			hitBox.y += speed;
		}
		
		if (keyH.checkUpPressed()) {
			hitBox.y -= speed;
		} 
		if (keyH.checkRightPressed()) {
			hitBox.x += speed;
		} 
		if (keyH.checkLeftPressed()) {
			hitBox.x -= speed;
		} 
		
		
		if(hitBox.x + hitBox.width < -1) {
			hitBox.x = gp.getScreenWidth();
		}
		if(hitBox.x - hitBox.width > gp.getScreenWidth()) {
			hitBox.x = 0;
		}
		if(hitBox.y + hitBox.height < -1) {
			hitBox.y = gp.getScreenHeight();
		}
		if(hitBox.y - hitBox.height > gp.getScreenHeight()) {
			hitBox.y = 0;
		}
				
	}

	
}
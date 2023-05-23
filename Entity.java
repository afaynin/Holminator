package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
	GamePanel gp;
	protected int worldX, worldY;	
	protected int speed;
	protected int health;
	protected int knockback;
	protected BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, left4, right1, right2, right3, right4;
	protected BufferedImage atk1;
	protected String direction;
	protected int spriteCounter = 0;
	protected int spriteNum = 1;
	protected Rectangle hitBox = new Rectangle(5, 5, 38, 38);//5, 5, 38, 38
	protected int hitBoxDefaultX, hitBoxDefaultY;
	protected boolean collisionOn;
	protected boolean doesDamage;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setAction() {}
	public void doAction() {}
	public void speak() {}
	public void update() {}
	public void draw(Graphics2D g2) {
		
//		BufferedImage image = null;
//		int screenX = worldX - gp.getPlayer().worldX + gp.getPlayer().getScreenX();
//		int screenY = worldY - gp.getPlayer().worldY + gp.getPlayer().getScreenY();
		
		if(worldX + (gp.getTileSize())> gp.getPlayer().worldX - gp.getPlayer().getScreenX() && 
		   worldX - (gp.getTileSize()) < gp.getPlayer().worldX + gp.getPlayer().getScreenX() && 
		   worldY + (gp.getTileSize()) > gp.getPlayer().worldY - gp.getPlayer().getScreenY() && 
		   worldY - (gp.getTileSize()) < gp.getPlayer().worldY + gp.getPlayer().getScreenY()) {

			System.out.println("hfdsjkf");
			
			//draws sprite
			//g2.drawImage(image, screenX, screenY, null);
		}
	}
}
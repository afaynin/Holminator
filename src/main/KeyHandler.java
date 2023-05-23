package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	private GamePanel gp;
	private boolean spacePressed, leftPressed, rightPressed, downPressed, upPressed, jumpMaxed;

	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}	
	public boolean checkSpacePressed() {return spacePressed;}
	public boolean checkLeftPressed() {return leftPressed;}
	public boolean checkRightPressed() {return rightPressed;}
	public boolean checkDownPressed() {return downPressed;}
	public boolean checkUpPressed() {return upPressed;}
	public boolean checkJumpMaxed() {return jumpMaxed;}
	public void setJumpMaxed(boolean a) {jumpMaxed = a;}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();

		if(code == KeyEvent.VK_SPACE) {spacePressed = true;}
		if(code == KeyEvent.VK_A) {leftPressed = true;}
		if(code == KeyEvent.VK_D) {rightPressed = true;}
		if(code == KeyEvent.VK_S) {downPressed = true;}
		if(code == KeyEvent.VK_W) {upPressed = true;}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE) {spacePressed = false; jumpMaxed = true;}
		if(code == KeyEvent.VK_A) {leftPressed = false;}
		if(code == KeyEvent.VK_D) {rightPressed = false;}
		if(code == KeyEvent.VK_S) {downPressed = false;}
		if(code == KeyEvent.VK_W) {upPressed = false;}

	}

}

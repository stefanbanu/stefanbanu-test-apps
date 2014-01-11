package com.stefanbanu1;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

public class Paddle {

	
	int x = 150;
	int y = 450;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 10;
	int xspeed=0;
	Game game;
	
	public Paddle(Game game){
		this.game = game;
	}
	


	public void update(){
		/////moving the paddle
		if (x + xspeed >= 0 && x + xspeed <= game.getWidth() - WIDTH){
		x = x + xspeed;
		}
	}
	public void drawPaddle(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.blue);
		//g2d.fillRect(x, y, WIDTH, HEIGHT);
		g2d.fillRoundRect(x, y, WIDTH, HEIGHT, 20, 20);
		//g2d.draw(getBounds());
	}
	public void keyReleased(KeyEvent e) {
		xspeed = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xspeed = -5;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xspeed = 5;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, WIDTH, HEIGHT);
	}
}

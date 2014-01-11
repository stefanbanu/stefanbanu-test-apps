package com.stefanbanu1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JOptionPane;

import com.stefanbanu2.Sound2;

public class Ball {
	private static final int DIAMETER = 20;
	static int x = 0;
	static int y = 0;
	int xa = 5;
	int ya = 5;
	private Game game;
	private Sound sound;
	public Blocks blocks;
	boolean isrunning = true;

	public Ball(Game game) {
		this.game = game;
		sound = new Sound();
		blocks = new Blocks(0, 0);
	}

	public void move() {
		boolean changeDirection = true;
		

		if (x + xa < 0)
			xa = 5;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -5;
		else if (y + ya < 0)
			ya = 5;
		else if (y + ya > game.getHeight() - DIAMETER) {
			// game.gameOver();
			System.out.println("game over");
			game.lives--;
			sound.droppedSound();
			x = 0;
			y = 0;
			if (game.lives == 0) {
				game.gameOver();
			}

		} else
			changeDirection = false;

		if (changeDirection) {

			sound.playBallSound();
		}
		if (collision()) {
			ya = -5;
			sound.playBallSound();

			// y = game.racquet.getTopY() - DIAMETER;
		}
		
	
			x += xa;
			y +=  ya;

	}

	private boolean collision() {
		return game.paddle.getBounds().intersects(getBounds());
	}


	public void drawBall(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.red);
		g2d.fillOval(x, y, DIAMETER, DIAMETER);
		// g2d.draw(getBounds());

	}

	public static Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}

}
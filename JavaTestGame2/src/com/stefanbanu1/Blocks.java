package com.stefanbanu1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Blocks {

	int x, y, width = 64, height = 16;
	int widthCircle = 35;
	int heightCircle = 35;
	Ball ball;
	Game game;
	Sound sound;
	Random rand = new Random();
	int red = rand.nextInt(255);
	int green = rand.nextInt(255);
	int blue = rand.nextInt(255);
	Color randomColour = new Color(red, green, blue);

	public Blocks(int x, int y) {
		this.x = x;
		this.y = y;

		sound = new Sound();
	}

	public void update() {
		checkCollision();

	}

	public void drawBlocks(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(randomColour);
		g2d.fillRect(x, y, width, height);
		// g2d.fillOval(x, y, widthCircle, heightCircle);
		g2d.setColor(Color.black);
		g2d.draw(getBounds());
	}

	public void checkCollision() {
		LinkedList<Blocks> b = Game.getBlockslist();

		for (int i = 0; i < b.size(); i++) {
			Blocks br = b.get(i);

			if (Ball.getBounds().intersects(br.getBounds())) {
			
				Game.score += 100;
				sound.blockSound();
				System.out.println("ball hited");
				

				Game.getBlockslist().remove(br);
				
				// listSize++;
				// System.out.println("listsizeis : " + listSize);
				// /////////////////////////////////////////////////
				// if(listSize == 3 ){
				// JOptionPane.showMessageDialog(game, "You win", "Congrats ",
				// JOptionPane.YES_OPTION);
				// }

			}

		}
	}

	private boolean collisionBlocksBall() {
		return Ball.getBounds().intersects(getBounds());
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
}

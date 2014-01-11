package com.stefanbanu1;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JOptionPane;

//import com.stefanbanu1.src.controller.Controller;
//import com.stefanbanu1.src.enemy.Textures;
//import com.stefanbanu1.src.images.BufferedImageLoader;
//import com.stefanbanu1.src.interfaces.EntityA;
//import com.stefanbanu1.src.interfaces.EntityB;
//import com.stefanbanu1.src.player.Bullet;
//import com.stefanbanu1.src.player.KeyInput;
//import com.stefanbanu1.src.player.Player;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static LinkedList<Blocks> blockList = new LinkedList<Blocks>();
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static int lives = 3;
	public static int score = 0;

	private boolean running = false;
	private Thread thread;

	public Paddle paddle;
	public Ball ball;
	private Sound sound;

	 Blocks blocks;

	 private String[] level = { "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............b...b...........",
	 ".......b...b.....b...b........",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 "..............................",
	 ".............................." };

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	public Game() {
		// setFocusable(true);

	}

	public void init() {
		requestFocus();
		
		paddle = new Paddle(this);
		ball = new Ball(this);
		sound = new Sound();
		
		sound.playBgMusic();

		 blocks = new Blocks(0, 0);

		 for (int y = 0; y < level.length; y++) {
		 for (int x = 0; x < level[y].length(); x++) {
		 if (level[y].charAt(x) == 'b')
		 blockList.add(new Blocks(x * 16, y * 16));
		
		 }
		
		 }
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				paddle.keyReleased(e);

			}

			@Override
			public void keyPressed(KeyEvent e) {
				paddle.keyPressed(e);

			}
		});

	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if (!running)
			return;

		running = false;

		try {
			thread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.exit(1);
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

	// update
	private void tick() {
		paddle.update();
		ball.move();
		blocks.update();

	}

	// ////////////////////////////////// rendering
	private void render() {

		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			// System.out.println(bs);
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		// / drawing
		// /////////////////////////////////////

		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.gray);
		g.fillRect(0, 0, 800, 800);

		// g.drawImage(bg, 0, 0, null);

		// for (int i = 0; i < bList.size(); i++) {
		// Bricks brick = bList.get(i);
		// brick.drawBricks(g);
		// }

		paddle.drawPaddle(g);
		ball.drawBall(g);

		g.setColor(Color.white);
		g.drawString("SCORE: " + score, 10, 20);

		g.setColor(Color.white);
		g.drawString("LIVES: " + lives, 590, 20);

		 for (Blocks b : blockList) {
		 b.drawBlocks(g);
		 }

		// ////////////////////////////////////
		g.dispose();
		bs.show();
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		Game.score = score;
	}

	public void gameOver() {
		// Sound.BACKMUSIC.stop();
		// Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this,
				"your score is: " + Game.getScore(), "Game Over",
				JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	 public static LinkedList<Blocks> getBlockslist() {
	 return blockList;
	 }

	 public void removeBlocks(Blocks b) {
	 blockList.remove(b);
	 }
}

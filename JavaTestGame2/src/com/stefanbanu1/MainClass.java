package com.stefanbanu1;


import java.awt.Dimension;

import javax.swing.JFrame;



public class MainClass {

	public static void main(String[] args) {
		Game game = new Game();
		
		
		
		game.setPreferredSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		game.setMaximumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		game.setMinimumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Testing Game");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		frame.setResizable(false);
		
		
		game.start();
		
	}
}

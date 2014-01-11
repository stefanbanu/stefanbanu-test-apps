package com.stefanbanu2;

import java.applet.Applet;
import java.applet.AudioClip;



public class Sound2 {

	private AudioClip clip;
	
	public static final Sound2 sound1 = new Sound2("/ballmusic.wav");
	//public static final Sound2 GAMEOVER =new Sound2("/gameover.wav");
	public static final Sound2 BACKMUSIC = new Sound2("/bgsong.wav");
	
	public Sound2(String filename) {
		try {
			clip =Applet.newAudioClip(Sound2.class.getResource(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void play(){
		try {
			new Thread(){
				public void run() {
					clip.play();
				};
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loop(){
		try {
			new Thread(){
				public void run() {
					clip.loop();
				};
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

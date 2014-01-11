package com.stefanbanu1;


import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Sound {
	//public static final URL BALL = Sound.class.getResource("ballmusic.wav");
	//public static final URL gameover = Sound.class.getResource("bgsong.wav");
	//public static final URL BGSONG = Sound.class.getResource("bgsong.wav");
	
	
	public  void playBgMusic(){
   
		      try {
		         // Open an audio input stream.
		         URL url = this.getClass().getClassLoader().getResource("bgsong.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		         // Get a sound clip resource.
		         Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		        clip.loop(Clip.LOOP_CONTINUOUSLY);
		      
		         final FloatControl control = (FloatControl) 
		                 clip.getControl(FloatControl.Type.MASTER_GAIN);
		         control.setValue(-30.0f);

		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
		   }
	public void playBallSound(){
		   try {
		         // Open an audio input stream.
		         URL url = this.getClass().getClassLoader().getResource("ballmusic.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		         // Get a sound clip resource.
		         Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		        clip.start();
		      
		         final FloatControl control = (FloatControl) 
		                 clip.getControl(FloatControl.Type.MASTER_GAIN);
		         control.setValue(-10.0f);

		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
	}
	public void droppedSound(){
		   try {
		         // Open an audio input stream.
		         URL url = this.getClass().getClassLoader().getResource("dropped.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		         // Get a sound clip resource.
		         Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		        clip.start();
		      
		         final FloatControl control = (FloatControl) 
		                 clip.getControl(FloatControl.Type.MASTER_GAIN);
		         control.setValue(-20.0f);

		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
	}
	public void blockSound(){
		   try {
		         // Open an audio input stream.
		         URL url = this.getClass().getClassLoader().getResource("pickup.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		         // Get a sound clip resource.
		         Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		        clip.start();
		      
		         final FloatControl control = (FloatControl) 
		                 clip.getControl(FloatControl.Type.MASTER_GAIN);
		         control.setValue(-20.0f);

		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
	}
}
package com.stefanbanu2;
import java.io.*;
import java.net.URL;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundClipTest extends JFrame {

	private static final long serialVersionUID = 1L;

// Constructor
   public SoundClipTest() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("Test Sound Clip");
      this.setSize(300, 200);
      this.setVisible(true);
   
      try {
         // Open an audio input stream.
         URL url = this.getClass().getClassLoader().getResource("bgsong.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
         final FloatControl control = (FloatControl) 
                 clip.getControl(FloatControl.Type.MASTER_GAIN);
         control.setValue(-30.0f);

//         final JSlider volume = new JSlider(
//                 JSlider.HORIZONTAL,
//                 (int) control.getMinimum(),
//                 (int) control.getMaximum(),
//                 (int) control.getValue());
//         volume.addChangeListener(new ChangeListener() {
//
//             public void stateChanged(ChangeEvent ce) {
//                 control.setValue(volume.getValue());
//             }
//         });
//
//         JOptionPane.showMessageDialog(null, volume);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
   public static void main(String[] args) {
      new SoundClipTest();
   }
}
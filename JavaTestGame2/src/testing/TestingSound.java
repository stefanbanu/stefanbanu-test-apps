package testing;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


public class TestingSound extends JFrame {
	
	public TestingSound() {
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

//		         final JSlider volume = new JSlider(
//		                 JSlider.HORIZONTAL,
//		                 (int) control.getMinimum(),
//		                 (int) control.getMaximum(),
//		                 (int) control.getValue());
//		         volume.addChangeListener(new ChangeListener() {
		//
//		             public void stateChanged(ChangeEvent ce) {
//		                 control.setValue(volume.getValue());
//		             }
//		         });
		//
//		         JOptionPane.showMessageDialog(null, volume);
		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
		   }
	

	public static void main(String[] args) {
		new TestingSound();

	}

}

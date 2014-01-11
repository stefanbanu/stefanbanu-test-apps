package com.stefanbanu2;
import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;
import javax.sound.sampled.*;

class ClipVolume {

    public static void main(String[] args) throws Exception {
        URL url = new URL("");
        final Clip clip = AudioSystem.getClip();
        // getAudioInputStream() also accepts a File or InputStream
        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        Runnable r = new Runnable() {

            @Override
            public void run() {
                final FloatControl control = (FloatControl) 
                        clip.getControl(FloatControl.Type.MASTER_GAIN);

                final JSlider volume = new JSlider(
                        JSlider.HORIZONTAL,
                        (int) control.getMinimum(),
                        (int) control.getMaximum(),
                        (int) control.getValue());
                volume.addChangeListener(new ChangeListener() {

                    public void stateChanged(ChangeEvent ce) {
                        control.setValue(volume.getValue());
                    }
                });

                JOptionPane.showMessageDialog(null, volume);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}
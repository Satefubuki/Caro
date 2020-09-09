package Model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	public static boolean sound;
	public static String soundName;
	static AudioInputStream audioInputStream;
	public static Clip clip ;
	Constant cons = new Constant();
	public static String songName = "music.wav";
	public static boolean isSound() {
		return sound;
	}

	public static void playSound(String soundName) {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	public static void playSound1(String soundName) {

		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			clip.loop(Integer.MAX_VALUE);

			
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	public static void on() {
		sound=true;
		playSound1(songName);
	}
	public static void off() {
		sound=false;
		clip.close();
		
	}
}

package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.MyModel;
import View.Music;

public class SoundControl implements ActionListener {
	MyModel model;

	public SoundControl() {
		// TODO Auto-generated constructor stub
		Music.on.addActionListener(this);
		Music.off.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == Music.on) {
			model.sound.on();
		}
		if (e.getSource() == Music.off) {
			model.sound.off();
		}
	}

}

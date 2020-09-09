package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Music {
	private static Music music ;
	JFrame frame = new JFrame();
	JPanel songPanel = new JPanel();
	JPanel soundPanel = new JPanel();
	JPanel panel = new JPanel();
	public static JRadioButton on = new JRadioButton();
	public static JRadioButton off = new JRadioButton();
	ButtonGroup g1 = new ButtonGroup();
	ButtonGroup g2  = new ButtonGroup();
	JLabel l1 = new JLabel("Music 1");
	JLabel l2 = new JLabel("Music 2");
	JLabel l3 = new JLabel("Music 3");
	JLabel sOn = new JLabel("On");
	JLabel sOf = new JLabel("Off");
	JLabel lb = new JLabel(MyView.load("image/miku.png", 200, 200));
	private Music(){
		frame.setLayout(new GridLayout(2, 1));
		frame.add(songPanel);
		frame.add(soundPanel);
		soundPanel.setBorder(BorderFactory.createTitledBorder("Sound"));
		songPanel.add(lb);
		soundPanel.add(on);
		soundPanel.add(sOn);
		soundPanel.add(off);
		soundPanel.add(sOf);
		g2.add(on);
		g2.add(off);
		on.setSelected(true);
		soundPanel.setLayout(new GridLayout());

		
		frame.setVisible(true);
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setLocationRelativeTo(null);

			
	}
	public static Music createStructure() {
		if(music == null){
		music = new Music();
	}
		music.frame.show();
		music.frame.setLocationRelativeTo(null);
		return music;
	}
	
}

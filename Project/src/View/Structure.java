package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Structure {
	private static Structure strucFrame ;
	JFrame frame = new JFrame();
	private Structure(){
		// TODO Auto-generated constructor stub
		frame.setTitle("Structure");
		frame.setVisible(true);
		frame.setSize(905, 430);
		JLabel lb = new JLabel(MyView.load("image/mkStruc.png", 900, 500));
		lb.setSize(900, 500);
		frame.add(lb);
		frame.setResizable(false);
	//	ImageIcon icon = new ImageIcon("image/mkStruc.png");
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		//lb.setIcon(icon);

	}
	public static Structure createStructure() {
		if(strucFrame == null){
		strucFrame = new Structure();
	}
		strucFrame.frame.show();
		strucFrame.frame.setLocationRelativeTo(null);
		return strucFrame;
	}
	public static void main(String[] args) {
		new Structure();
	}
}

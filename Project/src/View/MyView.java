package View;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Control.MyControl;
import Model.Constant;
import Model.MyModel;



public class MyView {
	public static JFrame fh = new JFrame();
	

	public HomePanel panel = new HomePanel(new ImageIcon("image/background2.png"));
	public JLabel out = new JLabel(load("image/nor.png", 60, 60));
	public JLabel human = new JLabel(load("image/human.png", 270, 270));
	public JLabel comp = new JLabel(load("image/comp.png", 240, 240));
	public JLabel struc = new JLabel(load("image/structure.png", 170, 170));
	public JLabel music = new JLabel(load("image/music.png", 170, 170));
	MyControl con;
	Constant cons = new Constant();
	
	Image img;
	
	public MyView() {
		MyModel.sound.on();
		panel.setCursor(cons.cursor1);
		//FrameStart.playSound("menu.wav");
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.add(out);
		
	//	out.addMouseListener(EventHandling);
		out.setBounds(800, 580, 60, 60);
//		panel.add(newGame);
//		newGame.setBounds(240, 250, 250, 250);
	//	newGame.addMouseListener(EventHandling);
		panel.add(human);
		human.setBounds(80, 260, 240, 240);
		//structure.addMouseListener(EventHandling);
		panel.add(struc);
		struc.setBounds(600, 490, 170, 170);
	//	about.addMouseListener(EventHandling);
		panel.add(comp);
		comp.setBounds(350, 280, 270, 270);
		//highScore.addMouseListener(EventHandling);
		panel.add(music);
		music.setBounds(230, 490, 170, 170);
		 fh.add(panel);
		 fh.setBounds(10, 10, 900, 700);
		 fh.setBackground(Color.BLACK);
		 fh.setTitle("Caro");
		 fh.setDefaultCloseOperation( fh.EXIT_ON_CLOSE);
		 fh.setResizable(false);
		// fh.requestFocus();
		// Place frame in the middle of the screen
		 fh.setLocationRelativeTo(null);
		 fh.setVisible(true);
		
	}

	 class HomePanel extends JPanel {
		private ImageIcon mi;

		public HomePanel(ImageIcon mi) {
			this.mi = mi;

		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(mi.getImage(), 0, 0, 900, 700, this);
		}
	}

	 public static Icon load(String linkImage, int k, int m) {/*linkImage lÃ  tÃªn icon, k kÃ­ch thÆ°á»›c chiá»�u rá»™ng mÃ¬nh muá»‘n,m chiá»�u dÃ i vÃ  hÃ m nÃ y tráº£ vá»� giÃ¡ trá»‹ lÃ  1 icon.*/
		    try {
		        BufferedImage image = ImageIO.read(new File(linkImage));
		 
		        int x = k;
		        int y = m;
		        int ix = image.getWidth();
		        int iy = image.getHeight();
		        int dx = 0, dy = 0;
		 
		        if (x / y > ix / iy) {
		            dy = y;
		            dx = dy * ix / iy;
		        } else {
		            dx = x;
		            dy = dx * iy / ix;
		        }
		 
		        return new ImageIcon(image.getScaledInstance(dx, dy,
		                image.SCALE_SMOOTH));
		 
		    } catch (IOException e) {
		 
		        e.printStackTrace();
		    }
		    return null;
		}
	public static void exit() {

		//String[] exit = { "Yes", "No" };
		ImageIcon icon = new ImageIcon("image/mikuop.png");
		int question = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION, icon);
		if (question == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	

}
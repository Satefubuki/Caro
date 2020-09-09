package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Constant;
import Model.Game;
import Model.MyModel;

public class Program {
	private static Program proFrame ;
	JFrame frame = new JFrame();
	public static Game game = new Game();
	Constant cons = new Constant();
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JButton but = new JButton("OK");
	public static JLabel exit = new JLabel(MyView.load("image/exit.png", 30, 30));
	public static JLabel book = new JLabel(MyView.load("image/book.png", 30, 30));
	public static JLabel sound = new JLabel(MyView.load("image/sound1.png", 30, 30));

	HomePanel gamePanel = new HomePanel(new ImageIcon("image/board1.png"));
	private Program(){
	
		// TODO Auto-generated constructor stub
		frame.setTitle("Game");
		frame.setBackground(Color.black);
		frame.setVisible(true);
		frame.setSize(900, 700);
		frame.add(panel);
		panel.setLayout(new BorderLayout());
		panel.add(panel1, BorderLayout.NORTH);
		panel1.setBackground(Color.WHITE);
		panel1.setLayout(new BorderLayout());
		panel1.add(exit, BorderLayout.WEST);
		panel1.add(book, BorderLayout.CENTER);
		panel1.add(sound, BorderLayout.EAST);
		
		panel.add(gamePanel, BorderLayout.CENTER);
		
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		GridBagLayout bag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gamePanel.setLayout(bag);
		
		gamePanel.add(game);
//		frame.add(panel);
//		panel.setLayout(bag);
//		gbc.fill = GridBagConstraints.HORIZONTAL;
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		panel.add(game);
//		panel.setBackground(Color.YELLOW);
//		
//		
//		gbc.weighty = 30;
//		gbc.insets = new Insets(00, 10, 10, 50);
//
//		panel.add(panel1);
//		gbc.gridx = 0;
//		gbc.gridy = 1;gbc.weightx = 30;
//		gbc.insets = new Insets(00, 50, 50, 10);
		//panel1.setLayout(new FlowLayout(1, 30, 30));
		//panel1.add(new JLabel(MyView.load("image/tenor.gif", 300, 300)), BorderLayout.CENTER);
		frame.setResizable(false);
	//	ImageIcon icon = new ImageIcon("image/mkStruc.png");
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		//lb.setIcon(icon);

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
	 public void exit(){
		 proFrame.exit();
	 }
	public static Program createProgram() {
		if(proFrame == null){
			proFrame = new Program();
	}
		proFrame.frame.show();
		proFrame.frame.setLocationRelativeTo(null);
		return proFrame;
	}
	
}
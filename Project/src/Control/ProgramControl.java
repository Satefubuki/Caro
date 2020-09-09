package Control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Game;
import Model.MyModel;
import View.MyView;
import View.Program;
import View.Structure;

public class ProgramControl implements MouseListener{
	
	Structure struc;
	static boolean on = true;
	public ProgramControl() {
		// TODO Auto-generated constructor stub
		Program.book.addMouseListener(this);
		Program.exit.addMouseListener(this);
		Program.sound.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Program.book) {
			Program.book.setIcon(MyView.load("image/book1.png", 30, 30));
		}
		if (e.getSource() == Program.exit) {
			Program.exit.setIcon(MyView.load("image/exit1.png", 30, 30));
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Program.book) {
			Program.book.setIcon(MyView.load("image/book.png", 30, 30));
		}
		if (e.getSource() == Program.exit) {
			Program.exit.setIcon(MyView.load("image/exit.png", 30, 30));
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Program.book) {
			// home.about.setIcon(Option.load("about2.png", 170, 170));
			struc.createStructure();
		}
		if (e.getSource() == Program.exit) {
			Program.game.start();
		}
		if (e.getSource() == Program.sound) {
			if(MyModel.sound.sound == true){
				MyModel.sound.off();
				Program.sound.setIcon(MyView.load("image/sound.png", 30, 30));
			}else{
				MyModel.sound.on();
				Program.sound.setIcon(MyView.load("image/sound1.png", 30, 30));
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

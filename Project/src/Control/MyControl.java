package Control;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Model.Constant;
import Model.Game;
import Model.MyModel;
import View.Program;
import View.Music;
import View.MyView;
import View.Structure;


public class MyControl implements MouseListener {
	MyView view;
	MyModel model;
	Structure struc;
	Program pro;
	
	Music music;
	SoundControl sc;
	ProgramControl pc;
	Constant cons = new Constant();
	public MyControl(MyModel model, MyView view) {
		this.view = view;
		this.model = model;
		sc = new SoundControl();
		pc = new ProgramControl();
		view.music.addMouseListener(this);
		view.comp.addMouseListener(this);
		view.human.addMouseListener(this);
		view.struc.addMouseListener(this);
		view.out.addMouseListener(this);
	
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// out.setIcon(Option.load("nor.png", 60, 60));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == view.out) {
			view.out.setIcon(MyView.load("image/press.png", 60, 60));
			MyView.exit();
		}
		
		if (e.getSource() == view.human) {
			// home.structure.setIcon(Option.load("structure2.png", 170, 170));
			Constant.mode = "human";
			Program.game.start();
			pro.createProgram();
		}
		if (e.getSource() == view.music) {
			// home.option.setIcon(Option.load("option2.png", 170, 170));
			music.createStructure();
		}
		if (e.getSource() == view.comp) {
			// home.highScore.setIcon(Option.load("highscore2.png", 170, 170));
			Constant.mode = "com";
			Program.game.start();

			pro.createProgram();
			
		}
		if (e.getSource() == view.struc) {
			// home.about.setIcon(Option.load("about2.png", 170, 170));
			struc.createStructure();
		}
		
	}


	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == view.out) {
			view.out.setIcon(MyView.load("image/nor.png", 60, 60));
		}
		
		if (e.getSource() == view.human) {
			view.human.setIcon(MyView
					.load("image/human.png", 270, 270));
		}
		if (e.getSource() == view.music) {
			view.music.setIcon(MyView.load("image/music.png", 170, 170));
		}
		if (e.getSource() == view.comp) {
			view.comp.setIcon(MyView
					.load("image/comp.png", 240, 240));
		}
		if (e.getSource() == view.struc) {
			view.struc.setIcon(MyView.load("image/structure.png", 170, 170));
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == view.out) {
			view.out.setIcon(MyView.load("image/move.png", 60, 60));
			view.out.setCursor(cons.hover);
		}
		
		if (e.getSource() == view.human) {
			view.human.setIcon(MyView.load("image/human1.png", 270, 270));
			view.human.setCursor(cons.hover);
		}
		if (e.getSource() == view.music) {
			view.music.setIcon(MyView.load("image/music1.png", 170, 170));
			view.music.setCursor(cons.hover);
		}
		if (e.getSource() == view.comp) {
			view.comp.setIcon(MyView
					.load("image/comp1.png", 240, 240));
			view.comp.setCursor(cons.hover);
		}
		if (e.getSource() == view.struc) {
			view.struc.setIcon(MyView.load("image/structure1.png", 170, 170));
			view.struc.setCursor(cons.hover);
		}
		if (e.getSource() == pro.book) {
			view.struc.setIcon(MyView.load("image/book1.png", 30, 30));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}
	
	private void newStructure() {
		// TODO Auto-generated method stub
//		Structure structure;
//		Structure.createStructure();
	}
	private void newOption() {
	//	Option.createOption();
		
	}
	private void newHigh() {
//		new HighScore();
//		view.fh.dispose();
	}
	
}
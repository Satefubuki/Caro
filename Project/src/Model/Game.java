package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Game extends JPanel {
	Constant cons = new Constant();
	public ArrayList<Point> vec;
	Position posi;
	Board field;
	boolean isWin = false;
	Point point, p, p1;
	Image img;
	public Point com;

	public Game() {
		// TODO Auto-generated constructor stub
		setCursor(cons.cursor);
		setPreferredSize(new Dimension(cons.width, cons.height));
		start();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				p = convertPoint(e.getPoint());
				p1 = convertPointToMaxtrix(p);

				posi = new Position((int) p1.getX(), (int) p1.getY());
				if (field.turn) {
					setCursor(cons.cursorX);
				} else {
					// field.o.move();
					setCursor(cons.cursorO);
				}
				if (cons.mode.equals("com")) {
					if (field.play(null, posi)) {
						// if (field.turn == true) {
						vec.add(p);
						field.play(null, posi);
						// if (field.isWin == true) {
						// start();
						// } else {
						// if(field.turn == false){

						Position cp = field.o.move();
						if (field.play(null, cp)) {
							com = field.convertMatrixToPoint(cp);
							vec.add(com);
							field.play(null, cp);
							// }
						}
					}
				}
				if (cons.mode.equals("human")) {
					if (field.play(null, posi)) {

						vec.add(p);

						field.play(null, posi);
					}
				}
				// }

				// }
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				setCursor(cons.cursor);
			}

		});

	}

	// start game
	public void start() {
		// TODO Auto-generated method stub
		field = new Board();
		field.field = new int[cons.size][cons.size];
		vec = new ArrayList<Point>();
		// repaint();

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		setBackground(Color.WHITE);
		// g.drawImage(cons.board, 0, 0, null);
		for (int i = 0; i <= cons.size; i++) {
			g.drawLine(i * cons.sizeCell, 0, i * cons.sizeCell, cons.height - 1);
			g.drawLine(0, i * cons.sizeCell, cons.width - 1, i * cons.sizeCell);
		}

		drawChess(g);

	}

	// draw X O
	private void drawChess(Graphics g) {
		// TODO Auto-generated method stub
		if (cons.mode.equals("com")) {
			boolean player = cons.firstTurn;
			for (int i = 0; i < vec.size(); i  = i+2) {
				// img = player ? cons.chessX : cons.chessO;
				img = cons.chessX;
				point = convertPointToCaro(convertPoint(vec.get(i)));
				Point point2 = convertPointToCaro(convertPoint(vec.get(i + 1)));
				//if (!field.isWin) {
					// if(cons.mode.equals("2vs2")){
					Image img1 = resizeImg(img, cons.imgSize, cons.imgSize);
					g.drawImage(img1, point.x + cons.sizeCell / 2 + 3, point.y + cons.sizeCell / 2 + 3, null);
					img = cons.chessO;
					img1 = resizeImg(img, cons.imgSize, cons.imgSize);
					g.drawImage(img1, point2.x + cons.sizeCell / 2 + 3, point2.y + cons.sizeCell / 2 + 3, null);
					// player = !player;
					// }
					// else if(cons.mode.equals("com")){
					// Image img1 = resizeImg(img, cons.imgSize, cons.imgSize);
					// g.drawImage(img1, point.x + cons.sizeCell / 2 + 3,
					// point.y + cons.sizeCell / 2 + 3, null);
					// point = convertPointToCaro(com);
					// g.drawImage(img1, point.x + cons.sizeCell / 2 + 3,
					// point.y + cons.sizeCell / 2 + 3, null);
					// }
				}
				if (field.isWin) {
					start();
				}
			}
			repaint();
		//}
		if (cons.mode.equals("human")) {
			boolean player = cons.firstTurn;

			for (int i = 0; i < vec.size(); i++) {
				Image img = player ? cons.chessX : cons.chessO;

				Point point = convertPointToCaro(convertPoint(vec.get(i)));
				Point point1 = convertPointToMaxtrix(convertPoint(vec.get(i)));
				Position pos = new Position((int) point.getX(), (int) point.getX());

				if (!field.isWin) {
					g.drawImage(resizeImg(img, cons.imgSize, cons.imgSize), point.x + cons.sizeCell / 2 + 3,
							point.y + cons.sizeCell / 2 + 3, null);

					player = !player;
				}
				if (field.isWin) {
					start();
				}
			}

			repaint();
		}

	}

	// Minimizing the image's size
	public Image resizeImg(Image img, int width, int height) {
		img = new ImageIcon(img.getScaledInstance(width, height, img.SCALE_SMOOTH)).getImage();
		return img;
	}

	private Point convertPoint(Point point) {
		int x, y;
		int deviation = 1;
		x = (point.x % cons.sizeCell > deviation) ? (point.x / cons.sizeCell * cons.sizeCell + cons.sizeCell / 2)
				: (point.x / cons.sizeCell * cons.sizeCell - cons.sizeCell / 2);
		y = (point.y % cons.sizeCell > deviation) ? (point.y / cons.sizeCell * cons.sizeCell + cons.sizeCell / 2)
				: (point.y / cons.sizeCell * cons.sizeCell - cons.sizeCell / 2);
		return new Point(x, y);
	}

	// convert point to the index of array
	private Point convertPointToMaxtrix(Point point) {
		return new Point(point.y / cons.sizeCell, point.x / cons.sizeCell);
	}

	// convert point to draw chess on the field in concordant way
	private Point convertPointToCaro(Point point) {
		return new Point(point.x - cons.sizeCell - 2 / 2, point.y - cons.sizeCell - 2 / 2);
	}
}

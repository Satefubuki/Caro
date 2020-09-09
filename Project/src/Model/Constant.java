package Model;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Constant {
	public final int frameW = 500;
	public final int frameH = 500;

	public static final int size = 19;
	public static String mode = "human";
	
	public final int sizeCell = frameH / size;
	public final int imgSize = sizeCell - 3;
	public final int width = size * sizeCell;
	public final int height = size * sizeCell;
	public final boolean firstTurn = true;
	public static String soundName = "menu.wav";
	public final Image chessO = new ImageIcon("image/O.png").getImage();
	public final Image chessX = new ImageIcon("image/X.png").getImage();
	public final Image board = Toolkit.getDefaultToolkit().createImage("image/board.png");
	public final Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("image/pen.png").getImage(),
			new Point(10, 25), "custom cursor");
	public final Cursor cursor1 = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("image/cusor.png").getImage(),
			new Point(10, 25), "custom cursor");
	public final Cursor hover = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("image/cusor1.png").getImage(),
			new Point(10, 25), "custom cursor");
	public final Cursor cursorX = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("image/penX.png").getImage(),
			new Point(10, 25), "X cursor");
	public final Cursor cursorO = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("image/penO.png").getImage(),
			new Point(10, 25), "O cursor");
	public final Image pig = Toolkit.getDefaultToolkit().createImage("image/pig.png");
	public int player = 0;

	
}

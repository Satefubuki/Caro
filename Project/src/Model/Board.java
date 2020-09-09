package Model;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Board {
	Constant cons = new Constant();
	//Evaluate e = new Evaluate();
	public int[][] field = new int[cons.size][cons.size];
	public Player x = new Player1(this);
	public Player o = new Player2(this);
	int quantity;
	public boolean turn = cons.firstTurn;
	boolean isWin = false;
	int[][] sub = null;
	Position currentMove = new Position();
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	

	public void setTurn(boolean turn) {
		this.turn = turn;
	}


	public boolean getTurn() {
		return turn;
	}
	public int[][] getSub() {
		return sub;
	}



	public Board(int[][] field, Player x, Player o, int size, int quantity, Player turn) {
		field = new int[cons.size][cons.size];
		this.x = x;
		this.o = o;
		this.quantity = quantity;

	}

	public boolean isValid(Player c, Position vt) {
		if (field[vt.x][vt.y] == 0 || vt.x > cons.size || vt.y > cons.size)
			return true;
		if (vt.x > cons.size || vt.y > cons.size) {
			return false;
		}
		return false;
	}

	// public boolean isOver(int[][] matrix, Position p) {
	// if (isWinRow(p)) {
	// return true;
	// }
	// if (isWinCol(p)) {
	// return true;
	// }
	// if (isWinDiagonalOne(p)) {
	// return true;
	// }
	// if (isWinDiagonalTwo(p)) {
	// return true;
	// }
	// return false;
	//
	// }
	public boolean isOver(int[][] matrix, Position p) {
		sub = subArr(p);
		if (isWinRow(sub, p)) {
			return true;
		}
		if (isWinCol(sub, p)) {
			return true;
		}
		if (isWinDiagonalOne(sub, p)) {
			return true;
		}
		if (isWinDiagonalTwo(sub, p)) {
			return true;
		}
		sub = null;
		System.gc();
		return false;

	}

	// tao mang con voi vi tri quan co moi danh o chinh giua
	private synchronized int[][] subArr(Position p) {
		p = currentMove;
		int[][] newArr = new int[9][9];
		int m = 0, n = 0;
		for (int i = p.x - 4; i <= p.x + 4; i++) {
			for (int j = p.y - 4; j <= p.y + 4; j++) {
				if (i > field.length - 1 || j > field.length - 1 || i < 0 || j < 0) {
					newArr[m][n] = 4;
				} else {
					newArr[m][n] = field[i][j];
				}

				n++;
				if (j == p.y + 4) {
					n = 0;
				}

			}
			m++;
		}
		return newArr;
	}

	// kiem tra duong cheo thu 1
	private boolean isWinDiagonalOne(int[][] arr, Position p) {
		// TODO Auto-generated method stub
		int count = 0;
		int flag = 0;
		int k = field[p.x][p.y];
		for (int i = 0; i < arr.length; i++) {

			if (arr[i][i] == k && arr[i][i] != 0) {
				count++;
			} else {
				count = 0;
			}

			if (count > flag) {
				flag = count;

			}

		}

		return flag == 5;
	}

	// kiem tra duong cheo thu 2
	private boolean isWinDiagonalTwo(int[][] arr, Position p) {
		// TODO Auto-generated method stub
		int m = arr.length - 1;
		int count = 0;
		int flag = 0;
		int k = field[p.x][p.y];
		for (int i = 0; i < arr.length; i++) {

			if (arr[m][i] == k && arr[m][i] != 0) {
				count++;
			} else {
				count = 0;
			}
			m--;
			if (count > flag) {
				flag = count;

			}

		}

		return flag == 5;
	}

	// kiem tra cot
	private boolean isWinCol(int[][] arr, Position p) {
		// TODO Auto-generated method stub
		int count = 0;
		int flag = 0;
		int k = field[p.x][p.y];
		for (int i = 0; i < arr[0].length; i++) {

			if (arr[i][4] == k && arr[i][4] != 0) {
				count++;
			} else {
				count = 0;
			}

			if (count > flag) {
				flag = count;

			}

		}

		return flag == 5;
	}

	// kiem tra hang
	private boolean isWinRow(int[][] arr, Position p) {
		// TODO Auto-generated method stub
		int count = 0;
		int flag = 0;
		int k = field[p.x][p.y];
		for (int i = 0; i < arr[0].length; i++) {

			if (arr[4][i] == k && arr[4][i] != 0) {
				count++;
			} else {
				count = 0;
			}

			if (count > flag) {
				flag = count;
			}

		}

		return flag == 5;
	}

	// danh co 
	public boolean play(Player c, Position p) {
		this.currentMove = p;
		System.out.println("current move: " + currentMove.x +"," +currentMove.y);
		
		if (isValid(c, currentMove)) {
			this.field[p.x][p.y] = (turn) ? o.value : x.value;
			changePlayer();
			update(field);

			return true;

		} 
if (isOver(field, currentMove)) {
	if(cons.mode.equals("com")){
		ImageIcon icon = new ImageIcon("image/sad.png");
		if(checkPlayer().equals("Computer")){
			icon = new ImageIcon("image/haha.png");
		}
		JOptionPane.showMessageDialog(null, checkPlayer() + " Win","Notify", 0, icon);
	}
			isWin = true;
			return false;

		}else {

			// System.out.println("Invalid");
			return false;
		}

	}
	public Point convertMatrixToPoint(Position pos){
		return new Point((pos.y)*cons.sizeCell + 20, 
				(pos.x) * cons.sizeCell +20);
	}
	// doi luot choi
	private void changePlayer() {
		// TODO Auto-generated method stub
		if (turn == o.turn) {
			turn = x.turn;
		} else {
			turn = o.turn;
		}
	}

	// kiem tra luot cua nguoi choi
	private String checkPlayer() {
		if(cons.mode.equals("human")){
		return (turn == x.turn) ? x.name : o.name;
		}
		if(cons.mode.equals("com")){
			return (turn == x.turn) ? "Computer" : "Player";
			}
		return "Computer";
	}
	public int[][] getField() {
		return field;
	}


	public Position getCurrentMove(){
		return this.currentMove;
	}
	public void setPosition(int x, int y, int value){
		
	}
	// cai nay thi ko can :/
	private void update(int[][] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");

	}
	public Set<Position> getAvailableMoves(){
		Set<Position> res = new HashSet<>();
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				if(field[i][j] ==0){
					Position p = new Position(i, j);
					res.add(p);
				}
			}
		}
		return res;
	}
	public int[][] fieldCopy(){
		int[][] res = new int[field.length][field.length];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
			res[i][j] = field[i][j];
			}
		}
		return res;
	}
	public Board getCopy(){
		Board res = new Board();
		for (int i = 0; i < field.length; i++) {
			res.field[i] = this.field[i].clone();
		}
		res.currentMove = this.currentMove;
		res.sub = this.sub;
		res.turn = this.turn;
		res.o = this.o;
		res.x = this.x;
		
		return res;
	}
}

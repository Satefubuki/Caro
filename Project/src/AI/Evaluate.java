package AI;

import Model.Position;

public class Evaluate {
	public int width;
	public int height;
	public int[][] eBoard;
    public int destination;

	public Evaluate(int width, int height) {
		// TODO Auto-generated constructor stub
		eBoard = new int[width][height];
	}
	public void reset(){
		for (int i = 0; i < eBoard.length; i++) {
			for (int j = 0; j < eBoard.length; j++) {
				eBoard[i][j] = 0;
			}
		}
	}
	public Position getMax(){
		Position pos = new Position(0,0);
		int max = 0;
		for (int i = 0; i < eBoard.length; i++) {
			for (int j = 0; j <eBoard.length; j++) {
				if(eBoard[i][j] > max ){
					max = eBoard[i][j];
					pos.x = i;
					pos.y = j;
				}
			}
		}
		destination =  max;
		return pos;
	}
	
	
//	int[] atkPoint = { 1, 3, 9, 27, 81, 243, 729, 2187, 6561 };
//	int[] defPoint = { 0, 2, 4, 8, 16, 32, 64, 128, 256 };
//	int[][] evaArr = new int[9][9];
//	Board board = new Board();
//	int[][] arr = board.sub;
//	public int evaluationBoard = 0;
//	// depth must be a odd number
//	public int depth = 1;
//	public int human, pc;
//	public Evaluate(int[][] arr) {
//		// TODO Auto-generated constructor stub
//		//eval(arr);
//	}
//	public void reset() {
//		for (int i = 0; i < atkPoint.length; i++) {
//			for (int j = 0; j < atkPoint.length; j++) {
//				evaArr[i][j] = 0;
//			}
//		}
//	}
//	public void setPosition(int x, int y, int score){
//		evaArr[x][y] = score;
//	}
//
//	public void minimax(int[][] arr, int depth) {
//		if(board.turn == false){
//			maxValue(arr, depth);
//		}else {
//			minValue(arr, depth);
//		}
//	}
//
//	
//	public void eval(int[][] arr) {
//		reset();
//		evaRow(arr);
//		evaCol(arr);
//		evaDia1(arr);
//		evaDia2(arr);
//		return;
//	}
//
//	public void evaCol(int[][] arr) {
//		human = 0;
//		pc = 0;
//		int[] a = new int[arr.length];
//		for (int i = 0; i < a.length; i++) {
//			a[i] = arr[i][4];
//			if (a[i] == 1) {
//				human++;
//			}
//			if (a[i] == 2) {
//				pc++;
//			}
//		}
//		for (int i = 0; i < a.length; i++) {
//			if (arr[i][4] == 0) {
//				if (board.turn == false) {
//					evaArr[i][4] += atkPoint[pc];
//				} else {
//					evaArr[i][4] += atkPoint[pc];
//
//				}
//				if (board.turn == true) {
//					evaArr[i][4] += atkPoint[human];
//				} else {
//					evaArr[i][4] += atkPoint[human];
//
//				}
//			}
//		}
//	}
//
//	public void evaRow(int[][] arr) {
//		human = 0;
//		pc = 0;
//		int[] a = new int[arr.length];
//		for (int i = 0; i < a.length; i++) {
//			a[i] = arr[2][i];
//			if (a[i] == 1) {
//				human++;
//			}
//			if (a[i] == 2) {
//				pc++;
//			}
//
//		}
//		for (int i = 0; i < a.length; i++) {
//			if (arr[2][i] == 0) {
//				if (board.turn == false) {
//					evaArr[2][i] += atkPoint[pc];
//				} else {
//					evaArr[2][i] += defPoint[pc];
//
//				}
//				if (board.turn == true) {
//					evaArr[2][i] += atkPoint[human];
//				} else {
//					evaArr[2][i] += defPoint[human];
//
//				}
//			}
//		}
//
//	}
//
//	public void evaDia1(int[][] arr) {
//		human = 0;
//		pc = 0;
//		int[] a = new int[arr.length];
//		for (int i = 0; i < a.length; i++) {
//
//			a[i] = arr[i][i];
//			if (a[i] == 1) {
//				human++;
//			}
//			if (a[i] == 2) {
//				pc++;
//			}
//
//		}
//		for (int i = 0; i < a.length; i++) {
//			if (arr[i][i] == 0) {
//				if (board.turn == false) {
//					evaArr[i][i] += atkPoint[pc];
//				} else {
//					evaArr[i][i] += atkPoint[pc];
//
//				}
//				if (board.turn == true) {
//					evaArr[i][i] += atkPoint[human];
//				} else {
//					evaArr[i][i] += atkPoint[human];
//
//				}
//			}
//		}
//
//	}
//
//	public void evaDia2(int[][] arr) {
//		human = 0;
//		pc = 0;
//		int m = arr.length - 1;
//		int[] a = new int[arr.length];
//		for (int i = 0; i < a.length; i++) {
//
//			a[i] = arr[i][m];
//			if (a[i] == 1) {
//				human++;
//			}
//			if (a[i] == 2) {
//				pc++;
//			}
//			m--;
//		}
//		m = arr.length - 1;
//		for (int i = 0; i < a.length; i++) {
//			if (arr[i][m] == 0) {
//				if (board.turn == false) {
//					evaArr[i][m] += atkPoint[pc];
//				} else {
//					evaArr[i][m] += atkPoint[pc];
//
//				}
//				if (board.turn == true) {
//					evaArr[i][m] += atkPoint[human];
//				} else {
//					evaArr[i][m] += atkPoint[human];
//
//				}
//			}
//			m--;
//		}
//
//	}
//	public Position maxPos(){
//		Position res = new Position();
//		int max = 0;
//		for (int i = 0; i < evaArr.length; i++) {
//			for (int j = 0; j < evaArr.length; j++) {
//				if(evaArr[i][j] > max){
//					res.x = i;
//					res.y = j;
//					max = evaArr[i][j];
//				}
//				
//			}
//		}
//		evaluationBoard = max;
//		return res;
//		
//	}
//	private void maxValue(int[][] arr2, int depth2) {
//		// TODO Auto-generated method stub
//		Position p = maxPos();
//	}
//	private void minValue(int[][] arr2, int depth2) {
//		// TODO Auto-generated method stub
//		Position p = maxPos();
//	}
//	public void AI() {
//		// TODO Auto-generated method stub
//		minimax(arr, depth);
//		
//	}
//	
//	
//
//	public static void main(String[] args) {
//	
//		int[][] arr = { { 0, 1, 2, 1, 0, 2, 1, 3, 2 }, { 0, 1, 2, 1, 2, 0, 1, 3, 2 }, { 0, 1, 2, 1, 2, 2, 1, 3, 2 },
//				{ 0, 1, 2, 1, 0, 2, 1, 3, 2 }, { 0, 1, 0, 1, 0, 2, 1, 3, 2 }, { 0, 1, 2, 1, 2, 2,0, 3, 2 },
//				{ 0, 1, 2, 1, 2, 2, 0, 3, 2 }, { 0, 1, 2, 1, 0, 2, 1, 3, 2 }, { 0, 1, 0, 1, 2, 2, 1, 3, 2 } };
//		for (int[] a : arr) {
//			for (int i : a) {
//				System.out.print(i + "\t");
//			}
//			System.out.println();
//		}
//		// System.out.println("Collum: " + eva.evaCol(arr));
//		// System.out.println("Row: " + eva.evaRow(arr));
//		// System.out.println("Diagonal One: " + eva.evaDia1(arr));
//		// System.out.println("Diagonal Two: " + eva.evaDia2(arr));
//		// System.out.println("Max Value: " + eva.getMax(arr));
//		// String s = "Uchiha Obito";
//		// String res = "";
//		// for (int i = 0; i < s.length(); i++) {
//		// String t = "" + s.charAt(i);
//		// if (t.equals(t.toLowerCase())) {
//		// res += t;
//		// }
//		// }
//		// System.out.println(res);
//		Evaluate eva = new Evaluate(arr);
//		System.out.println("-----------------------------");
//		int[][] a = eva.evaArr;
//		for (int[] a1 : a) {
//			for (int i : a1) {
//				System.out.print(i + "\t");
//			}
//			System.out.println();
//		}
//	}

}

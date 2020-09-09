package AI;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;

import Model.Board;
import Model.Position;



public class AlphaBeta {

    public double maxPly;
    public int[] atkPoint = {0,4,27,256,1458, 9800 };
	public int[] defPoint = { 0,2,9,99,769, 5200 };
    public Position go;
    public int maxDepth =5;
    public int x, y;
    Evaluate eBoard;
    int [][] boardState;
    int maxMove = 8;
    Board board;
    public AlphaBeta(Board cBoard) {
    	this.board = cBoard;
    	boardState = board.getField();
    	
    	System.out.println("length: " + boardState.length);

    	eBoard = new Evaluate(boardState.length, boardState.length);
    }
    public void evalBoard(boolean player){
    	int row, col;
		int ePC, eHuman;
		eBoard.reset();
		System.out.println("=====================");
		System.out.println(eBoard.eBoard.length + " "+ eBoard.eBoard.length);System.out.println("day la boardState: ");
		boardState = board.getField();
    	for (int i = 0; i < boardState.length; i++) {
			for (int j = 0; j < boardState.length; j++) {
				System.out.print(boardState[i][j]+" ");
			}
			System.out.println();
		}
    	System.out.println("------------------------------------------------------------");
		// Duyet theo hang
    	for (row = 0; row < eBoard.eBoard.length ; row++)
			for (col = 0; col < eBoard.eBoard.length  - 4; col++) {
				ePC = 0;
				eHuman = 0;
				for (int i = 0; i < 5; i++) {
					if (boardState[row][col + i] == 1)
						// neu quan do la cua human
						eHuman++;
					if (boardState[row][col + i] == 2) // neu quan do la cua pc
						ePC++;
				}
				// trong vong 5 o khong co quan dich
				if (eHuman * ePC == 0 && eHuman != ePC)
					for (int i = 0; i < 5; i++) {
						if (boardState[row][col + i] == 0) { // neu o chua danh
							if (eHuman == 0) // ePC khac 0
								if (player == true)
									eBoard.eBoard[row][col + i] += defPoint[ePC]; // cho diem phong ngu
								else
									eBoard.eBoard[row][col + i] += atkPoint[ePC];// cho diem tan cong
							if (ePC == 0) // eHuman khac 0
								if (player == false)
									eBoard.eBoard[row][col + i] += defPoint[eHuman];// cho diem phong ngu	
								else
									eBoard.eBoard[row][col + i] += atkPoint[eHuman];// cho diem tan cong
							if (eHuman == 4 || ePC == 4)
								eBoard.eBoard[row][col + i] *= 2;
						}
					}
			}

		// Duyet theo cot
		for (col = 0; col < eBoard.eBoard.length ; col++)
			for (row = 0; row < eBoard.eBoard.length -4; row++) {
				ePC = 0;
				eHuman = 0;
				for (int i = 0; i < 5; i++) {
					if (boardState[row +i][col] == 1)
						eHuman++;
					if (boardState[row + i][col] == 2)
						ePC++;
				}
				if (eHuman * ePC == 0 && eHuman != ePC)
					for (int i = 0; i < 5; i++) {
						if (boardState[row +i][col] == 0) // Neu o chua duoc danh
						{
							if (eHuman == 0)
								if (player == true)
									eBoard.eBoard[row +i][col] += defPoint[ePC];
								else
									eBoard.eBoard[row +i][col] += atkPoint[ePC];
							if (ePC == 0)
								if (player == false)
									eBoard.eBoard[row +i][col] += defPoint[eHuman];
								else
									eBoard.eBoard[row +i][col] += atkPoint[eHuman];
							if (eHuman == 4 || ePC == 4)
								eBoard.eBoard[row + i][col] *= 2;
						}

					}
			}

		// Duyet theo duong cheo xuong
		for (col = 0; col < eBoard.eBoard.length  - 4; col++)
			for (row = 0; row < eBoard.eBoard.length  - 4; row++) {
				ePC = 0;
				eHuman = 0;
				for (int i = 0; i < 5; i++) {
					if (boardState[row + i][ col + i] == 1)
						eHuman++;
					if (boardState[row + i][ col + i] == 2)
						ePC++;
				}
				if (eHuman * ePC == 0 && eHuman != ePC)
					for (int i = 0; i < 5; i++) {
						if (boardState[row + i][ col + i] == 0) // Neu o chua duoc danh
						{
							if (eHuman == 0)
								if (player == true)
									eBoard.eBoard[row + i][col + i] += defPoint[ePC];
								else
									eBoard.eBoard[row + i][col + i] += atkPoint[ePC];
							if (ePC == 0)
								if (player == false)
									eBoard.eBoard[row + i][col + i] += defPoint[eHuman];
								else
									eBoard.eBoard[row + i][col + i] += atkPoint[eHuman];
							if (eHuman == 4 || ePC == 4)
								eBoard.eBoard[row + i][col + i] *= 2;
						}

					}
			}

		// Duyet theo duong cheo len
		for (row = 4; row <eBoard.eBoard.length ; row++)
			for (col = 0; col < eBoard.eBoard.length  - 4; col++) {
				ePC = 0; // so quan PC
				eHuman = 0; // so quan Human
				for (int i = 0; i < 5; i++) {
					if (boardState[row - i][ col + i] == 1) // neu la human
						eHuman++; // tang so quan human
					if (boardState[row - i][ col + i] == 2) // neu la PC
						ePC++; // tang so quan PC
				}
				if (eHuman * ePC == 0 && eHuman != ePC)
					for (int i = 0; i < 5; i++) {
						if (boardState[row - i][ col + i] == 0) { // neu o chua duoc danh
							if (eHuman == 0)
								if (player == true)
									eBoard.eBoard[row - i][col + i] += defPoint[ePC];
								else
									eBoard.eBoard[row - i][col + i] += atkPoint[ePC];
							if (ePC == 0)
								if (player == false)
									eBoard.eBoard[row - i][col + i] += defPoint[eHuman];
								else
									eBoard.eBoard[row - i][col + i] += atkPoint[eHuman];
							if (eHuman == 4 || ePC == 4)
								eBoard.eBoard[row - i][col + i] *= 2;
						}

					}
			}
    }
    public void alphaBeta(int alpha, int beta, int depth, Boolean player) {
		if(player == false){
			maxValue(board, alpha, beta, depth);
			
		}
	}
private int minValue(Board state, int alpha, int beta, int depth) {
	evalBoard(true);
	eBoard.getMax();
	int value = eBoard.destination;
	if (depth >= maxDepth) {
		return value;
	}
	
	ArrayList<Position> list = new ArrayList<>(); // list cac nut con 
	for (int i = 0; i < maxMove; i++) {
		Position node = eBoard.getMax();
		if(node==null)
			break;
		list.add(node);
		eBoard.eBoard[node.x][node.y] = 0;
	}

	int v = Integer.MAX_VALUE;
	for (int i = 0; i < list.size(); i++) {
		Position com = list.get(i);
		state.setPosition(com.x, com.y, 1);
		v = Math.min(v, maxValue(state, alpha, beta, depth+1));
		state.setPosition(com.x, com.y, 0);
		//cat tia
		if(v > alpha){
			break;
		}
		beta = Math.min(beta, v);
	}
	return beta;		
		
	}
private int maxValue(Board state, int alpha, int beta, int depth) {
		

		evalBoard(false);
		eBoard.getMax();
		int value = eBoard.destination; // gia tri max hien tai
		System.out.println("current max: " + value);
		if (depth >= maxDepth) {
			return value;
		}
		 // danh gia diem voi nguoi choi hien tai la PC
		ArrayList<Position> list = new ArrayList<>(); // list cac nut con
		for (int i = 0; i < maxMove; i++) {
			Position node = eBoard.getMax();
			System.out.println(node.x +"," + node.y);
			if(node == null)
				break;
			list.add(node);
			eBoard.eBoard[node.x][node.y] = 0;
		}
		int v = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			Position com = list.get(i);
			state.setPosition(com.x, com.y, 2);
			v = Math.max(v, minValue(state, alpha, beta, depth+1));
			System.out.println("value: " + v );
			state.setPosition(com.x, com.y, 0);
			go = com;
			if(v>= beta){
				go= com;
				//System.out.println();
				return v;
				
			}
			alpha = Math.max(alpha, v);
		}

		return alpha;
	}
	public Position AI(boolean player){
		alphaBeta(0, 2, 3, player);
		Position goPos = go;
		if (goPos != null) {
			x = goPos.getX();
			y = goPos.getY();
			
		}
		System.out.println("=======" + x + "========" + y);
		return new Position(x, y);
		
	}
    
    
   
}

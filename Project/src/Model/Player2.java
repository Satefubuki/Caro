package Model;

import AI.AlphaBeta;
import AI.Minimax;

public class Player2 extends Player {
	//Board board = new Board();
	//Evaluate e = new Evaluate(b);
	AlphaBeta ab;
	Minimax mi;
	public Player2(Board board) {
		super(board);
		// TODO Auto-generated constructor stub
		ab = new AlphaBeta(board);
		//mi = new Minimax(board);
		this.name = "Player 1";
		this.turn = false;
		this.value = 2;
		
	}
	//public void playBestMove(int[][] arr){
	//	e.AI();
	//}
	@Override
	public Position move() {
		// TODO Auto-generated method stub
		Position ps = ab.AI(turn);
		//Position ps = mi.AI(turn);
		return ps;
		
	}
}

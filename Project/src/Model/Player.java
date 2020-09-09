package Model;


public abstract class Player {
	protected String name;

	protected boolean turn;
	protected int value;

	public Player(Board board) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.turn = turn;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public abstract Position move();
}

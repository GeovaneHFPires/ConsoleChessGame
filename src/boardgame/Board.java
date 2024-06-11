package boardgame;

public class Board {
	
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	
	public Board() {
		
	}
	
	
	public Board(int row, int column) {
		this.rows = row;
		this.columns = column;
		pieces = new Piece[rows][columns];
	}


	public int getRow() {
		return rows;
	}


	public void setRow(int row) {
		this.rows = row;
	}


	public int getColumn() {
		return columns;
	}


	public void setColumn(int column) {
		this.columns = column;
	}
	
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}

}

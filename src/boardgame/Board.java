package boardgame;

public class Board {
	
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	
	public Board() {
		
	}
	
	
	public Board(int row, int column) {
		if(row < 1 || column < 1) {
			throw new BoardException("Error creating board: there must be at least 1 line and 1 column");
		}
		this.rows = row;
		this.columns = column;
		pieces = new Piece[rows][columns];
	}


	public int getRow() {
		return rows;
	}


	public int getColumn() {
		return columns;
	}

	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position doesn't exists");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position doesn't exists");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public boolean positionExists(int row, int column) {
		return row < this.rows && column < this.columns 
				&& this.rows > 0 && this.columns > 0;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position doesn't exist on the board");
		}
		return piece(position) != null;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}

}

package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	
	
	
	
	@Override
	public String toString() {
		return "K";
	}

	
	private boolean canMove(Position position){
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
		
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p.getColor() == getColor() && p instanceof Rook && p.getMoveCount() == 0 & p != null;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		
		Position p = new Position(0,0);
		
		
		
		
		
		//above
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//below
		p.setValues(position.getRow() + 1 , position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//upper left diagonal
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//upper right diagonal
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//lower left
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//lower right
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		//Castling
		
		if(getMoveCount() == 0 && !chessMatch.getCheck() ) {
			//Big Castling
			p.setValues(position.getRow(), position.getColumn() - 4);
			Position p2 = new Position(position.getRow(), position.getColumn() - 1);
			Position p3 = new Position(position.getRow(), position.getColumn() - 2);
			Position p4 = new Position(position.getRow(), position.getColumn() - 3);
			if(testRookCastling(p) && getBoard().piece(p2) == null && getBoard().piece(p3) == null && getBoard().piece(p4) == null) {
				mat[p3.getRow()][p3.getColumn()] = true;
			}
			
			//Small Castling
			p.setValues(position.getRow(), position.getColumn() + 3);
			p2.setValues(position.getRow(), position.getColumn() + 1);
			p3.setValues(position.getRow(), position.getColumn() + 2);
			if(testRookCastling(p) && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
				mat[p3.getRow()][p3.getColumn()] = true;
			}
				
		}
		
		
		return mat;
	}

	
	
	
}

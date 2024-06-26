package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean [getBoard().getRow()][getBoard().getRow()];
		
		Position p = new Position(0,0);
		
		
		//N
		p.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		p.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		
		//O
		
		p.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//S
		
		p.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		p.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//E
		p.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		p.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		return mat;
		
	}

	@Override
	public String toString() {
		return "N";
	}
	
	
	

	
	
	
	
	
}

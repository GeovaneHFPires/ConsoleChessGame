package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	ChessMatch chessMatch;
	
	
	
	
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}



	@Override
	public boolean[][] possibleMoves() {
		Position p = new Position(0,0);
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];


		//N
		
		if(getColor() == Color.WHITE) {
			
			p.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				if(getMoveCount() == 0) {
					Position p2 = new Position(0,0);
					p2.setValues(position.getRow() - 2, position.getColumn());
					if(getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
						mat[p2.getRow()][p2.getColumn()] =  true;
					}

				}
			}

			//NO
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			//NE
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//White En Passant
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(left) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow()- 1][left.getColumn()] = true;
				}
			}
		}
		else if (getColor() == Color.BLACK) {
			
			//S
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				if (getMoveCount() == 0) {
					Position p2 = new Position(0,0);
					p2.setValues(position.getRow() + 2, position.getColumn());
					if(getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
						mat[p2.getRow()][p2.getColumn()] =  true;
					}
				}
			}

			//SO
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			//SE
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Black En Passant
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(left) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
			}
		}



		return mat;
	}


	@Override
	public String toString() {
		return "P";
	}





}

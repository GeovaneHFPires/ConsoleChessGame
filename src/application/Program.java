package application;

import java.util.Locale;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			
			
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessposition(sc);
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessposition(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			
			
			
		}

	}

}

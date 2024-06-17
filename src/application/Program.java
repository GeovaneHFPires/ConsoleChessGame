package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		List<ChessPiece> captured = new ArrayList<ChessPiece>();


		while(!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessposition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessposition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}

				if (chessMatch.getPromoted() != null) {
					System.out.print("Enter piece promotion (B/N/Q/R): ");
					String pieceType = sc.nextLine().toUpperCase();
					while (!pieceType.equals("B") && !pieceType.equals("N") && !pieceType.equals("R") & !pieceType.equals("Q")) {
						System.out.print("Inavalid Value! Enter piece promotion (B/N/Q/R): ");
						pieceType = sc.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(pieceType);
				}
				
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		

	}

}

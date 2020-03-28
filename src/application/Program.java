package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> capturedPieces = new ArrayList<ChessPiece>();
		
		Scanner sc = new Scanner(System.in);
		// Receber a matriz de peças da partida de xadrez
		while (!chessMatch.getCheckMate()) {
			
			try {
				
				UI.clearScreen();
				UI.printMatch( chessMatch, capturedPieces);
				System.err.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				
				
				System.err.println();
				System.err.println("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if (capturedPiece != null) {
					capturedPieces.add(capturedPiece);
				}
				
				if (chessMatch.getPromoted() != null) {
					System.out.println("Enter the piece for promotion (B - Bishop / N - Knight / R - Rook / Q - Queen): ");
					String type = sc.nextLine();
					chessMatch.replacePromotedPiece(type);
				}
				
				
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
		UI.clearScreen();
		UI.printMatch(chessMatch, capturedPieces);

	}

}

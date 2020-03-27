package application;

import chess.ChessPiece;

/**
 * Classe UI - User Interface que conterá um metodo chamado printBoard para imprimir um tabuleiro..
 * @author Vinicius-PC.
 */
public class UI {

	// Printing Board
	public static void printBoard( ChessPiece[][] pieces ) {
		
		// 1 FOR PARA PERCORRER AS LINHAS
		for (int i = 0; i < pieces.length; i++) {
			
			System.out.print( (8 - i) + " ");
			
			// 1 FOR PARA PERCORRER AS COLUNAS
			for (int j = 0; j < pieces.length; j++) {
				
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		
		System.out.print("  a b c d e f g h");
		
	}
	
	private static void printPiece( ChessPiece piece ) {
		
		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
		
		System.out.print(" ");
	}
}

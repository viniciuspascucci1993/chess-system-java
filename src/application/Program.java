package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessMatch = new ChessMatch();
		
		// Receber a matriz de pe�as da partida de xadrez
		UI.printBoard( chessMatch.getPieces() );

	}

}

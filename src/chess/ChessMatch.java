package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 * Classe ChessMatch representando uma partida de xadrez, nela que conterá as regras para o jogo de xadrez.
 * @author Vinicius-PC.
 */
public class ChessMatch {

	/**
	 * Representa o tabuleiro de xadrez.
	 */
	private Board board;
	
	/**
	 * Construtor padrão
	 */
	public ChessMatch() { 
		// recebendo as dimensoes de um tabuleiro de xadrez.
		board = new Board(8, 8);
		initialSetup();
	}
	
	/**
	 * metodo para retornar uma matriz de peças de xadrez.
	 * @return matriz.
	 */
	public ChessPiece[][] getPieces() {
		
		ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];
		
		// Percorrer a matriz de peças do tabuleiro fazer um downcasting para ChessPiece
		// Percorrendo as linhas
		for (int i = 0; i < board.getRows(); i++) {
			 // Percorrendo as colunas
			for (int j = 0; j < board.getColumns(); j++) {
				
				matriz[i][j] = ( ChessPiece )board.piece(i, j);
			}
		}
		
		return matriz;
	}
	
	// place new piece
	private void placeNewPiece( char column, int row, ChessPiece piece ) {
		
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	// Responsavel por iniciar a partida de xadrex
	private void initialSetup() {
		
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.WHITE));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
}

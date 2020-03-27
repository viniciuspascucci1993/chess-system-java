package chess;

import boardgame.Board;
import boardgame.Position;
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
	
	// Responsavel por iniciar a partida de xadrex
	private void initialSetup() {
		
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}

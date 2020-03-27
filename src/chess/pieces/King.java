package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

/**
 * Classe King para representar a peça Rei do xadrex.
 * @author Vinicius-PC.
 */
public class King extends ChessPiece {

	/**
	 * Construtor para repassar a chamada para a super classe	
	 * @param board - Object.
	 * @param color - Object.
	 */
	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		
		return "K";
	}
}

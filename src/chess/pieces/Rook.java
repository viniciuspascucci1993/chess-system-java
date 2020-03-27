package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

/**
 * Classe Rook para representar a peça Torre do xadrex.
 * @author Vinicius-PC.
 */
public class Rook extends ChessPiece {

	/**
	 * Construtor para repassar a chamada para a super classe	
	 * @param board - Object.
	 * @param color - Object.
	 */
	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
}

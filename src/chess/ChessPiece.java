package chess;

import boardgame.Board;
import boardgame.Piece;

/**
 * Classe Peça de xadrez.
 * @author Vinicius-PC
 */
public abstract class ChessPiece extends Piece {

	/**
	 * Cor da peça de xadrez.
	 */
	private Color color;

	/**
	 * Construtor com argumentos.
	 * @param board - Object.
	 * @param color - Enum.
	 */
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	
	/**
	 * metodo get().
	 * @return color - Enum - cor da peça de xadrez.
	 */
	public Color getColor() {
		return color;
	}	
	
}

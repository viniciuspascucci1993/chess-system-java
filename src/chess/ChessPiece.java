package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

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
	 * Representa a quantidade de movimentos contados.
	 */
	private int moveCount;

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
	
	/**
	 * metodo get().
	 * @return moveCount - int - movimentos contados.
	 */
	public int getMoveCount() {
		return moveCount;
	}
	
	public void increaseMoveCount() {
		moveCount++;
	}
	
	public void decreaseMoveCount() {
		moveCount--;
	}	
	
	public ChessPosition getChessPosition() {
		// pegar a posição e concerter para chessPosition
		return ChessPosition.fromPosition(position);
	}
	
	// Para saber se existe uma peça adversária em uma dada casa.
	protected boolean isThereOpponentPiece( Position position ) {
		
		ChessPiece p =  ( ChessPiece ) getBoard().piece(position);
		
		return p != null && p.getColor() != color;
	}
}

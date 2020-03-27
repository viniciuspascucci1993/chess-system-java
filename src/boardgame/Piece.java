package boardgame;

/**
 * Classe Peace responsável pelos atributos de uma peça de xadrez.
 * @author Vinicius-PC
 */
public class Piece {

	/**
	 * Representa a posição simples de uma matriz.
	 */
	protected Position position;
	
	/**
	 * Representa o tabuleiro de xadrez.
	 */
	private Board board;
	
	/**
	 * Construtor com argumentos
	 * @param board - Object - tabuleiro de xadrez.
	 */
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	/**
	 * metodo get().
	 * @return board - Object - tabuleiro de xadrez.
	 */
	protected Board getBoard() {
		return this.board;
	}
}

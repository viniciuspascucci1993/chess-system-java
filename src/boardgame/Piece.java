package boardgame;

/**
 * Classe Peace respons�vel pelos atributos de uma pe�a de xadrez.
 * @author Vinicius-PC
 */
public class Piece {

	/**
	 * Representa a posi��o simples de uma matriz.
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

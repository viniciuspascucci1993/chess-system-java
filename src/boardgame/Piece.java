package boardgame;

/**
 * Classe Peace responsável pelos atributos de uma peça de xadrez.
 * @author Vinicius-PC
 */
public abstract class Piece {

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
	
	
	public abstract boolean[][] possibleMoves();
	
	// hookMethods - faz gancho com a classe Piece	
	public boolean possibleMove( Position position ) {
		
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		
		boolean[][] mat = possibleMoves();
		
		for (int i = 0; i < mat.length; i++) {
			
			for (int j = 0; j < mat.length; j++) {
				
				if (mat[i][j]) {
					
					return true;
				}
			}
		}
		
		return false;
	}
}

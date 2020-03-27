package boardgame;

/**
 * Classe Board responsável pelos atributos de um tabuleiro de xadrez.
 * @author Vinicius-PC.
 */
public class Board {

	/**
	 * Representa as linhas de um tabuleiro.
	 */
	private int rows;
	
	/**
	 * Representa as colunas de um tabuleiro.
	 */
	private int columns;
	
	/**
	 * Representa uma matriz de peças de um tabuleiro.
	 */
	private Piece[][] pieces;

	/**
	 * Construtor com argumentos.
	 * @param rows - int - linhas do tabuleiro.
	 * @param columns - int - colunas do tabuleiro.
	 */
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	/**
	 * metodo get().
	 * @return rows - int - linhas do tabuleiro.
	 */
	public int getRows() {
		return this.rows;
	}

	/**
	 * metodo set().
	 * @param rows - int - linhas do tabuleiro.
	 */
	public void setRows(final int rows) {
		this.rows = rows;
	}

	/**
	 * metodo get().
	 * @return columns - int - colunas da tabela.
	 */
	public int getColumns() {
		return this.columns;
	}

	/**
	 * metodo set().
	 * @param columns - int - colunas da tabela.
	 */
	public void setColumns(final  int columns) {
		this.columns = columns;
	}
	
}

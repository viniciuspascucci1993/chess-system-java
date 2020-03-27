package boardgame;

/**
 * Classe Position responsável por conter os atributos de uma posição.
 * @author Vinicius-PC
 */
public class Position {

	/**
	 * Representa a Linha da posição.
	 */
	private int row;
	
	/**
	 * Representa a coluna da posição.
	 */
	private int column;
	
	/**
	 * Construtor com argumentos.
	 * @param row - int - linha posição.
	 * @param column - int - coluna posição
	 */
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * metodo get().
	 * @return row - int - linha posição.
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * metodo set().
	 * @param row - int - linha posição.
	 */
	public void setRow(final int row) {
		this.row = row;
	}

	/**
	 * metodo get().
	 * @return column - int - coluna da posição.
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * metodo set().
	 * @param column - int - coluna da posição.
	 */
	public void setColumn(final int column) {
		this.column = column;
	}
	
	/**
	 * Metodo toString para imprimir uma Position na tela.
	 */
	@Override
	public String toString() {
		
		return row + ", " + column;
	}
}

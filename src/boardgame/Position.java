package boardgame;

/**
 * Classe Position respons�vel por conter os atributos de uma posi��o.
 * @author Vinicius-PC
 */
public class Position {

	/**
	 * Representa a Linha da posi��o.
	 */
	private int row;
	
	/**
	 * Representa a coluna da posi��o.
	 */
	private int column;
	
	/**
	 * Construtor com argumentos.
	 * @param row - int - linha posi��o.
	 * @param column - int - coluna posi��o
	 */
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * metodo get().
	 * @return row - int - linha posi��o.
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * metodo set().
	 * @param row - int - linha posi��o.
	 */
	public void setRow(final int row) {
		this.row = row;
	}

	/**
	 * metodo get().
	 * @return column - int - coluna da posi��o.
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * metodo set().
	 * @param column - int - coluna da posi��o.
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

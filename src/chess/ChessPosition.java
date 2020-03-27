package chess;

import boardgame.Position;

/**
 * Classe ChessPosition para indicar a posição do xadrez que terá uma coluna e uma linha.
 * @author Vinicius-PC.
 */
public class ChessPosition {

	/**
	 * Representa a coluna.
	 */
	private char column;
	
	/**
	 * Representa a linha.
	 */
	private int row;

	/**
	 * Construtor com argumentos.
	 * @param column - char - column.
	 * @param row - int - row.
	 */
	public ChessPosition(char column, int row) {

		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
		}
		this.column = column;
		this.row = row;
	}

	/**
	 * metodo get().
	 * @return column - char - coluna.
	 */
	public char getColumn() {
		return this.column;
	}

	/**
	 * metodo get().
	 * @return row - int - linha.
	 */
	public int getRow() {
		return row;
	}
	
	// Converter para Position
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	// Converter para Position de xadrez
	protected static ChessPosition fromPosition( Position position ) {
		
		return new ChessPosition((char)('a' - position.getColumn()), 
					8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}

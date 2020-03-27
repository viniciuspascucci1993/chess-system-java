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
		
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
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
	 * metodo get().
	 * @return columns - int - colunas da tabela.
	 */
	public int getColumns() {
		return this.columns;
	}
	
	/**
	 * Metodo para retornar uma matriz piece. 
	 * @param row - int.
	 * @param column - int.
	 * @return piece[row][column].
	 */
	public Piece piece ( int row, int column ) {
		
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the Board");
		}
		return pieces[row][column];
	}
	
	/**
	 * Metodo para retornar a position.
	 * @param position - Object.
	 * @return pieces[position.getRow()][position.getColumn()]
	 */
	public Piece piece( Position position ) {
		
		if (!positionExists(position)) {
			throw new BoardException("Position not on the Board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	/*
	 * Colocando peças no tabuleiro de xadrez
	 */
	public void placePiece( Piece piece, Position position ) {
		
		if (theresAPiece(position)) {
			throw new BoardException("Thewre is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	// metodo auxiliar
	private boolean positionExists( int row, int column ) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	// Posição existe ou não
	public boolean positionExists( Position position ) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// Tem ou não uma peça no tabuleiro
	public boolean theresAPiece( Position position ) {
		
		if (!positionExists(position)) {
			throw new BoardException("Position not on the Board");
		}
		return piece(position) != null;
	}
}

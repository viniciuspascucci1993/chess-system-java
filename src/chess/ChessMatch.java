package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 * Classe ChessMatch representando uma partida de xadrez, nela que conter� as regras para o jogo de xadrez.
 * @author Vinicius-PC.
 */
public class ChessMatch {

	/**
	 * Representa o outro jogador.
	 */
	private int turn;
	
	/**
	 * Representa o atual.
	 */
	private Color currentPlayer;
	
	/**
	 * Representa o tabuleiro de xadrez.
	 */
	private Board board;
	
	/**
	 * Construtor padr�o
	 */
	public ChessMatch() { 
		// recebendo as dimensoes de um tabuleiro de xadrez.
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	
	/**
	 * metodo get().
	 * @return turn - int - turn.
	 */
	public int getTurn() {
		return this.turn;
	}

	/**
	 * metodo get().
	 * @return currentPlayer - Enum - currentPlayer.
	 */
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * metodo para retornar uma matriz de pe�as de xadrez.
	 * @return matriz.
	 */
	public ChessPiece[][] getPieces() {
		
		ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];
		
		// Percorrer a matriz de pe�as do tabuleiro fazer um downcasting para ChessPiece
		// Percorrendo as linhas
		for (int i = 0; i < board.getRows(); i++) {
			 // Percorrendo as colunas
			for (int j = 0; j < board.getColumns(); j++) {
				
				matriz[i][j] = ( ChessPiece )board.piece(i, j);
			}
		}
		
		return matriz;
	}
	
	// Imprimindo os movimentos possiveis
	public boolean[][] possibleMoves( ChessPosition sourcePosition ) {
		
		Position p = sourcePosition.toPosition();
		
		validateSourcePosition(p);
		
		return board.piece(p).possibleMoves();
	}
	
	public ChessPiece performChessMove(  ChessPosition sourcePosition, ChessPosition targetPosition ) {
		
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		validateSourcePosition( source );
		validateTargetPosition( source, target );
		
		Piece capturedPiece = makeMove( source, target );
		nextTurn();
		return ( ChessPiece ) capturedPiece;
	}
	

	private Piece makeMove(Position source, Position target) {
		
		Piece p = board.removePiece(source);
		Piece captured = board.removePiece(target);
		
		board.placePiece(p, target);
		
		return captured;
	}

	// validar posi��o de origem
	private void validateSourcePosition(Position position) {
		
		if (!board.theresAPiece(position)) {
			throw new ChessException("Thewre is no piece on source position");
		}
		
		if (currentPlayer != (( ChessPiece ) board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
			
		}
		
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
		
	}
	
	// validar posi��o de destino
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			
			throw new ChessException("The chosen piece cannot move to target position");
		}
		
	}	
	
	// proximo turno
	private void nextTurn() {
		
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	// place new piece
	private void placeNewPiece( char column, int row, ChessPiece piece ) {
		
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	// Responsavel por iniciar a partida de xadrex
	private void initialSetup() {
		
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}

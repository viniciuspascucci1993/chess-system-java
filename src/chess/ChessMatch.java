package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

/**
 * Classe ChessMatch representando uma partida de xadrez, nela que conterá as regras para o jogo de xadrez.
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
	 * Representa a propriedade de CHECK.
	 */
	private boolean check;
	
	/**
	 * Representa a propriedade de cheque-mate.
	 */
	private boolean checkMate;
	
	/**
	 * Representa as peças do tabuleiro
	 */
	private List<Piece> piecesOnTheBoard = new ArrayList<Piece>();
	
	/**
	 * Representa as peças capturadas
	 */
	private List<Piece> capturedPieces = new ArrayList<Piece>();
	
	/**
	 * Construtor padrão
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
	 * metodo get().
	 * @return check -boolean - propriedade de ceque.
	 */
	public boolean getCheck() {
		return check;
	}
	
	/**
	 * metodo get().
	 * @return checkMate - boolean - cheque-mate.
	 */
	public boolean getCheckMate() {
		return checkMate;
	}
	
	/**
	 * metodo para retornar uma matriz de peças de xadrez.
	 * @return matriz.
	 */
	public ChessPiece[][] getPieces() {
		
		ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];
		
		// Percorrer a matriz de peças do tabuleiro fazer um downcasting para ChessPiece
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
		
		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You cannot put yourself in check");
		}
		
		check = ( testCheck(opponent(currentPlayer) ) ? true : false);
		
		if (testCheckMate(opponent(currentPlayer))) {
			
			checkMate = true;
		} else {
			
			nextTurn();
		}
		return ( ChessPiece ) capturedPiece;
	}
	

	private Piece makeMove(Position source, Position target) {
		
		ChessPiece p = ( ChessPiece ) board.removePiece(source);
		p.increaseMoveCount();
		Piece captured = board.removePiece(target);
		
		board.placePiece(p, target);
		
		if (captured != null) {
			piecesOnTheBoard.remove(captured);
			capturedPieces.add(captured);
		}
		
		// Especial Move - Castling ou Roque - pequeno - Rei
		if (p instanceof King && target.getColumn() == source.getColumn() + 2) {
			
			Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
			Position targetT = new Position(source.getRow(), source.getColumn() + 1);
			
			ChessPiece rook = ( ChessPiece )board.removePiece(sourceT);
			board.placePiece(rook, targetT);
			rook.increaseMoveCount();
		}
		
		// Especial Move - Castling ou Roque - grande - Rei
		if (p instanceof King && target.getColumn() == source.getColumn() - 2) {
			
			Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
			Position targetT = new Position(source.getRow(), source.getColumn() - 1);
			
			ChessPiece rook = ( ChessPiece )board.removePiece(sourceT);
			board.placePiece(rook, targetT);
			rook.increaseMoveCount();
		}		
		return captured;
	}
	
	private void undoMove( Position source, Position target, Piece capturedPiece ) {
		
		ChessPiece p = ( ChessPiece ) board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p, source);
		
		if (capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}
		
		// Especial Move - Castling ou Roque - pequeno - Rei
			if (p instanceof King && target.getColumn() == source.getColumn() + 2) {
				
				Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
				Position targetT = new Position(source.getRow(), source.getColumn() + 1);
				
				ChessPiece rook = ( ChessPiece )board.removePiece(targetT);
				board.placePiece(rook, sourceT);
				rook.decreaseMoveCount();
			}
			
			// Especial Move - Castling ou Roque - grande - Rei
			if (p instanceof King && target.getColumn() == source.getColumn() - 2) {
				
				Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
				Position targetT = new Position(source.getRow(), source.getColumn() - 1);
				
				ChessPiece rook = ( ChessPiece )board.removePiece(targetT);
				board.placePiece(rook, sourceT);
				rook.decreaseMoveCount();
			}				
		
	}

	// validar posição de origem
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
	
	// validar posição de destino
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
	
	private Color opponent( Color color ) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private ChessPiece king( Color color ) {
		
		List<Piece> listPiece = piecesOnTheBoard.stream().filter(x -> (( ChessPiece)x).getColor() == color).collect(Collectors.toList());
		for (Piece piece : listPiece) {
			if (piece instanceof King) {
				return ( ChessPiece ) piece;
			}
		}
		
		throw new IllegalStateException("There is no " + color + " king on the board");
	}
	
	private boolean testCheckMate( Color color ) {
		
		if (!testCheck(color)) {
			
			return false;
		}
		
		List<Piece> listPieces = piecesOnTheBoard.stream().filter(x -> (( ChessPiece)x).getColor() == color).collect(Collectors.toList());
		
		for (Piece piece : listPieces) {
			
			boolean[][] matriz = piece.possibleMoves();
			// Percorre as linhas da matriz
			for (int i = 0; i < board.getRows(); i++) {
				// Percorre as colunas da matriz
				for (int j = 0; j < board.getColumns(); j++) {
					// Para cada elemnto da matriz testamos se essa posição d amatriz é um movimento possivel
					if (matriz[i][j]) {
						
						Position source = (( ChessPiece )piece).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturedPiece = makeMove(source, target);
						
						boolean testeCheck = testCheck(color);
						undoMove(source, target, capturedPiece);
						
						if (!testeCheck) {
							return false;
							
						}
					}
				}
			}
		}
		return true;
	}
	
	private boolean testCheck( Color color ) {
		
		Position kingPosition = king(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> (( ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
		
		for (Piece piece : opponentPieces) {
			
			boolean[][] matriz = piece.possibleMoves();
			if (matriz[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		return false;
	}

	// place new piece
	private void placeNewPiece( char column, int row, ChessPiece piece ) {
		
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	// Responsavel por iniciar a partida de xadrex
	private void initialSetup() {
		
		placeNewPiece('a', 1, new Rook(board, Color.WHITE));
		placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE, this));
        placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
		placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK, this));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));

	}
}

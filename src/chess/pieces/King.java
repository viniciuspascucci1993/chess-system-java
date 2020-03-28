package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

/**
* Classe Bishop responsável por conter os movimentos de um Rei no xadrez.
 * @author Vinicius-PC.
 */
public class King extends ChessPiece {
	
	// dependencia de ChessMatch
	private ChessMatch chessMatch;

	/**
	 * Construtor para repassar a chamada para a super classe	
	 * @param board - Object.
	 * @param color - Object.
	 */
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		
		return "K";
	}
	
	// metodo auxiliar para verificar se essa peça pode mover para qualquer direção ( Rei faz isso ). 
	private boolean canMove( Position position ) {
		
		ChessPiece p = ( ChessPiece )getBoard().piece(position);
		
		return p == null || p.getColor() != getColor();
	}
	
	// jogada especial - Castling ou Roque
	private boolean testRookCastling( Position position ) {
		ChessPiece p = ( ChessPiece )getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p  = new Position(0, 0);
		
		// verificar acima da minha peça - para cima
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// verificar acima da minha peça - para baixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		// verificar acima da minha peça - para esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		// verificar acima da minha peça - para direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		// verificar acima da minha peça - para noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// verificar acima da minha peça - para nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		// verificar acima da minha peça - para sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// verificar acima da minha peça - para sudeste
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		// # Jogada Especial Castling ou Roque
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			
			// Movimento Especial Rei lado direito - Roque pequeno
			Position positionRook = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(positionRook)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			
			// Movimento Especial Rainha lado esquerdo - Roque grande
				Position positionRookEsquerda = new Position(position.getRow(), position.getColumn() - 4);
				if (testRookCastling(positionRookEsquerda)) {
					Position p1 = new Position(position.getRow(), position.getColumn() - 1);
					Position p2 = new Position(position.getRow(), position.getColumn() - 2);
					Position p3 = new Position(position.getRow(), position.getColumn() - 3);
					
					if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
						mat[position.getRow()][position.getColumn() - 2] = true;
					}
				}			
		}
		
		
		return mat;
	}
}

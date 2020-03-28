package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
* Classe Bishop respons�vel por conter os movimentos de um Rei no xadrez.
 * @author Vinicius-PC.
 */
public class King extends ChessPiece {

	/**
	 * Construtor para repassar a chamada para a super classe	
	 * @param board - Object.
	 * @param color - Object.
	 */
	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		
		return "K";
	}
	
	// metodo auxiliar para verificar se essa pe�a pode mover para qualquer dire��o ( Rei faz isso ). 
	private boolean canMove( Position position ) {
		
		ChessPiece p = ( ChessPiece )getBoard().piece(position);
		
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p  = new Position(0, 0);
		
		// verificar acima da minha pe�a - para cima
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// verificar acima da minha pe�a - para baixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		// verificar acima da minha pe�a - para esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		// verificar acima da minha pe�a - para direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		// verificar acima da minha pe�a - para noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// verificar acima da minha pe�a - para nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		// verificar acima da minha pe�a - para sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// verificar acima da minha pe�a - para sudeste
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		
		return mat;
	}
}

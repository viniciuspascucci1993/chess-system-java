package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * Classe Rook para representar a pe�a Torre do xadrex.
 * @author Vinicius-PC.
 */
public class Rook extends ChessPiece {

	/**
	 * Construtor para repassar a chamada para a super classe	
	 * @param board - Object.
	 * @param color - Object.
	 */
	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// verificar acima da minha pe�a - pata cima
		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().theresAPiece(p)) {
			
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))  {
			
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// verificar acima da minha pe�a - para esquerda
			p.setValues(position.getRow(), position.getColumn() - 1);
			while (getBoard().positionExists(p) && !getBoard().theresAPiece(p)) {
				
				mat[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() - 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))  {
				
				mat[p.getRow()][p.getColumn()] = true;
			} 
			
			// verificar acima da minha pe�a - para direita
			p.setValues(position.getRow(), position.getColumn() + 1);
			while (getBoard().positionExists(p) && !getBoard().theresAPiece(p)) {
				
				mat[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() + 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))  {
				
				mat[p.getRow()][p.getColumn()] = true;
			} 		
			
			// verificar acima da minha pe�a - pata baixo
			p.setValues(position.getRow() + 1, position.getColumn());
			while (getBoard().positionExists(p) && !getBoard().theresAPiece(p)) {
				
				mat[p.getRow()][p.getColumn()] = true;
				p.setRow(p.getRow() + 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))  {
				
				mat[p.getRow()][p.getColumn()] = true;
			}
		
		return mat;
	}
}

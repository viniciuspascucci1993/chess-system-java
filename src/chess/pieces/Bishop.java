package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
* Classe Bishop responsável por conter os movimentos de um Rei no xadrez.
 * @author Vinicius-PC.
 */
public class Bishop extends ChessPiece {

	/**
	 * Construtor para repassar a chamada para a super classe	
	 * @param board - Object.
	 * @param color - Object.
	 */
	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// verificar acima da minha peça - NOROESTE
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().theresAPiece(p)) {
			
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))  {
			
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// verificar acima da minha peça - para nordeste
			p.setValues(position.getRow() -1, position.getColumn() + 1);
			while (getBoard().positionExists(p) && !getBoard().theresAPiece(p)) {
				
				mat[p.getRow()][p.getColumn()] = true;
				p.setValues(p.getRow() - 1, p.getColumn() + 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))  {
				
				mat[p.getRow()][p.getColumn()] = true;
			} 
			
			// verificar acima da minha peça - para noroeste
				p.setValues(position.getRow() -1, position.getColumn() - 1);
				while (getBoard().positionExists(p) && !getBoard().theresAPiece(p)) {
					
					mat[p.getRow()][p.getColumn()] = true;
					p.setValues(p.getRow() - 1, p.getColumn() - 1);
				}
				
				if (getBoard().positionExists(p) && isThereOpponentPiece(p))  {
					
					mat[p.getRow()][p.getColumn()] = true;
				} 			
			
			// verificar acima da minha peça - para sudeste
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			while (getBoard().positionExists(p) && !getBoard().theresAPiece(p)) {
				
				mat[p.getRow()][p.getColumn()] = true;
				p.setValues(p.getRow() + 1, p.getColumn() + 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))  {
				
				mat[p.getRow()][p.getColumn()] = true;
			} 		
			
			// verificar acima da minha peça - pata sudoeste
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			while (getBoard().positionExists(p) && !getBoard().theresAPiece(p)) {
				
				mat[p.getRow()][p.getColumn()] = true;
				p.setValues(p.getRow() + 1, p.getColumn() - 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))  {
				
				mat[p.getRow()][p.getColumn()] = true;
			}
		
		return mat;
	}
}

package chess;

import boardgame.BoardException;

/**
 * Classe ChessException parar exeções personalizadas.
 * @author Vinicius-PC.
 */
public class ChessException extends BoardException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	// Repassa a mensagem para o construtor da super classe RunTimeException - recebe a mensagem de exceção.
	public ChessException( String msg ) {
		super(msg);
	}
}

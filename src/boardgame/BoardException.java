package boardgame;

/**
 * Classe BoardException para personalização de exceção.
 * @author Vinicius-PC
 */
public class BoardException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	// Repassa a mensagem para o construtor da super classe RunTimeException - recebe a mensagem de exceção.
	public BoardException( String msg ) {
		super(msg);
	}
}

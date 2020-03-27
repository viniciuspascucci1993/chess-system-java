package boardgame;

/**
 * Classe BoardException para personaliza��o de exce��o.
 * @author Vinicius-PC
 */
public class BoardException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	// Repassa a mensagem para o construtor da super classe RunTimeException - recebe a mensagem de exce��o.
	public BoardException( String msg ) {
		super(msg);
	}
}

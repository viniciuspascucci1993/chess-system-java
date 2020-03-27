package chess;

/**
 * Classe ChessException parar exe��es personalizadas.
 * @author Vinicius-PC.
 */
public class ChessException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	// Repassa a mensagem para o construtor da super classe RunTimeException - recebe a mensagem de exce��o.
	public ChessException( String msg ) {
		super(msg);
	}
}

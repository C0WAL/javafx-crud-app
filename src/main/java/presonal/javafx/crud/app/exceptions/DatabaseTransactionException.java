package presonal.javafx.crud.app.exceptions;

@SuppressWarnings("serial")
public class DatabaseTransactionException extends RuntimeException {

	public DatabaseTransactionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatabaseTransactionException(String message) {
		super(message);
	}

}

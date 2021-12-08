package presonal.javafx.crud.app.exceptions;

@SuppressWarnings("serial")
public class BadInputException extends RuntimeException {

	public BadInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadInputException(String message) {
		super(message);
	}
}


public class IllegalDateParametersException extends Exception {
    public IllegalDateParametersException() {
        super();
    }

    public IllegalDateParametersException(String message) {
        super(message);
    }

    public IllegalDateParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalDateParametersException(Throwable cause) {
        super(cause);
    }

    protected IllegalDateParametersException(String message,
                                             Throwable cause,
                                             boolean enableSuppression,
                                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

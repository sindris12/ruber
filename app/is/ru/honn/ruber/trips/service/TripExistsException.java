package is.ru.honn.ruber.trips.service;

/**
 * Created by arnif on 10/24/14.
 */
public class TripExistsException extends RuntimeException{

    public TripExistsException() {
    }

    public TripExistsException(String message) {
        super(message);
    }

    public TripExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TripExistsException(Throwable cause) {
        super(cause);
    }

    public TripExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

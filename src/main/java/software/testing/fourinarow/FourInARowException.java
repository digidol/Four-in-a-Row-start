package software.testing.fourinarow;

/**
 * Represents an error in Four In A Row game.
 *
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class FourInARowException extends Exception {

    /**
     * Creates a new exception, with the specified message.
     *
     * @param message The message.
     */
    public FourInARowException(String message) {
        super(message);
    }
}

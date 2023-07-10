package task1.exception;

public class NullElementException extends IllegalArgumentException {

    public NullElementException() {
        super("Incorrect element in array - null element.");
    }
}

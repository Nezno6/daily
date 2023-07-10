package task1.exception;

public class EmptyArrayException extends IllegalArgumentException {

    public EmptyArrayException() {
        super("Incorrect array length - none element in array.");
    }
}

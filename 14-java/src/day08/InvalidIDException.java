package day08;

public class InvalidIDException extends Exception {
    public InvalidIDException() {
        super("Invalid Value.");
    }

    public InvalidIDException(String message) {
        super(message);
    }
}
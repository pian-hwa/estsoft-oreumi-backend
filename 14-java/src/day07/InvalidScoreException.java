package day07;

public class InvalidScoreException extends Exception {
    public InvalidScoreException() {
        super("Invalid score.");
    }

    public InvalidScoreException(String message) {
        super(message);
    }
}
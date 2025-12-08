package day07;

public class NegativeScoreException extends Exception {
    public NegativeScoreException() {
        super("Invalid score.");
    }

    public NegativeScoreException(String message) {
        super(message);
    }
}

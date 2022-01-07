package bank.domain.exceptions;

public class InvalidValueException extends Exception {
    
    public InvalidValueException(String message) {
        super("Invalid Value: " + message);
    }
}

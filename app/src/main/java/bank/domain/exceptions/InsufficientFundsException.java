package bank.domain.exceptions;

public class InsufficientFundsException extends Exception {
    
    public InsufficientFundsException() {
        super("Insufficient Funds");
    }

    public InsufficientFundsException(String message) {
        super("Insufficient Funds: " + message);
    }
}

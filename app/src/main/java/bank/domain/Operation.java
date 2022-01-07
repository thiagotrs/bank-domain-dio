package bank.domain;

import bank.domain.exceptions.InsufficientFundsException;
import bank.domain.exceptions.InvalidValueException;

public interface Operation {
    void withdraw(double value) throws InvalidValueException, InsufficientFundsException;
    void deposit(double value) throws InvalidValueException;
    void printBalance();
}

package bank.domain.entities;

import java.util.LinkedHashSet;
import java.util.Set;

import bank.domain.Operation;
import bank.domain.exceptions.InsufficientFundsException;
import bank.domain.exceptions.InvalidValueException;

public class Bank {
    private String name;
    private Set<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new LinkedHashSet<>();
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void transfer(Operation fromAccount, Operation toAccount, double value) throws InvalidValueException, InsufficientFundsException {
        fromAccount.withdraw(value);
        toAccount.deposit(value);
    }

    @Override
    public String toString() {
        return "Bank [name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bank other = (Bank) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}

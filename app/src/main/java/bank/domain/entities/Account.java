package bank.domain.entities;

import bank.domain.Operation;
import bank.domain.exceptions.InsufficientFundsException;
import bank.domain.exceptions.InvalidValueException;

public abstract class Account implements Operation {
    private final int DEFAULT_AGENCY = 1;
    private static int SEQ = 1;

    private int agency;
    private int accountNum;
    private double balance;
    private Client client;
    private double overdraft;

    public Account(Client client, double overdraft) throws InvalidValueException, InsufficientFundsException {
        this.client = client;
        this.agency = this.DEFAULT_AGENCY;
        this.accountNum = Account.SEQ++;
        this.setOverdraft(overdraft);
    }

    public double getOverdraft() {
        return overdraft;
    }

    protected void setOverdraft(double overdraft) throws InvalidValueException, InsufficientFundsException {
        if(overdraft < 0) throw new InvalidValueException("Can not be negative.");
        if(-overdraft > this.getBalance()) throw new InsufficientFundsException("Operation break policy");
        this.overdraft = overdraft;
    }

    public Client getClient() {
        return client;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public int getAgency() {
        return agency;
    }

    public double getBalance() {
        return balance;
    }

    private double setBalance(double value) {
        return balance += value;
    }

    @Override
    public void deposit(double value) throws InvalidValueException {
        if(value <= 0) throw new InvalidValueException("Can not be negative or zero.");
        this.setBalance(value);
    }

    @Override
    public void withdraw(double value) throws InvalidValueException, InsufficientFundsException {
        if(value <= 0) throw new InvalidValueException("Can not be negative or zero.");
        if(value > (this.getBalance() + this.getOverdraft())) throw new InsufficientFundsException();
        this.setBalance(-value);
    }

    @Override
    public String toString() {
        return "Account [accountNum=" + accountNum + ", agency=" + agency + ", balance=" + String.format("%.2f", this.getBalance()) + ", client="
                + client + ", overdraft=" + String.format("%.2f", this.getOverdraft()) + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + accountNum;
        result = prime * result + agency;
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
        Account other = (Account) obj;
        if (accountNum != other.accountNum)
            return false;
        if (agency != other.agency)
            return false;
        return true;
    }   
}

package bank.domain.entities;

import bank.domain.exceptions.InsufficientFundsException;
import bank.domain.exceptions.InvalidValueException;

public class CheckingAccount extends Account {

    private final static double DEFAULT_OVERDRAFT = 100;

    public CheckingAccount(Client client) throws InvalidValueException, InsufficientFundsException {
        super(client, DEFAULT_OVERDRAFT);
    }

    @Override
    public void printBalance() {
        System.out.println("---------------");
        System.out.println("Checking Account:");
        System.out.println("Agency nº: " + this.getAgency());
        System.out.println("Account nº: " + this.getAccountNum());
        System.out.println("Client: " + this.getClient().getName());
        System.out.println("---------------");
        System.out.printf("TOTAL: %.2f\n", this.getBalance());
        System.out.println("---------------");
    }

    @Override
    public void setOverdraft(double overdraft) throws InvalidValueException, InsufficientFundsException {
        super.setOverdraft(overdraft);
    }

    @Override
    public String toString() {
        return "CheckingAccount [accountNum=" + this.getAccountNum() + ", agency=" + this.getAgency() + ", balance=" + String.format("%.2f", this.getBalance()) + ", client="
        + this.getClient() + ", overdraft=" + String.format("%.2f", this.getOverdraft()) + "]";
    }
}

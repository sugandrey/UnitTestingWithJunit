package com.company;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;
    public static final int CHECKING = 1;
    public static final int SAVING = 2;
    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }
    // the branch argument is true if the customer is performing the transaction in the branch with a teller
    // he branch argument is false if the customer is performing the transaction at an ATM
    public double deposit(Double amount, boolean branch) {
        balance += amount;
        return balance;
    }
    // the branch argument is true if the customer is performing the transaction in the branch with a teller
    // he branch argument is false if the customer is performing the transaction at an ATM
    public double withdraw(Double amount, boolean branch) {
        if(amount > 500 && !branch) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
    // more methods that use firstName, lastName, and perform other functions
    public boolean isChecking() {
        return accountType == CHECKING;
    }
}

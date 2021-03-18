package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account;
    private Double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(Double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Andrey","Sugr",1000.0,BankAccount.CHECKING);
        System.out.println("Running a test...");
    }
    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
            {100.0,true,1100.0},
            {200.0,true,1200.0},
            {325.14,true,1325.14},
            {489.33,true,1489.33},
            {1000.0,true,2000.00}
        });
    }
    @org.junit.Test
    public void deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }
}

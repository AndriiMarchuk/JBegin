package com.luxoft.bankapp.domain;

public interface Account
{
    public void deposit(double amount);

    public void withdraw(double amount);

    public int getId();

    public double getBalance();

    public double maximumAmountToWithdraw();
}

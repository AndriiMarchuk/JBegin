package com.luxoft.bankapp.domain;

public interface Account
{
    void deposit(double amount);

    void withdraw(double amount);

    int getId();

    double getBalance();

    double maximumAmountToWithdraw();
}

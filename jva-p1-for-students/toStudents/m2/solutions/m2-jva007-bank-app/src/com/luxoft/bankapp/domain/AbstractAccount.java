package com.luxoft.bankapp.domain;

public abstract class AbstractAccount implements Account
{

    private int id;
    protected double balance;

    public AbstractAccount(int id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public void deposit(final double amount)
    {
        if (amount < 0)
        {
            throw new IllegalArgumentException("Cannot deposit a negative amount");
        }
        balance += amount;
    }

    @Override
    public void withdraw(final double amount)
    {
        if (amount < 0)
        {
            throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }

        if (amount > maximumAmountToWithdraw())
        {
            // TODO
            throw new IllegalStateException(id + " " + balance + " " + amount + ". Requested amount exceeds the maximum amount to withdraw");
        }

        balance -= amount;
    }

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public double getBalance()
    {
        return balance;
    }

}

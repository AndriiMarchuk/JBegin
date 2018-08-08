package com.luxoft.bankapp.domain;

public class CheckingAccount extends AbstractAccount
{

    private double overdraft;

    public CheckingAccount(int id, double balance, double overdraft)
    {
        super(id, balance);
        if (overdraft < 0)
        {
            throw new IllegalArgumentException("Cannot create an account with a starting negative overdraft.");
        }
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double value)
    {
        super.withdraw(value);
    }

    public double getOverdraft()
    {
        return overdraft;
    }

    public double maximumAmountToWithdraw()
    {
        return getBalance() + overdraft;
    }
}

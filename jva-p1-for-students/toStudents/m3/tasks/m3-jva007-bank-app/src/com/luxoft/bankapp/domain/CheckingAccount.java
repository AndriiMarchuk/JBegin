package com.luxoft.bankapp.domain;

public class CheckingAccount extends AbstractAccount
{

    private double overdraft;

    public CheckingAccount(int id, double balance, double overdraft)
    {
        super(id, balance);
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

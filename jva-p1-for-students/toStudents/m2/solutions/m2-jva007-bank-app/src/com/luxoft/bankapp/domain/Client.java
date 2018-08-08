package com.luxoft.bankapp.domain;

import java.util.Arrays;

public class Client
{

    private String name;
    private Gender gender;

    private Account[] accounts;

    private int numberOfAccounts;

    public Client(String name, Gender gender)
    {
        this.name = name;
        this.gender = gender;

        this.accounts = new Account[100];
        this.numberOfAccounts = 0;
    }

    public void addAccount(final Account account)
    {
        accounts[numberOfAccounts++] = account;
    }

    public String getName()
    {
        return name;
    }

    public Gender getGender()
    {
        return gender;
    }

    public Account[] getAccounts()
    {
        return Arrays.copyOfRange(accounts, 0, numberOfAccounts);
    }

    public String getClientGreeting()
    {
        if (gender != null)
        {
            return gender.getGreeting() + " " + name;
        }
        else
        {
            return name;
        }
    }

    @Override
    public String toString()
    {
        return getClientGreeting();
    }

}

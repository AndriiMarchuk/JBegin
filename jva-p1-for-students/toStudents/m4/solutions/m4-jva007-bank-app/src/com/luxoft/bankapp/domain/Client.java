package com.luxoft.bankapp.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client extends Indexed
{
    private String name;
    private Gender gender;

    private List<Account> accounts;

    public Client(String name, Gender gender)
    {
        this.name = name;
        this.gender = gender;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(final Account account)
    {
        accounts.add(account);
    }

    public String getName()
    {
        return name;
    }

    public Gender getGender()
    {
        return gender;
    }

    public List<Account> getAccounts()
    {
        return Collections.unmodifiableList(accounts);
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

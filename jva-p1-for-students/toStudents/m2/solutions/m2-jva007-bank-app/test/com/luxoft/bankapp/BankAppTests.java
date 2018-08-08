package com.luxoft.bankapp;

import com.luxoft.bankapp.domain.*;
import com.luxoft.bankapp.service.BankService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAppTests
{
    private Bank bank;


    @Test
    public void testSavingAccountId()
    {
        SavingAccount savingAccount = getSavingAccount();

        assertEquals(1, savingAccount.getId());
    }

    @Test
    public void testSavingAccountBalance()
    {
        SavingAccount savingAccount = getSavingAccount();

        assertEquals(1050, savingAccount.getBalance(), 0);
    }

    @Test
    public void testSavingAccountMaximumAmountToWithdraw()
    {
        SavingAccount savingAccount = getSavingAccount();

        assertEquals(1050, savingAccount.maximumAmountToWithdraw(), 0);
    }

    private SavingAccount getSavingAccount()
    {
        SavingAccount savingAccount = new SavingAccount(1, 1000.0);
        savingAccount.deposit(100.0);
        savingAccount.withdraw(50.0);
        return savingAccount;
    }

    @Test
    public void testCheckingAccountId()
    {
        CheckingAccount checkingAccount = getCheckingAccount();

        assertEquals(2, checkingAccount.getId());
    }

    @Test
    public void testCheckingAccountBalance()
    {
        CheckingAccount checkingAccount = getCheckingAccount();

        assertEquals(-50, checkingAccount.getBalance(), 0);
    }

    @Test
    public void testCheckingAccountOverdraft()
    {
        CheckingAccount checkingAccount = getCheckingAccount();

        assertEquals(100, checkingAccount.getOverdraft(), 0);
    }

    @Test
    public void testCheckingAccountMaximumAmountToWithdraw()
    {
        CheckingAccount checkingAccount = getCheckingAccount();

        assertEquals(50, checkingAccount.maximumAmountToWithdraw(), 0);
    }

    private CheckingAccount getCheckingAccount()
    {
        CheckingAccount checkingAccount = new CheckingAccount(2, 1000.0, 100.0);
        checkingAccount.deposit(100.0);
        checkingAccount.withdraw(1150.0);
        return checkingAccount;
    }

    @Test
    public void testClientAccountsLength()
    {
        Client client = getClient();

        assertEquals(2, client.getAccounts().length);
    }

    @Test
    public void testClientGreeting()
    {
        Client client = getClient();

        assertEquals("Mr. Smith John", client.getClientGreeting());
    }

    @Test
    public void testClientToString()
    {
        Client client = getClient();

        assertEquals("Mr. Smith John", client.toString());
    }

    private Client getClient()
    {
        Client client = new Client("Smith John", Gender.MALE);
        client.addAccount(new SavingAccount(1, 1000.0));
        client.addAccount(new CheckingAccount(2, 1000.0, 100.0));
        return client;
    }


    @Before
    public void initBank()
    {
        bank = new Bank();

        Client client1 = getClient();

        Client client2 = new Client("Smith Michelle", Gender.FEMALE);
        client2.addAccount(new SavingAccount(3, 2000.0));
        client2.addAccount(new CheckingAccount(4, 1500.0, 200.0));

        BankService.addClient(bank, client1);
        BankService.addClient(bank, client2);
    }

    @Test
    public void testNumberOfClients()
    {
        assertEquals(2, bank.getClients().length);
    }

    @Test
    public void testClientGreeting1()
    {
        assertEquals("Mr. Smith John", bank.getClients()[0].getClientGreeting());
    }

    @Test
    public void testClientGreeting2()
    {
        assertEquals("Ms. Smith Michelle", bank.getClients()[1].getClientGreeting());
    }

    @Test
    public void testClientToString1()
    {
        assertEquals("Mr. Smith John", bank.getClients()[0].toString());
    }

    @Test
    public void testClientToString2()
    {
        assertEquals("Ms. Smith Michelle", bank.getClients()[1].toString());
    }

}

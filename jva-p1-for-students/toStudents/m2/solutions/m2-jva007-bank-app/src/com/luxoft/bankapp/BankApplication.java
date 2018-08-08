package com.luxoft.bankapp;

import com.luxoft.bankapp.domain.Account;
import com.luxoft.bankapp.domain.Bank;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.Client;
import com.luxoft.bankapp.domain.Gender;
import com.luxoft.bankapp.domain.SavingAccount;
import com.luxoft.bankapp.service.BankService;

public class BankApplication
{

    private static Bank bank;

    public static void main(String[] args)
    {
        bank = new Bank();
        modifyBank();
        printBalance();
        BankService.printMaximumAmountToWithdraw(bank);
    }

    private static void modifyBank()
    {
        Client client1 = new Client("John", Gender.MALE);
        Account account1 = new SavingAccount(1, 100);
        Account account2 = new CheckingAccount(2, 100, 20);
        client1.addAccount(account1);
        client1.addAccount(account2);

        BankService.addClient(bank, client1);

        account1.deposit(100);
        account1.withdraw(10);

        account2.withdraw(90);

        try
        {
            account2.withdraw(100);
        }
        catch (IllegalStateException e)
        {
            System.out.format("Not enough funds for account.");
        }

        try
        {
            BankService.addClient(bank, client1);
        }
        catch (IllegalStateException e)
        {
            System.out.format("Cannot add an already existing client: %s%n", client1);
        }
    }

    private static void printBalance()
    {
        System.out.format("%nPrint balance for all clients%n");
        for (Client client : bank.getClients())
        {
            System.out.println("Client: " + client);
            for (Account account : client.getAccounts())
            {
                System.out.format("Account %d : %.2f%n", account.getId(), account.getBalance());
            }
        }
    }

}

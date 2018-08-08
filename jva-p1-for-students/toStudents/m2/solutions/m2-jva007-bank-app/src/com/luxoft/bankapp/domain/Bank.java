package com.luxoft.bankapp.domain;

import java.util.Arrays;

public class Bank
{
    private int printedClients = 0;
    private int emailedClients = 0;
    private int debuggedClients = 0;

    private final Client[] clients;
    private int numberOfClients;

    public Bank()
    {
        this.clients = new Client[100];
    }

    public int getPrintedClients()
    {
        return printedClients;
    }

    public int getEmailedClients()
    {
        return emailedClients;
    }

    public int getDebuggedClients()
    {
        return debuggedClients;
    }

    public void addClient(final Client client)
    {
        for (Client c : clients)
        {
            if (c == null)
            {
                break;
            }

            if (c.equals(client))
            {
                throw new IllegalStateException("Client already exists into the bank");
            }
        }

        clients[numberOfClients++] = client;
    }

    public Client[] getClients()
    {
        return Arrays.copyOfRange(clients, 0, numberOfClients);
    }
}





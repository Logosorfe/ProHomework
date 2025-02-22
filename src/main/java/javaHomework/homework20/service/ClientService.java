package javaHomework.homework20.service;

import javaHomework.homework20.model.Client;

import java.util.Set;

public interface ClientService {

    Set<Client> getAllClients();

    Client getClientById(String uuid);

    Client addClient(Client client);

    Client removeClientById(String uuid);
}

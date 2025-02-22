package javaHomework.homework20.service;

import javaHomework.homework20.model.Client;
import javaHomework.homework20.repository.ClientInMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientInMemoryRepository repository;

    @Override
    public Set<Client> getAllClients() {
        return repository.getAllClients();
    }

    @Override
    public Client getClientById(String uuid) {
        return repository.getClientById(uuid);
    }

    @Override
    public Client addClient(Client client) {
        return repository.addClient(client);
    }

    @Override
    public Client removeClientById(String uuid) {
        return repository.removeClientById(uuid);
    }
}

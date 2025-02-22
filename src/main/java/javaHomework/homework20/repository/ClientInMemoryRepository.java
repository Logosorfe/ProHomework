package javaHomework.homework20.repository;

import javaHomework.homework20.model.Client;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class ClientInMemoryRepository {

    private Map<String, Client> clients = new HashMap<>();

    public ClientInMemoryRepository() {init();}

    private void init() {
        Client alex = new Client("Alex Jones", "a.jones@gmail.com", "555-320-705");
        Client peter = new Client("Peter Pan", "p.pan@gmail.com", "555-328-766");
        Client john = new Client("John Smith", "j.smith@gmail.com", "555-469-666");

        clients.put(alex.getId(), alex);
        clients.put(peter.getId(), peter);
        clients.put(john.getId(), john);
    }

    public Set<Client> getAllClients() {
        return new HashSet<>(clients.values());
    }

    public Client getClientById(String uuid) {
        return clients.get(uuid);
    }

    public Client addClient(Client client) {
        Client newClient = new Client(client.getName(), client.getEmail(), client.getPhone());
        clients.put(newClient.getId(), newClient);
        return newClient;
    }

    public Client removeClientById(String uuid) {
        return clients.remove(uuid);
    }
}

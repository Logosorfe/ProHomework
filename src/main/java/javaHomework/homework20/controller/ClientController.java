package javaHomework.homework20.controller;

import javaHomework.homework20.model.Client;
import javaHomework.homework20.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public Set<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{uuid}")
    public Client getClientById(@PathVariable String uuid) {
        return clientService.getClientById(uuid);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @DeleteMapping("/{uuid}")
    public Client removeClientById(@PathVariable String uuid) {
        return clientService.removeClientById(uuid);
    }
}

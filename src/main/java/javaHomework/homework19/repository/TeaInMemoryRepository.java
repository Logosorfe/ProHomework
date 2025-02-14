package javaHomework.homework19.repository;


import javaHomework.homework19.model.Tea;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class TeaInMemoryRepository {

    private Map<String, Tea> storage = new HashMap<>();

    public TeaInMemoryRepository() {
        init();
    }

    private void init() {
        Tea lipton = new Tea("Lipton");
        Tea tetley = new Tea("Tetley");
        Tea dilmah = new Tea("Dilmah");
        Tea greenfield = new Tea("Greenfield");

        storage.put(tetley.getId(), tetley);
        storage.put(lipton.getId(), lipton);
        storage.put(dilmah.getId(), dilmah);
        storage.put(greenfield.getId(), greenfield);
    }

    public Set<Tea> getAll() {
        return new HashSet<>(storage.values());
    }

    public Tea add(Tea tea) {
        Tea newTea = new Tea(tea.getName());
        storage.put(newTea.getId(), newTea);
        return newTea;
    }

    public Tea getById(String uuid) {
       return storage.get(uuid);
    }
}

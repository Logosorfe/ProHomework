package javaHomework.homework19.service;

import javaHomework.homework19.model.Tea;
import javaHomework.homework19.repository.TeaInMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeaServiceImpl implements TeaService {

    @Autowired
    private TeaInMemoryRepository repository;

    @Override
    public Set<Tea> getAll() {
        return repository.getAll();
    }

    @Override
    public Tea getById(String uuid) {
        return repository.getById(uuid);
    }

    @Override
    public Tea add(Tea tea) {
        return repository.add(tea);
    }
}

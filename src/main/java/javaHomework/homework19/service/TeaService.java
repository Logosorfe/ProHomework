package javaHomework.homework19.service;



import javaHomework.homework19.model.Tea;

import java.util.Set;

public interface TeaService {

    Set<Tea> getAll();

    Tea getById(String uuid);

    Tea add(Tea tea);
}

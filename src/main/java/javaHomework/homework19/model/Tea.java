package javaHomework.homework19.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Tea {

    private final String id;

    private final String name;

    public Tea(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tea(String name) {
        this(UUID.randomUUID().toString(), name);
    }
}

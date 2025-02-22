package javaHomework.homework20.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Client {

    private final String id;

    private final String name;

    private final String email;

    private final String phone;

    public Client(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Client(String name, String email, String phone) {
        this(UUID.randomUUID().toString(), name, email, phone);
    }
}

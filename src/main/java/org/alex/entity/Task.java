package org.alex.entity;

import java.util.UUID;

public class Task {

    final private String name;
    final String uid = String.valueOf(UUID.randomUUID());

    public Task (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

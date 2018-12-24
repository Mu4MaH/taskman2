package org.alex.entity;

import java.util.UUID;

public class Project {

    private final String name;
    final String uid = String.valueOf(UUID.randomUUID());

    Project (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

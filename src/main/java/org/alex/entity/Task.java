package org.alex.entity;

import java.util.UUID;

public class Task {

    private String name;
    private String uid = String.valueOf(UUID.randomUUID());

    public Task(){}

    public Task (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}

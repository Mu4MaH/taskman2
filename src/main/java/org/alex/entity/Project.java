package org.alex.entity;

import org.alex.repository.ProjectRepository;

import java.util.UUID;

public class Project {

    private String name;
    private String uid = String.valueOf(UUID.randomUUID());

    public Project() {}

    public Project (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}

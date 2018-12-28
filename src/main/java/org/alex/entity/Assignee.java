package org.alex.entity;

import java.util.UUID;

public class Assignee {

    private String uid = UUID.randomUUID().toString();
    private String name = "Unnamed_assignee";

    public Assignee() {
    }

    public Assignee(String name) {
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

    @Override
    public String toString() {
        return this.uid + " : " + this.name;
    }
}

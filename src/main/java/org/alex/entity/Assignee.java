package org.alex.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Assignee implements Serializable {

    private String uid = UUID.randomUUID().toString();
    private String name = "Unnamed_assignee";
    private final List<String> taskList = new ArrayList();

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

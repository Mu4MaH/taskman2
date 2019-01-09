package org.alex.entity;

import java.io.Serializable;
import java.util.UUID;

public class Project implements Serializable {

    private String uid = String.valueOf(UUID.randomUUID());
    private String name;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Project() {
        this.name = "default";
    }

    public Project(String name) {
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

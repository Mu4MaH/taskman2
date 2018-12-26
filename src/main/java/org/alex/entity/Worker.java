package org.alex.entity;

import java.util.UUID;

public class Worker {

    private String name;
    private String uid;

    public Worker(){
        this.name = "unnamed worker";
        this.uid = UUID.randomUUID().toString();
    }

    public Worker(String name){
        this.name = name;
        this.uid = UUID.randomUUID().toString();
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

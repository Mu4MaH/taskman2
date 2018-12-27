package org.alex.entity;

import java.util.UUID;

public class Worker {

    private String uid = UUID.randomUUID().toString();
    private String name;

    public Worker(){
        this.name = "unnamed_worker";
    }

    public Worker(String name){
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

package org.alex.entity;

import java.io.Serializable;
import java.util.UUID;

public class Assignee implements Serializable {

    private String uid = UUID.randomUUID().toString();
    private String name = "Unnamed_assignee";
    private String login;
    private String password;
    private String group; //TODO
    private boolean isAdmin = false;

    public Assignee() {
    }

    public Assignee(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassHash() {
        return this.password.hashCode();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return this.isAdmin;
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

    public void setAdmin() {
        this.isAdmin = true;
    }

    /* -= Конструктор для тестов =- */

    public Assignee(String name, String login, String password, String group, boolean isAdmin) {
        this.uid = UUID.randomUUID().toString();
        this.name = name;
        this.login = login;
        this.password = password;
        this.group = group;
        this.isAdmin = isAdmin;
    }

    /*    ***    */

    @Override
    public String toString() {
        return this.uid + " # " + this.name + " : " + this.login;
    }
}

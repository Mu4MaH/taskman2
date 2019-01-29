package org.alex.entity;

import org.alex.api.entity.AbstractEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.UUID;

public class Assignee extends AbstractEntity implements Serializable {


    private String uid = String.valueOf(UUID.randomUUID());

    private String name = "Unnamed_assignee";

    private String login;

    private int password;

    private String group;

    private boolean isAdmin = false;

    public Assignee() {
    }

    public Assignee(@NotNull String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(@NotNull String group) {
        this.group = group;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(@NotNull String login) {
        this.login = login;
    }

    public int getPassword() {
        return this.password;
    }

    public void setPassword(@NotNull int password) {
        this.password = password;
    }

    public boolean getAdmin() {
        return this.isAdmin;
    }


    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull public String getUid() {
        return uid;
    }

    public void setUid(@NotNull String uid) {
        this.uid = uid;
    }

    public void setAdmin() {
        this.isAdmin = true;
    }

    /* -= Конструктор для тестов =- */

    public Assignee(String name, String login, int password, String group, boolean isAdmin) {
        this.uid = String.valueOf(UUID.randomUUID());
        this.name = name;
        this.login = login;
        this.password = password;
        this.group = group;
//        this.isAdmin = isAdmin;
    }

    /*    ***    */

    @Override
   @Nullable public String toString() {
        return this.uid + " : " + this.name + " : " + this.login + " : " + this.group;
    }

    public boolean equals(Assignee assignee) {
        if (this.getLogin().equals(assignee.getLogin())); return true;
        //else return false;
    }
}

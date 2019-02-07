package org.alex.entity;

import lombok.Getter;
import lombok.Setter;
import org.alex.api.entity.AbstractEntity;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "assignee")

public class Assignee extends AbstractEntity implements Serializable {


    @Id
    @Column
    @Getter
    @Setter
    private String uid = String.valueOf(UUID.randomUUID());

    @Column
    @Getter
    @Setter
    private String name = "Unnamed_assignee";

    @Column
    @Getter
    @Setter
    private String login;

    @Column(name = "pass")
    @Getter
    @Setter
    private Integer password;

    @Column(name = "grp")
    @Getter
    @Setter
    private String group;

    @Column(name = "isadmin")
    private boolean isAdmin = false;

    public Assignee() {
    }

    public boolean getAdmin() {
        return this.isAdmin;
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
    }
}

package org.alex.entity;

import org.alex.api.entity.AbstractEntity;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.UUID;

public class Project extends AbstractEntity implements Serializable {

    private String uid = String.valueOf(UUID.randomUUID());
    private String name;
    private String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(@NotNull String ownerId) {
        this.ownerId = ownerId;
    }

    public Project() {
        this.name = "default";
    }

    public Project(@NotNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(@NotNull String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return this.uid + " : " + this.name;
    }

    public Project(@NotNull String uid, @NotNull String name, @NotNull String ownerId) {
        this.uid = uid;
        this.name = name;
        this.ownerId = ownerId;
    }
}

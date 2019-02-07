package org.alex.entity;

import lombok.Getter;
import lombok.Setter;
import org.alex.api.entity.AbstractEntity;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "project")
public class Project extends AbstractEntity implements Serializable {

    @Id
    @Column
    @Getter
    @Setter
    private String uid = String.valueOf(UUID.randomUUID());

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String ownerId;

    public Project() {
        this.name = "default";
    }

    public Project(@NotNull String name) {
        this.name = name;
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

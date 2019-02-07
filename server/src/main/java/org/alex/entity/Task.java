package org.alex.entity;

import lombok.Getter;
import lombok.Setter;
import org.alex.api.entity.AbstractEntity;
import org.alex.enumerated.Priority;
import org.alex.enumerated.State;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="app_task")
public class Task extends AbstractEntity implements Serializable {

    @Id
    @Column
    @Getter
    @Setter
    private String uid = String.valueOf(UUID.randomUUID());

    @Column
    @Getter
    @Setter
    private String name = "New_task";

    @Column
    @Getter
    @Setter
    private Integer hours = 0; //TODO: время в часах, при выдаче инфы пользователю пересчёт в рабочие дни /8 + остаток в часах

    @Column
    @Getter
    @Enumerated(EnumType.STRING)
    private State state = State.OPEN;

    @Column
    @Getter
    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.IDLE;

    @Column
    @Getter
    @Setter
    private String ownerId;

    public Task() {
    }



    public Task(@NotNull String name) {
        this.name = name;
    }

    /* Конструктор для тестирования */
    public Task(String uid, String name, int hours, State state, Priority priority) {
        this.uid = uid;
        this.name = name;
        this.hours = hours;
        this.state = state;
        this.priority = priority;
    }
    /*      ***     */


    public void setState(@NotNull String state) {
        this.state = State.OPEN;
        switch (state.toLowerCase()) {
            case "open":
                break;
            case "set":
                this.state = State.SET;
                break;
            case "inwork":
                this.state = State.INWORK;
                break;
            case "finished":
                this.state = State.FINISHED;
                break;
        }
    }

    public void setPriority(@NotNull String priority) {
        this.priority = Priority.IDLE;
        switch (priority.toLowerCase()) {
            case "idle":
                break;
            case "normal":
                this.priority = Priority.NORMAL;
                break;
            case "urgent":
                this.priority = Priority.URGENT;
                break;
            case "fatal":
                this.priority = Priority.FATAL;
                break;
        }
    }

    @Override
    public String toString() {
        return "Задача {" +
                "uid='" + uid + '\'' +
                ", name = '" + name + '\'' +
                ", время = " + hours/8 + " рабочих дней и " + hours%8 + " часов." +
                ", state = " + state +
                ", priority = " + priority +
                '}';
    }


    public Boolean equals(@Nullable Task task) {
        if (task == null) return false;
        return this.name.equals(task.getName());
    }
}

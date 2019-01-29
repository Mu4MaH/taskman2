package org.alex.entity;

import org.alex.api.entity.AbstractEntity;
import org.alex.enumerated.Priority;
import org.alex.enumerated.State;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.UUID;

public class Task extends AbstractEntity implements Serializable {

    private String uid = String.valueOf(UUID.randomUUID());
    private String name = "New_task";
    private Integer hours = 0; //TODO: время в часах, при выдаче инфы пользователю пересчёт в рабочие дни /8 + остаток в часах
    private State state = State.OPEN;
    private Priority priority = Priority.IDLE;
    private String ownerId;

    public Task() {
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(@NotNull String ownerId) {
        this.ownerId = ownerId;
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

    public int getHours() {
        return hours;
    }

    public void setHours(@NotNull int hours) {
        this.hours = hours;
    }

    public State getState() {
        return state;
    }

    public void setState(@NotNull String state) {
        switch (state.toLowerCase()) {
            case "open":
                this.state = State.OPEN;
                break;
            case "set":
                this.state = State.SET;
                break;
            case "inwork":
                this.state = State.INWORK;
                break;
            case "finished":
                this.state = State.FINISHED;

        }

    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(@NotNull String priority) {
        switch (priority.toLowerCase()) {
            case "idle":
                this.priority = Priority.IDLE;
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


    public boolean equals(@NotNull Task task) {
        if (task == null) return false;
        return this.name.equals(task.getName());
    }
}

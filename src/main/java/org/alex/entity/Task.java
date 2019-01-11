package org.alex.entity;

import org.alex.enumerated.Priority;
import org.alex.enumerated.State;

import java.io.Serializable;
import java.util.UUID;

public class Task implements Serializable {

    private String uid = String.valueOf(UUID.randomUUID());
    private String name = "New_task";
    private int hours = 0; //TODO: время в часах, при выдаче инфы пользователю пересчёт в рабочие дни /8 + остаток в часах
    private State state = State.OPEN;
    private Priority priority = Priority.IDLE;
    private String ownerId;

    public Task() {
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Task(String name) {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public State getState() {
        return state;
    }

    public void setState(int index) {
        for (State s : State.values()) {
            if (s.getIndex() == index) {
                this.state = s;
                return;
            }
        }
        this.state = State.OPEN;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(final int index) {
        for (Priority p : Priority.values()) {
            if (p.getIndex() == index) this.priority = p;
            else this.priority = Priority.IDLE;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", priority=" + priority +
                '}';
    }

}

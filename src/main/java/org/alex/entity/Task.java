package org.alex.entity;

import org.alex.enumerated.Priority;
import org.alex.enumerated.State;

import java.util.Map;
import java.util.UUID;

public class Task {

    private String uid = String.valueOf(UUID.randomUUID());
    private String name = "New_task";
    private int hours = 0; //TODO: время в часах, при выдаче инфы пользователю пересчёт в рабочие дни /8 + остаток в часах
    private String worker; //TODO: связь с ентити Assignee через класс-связку Assignee
    private State state = State.OPEN;
    private Priority priority = Priority.IDLE;

    public Task() {
            }

    public Task(String name) {
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

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public State getState() {
        return state;
    }

    public void setState(String state) {
        this.state = State.valueOf(state.toUpperCase());
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = Priority.valueOf(priority.toUpperCase());
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

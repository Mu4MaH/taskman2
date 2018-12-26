package org.alex.entity;

import org.alex.enumerated.Priority;
import org.alex.enumerated.State;

import java.util.UUID;

public class Task {

    private String name;
    private String uid;
    private int hours; //TODO: время в часах, при выдаче инфы пользователю пересчёт в рабочие дни /8 + остаток в часах
    private String worker; //TODO: связь с ентити Worker через класс-связку Assignee
    private State state;
    private Priority priority;

    public Task(){
        this.name = "default";
        this.uid = String.valueOf(UUID.randomUUID());
    }

    public Task (String name) {
        this.uid = String.valueOf(UUID.randomUUID());
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public void setName(String name) {
        this.name = name;
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

}

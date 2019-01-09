package org.alex.exception;

public class TaskNotFoundException extends Exception {

    public TaskNotFoundException() {
        super("Задача не найдена");
    }

}

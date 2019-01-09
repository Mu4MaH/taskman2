package org.alex.exception;

public class ProjectNotFoundException extends Exception {

    public ProjectNotFoundException() {
        super("Такой проект не найден");
    }

}

package org.alex.exception;

public class AssignmentNotFoundException extends Exception{

    public AssignmentNotFoundException() {
        super("Нет такого назначения");
    }

}

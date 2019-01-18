package org.alex.exception;

public class AssigneeNotFoundException extends Exception{

    public AssigneeNotFoundException() {
        super("Исполнитель не найден");
    }

}

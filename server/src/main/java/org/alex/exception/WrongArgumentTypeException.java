package org.alex.exception;

public class WrongArgumentTypeException extends Exception {

    public WrongArgumentTypeException() {
        super("Невалидные параметры вызова метода");
    }

}

package org.alex.exception;

public class IllegalArgumentException extends Exception {

    public IllegalArgumentException() {
        super("Невалидные параметры вызова метода");
    }

}

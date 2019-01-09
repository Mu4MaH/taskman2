package org.alex.exception;

public class IllegalCallParameterException extends Exception {

    public IllegalCallParameterException() {
        super("Невалидные параметры вызова метода");
    }

}

package org.alex.exception;

public class IdNotFoundException extends Exception {

    public IdNotFoundException() {
        super("Такого ай ди нет в списке");
    }

    public IdNotFoundException(String message) {
        super(message);
    }

}

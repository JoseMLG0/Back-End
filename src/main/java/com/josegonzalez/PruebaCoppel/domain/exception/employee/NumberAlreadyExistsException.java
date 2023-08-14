package com.josegonzalez.PruebaCoppel.domain.exception.employee;

public class NumberAlreadyExistsException extends RuntimeException {

    public NumberAlreadyExistsException(String number) {
        super("El numero de empleado '" + number + "' ya existe.");
    }
}
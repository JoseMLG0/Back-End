package com.josegonzalez.PruebaCoppel.domain.exception.employee;

public class IdNotExistsException extends RuntimeException {

    public IdNotExistsException(Long id) {
        super("El ID de empleado '" + id + "' no existe.");
    }
}
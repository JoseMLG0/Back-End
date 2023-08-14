package com.josegonzalez.PruebaCoppel.domain.exception.employee;

public class RoleNotExistsException extends RuntimeException {

    public RoleNotExistsException(String role) {
        super("El rol '" + role + "' no existe.");
    }
}
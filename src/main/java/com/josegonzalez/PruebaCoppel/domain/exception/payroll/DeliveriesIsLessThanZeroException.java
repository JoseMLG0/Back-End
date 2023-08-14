package com.josegonzalez.PruebaCoppel.domain.exception.payroll;

public class DeliveriesIsLessThanZeroException extends RuntimeException {

    public DeliveriesIsLessThanZeroException(Integer deliveries) {
        super("Las entragas realizadas '" + deliveries + "' no puede ser menor a 0.");
    }
}
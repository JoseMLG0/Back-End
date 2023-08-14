package com.josegonzalez.PruebaCoppel.application.usecases.employee;

import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.DeleteEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;

public class DeleteEmployee implements DeleteEmployeeUseCase {

    private final EmployeeRepositoryPort employeeRepositoryPort;


    public DeleteEmployee(EmployeeRepositoryPort employeeRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employeeRepositoryPort.deleteById(id);
    }
}

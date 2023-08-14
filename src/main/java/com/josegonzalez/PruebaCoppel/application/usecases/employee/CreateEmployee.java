package com.josegonzalez.PruebaCoppel.application.usecases.employee;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.CreateEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;

public class CreateEmployee implements CreateEmployeeUseCase {

    private final EmployeeRepositoryPort employeeRepositoryPort;


    public CreateEmployee(EmployeeRepositoryPort employeeRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
    }


    @Override
    public EmployeeModel createEmployee(EmployeeModel employee) {

        return employeeRepositoryPort.save(employee);
    }
}

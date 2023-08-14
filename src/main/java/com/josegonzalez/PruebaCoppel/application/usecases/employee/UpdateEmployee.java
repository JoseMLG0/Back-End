package com.josegonzalez.PruebaCoppel.application.usecases.employee;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.UpdateEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;

import java.util.Date;
import java.util.Optional;

public class UpdateEmployee implements UpdateEmployeeUseCase {
    private final EmployeeRepositoryPort employeeRepositoryPort;


    public UpdateEmployee(EmployeeRepositoryPort employeeRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
    }

    @Override
    public Optional<EmployeeModel> updateEmployee(Long id, EmployeeModel employee) {
        employee.setUpdatedDate(new Date());
        return employeeRepositoryPort.update(id, employee);
    }
}

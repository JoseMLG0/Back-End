package com.josegonzalez.PruebaCoppel.application.usecases.employee;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.RetrieveEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveEmployee implements RetrieveEmployeeUseCase {
    private final EmployeeRepositoryPort employeeRepositoryPort;


    public RetrieveEmployee(EmployeeRepositoryPort employeeRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
    }

    @Override
    public Optional<EmployeeModel> getEmployee(Long id) {
        return employeeRepositoryPort.findById(id);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepositoryPort.findAll();
    }
}

package com.josegonzalez.PruebaCoppel.application.services.employee;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.CreateEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.DeleteEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.RetrieveEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.UpdateEmployeeUseCase;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements CreateEmployeeUseCase, UpdateEmployeeUseCase, DeleteEmployeeUseCase, RetrieveEmployeeUseCase {

    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;
    private final DeleteEmployeeUseCase deleteEmployeeUseCase;
    private final RetrieveEmployeeUseCase retrieveEmployeeUseCase;

    public EmployeeService(CreateEmployeeUseCase createEmployeeUseCase, UpdateEmployeeUseCase updateEmployeeUseCase, DeleteEmployeeUseCase deleteEmployeeUseCase, RetrieveEmployeeUseCase retrieveEmployeeUseCase) {
        this.createEmployeeUseCase = createEmployeeUseCase;
        this.updateEmployeeUseCase = updateEmployeeUseCase;
        this.deleteEmployeeUseCase = deleteEmployeeUseCase;
        this.retrieveEmployeeUseCase = retrieveEmployeeUseCase;
    }

    @Override
    public EmployeeModel createEmployee(EmployeeModel employee) {
        return createEmployeeUseCase.createEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return deleteEmployeeUseCase.deleteEmployee(id);
    }

    @Override
    public Optional<EmployeeModel> getEmployee(Long id) {
        return retrieveEmployeeUseCase.getEmployee(id);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return retrieveEmployeeUseCase.getAllEmployees();
    }

    @Override
    public Optional<EmployeeModel> updateEmployee(Long id, EmployeeModel employee) {
        return updateEmployeeUseCase.updateEmployee(id, employee);
    }
}

package com.josegonzalez.PruebaCoppel.domain.ports.in.employee;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface RetrieveEmployeeUseCase {
    Optional<EmployeeModel> getEmployee(Long id);
    List<EmployeeModel> getAllEmployees();
}

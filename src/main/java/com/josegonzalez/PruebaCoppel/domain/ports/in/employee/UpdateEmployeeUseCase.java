package com.josegonzalez.PruebaCoppel.domain.ports.in.employee;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;

import java.util.Optional;

public interface UpdateEmployeeUseCase {
    Optional<EmployeeModel> updateEmployee(Long id, EmployeeModel employee);
}

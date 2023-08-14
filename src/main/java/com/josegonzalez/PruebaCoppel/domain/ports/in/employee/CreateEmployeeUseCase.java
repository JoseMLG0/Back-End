package com.josegonzalez.PruebaCoppel.domain.ports.in.employee;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;

public interface CreateEmployeeUseCase {
    EmployeeModel createEmployee(EmployeeModel employee);
}

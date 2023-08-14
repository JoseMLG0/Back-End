package com.josegonzalez.PruebaCoppel.domain.ports.out;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepositoryPort {
    EmployeeModel save(EmployeeModel employee);
    Optional<EmployeeModel> findById(Long id);
    List<EmployeeModel> findAll();
    Optional<EmployeeModel> update(Long id, EmployeeModel employee);
    boolean deleteById(Long id);
}

package com.josegonzalez.PruebaCoppel.domain.ports.out;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;

import java.util.List;
import java.util.Optional;

public interface PayrollRepositoryPort {
    PayrollModel save(EmployeeModel employee, PayrollModel payroll);
    Optional<PayrollModel> findById(Long id);
    List<PayrollModel> findAllByEmployeeId(EmployeeModel employee);
    Optional<PayrollModel> update(Long id, PayrollModel payroll);
    boolean deleteById(Long id);
}

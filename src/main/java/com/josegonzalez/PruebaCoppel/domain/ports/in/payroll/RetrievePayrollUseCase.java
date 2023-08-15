package com.josegonzalez.PruebaCoppel.domain.ports.in.payroll;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;

import java.util.List;
import java.util.Optional;

public interface RetrievePayrollUseCase {
    Optional<PayrollModel> getPayroll(Long id);
    List<PayrollModel> getAllPayrollFromEmployee(EmployeeModel employee);

    List<PayrollModel> findAll();
}

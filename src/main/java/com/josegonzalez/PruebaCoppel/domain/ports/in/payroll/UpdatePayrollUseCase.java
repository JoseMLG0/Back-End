package com.josegonzalez.PruebaCoppel.domain.ports.in.payroll;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;

import java.util.Optional;

public interface UpdatePayrollUseCase {
    Optional<PayrollModel> updatePayroll(Long id, PayrollModel payroll);
}

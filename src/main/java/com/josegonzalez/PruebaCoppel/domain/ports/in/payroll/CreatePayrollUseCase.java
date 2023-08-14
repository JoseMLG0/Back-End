package com.josegonzalez.PruebaCoppel.domain.ports.in.payroll;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;

public interface CreatePayrollUseCase {
    PayrollModel createPayroll(PayrollModel payroll, EmployeeModel employee);
}

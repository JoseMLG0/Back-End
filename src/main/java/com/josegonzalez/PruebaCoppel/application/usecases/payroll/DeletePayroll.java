package com.josegonzalez.PruebaCoppel.application.usecases.payroll;

import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.DeleteEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.payroll.DeletePayrollUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;
import com.josegonzalez.PruebaCoppel.domain.ports.out.PayrollRepositoryPort;

public class DeletePayroll implements DeletePayrollUseCase {

    private final PayrollRepositoryPort payrollRepositoryPort;


    public DeletePayroll(PayrollRepositoryPort payrollRepositoryPort) {
        this.payrollRepositoryPort = payrollRepositoryPort;
    }

    @Override
    public boolean deletePayroll(Long id) {
        return payrollRepositoryPort.deleteById(id);
    }
}

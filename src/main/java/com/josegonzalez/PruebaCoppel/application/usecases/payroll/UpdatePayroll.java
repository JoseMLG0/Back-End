package com.josegonzalez.PruebaCoppel.application.usecases.payroll;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.UpdateEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.payroll.UpdatePayrollUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;
import com.josegonzalez.PruebaCoppel.domain.ports.out.PayrollRepositoryPort;

import java.util.Optional;

public class UpdatePayroll implements UpdatePayrollUseCase {
    private final PayrollRepositoryPort payrollRepositoryPort;


    public UpdatePayroll(PayrollRepositoryPort payrollRepositoryPort) {
        this.payrollRepositoryPort = payrollRepositoryPort;
    }

    @Override
    public Optional<PayrollModel> updatePayroll(Long id, PayrollModel payroll) {
        return payrollRepositoryPort.update(id, payroll);
    }
}

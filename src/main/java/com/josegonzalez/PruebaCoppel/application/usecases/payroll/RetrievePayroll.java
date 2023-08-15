package com.josegonzalez.PruebaCoppel.application.usecases.payroll;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.RetrieveEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.payroll.RetrievePayrollUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;
import com.josegonzalez.PruebaCoppel.domain.ports.out.PayrollRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrievePayroll implements RetrievePayrollUseCase {
    private final PayrollRepositoryPort payrollRepositoryPort;


    public RetrievePayroll(PayrollRepositoryPort payrollRepositoryPort) {
        this.payrollRepositoryPort = payrollRepositoryPort;
    }

    @Override
    public Optional<PayrollModel> getPayroll(Long id) {
        return payrollRepositoryPort.findById(id);
    }

    @Override
    public List<PayrollModel> getAllPayrollFromEmployee(EmployeeModel employee) {
        return payrollRepositoryPort.findAllByEmployeeId(employee);
    }

    @Override
    public List<PayrollModel> findAll() {
        return payrollRepositoryPort.findAll();
    }


}

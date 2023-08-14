package com.josegonzalez.PruebaCoppel.application.usecases.payroll;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.CreateEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.payroll.CreatePayrollUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;
import com.josegonzalez.PruebaCoppel.domain.ports.out.PayrollRepositoryPort;

public class CreatePayroll implements CreatePayrollUseCase {

    private final PayrollRepositoryPort payrollRepositoryPort;


    public CreatePayroll(PayrollRepositoryPort payrollRepositoryPort) {
        this.payrollRepositoryPort = payrollRepositoryPort;
    }


    @Override
    public PayrollModel createPayroll(PayrollModel payroll, EmployeeModel employee) {
        payroll.setEmployee(employee);
        payroll.calculateAnotherFields();
        return payrollRepositoryPort.save(employee, payroll);
    }
}

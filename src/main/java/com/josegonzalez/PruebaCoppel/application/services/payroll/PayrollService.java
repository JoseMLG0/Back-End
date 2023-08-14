package com.josegonzalez.PruebaCoppel.application.services.payroll;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.CreateEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.DeleteEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.RetrieveEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.UpdateEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.payroll.CreatePayrollUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.payroll.DeletePayrollUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.payroll.RetrievePayrollUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.in.payroll.UpdatePayrollUseCase;

import java.util.List;
import java.util.Optional;

public class PayrollService implements CreatePayrollUseCase, UpdatePayrollUseCase, DeletePayrollUseCase, RetrievePayrollUseCase {

    private final CreatePayrollUseCase createPayrollUseCase;
    private final UpdatePayrollUseCase updatePayrollUseCase;
    private final DeletePayrollUseCase deletePayrollUseCase;
    private final RetrievePayrollUseCase retrievePayrollUseCase;

    public PayrollService(CreatePayrollUseCase createPayrollUseCase, UpdatePayrollUseCase updatePayrollUseCase, DeletePayrollUseCase deletePayrollUseCase, RetrievePayrollUseCase retrievePayrollUseCase) {
        this.createPayrollUseCase = createPayrollUseCase;
        this.updatePayrollUseCase = updatePayrollUseCase;
        this.deletePayrollUseCase = deletePayrollUseCase;
        this.retrievePayrollUseCase = retrievePayrollUseCase;
    }

    @Override
    public PayrollModel createPayroll(PayrollModel payroll, EmployeeModel employee) {
        return createPayrollUseCase.createPayroll(payroll, employee);
    }

    @Override
    public boolean deletePayroll(Long id) {
        return deletePayrollUseCase.deletePayroll(id);
    }

    @Override
    public Optional<PayrollModel> getPayroll(Long id) {
        return retrievePayrollUseCase.getPayroll(id);
    }

    @Override
    public List<PayrollModel> getAllPayrollFromEmployee(EmployeeModel employee) {
        return retrievePayrollUseCase.getAllPayrollFromEmployee(employee);
    }

    @Override
    public Optional<PayrollModel> updatePayroll(Long id, PayrollModel payroll) {
        return updatePayrollUseCase.updatePayroll(id, payroll);
    }
}

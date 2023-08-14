package com.josegonzalez.PruebaCoppel.application.usecases.employee;

import com.josegonzalez.PruebaCoppel.domain.constants.payroll.PayrollConstants;
import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.ports.in.employee.CreateEmployeeUseCase;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;

import java.util.Date;

public class CreateEmployee implements CreateEmployeeUseCase {

    private final EmployeeRepositoryPort employeeRepositoryPort;


    public CreateEmployee(EmployeeRepositoryPort employeeRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
    }


    @Override
    public EmployeeModel createEmployee(EmployeeModel employee) {
        if(employee.getBaseSalary() == 0){
            employee.setBaseSalary((float) PayrollConstants.DEFAULT_BASE_SALARY_PER_HOUR_FOR_ALL);
        }
        employee.setCreationDate(new Date());
        try {
            return employeeRepositoryPort.save(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

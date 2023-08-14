package com.josegonzalez.PruebaCoppel.infrastructure.config;

import com.josegonzalez.PruebaCoppel.application.services.employee.EmployeeService;
import com.josegonzalez.PruebaCoppel.application.services.payroll.PayrollService;
import com.josegonzalez.PruebaCoppel.application.usecases.employee.CreateEmployee;
import com.josegonzalez.PruebaCoppel.application.usecases.employee.DeleteEmployee;
import com.josegonzalez.PruebaCoppel.application.usecases.employee.RetrieveEmployee;
import com.josegonzalez.PruebaCoppel.application.usecases.employee.UpdateEmployee;
import com.josegonzalez.PruebaCoppel.application.usecases.payroll.CreatePayroll;
import com.josegonzalez.PruebaCoppel.application.usecases.payroll.DeletePayroll;
import com.josegonzalez.PruebaCoppel.application.usecases.payroll.RetrievePayroll;
import com.josegonzalez.PruebaCoppel.application.usecases.payroll.UpdatePayroll;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;
import com.josegonzalez.PruebaCoppel.domain.ports.out.ExternalServicePort;
import com.josegonzalez.PruebaCoppel.domain.ports.out.PayrollRepositoryPort;
import com.josegonzalez.PruebaCoppel.infrastructure.adapters.ExternalServiceAdapter;
import com.josegonzalez.PruebaCoppel.infrastructure.repositories.JpaEmployeeRepositoryAdapter;
import com.josegonzalez.PruebaCoppel.infrastructure.repositories.JpaPayrollRepository;
import com.josegonzalez.PruebaCoppel.infrastructure.repositories.JpaPayrollRepositoryAdapter;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public PayrollService payrollService(PayrollRepositoryPort payrollRepositoryPort){
        return new PayrollService(
                new CreatePayroll(payrollRepositoryPort),
                new UpdatePayroll(payrollRepositoryPort),
                new DeletePayroll(payrollRepositoryPort),
                new RetrievePayroll(payrollRepositoryPort)
        );
    }
    @Bean
    public EmployeeService employeeService(EmployeeRepositoryPort employeeRepositoryPort){
        return new EmployeeService(
                new CreateEmployee(employeeRepositoryPort),
                new UpdateEmployee(employeeRepositoryPort),
                new DeleteEmployee(employeeRepositoryPort),
                new RetrieveEmployee(employeeRepositoryPort)
        );
    }

    @Bean
    public EmployeeRepositoryPort employeeRepositoryPort(JpaEmployeeRepositoryAdapter jpaEmployeeRepositoryAdapter){
        return jpaEmployeeRepositoryAdapter;
    }
    @Bean
    public PayrollRepositoryPort payrollRepositoryPort(JpaPayrollRepositoryAdapter jpaPayrollRepositoryAdapter){
        return jpaPayrollRepositoryAdapter;
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }

}

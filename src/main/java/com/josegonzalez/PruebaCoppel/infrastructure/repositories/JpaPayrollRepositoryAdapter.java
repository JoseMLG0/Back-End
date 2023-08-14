package com.josegonzalez.PruebaCoppel.infrastructure.repositories;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;
import com.josegonzalez.PruebaCoppel.domain.ports.out.PayrollRepositoryPort;
import com.josegonzalez.PruebaCoppel.infrastructure.entities.EmployeeEntity;
import com.josegonzalez.PruebaCoppel.infrastructure.entities.PayrollEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaPayrollRepositoryAdapter implements PayrollRepositoryPort {

    private final JpaPayrollRepository jpaPayrollRepository;

    public JpaPayrollRepositoryAdapter(JpaPayrollRepository jpaPayrollRepository) {
        this.jpaPayrollRepository = jpaPayrollRepository;
    }

    @Override
    public PayrollModel save(EmployeeModel employee, PayrollModel payroll) {
        PayrollEntity payrollEntity = PayrollEntity.fromDomainModel(payroll);
        PayrollEntity saveEmployeeEntity = jpaPayrollRepository.save(payrollEntity);
        return saveEmployeeEntity.toDomainModel();
    }

    @Override
    public Optional<PayrollModel> findById(Long id) {
        return jpaPayrollRepository.findById(id).map(PayrollEntity::toDomainModelComplete);
    }

    @Override
    public List<PayrollModel> findAllByEmployeeId(EmployeeModel employee) {

        return jpaPayrollRepository.findByEmployee(EmployeeEntity.fromDomainModel(employee)).stream().map(PayrollEntity::toDomainModelComplete).collect(Collectors.toList());
    }

    @Override
    public Optional<PayrollModel> update(Long id, PayrollModel payroll) {
        if (jpaPayrollRepository.existsById(payroll.getId())){
            PayrollEntity employeeEntity = PayrollEntity.fromDomainModel(payroll);
            PayrollEntity updateEmployeeEntity = jpaPayrollRepository.save(employeeEntity);
            return  Optional.of(updateEmployeeEntity.toDomainModelComplete());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaPayrollRepository.existsById(id)){
            jpaPayrollRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

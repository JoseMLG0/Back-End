package com.josegonzalez.PruebaCoppel.infrastructure.repositories;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.infrastructure.entities.EmployeeEntity;
import com.josegonzalez.PruebaCoppel.infrastructure.entities.PayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPayrollRepository extends JpaRepository<PayrollEntity, Long> {
    List<PayrollEntity> findByEmployee(EmployeeEntity employee);

}

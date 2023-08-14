package com.josegonzalez.PruebaCoppel.infrastructure.repositories;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.ports.out.EmployeeRepositoryPort;
import com.josegonzalez.PruebaCoppel.infrastructure.entities.EmployeeEntity;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class JpaEmployeeRepositoryAdapter implements EmployeeRepositoryPort {

    private final JpaEmployeeRepository jpaEmployeeRepository;

    public JpaEmployeeRepositoryAdapter(JpaEmployeeRepository jpaEmployeeRepository) {
        this.jpaEmployeeRepository = jpaEmployeeRepository;
    }

    @Override
    public EmployeeModel save(EmployeeModel employee) {
        EmployeeEntity employeeEntity = EmployeeEntity.fromDomainModel(employee);
        EmployeeEntity saveEmployeeEntity = jpaEmployeeRepository.save(employeeEntity);
        return saveEmployeeEntity.toDomainModel();
    }

    @Override
    public Optional<EmployeeModel> findById(Long id) {
        return jpaEmployeeRepository.findById(id).map(EmployeeEntity::toDomainModel);
    }

    @Override
    public List<EmployeeModel> findAll() {
        return jpaEmployeeRepository.findAll().stream().map(EmployeeEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeModel> update(Long id, EmployeeModel employee) {
        if (jpaEmployeeRepository.existsById(employee.getId())){
            EmployeeEntity employeeEntity = EmployeeEntity.fromDomainModel(employee);
            EmployeeEntity updateEmployeeEntity = jpaEmployeeRepository.save(employeeEntity);
            return  Optional.of(updateEmployeeEntity.toDomainModel());
        }
        // TAMBIEN PUEDO USAR MERGE PARA ACTUALIZARLO
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaEmployeeRepository.existsById(id)){
            jpaEmployeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

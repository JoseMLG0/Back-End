package com.josegonzalez.PruebaCoppel.infrastructure.repositories;

import com.josegonzalez.PruebaCoppel.infrastructure.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}

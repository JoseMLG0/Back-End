package com.josegonzalez.PruebaCoppel.infrastructure.entities;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.constants.employee.Rol;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number", nullable = false, unique = true)
    private String number;
    @Column(name = "name")
    private String name;
    @Column(name = "role")
    private Rol rol;
    @Column(name = "base_salary")
    private float baseSalary;
    @Column(name = "active")
    private boolean active;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String number, String name, Rol rol, float baseSalary, boolean active, LocalDateTime creationDate) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.rol = rol;
        this.baseSalary = baseSalary;
        this.active = active;
        this.creationDate = creationDate;
    }
    @PrePersist
    public void beforeSave() {
//        EntityManager em = this.createNativeQuery("CALL tu_procedimiento(?, ?, ?)")
//                        .setParameter(1, valor1)
//                        .setParameter(2, valor2)
//                        .setParameter(3, valor3)
//                        .executeUpdate();
//
//        if (!procedimientoAlmacenadoPermiteGuardar) {
//            throw new PersistenceException("El procedimiento almacenado no permite guardar el registro.");
//        }
    }
    @PreUpdate
    public void beforeUpdate(){


    }

    public  static EmployeeEntity fromDomainModel(EmployeeModel employee){
        return new EmployeeEntity(employee.getId(), employee.getNumber(), employee.getName(), employee.getRol(), employee.getBaseSalary(), employee.isActive(), employee.getCreationDate());
    }

    public EmployeeModel toDomainModel(){
        return new EmployeeModel(id, number, name, rol, baseSalary, active);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}

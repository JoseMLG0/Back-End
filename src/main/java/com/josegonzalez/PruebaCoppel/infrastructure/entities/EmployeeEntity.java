package com.josegonzalez.PruebaCoppel.infrastructure.entities;

import com.josegonzalez.PruebaCoppel.domain.exception.employee.NumberAlreadyExistsException;
import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.constants.employee.Rol;
import com.josegonzalez.PruebaCoppel.infrastructure.config.ApplicationContextProvider;
import com.josegonzalez.PruebaCoppel.infrastructure.procedurals.EmployeeProcedurals;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number", nullable = false, unique = true)
    private String number;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Rol rol;
    @Column(name = "base_salary")
    private float baseSalary;
    @Column(name = "active")
    private boolean active;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "updated_date")
    private Date updatedDate;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String number, String name, Rol rol, float baseSalary, boolean active, Date creationDate, Date updatedDate) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.rol = rol;
        this.baseSalary = baseSalary;
        this.active = active;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
    }
    @PrePersist
    public void beforeSave() {
        EmployeeProcedurals myService = ApplicationContextProvider.getBean(EmployeeProcedurals.class);

        boolean existNumber = myService.validateEmployeeNumber(number);
        if(existNumber){
            throw new NumberAlreadyExistsException(number);
        }
    }
    @PreUpdate
    public void beforeUpdate(){


    }

    public  static EmployeeEntity fromDomainModel(EmployeeModel employee){
        return new EmployeeEntity(employee.getId(), employee.getNumber(), employee.getName(), employee.getRol(), employee.getBaseSalary(), employee.isActive(), employee.getCreationDate(), employee.getUpdatedDate());
    }

    public EmployeeModel toDomainModel(){
        return new EmployeeModel(id, number, name, rol, baseSalary, active, creationDate, updatedDate);
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}

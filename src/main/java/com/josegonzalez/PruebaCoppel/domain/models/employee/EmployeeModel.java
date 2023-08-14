package com.josegonzalez.PruebaCoppel.domain.models.employee;

import com.josegonzalez.PruebaCoppel.domain.constants.employee.Rol;

import java.util.Date;


public class EmployeeModel {
    private Long id;
    private String number;
    private String name;
    private Rol rol;
    private float baseSalary;
    private boolean active;
    private Date creationDate;
    private Date updatedDate;

    public EmployeeModel() {
    }

    public EmployeeModel(Long id, String number, String name, Rol rol, float baseSalary, boolean active) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.rol = rol;
        this.baseSalary = baseSalary;
        this.active = active;
    }

    public EmployeeModel(Long id, String number, String name, Rol rol, float baseSalary, boolean active, Date creationDate, Date updatedDate) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.rol = rol;
        this.baseSalary = baseSalary;
        this.active = active;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
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

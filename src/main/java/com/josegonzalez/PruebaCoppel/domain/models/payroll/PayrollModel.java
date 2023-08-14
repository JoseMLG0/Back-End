package com.josegonzalez.PruebaCoppel.domain.models.payroll;

import com.josegonzalez.PruebaCoppel.domain.constants.employee.Rol;
import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.services.payroll.PayrollBusiness;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;

public class PayrollModel {
    private Long id;
    private Date date;
    private Integer deliveriesMade;
    private double baseSalary;
    private double bonus;
    private double isrWithholding;
    private double pantryVoucher;
    private double grossSalary;
    private double netSalary;
    private EmployeeModel employee;

    public PayrollModel() {
    }

    public PayrollModel(Long id, Date date, Integer deliveriesMade, EmployeeModel employee) {
        this.id = id;
        this.date = date;
        this.deliveriesMade = deliveriesMade;
        this.employee = employee;
    }

    public PayrollModel(Long id, Date date, Integer deliveriesMade, double baseSalary, double bonus, double isrWithholding, double pantryVoucher, double grossSalary, double netSalary, EmployeeModel employee) {
        this.id = id;
        this.date = date;
        this.deliveriesMade = deliveriesMade;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.isrWithholding = isrWithholding;
        this.pantryVoucher = pantryVoucher;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
        this.employee = employee;
    }

    public void calculateAnotherFields(){
        double[] amounts = PayrollBusiness.calculateMonthlySalary(this.employee, this.deliveriesMade);
        this.baseSalary = amounts[0];
        this.bonus = amounts[1];
        this.grossSalary = amounts[2];
        this.isrWithholding = amounts[3];
        this.pantryVoucher = amounts[4];
        this.netSalary = amounts[5];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getIsrWithholding() {
        return isrWithholding;
    }

    public void setIsrWithholding(double isrWithholding) {
        this.isrWithholding = isrWithholding;
    }

    public double getPantryVoucher() {
        return pantryVoucher;
    }

    public void setPantryVoucher(double pantryVoucher) {
        this.pantryVoucher = pantryVoucher;
    }

    public Integer getDeliveriesMade() {
        return deliveriesMade;
    }

    public void setDeliveriesMade(Integer deliveriesMade) {
        this.deliveriesMade = deliveriesMade;
    }

    public EmployeeModel getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeModel employee) {
        this.employee = employee;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}

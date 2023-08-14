package com.josegonzalez.PruebaCoppel.infrastructure.entities;

import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;
import com.josegonzalez.PruebaCoppel.infrastructure.entities.EmployeeEntity;
import jakarta.persistence.*;

import java.time.YearMonth;
import java.util.Date;

@Entity
@Table(name = "Payroll")
public class PayrollEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "deliveries_made")
    private Integer deliveriesMade;

    @Column(name = "base_salary")
    private double baseSalary;

    @Column(name = "bonus")
    private double bonus;

    @Column(name = "isr_withholding")
    private double isrWithholding;

    @Column(name = "pantry_voucher")
    private double pantryVoucher;

    @Column(name = "gross_salary")
    private double grossSalary;

    @Column(name = "net_salary")
    private double netSalary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    public PayrollEntity() {
    }

    public PayrollEntity(Long id, Date date, Integer deliveriesMade, double baseSalary, double bonus, double isrWithholding, double pantryVoucher, double grossSalary, double netSalary, EmployeeEntity employee) {
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

    public static PayrollEntity fromDomainModel(PayrollModel payroll){
        return new PayrollEntity(payroll.getId(), payroll.getDate(), payroll.getDeliveriesMade(), payroll.getBaseSalary(), payroll.getBonus(), payroll.getIsrWithholding(), payroll.getPantryVoucher(), payroll.getGrossSalary(), payroll.getNetSalary(), EmployeeEntity.fromDomainModel(payroll.getEmployee()) );
    }

    public PayrollModel toDomainModel(){
        return new PayrollModel(id, date, deliveriesMade, baseSalary, bonus, isrWithholding, pantryVoucher, grossSalary, netSalary, employee.toDomainModel());
    }

    public PayrollModel toDomainModelComplete(){
        return new PayrollModel(id, date, deliveriesMade, baseSalary, bonus, isrWithholding, pantryVoucher, grossSalary, netSalary, employee.toDomainModel());
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

    public Integer getDeliveriesMade() {
        return deliveriesMade;
    }

    public void setDeliveriesMade(Integer deliveriesMade) {
        this.deliveriesMade = deliveriesMade;
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

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}

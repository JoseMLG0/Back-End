package com.josegonzalez.PruebaCoppel.domain.services.payroll;

import com.josegonzalez.PruebaCoppel.domain.constants.payroll.PayrollConstants;
import com.josegonzalez.PruebaCoppel.domain.exception.payroll.DeliveriesIsLessThanZeroException;
import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;


public class PayrollBusiness {

    public static Date parseDateFromYearMonthToYearMonthDay(String date){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDate parsedDate = LocalDate.parse(date, dateFormatter);

        LocalDate lastDayOfMonth = parsedDate
                .plusMonths(1)
                .with(TemporalAdjusters.firstDayOfMonth())
                .minusDays(1);

        return java.sql.Date.valueOf(lastDayOfMonth);
    }
    public static double[] calculateMonthlySalary(EmployeeModel employee, Integer deliveriesMade) {
        if(deliveriesMade<0){
            throw new DeliveriesIsLessThanZeroException(deliveriesMade);
        }

        double baseSalaryPerMonth = employee.getBaseSalary() * PayrollConstants.HOURS_PER_DAYS * PayrollConstants.DAYS_PER_WEEKS * PayrollConstants.WEEKS_PER_MONTH;
        double bonusSalary = calculateBonusSalary(employee, deliveriesMade);
        double grossSalary = baseSalaryPerMonth + bonusSalary;

        double isrWithholding = calculateISRWithholding(grossSalary);
        double pantryVoucher = grossSalary * PayrollConstants.PANTRY_VOUCHERS;

        return new double[]{baseSalaryPerMonth,bonusSalary,grossSalary,isrWithholding, pantryVoucher, grossSalary-isrWithholding+pantryVoucher};
    }

    private static double calculateBonusSalary(EmployeeModel employee, Integer deliveriesMade) {
        double hourlyBonus = 0;
        double deliverBonus = 0;
        switch (employee.getRol()){
            case Auxiliar -> {
                hourlyBonus = PayrollConstants.ASSISTANT_BONUS_FOR_HOUR;
            }
            case Chofer -> {
                hourlyBonus = PayrollConstants.DRIVER_BONUS_FOR_HOUR;
                deliverBonus = PayrollConstants.BONUS_PER_DELIVERY * deliveriesMade;
            }
            case Cargador -> {
                hourlyBonus = PayrollConstants.WAREHOUSE_LOADER_BONUS_FOR_HOUR;
            }
        }

        return  hourlyBonus + deliverBonus;
    }

    private static double calculateISRWithholding(double grossSalary) {
        double withholding = grossSalary * PayrollConstants.ISR_WITHHOLDING;
        if (grossSalary > PayrollConstants.MONTHLY_SALARY_MIN_FOR_ADDITIONAL_ISR) {
            withholding += grossSalary * PayrollConstants.ADDITIONAL_ISR_WITHHOLDING;
        }
        return withholding;
    }
}

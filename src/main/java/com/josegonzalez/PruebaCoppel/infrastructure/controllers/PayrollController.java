package com.josegonzalez.PruebaCoppel.infrastructure.controllers;

import com.josegonzalez.PruebaCoppel.application.services.employee.EmployeeService;
import com.josegonzalez.PruebaCoppel.application.services.payroll.PayrollService;
import com.josegonzalez.PruebaCoppel.domain.exception.employee.IdNotExistsException;
import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import com.josegonzalez.PruebaCoppel.domain.models.payroll.PayrollModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/{employeeId}/payroll")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PayrollController {
    private final PayrollService payrollService;
    private final EmployeeService employeeService;


    public PayrollController(EmployeeService employeeService, PayrollService payrollService) {
        this.employeeService = employeeService;
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<PayrollModel> createPayroll(@PathVariable Long employeeId, @RequestBody PayrollModel payroll){
        EmployeeModel employee = employeeService.getEmployee(employeeId).orElse(null);
        if(employee == null){
            throw new IdNotExistsException(employeeId);
        }
        PayrollModel createdEmployee = payrollService.createPayroll(payroll, employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{payrollId}")
    public ResponseEntity<PayrollModel> getPayrollById(@PathVariable Long employeeId, @PathVariable Long payrollId){
        EmployeeModel employee = employeeService.getEmployee(employeeId).orElse(null);
        if(employee == null){
            throw new IdNotExistsException(employeeId);
        }
        return payrollService.getPayroll(payrollId).map(payroll -> new ResponseEntity<>(payroll, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value={"", "/"})
    public ResponseEntity<List<PayrollModel>> getAllPayrollFromEmployee(@PathVariable Long employeeId){
        EmployeeModel employee = employeeService.getEmployee(employeeId).orElse(null);
        if(employee == null){
            throw new IdNotExistsException(employeeId);
        }
        List<PayrollModel> payroll = payrollService.getAllPayrollFromEmployee(employee);
        return new ResponseEntity<>(payroll, HttpStatus.OK);
    }

    @PutMapping("/{payrollId}")
    public ResponseEntity<PayrollModel> updatePayroll(@PathVariable Long employeeId, @PathVariable Long payrollId, @RequestBody PayrollModel updatePayroll){
        EmployeeModel employee = employeeService.getEmployee(employeeId).orElse(null);
        if(employee == null){
            throw new IdNotExistsException(employeeId);
        }
        return payrollService.updatePayroll(payrollId, updatePayroll).map(payroll -> new ResponseEntity<>(payroll, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{payrollId}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long employeeId, @PathVariable Long payrollId){
        EmployeeModel employee = employeeService.getEmployee(employeeId).orElse(null);
        if(employee == null){
            throw new IdNotExistsException(employeeId);
        }
        if(payrollService.deletePayroll(payrollId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

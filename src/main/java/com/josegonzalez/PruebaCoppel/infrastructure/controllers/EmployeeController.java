package com.josegonzalez.PruebaCoppel.infrastructure.controllers;

import com.josegonzalez.PruebaCoppel.application.services.employee.EmployeeService;
import com.josegonzalez.PruebaCoppel.domain.models.employee.EmployeeModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employee){
        EmployeeModel createdEmployee = employeeService.createEmployee(employee);

        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeModel> getPayrollById(@PathVariable Long employeeId){
        return employeeService.getEmployee(employeeId).map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployees(){
        List<EmployeeModel> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeModel updatedEmployee){
        return employeeService.updateEmployee(employeeId, updatedEmployee).map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId){
        if(employeeService.deleteEmployee(employeeId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
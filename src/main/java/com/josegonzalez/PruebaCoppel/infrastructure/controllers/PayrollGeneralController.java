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
@RequestMapping("/payroll")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PayrollGeneralController {
    private final PayrollService payrollService;


    public PayrollGeneralController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping(value={"", "/"})
    public ResponseEntity<List<PayrollModel>> findAll(){
        List<PayrollModel> payroll = payrollService.findAll();
        return new ResponseEntity<>(payroll, HttpStatus.OK);
    }

}

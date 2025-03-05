package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.service.EmployeePayrollService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee-payroll")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @RequestMapping({"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(int empId) {
        return new ResponseEntity<String>("Get Call Success for id: " + empId, HttpStatus.OK);
    }

    @GetMapping("test-db")
    public ResponseEntity<String> testDatabaseConnection() {
        employeePayrollService.testDatabaseConnection();
        return new ResponseEntity<String>("Connection is successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new ResponseEntity<String>("Created Employee Payroll Data for: " + employeePayrollDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new ResponseEntity<String>("Updated Employee Payroll Data for: " + employeePayrollDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(int empId) {
        return new ResponseEntity<String>("Deleted Employee Payroll Data for id: " + empId, HttpStatus.OK);
    }
}

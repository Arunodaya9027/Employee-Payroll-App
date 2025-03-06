package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-payroll")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @RequestMapping({"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollDTO> employeePayrollData = employeePayrollService.getEmployeePayrollData();
        return new ResponseEntity<>(new ResponseDTO("Get All Employees Payroll Data", employeePayrollData), HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getAllEmployeePayroll(int empId) {
        EmployeePayrollDTO employeePayroll = employeePayrollService.getEmployeePayrollDataById(empId);
        return new ResponseEntity<>(new ResponseDTO("Get Call for ID Successful", employeePayroll), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollDTO newEmployeePayroll = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        return new ResponseEntity<>(new ResponseDTO("Create New Employee Payroll Data", newEmployeePayroll), HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@PathVariable Long empId, @RequestBody EmployeePayrollDTO updatedEmployeePayroll) {
        EmployeePayrollDTO employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        boolean operation = employeePayrollService.updateEmployeePayrollData(employeePayrollData, updatedEmployeePayroll);
        if(!operation)
            return new ResponseEntity<>(new ResponseDTO("Update Failed", employeePayrollData), HttpStatus.OK);
        return new ResponseEntity<>(new ResponseDTO("Updated Employee Payroll Data for:" + employeePayrollData + "to below Data ", updatedEmployeePayroll), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayroll(@PathVariable Long empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        return new ResponseEntity<String>("Deleted Employee Payroll Data for id: " + empId, HttpStatus.OK);
    }
}

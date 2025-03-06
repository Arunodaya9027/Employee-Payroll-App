package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.model.EmployeePayroll;
import com.example.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee-payroll")
@RestController
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping({"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayroll> employeePayrollData = employeePayrollService.getEmployeePayrollData();
        return new ResponseEntity<>(new ResponseDTO("Get All Employees Payroll Data", employeePayrollData), HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getAllEmployeePayroll(@PathVariable Long empId) {
        try {
            EmployeePayrollDTO employeePayroll = employeePayrollService.getEmployeePayrollDataById(empId);
            return new ResponseEntity<>(new ResponseDTO("Get Call for ID Successful", employeePayroll), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO("Get Call for ID Unsuccessful", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll newEmployeePayroll = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        return new ResponseEntity<>(new ResponseDTO("Create New Employee Payroll Data", newEmployeePayroll), HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@PathVariable Long empId, @RequestBody EmployeePayrollDTO updatedEmployeePayroll) {
        EmployeePayrollDTO employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        boolean operation = employeePayrollService.updateEmployeePayrollData(employeePayrollData, updatedEmployeePayroll);
        if(!operation)
            return new ResponseEntity<>(new ResponseDTO("Update Failed", employeePayrollData), HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(new ResponseDTO("Updated Employee Payroll Data for:" + employeePayrollData + "to below Data ", updatedEmployeePayroll), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroll(@PathVariable Long empId) {
        try {
            EmployeePayrollDTO employeePayroll = employeePayrollService.getEmployeePayrollDataById(empId);
            employeePayrollService.deleteEmployeePayrollData(empId);
            return new ResponseEntity<ResponseDTO>(new ResponseDTO("Deleted Employee Payroll Data for id: " + empId, new EmployeePayrollDTO()), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<ResponseDTO>(new ResponseDTO("Employee Payroll Data for id " + empId + " is not found", new EmployeePayrollDTO()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<ResponseDTO>(new ResponseDTO("Error Deleting Employee Payroll Data for id: " + empId, new EmployeePayrollDTO()), HttpStatus.NOT_FOUND);
        }
    }
}

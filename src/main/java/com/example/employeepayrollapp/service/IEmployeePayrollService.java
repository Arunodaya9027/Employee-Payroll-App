package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayroll;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayroll> getEmployeePayrollData();
    EmployeePayroll getEmployeePayrollDataById(long empId);
    EmployeePayroll createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
    boolean updateEmployeePayrollData(EmployeePayroll employeePayroll, EmployeePayrollDTO updatedEmployeePayrollDTO);
    void deleteEmployeePayrollData(long empId);
}

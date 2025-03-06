package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollDTO> getEmployeePayrollData();
    EmployeePayrollDTO getEmployeePayrollDataById(long empId);
    EmployeePayrollDTO createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
    boolean updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO, EmployeePayrollDTO updatedEmployeePayrollDTO);
    void deleteEmployeePayrollData(long empId);
}

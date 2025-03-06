package com.example.employeepayrollapp.dto;

import com.example.employeepayrollapp.model.EmployeePayroll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollDTO {
    private String name;
    private long salary;

    public EmployeePayrollDTO(EmployeePayroll employeePayroll) {
        this.name = employeePayroll.getName();
        this.salary = employeePayroll.getSalary();
    }
}

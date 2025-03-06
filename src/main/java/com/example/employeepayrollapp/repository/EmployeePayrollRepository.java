package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.model.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Long> {
}

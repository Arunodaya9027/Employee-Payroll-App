package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollDTO, Long> {
}

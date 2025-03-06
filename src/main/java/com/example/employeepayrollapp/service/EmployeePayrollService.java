package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayroll;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Override
    public List<EmployeePayroll> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollDTO getEmployeePayrollDataById(long empId) {
        return new EmployeePayrollDTO(employeePayrollRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee Payroll not found with id: " + empId)));
    }

    @Override
    public EmployeePayroll createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayroll employeePayroll = new EmployeePayroll(empPayrollDTO);
        return employeePayrollRepository.save(employeePayroll);
    }

    @Override
    public boolean updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO, EmployeePayrollDTO updatedEmployeePayrollDTO) {
        try {
            EmployeePayroll employeePayroll = new EmployeePayroll(employeePayrollDTO);
            employeePayroll.setName(updatedEmployeePayrollDTO.getName());
            employeePayroll.setSalary(updatedEmployeePayrollDTO.getSalary());
            employeePayrollRepository.save(employeePayroll);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void deleteEmployeePayrollData(long empId) {
        employeePayrollRepository.deleteById(empId);
    }
}

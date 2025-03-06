package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Override
    public List<EmployeePayrollDTO> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollDTO getEmployeePayrollDataById(long empId) {
        return employeePayrollRepository.findById(empId).get();
    }

    @Override
    public EmployeePayrollDTO createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        return employeePayrollRepository.save(empPayrollDTO);
    }

    @Override
    public boolean updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO, EmployeePayrollDTO updatedEmployeePayrollDTO) {
        try {
            employeePayrollDTO.setName(updatedEmployeePayrollDTO.getName());
            employeePayrollDTO.setSalary(updatedEmployeePayrollDTO.getSalary());
            employeePayrollRepository.save(employeePayrollDTO);
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

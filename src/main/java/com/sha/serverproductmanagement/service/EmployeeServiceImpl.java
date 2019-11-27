package com.sha.serverproductmanagement.service;


import com.sha.serverproductmanagement.model.Employee;
import com.sha.serverproductmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //It is not necessary. You can use it, if you have multiple database operation in a single service method.
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(final Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(final Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(final Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Long numberOfEmployees(){
        return employeeRepository.count();
    }

    @Override
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

}

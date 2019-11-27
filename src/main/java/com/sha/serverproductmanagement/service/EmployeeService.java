package com.sha.serverproductmanagement.service;



import com.sha.serverproductmanagement.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

    Long numberOfEmployees();

    List<Employee> findAllEmployees();
}

package com.sha.serverproductmanagement.repository;

import com.sha.serverproductmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

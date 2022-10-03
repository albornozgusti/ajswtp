package com.example.ajswtp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findById(Long id);
    Employee replaceEmployee(Employee newEmployee, Long id);
}

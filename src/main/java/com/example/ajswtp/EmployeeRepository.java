package com.example.ajswtp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long id);
    Employee replaceEmployee(Employee newEmployee, Long id);
}

package com.example.ajswtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EmployeeController {

    private  final EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //aggregate root
    @GetMapping(path="/employees")
    List<Employee> all() {
        return employeeService.findAll();
    }

    @PostMapping(path="/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return employeeService.save(newEmployee);
    }

    //single item

    @GetMapping(path="/employees/{id}")
    Employee one(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.findById(id);
    }

    @PutMapping(path="/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
        return employeeService.replaceEmployee(newEmployee, id);
    }

    @DeleteMapping(path="/employees/{id}")
    void deleteEmployee(@PathVariable("id")Long id){
        employeeService.deleteById(id);
    }
}

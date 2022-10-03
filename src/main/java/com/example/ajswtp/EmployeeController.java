package com.example.ajswtp;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeController {

    private  final EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //aggregate root
    @GetMapping("/employees")
    List<Employee> all() {
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return employeeService.save(newEmployee);
    }

    //single item

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
        return employeeService.replaceEmployee(newEmployee, id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVarible Long id){
        employeeService.deleteById(id);
    }
}

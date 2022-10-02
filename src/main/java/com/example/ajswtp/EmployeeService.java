package com.example.ajswtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmloyeeRepository repository;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository){
        this.repository = employeeRepository;
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }


    public Employee save(Employee newEmployee){
        return repository.save(newEmployee);
    }

    public <T> Employee findById(Long id) throws  EmployeeNotFoundException{
        return  repository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
    }



    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Employee replaceEmployee(Employee newEmployee, Long id){
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                })
    }
}

package com.example.ajswtp;

public class Employee {

    private String name;
    private String role;
    private Long id;

    public Employee(String name, String role, Long id){
        this.name = name;
        this.role = role;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}

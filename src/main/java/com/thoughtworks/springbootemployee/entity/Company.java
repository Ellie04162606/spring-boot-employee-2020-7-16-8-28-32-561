package com.thoughtworks.springbootemployee.entity;

import java.util.List;

public class Company {
    private int id;
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

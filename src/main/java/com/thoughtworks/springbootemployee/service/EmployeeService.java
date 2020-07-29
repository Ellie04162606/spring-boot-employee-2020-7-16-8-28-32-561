package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployee(int employeeId);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);
}

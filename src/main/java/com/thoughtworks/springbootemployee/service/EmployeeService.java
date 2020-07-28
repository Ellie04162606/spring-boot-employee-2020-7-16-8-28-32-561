package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeDeleteException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeAddException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeUpdateException;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployee(int id);

    void addEmployee(Employee employee) throws EmployeeAddException;

    void updateEmployee(Employee employee) throws EmployeeUpdateException;

    void deleteEmployee(int id) throws EmployeeDeleteException;

    List<Employee> getEmployeeByGender(String gender);

    List<Employee> getEmployeesByPage(int page, int pageSize);
}

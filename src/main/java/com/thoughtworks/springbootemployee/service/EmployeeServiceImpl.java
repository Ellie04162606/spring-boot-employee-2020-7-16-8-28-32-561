package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.util.PageControlUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
        return employees.stream().filter(e -> id == e.getId()).findFirst().orElse(null);
    }

    @Override
    public void addEmployee(Employee employee) {
        Employee employeeInDatabase = employees.stream().filter(e -> e.getId() == employee.getId()).findFirst().orElse(null);
        if (employeeInDatabase == null)
            employees.add(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee employeeInDatabase = employees.stream().filter(e -> e.getId() == employee.getId()).findFirst().orElse(null);

        if (employeeInDatabase != null) {
            employeeInDatabase.setName(employee.getName());
            employeeInDatabase.setAge(employee.getAge());
            employeeInDatabase.setGender(employee.getGender());
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employeeInDatabase = employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (employeeInDatabase != null) {
            employees.remove(employeeInDatabase);
        }
    }

    @Override
    public List<Employee> getEmployeeByGender(String gender) {
        return employees.stream().filter(e -> e.getGender().equals(gender)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByPage(int page, int pageSize) {
        return new PageControlUtil<Employee>().getData(employees, page, pageSize);
    }
}

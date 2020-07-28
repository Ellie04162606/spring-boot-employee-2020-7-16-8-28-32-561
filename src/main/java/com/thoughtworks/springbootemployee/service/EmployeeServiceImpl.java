package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeDeleteException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeAddException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeUpdateException;
import com.thoughtworks.springbootemployee.util.PageControlUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
        return employees.stream().filter(e -> id == e.getId()).findFirst().orElse(null);
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeAddException {
        if (employees.contains(employee))
            throw new EmployeeAddException("the employee had exited");
        employees.add(employee);
    }

    @Override
    public void updateEmployee(Employee employee) throws EmployeeUpdateException {
        if (!employees.contains(employee)) {
            throw new EmployeeUpdateException("the employee is not exit");
        }
        Employee employeeInDatabase = getEmployee(employee.getId());
        employeeInDatabase.setName(employee.getName());
        employeeInDatabase.setAge(employee.getAge());
        employeeInDatabase.setGender(employee.getGender());
    }

    @Override
    public void deleteEmployee(int id) throws EmployeeDeleteException {
        Employee employeeInDatabase = getEmployee(id);
        if (employeeInDatabase == null) {
            throw new EmployeeDeleteException("the employee is not exit");
        }
        employees.remove(employeeInDatabase);
    }

    @Override
    public List<Employee> getEmployeeByGender(String gender) {
        return employees.stream().filter(e -> e.getGender().equals(gender)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByPage(int page, int pageSize) {
        return PageControlUtil.getDataByPaging(employees, page, pageSize);
    }

}

package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeDeleteException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeAddException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeUpdateException;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final static Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        try {
            employeeService.addEmployee(employee);
        } catch (EmployeeAddException e) {
            log.info(e.getMessage());
        }
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        try {
            employeeService.deleteEmployee(id);
        } catch (EmployeeDeleteException e) {
            log.info(e.getMessage());
        }
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        try {
            employeeService.updateEmployee(employee);
        } catch (EmployeeUpdateException e) {
            log.info(e.getMessage());
        }
    }

    @GetMapping("/employees_in_gender")
    public List<Employee> getEmployeeByGender(@RequestParam("gender") String gender) {
        return employeeService.getEmployeeByGender(gender);
    }

    @GetMapping("/employees_in_page")
    public List<Employee> getEmployeesByPage(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        return employeeService.getEmployeesByPage(page, pageSize);
    }

}

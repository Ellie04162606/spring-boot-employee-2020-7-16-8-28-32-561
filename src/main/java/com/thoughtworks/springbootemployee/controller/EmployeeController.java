package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeDeleteException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeAddException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeUpdateException;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final static Logger log = LoggerFactory.getLogger(EmployeeController.class);

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

    @GetMapping("/employees")
    public List<Employee> getEmployees(@Nullable @RequestParam("gender") String gender, @Nullable @RequestParam("page") Integer page, @Nullable @RequestParam("pageSize") Integer pageSize) {
        List<Employee> employeeList = (gender == null) ? employeeService.getEmployeeByGender(gender) : employeeService.getEmployees();
        return (page == null || pageSize == null) ? employeeList : employeeService.getEmployeesByPage(employeeList,page,pageSize);
    }
}

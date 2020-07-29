package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyAddException;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyDeleteException;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyQueryException;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyUpdateException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeUpdateException;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    private final static Logger log = LoggerFactory.getLogger(CompanyController.class);

    @GetMapping("/companies")
    public List<Company> getCompanies(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize) {
        return (page == null || pageSize == null) ? companyService.getCompanies() : companyService.getCompaniesByPage(page, pageSize);
    }

    @GetMapping("/companies/{companyId}")
    public Company getCompany(@PathVariable("companyId") int companyId) {
        return companyService.getCompany(companyId);
    }

    @GetMapping("/companies/{companyId}/employees")
    public List<Employee> getEmployeesInCompany(@PathVariable("companyId") int companyId) {
        try {
            return companyService.getEmployeesInCompany(companyId);
        } catch (CompanyQueryException e) {
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
        try {
            companyService.addCompany(company);
        } catch (CompanyAddException e) {
            log.error(e.getMessage());
        }
    }

    @PutMapping("/companies")
    public void updateCompany(@RequestBody Company company) {
        try {
            companyService.updateCompany(company);
        } catch (CompanyUpdateException | EmployeeUpdateException e) {
            log.error(e.getMessage());
        }
    }

    @DeleteMapping("/companies/{companyId}")
    public void deleteCompany(@PathVariable("companyId") int companyId) {
        try {
            companyService.deleteCompany(companyId);
        } catch (CompanyDeleteException e) {
            log.error(e.getMessage());
        }
    }

}

package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyAddException;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyDeleteException;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyUpdateException;
import com.thoughtworks.springbootemployee.exceptions.employee.EmployeeUpdateException;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanies();

    Company getCompany(int companyId);

    List<Employee> getEmployeesInCompany(int companyId);

    List<Company> getCompaniesByPage(int page, int pageSize);

    void addCompany(Company company) throws CompanyAddException;

    void updateCompany(Company company) throws EmployeeUpdateException, CompanyUpdateException;

    void deleteCompany(int companyId) throws CompanyDeleteException;
}

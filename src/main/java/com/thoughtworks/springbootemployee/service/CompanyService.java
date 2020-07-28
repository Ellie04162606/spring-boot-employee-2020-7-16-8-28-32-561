package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanies();

    Company getCompany(int companyId);

    List<Employee> getEmployeeInCompany(int companyId);

    List<Company> getCompaniesByPage(int page, int pageSize);

    void addCompany(Company company);

    void updateCompany(Company company);

    void deleteCompany(int companyId);
}

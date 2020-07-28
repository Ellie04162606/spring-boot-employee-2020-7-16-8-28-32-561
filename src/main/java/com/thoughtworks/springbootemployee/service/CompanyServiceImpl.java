package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyAddException;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyDeleteException;
import com.thoughtworks.springbootemployee.exceptions.company.CompanyUpdateException;
import com.thoughtworks.springbootemployee.util.PageControlUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    List<Company> companies = new ArrayList<>();

    @Override
    public List<Company> getCompanies() {
        return companies;
    }

    @Override
    public Company getCompany(int companyId) {
        return companies.stream().filter(e -> companyId == e.getId()).findFirst().orElse(null);
    }

    @Override
    public List<Employee> getEmployeesInCompany(int companyId) {
        Company company = companies.stream().filter(e -> companyId == e.getId()).findFirst().orElse(null);
        return company.getEmployees();
    }

    @Override
    public List<Company> getCompaniesByPage(int page, int pageSize) {
        return new PageControlUtil<Company>().getData(companies, page, pageSize);
    }

    @Override
    public void addCompany(Company company) throws CompanyAddException {
        if (companies.contains(company))
            throw new CompanyAddException("the employee had exited");
        companies.add(company);
    }

    @Override
    public void updateCompany(Company company) throws CompanyUpdateException {
        if (!companies.contains(company)) {
            throw new CompanyUpdateException("the company is not exit");
        }
        Company companyInDatabase = getCompany(company.getId());
        companyInDatabase.setEmployees(company.getEmployees());
    }

    @Override
    public void deleteCompany(int companyId) throws CompanyDeleteException {
        Company companyInDatabase = getCompany(companyId);
        if (companyInDatabase == null) {
            throw new CompanyDeleteException("the company is not exit");
        }
        companies.remove(companyInDatabase);
    }
}

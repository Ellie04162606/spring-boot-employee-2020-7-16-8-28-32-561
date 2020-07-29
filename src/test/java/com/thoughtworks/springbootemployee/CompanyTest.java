package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.service.Impl.CompanyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CompanyTest {

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Mock
    private CompanyRepository companyRepository;

    /*
        given:
            companyId 1, employees 2 in this company
        when:
            get employees by company id
        then:
            return 2 employees
     */
    /*
        given:
            page 2, pageSize 2, 5 companies id from 1 to 5
        when:
            getCompaniesByPage
        then:
            return 2 companies and id form 3 to 4
     */

    @Test
    void should_return_2_employees_when_get_employees_by_company_id_given_company_id_1_and_2_employees_in_this_company() {
        //given
        int companyId = 1;
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            employees.add(new Employee());
        }

        //when
        List<Employee> employeesQueried = companyService.getEmployeesByCompanyId(companyId);

        //then
        assertEquals(employees.size(), employeesQueried.size());
    }

    @Test
    void should_return_2_companies_id_from_3_to_4_when_get_companies_by_page_given_page_2_and_pageSize_2_and_5_companies_id_from_1_to_5() {
        //given
        List<Company> companies = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Company company = new Company();
            company.setId(i);
            companies.add(company);
        }
        int page = 2;
        int pageSize = 2;

        //when
//        List<Company> companiesByPage = companyService.getCompanies();

        //then
//        Assertions.assertEquals(2, companiesByPage.size());
//        Assertions.assertEquals(3, companiesByPage.get(0).getId());
//        Assertions.assertEquals(4, companiesByPage.get(1).getId());
    }

    @Test
    void should_return_company_with_id_1_when_getCompanyByCompanyId_given_companyId_1_and_company_2_with_id_1_to_2() {

        //given
        int companyId = 1;
        Company company1 = new Company();
        company1.setId(1);

        Mockito.when(companyRepository
                .findById(companyId))
                .thenReturn(java.util.Optional.of(company1));

        //when
        Optional<Company> companyQueried = companyRepository.findById(companyId);

        //then
        Assertions.assertEquals(1, companyQueried.get().getId());
    }

    @Test
    void should_return_2_employees_when_get_employees_by_company_id_given_company_id_and_2_employees() {
        //given
        int companyId = 1;
        Company company = new Company();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());
        company.setEmployee(employees);

        Mockito.when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));

        //when
        List<Employee> employeesByQueried = companyService.getEmployeesByCompanyId(companyId);

        //then
        assertEquals(2, employeesByQueried.size());
    }

    @Test
    void should_return_1_company_when_add_company_given_1_company(){
        //given
        Company company = new Company();

        //when


        //then
    }
}

package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CompanyTest {

    @Mock
    private CompanyService companyService;

    /*
        given:
            companyId 1, employees 2 in this company
        when:
            get employees by company id
        then:
            return 2 employees
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
        assertEquals(2,employeesQueried.size());
    }

}

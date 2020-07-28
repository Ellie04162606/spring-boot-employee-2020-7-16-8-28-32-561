package com.thoughtworks.springbootemployee.exceptions.employee;

import com.thoughtworks.springbootemployee.exceptions.BaseException;

public class EmployeeUpdateException extends BaseException {

    public EmployeeUpdateException(String message) {
        super(message);
    }
}

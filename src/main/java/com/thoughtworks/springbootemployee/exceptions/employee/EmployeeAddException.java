package com.thoughtworks.springbootemployee.exceptions.employee;

import com.thoughtworks.springbootemployee.exceptions.BaseException;

public class EmployeeAddException extends BaseException {
    public EmployeeAddException(String message) {
        super(message);
    }
}

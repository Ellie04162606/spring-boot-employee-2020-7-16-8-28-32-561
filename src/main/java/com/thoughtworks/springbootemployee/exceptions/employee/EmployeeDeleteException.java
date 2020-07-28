package com.thoughtworks.springbootemployee.exceptions.employee;

import com.thoughtworks.springbootemployee.exceptions.BaseException;

public class EmployeeDeleteException extends BaseException {

    public EmployeeDeleteException(String message) {
        super(message);
    }
}

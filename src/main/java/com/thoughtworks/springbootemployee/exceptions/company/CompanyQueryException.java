package com.thoughtworks.springbootemployee.exceptions.company;

import com.thoughtworks.springbootemployee.exceptions.BaseException;

public class CompanyQueryException extends BaseException {
    public CompanyQueryException(String message) {
        super(message);
    }
}

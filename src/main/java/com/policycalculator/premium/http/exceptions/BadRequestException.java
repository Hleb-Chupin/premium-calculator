package com.policycalculator.premium.http.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 2L;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String arg0) {
        super(arg0);
    }

}

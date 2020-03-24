package com.chiragbohet.restfulwebservice1.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter @AllArgsConstructor
public class ExceptionResponseFormat {
    private Date timestamp;
    private String message;
    private String details;
}

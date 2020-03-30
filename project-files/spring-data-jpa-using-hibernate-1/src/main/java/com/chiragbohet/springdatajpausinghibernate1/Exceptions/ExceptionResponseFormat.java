package com.chiragbohet.springdatajpausinghibernate1.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ExceptionResponseFormat {
    Date timestamp;
    String message;
    String details;
}

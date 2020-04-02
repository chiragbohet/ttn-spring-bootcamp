package com.chiragbohet.springdatajpahibernate3.Embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {

    private int streetNumber;
    private String location;
    private String state;

}

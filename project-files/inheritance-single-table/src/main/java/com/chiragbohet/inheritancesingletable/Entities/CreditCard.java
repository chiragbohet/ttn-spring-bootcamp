package com.chiragbohet.inheritancesingletable.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Getter
@Setter
@Entity
@DiscriminatorValue("CC")
public class CreditCard extends Payment {
    @Column(name = "creditcard_number")
    private String CreditCardNumber;
}

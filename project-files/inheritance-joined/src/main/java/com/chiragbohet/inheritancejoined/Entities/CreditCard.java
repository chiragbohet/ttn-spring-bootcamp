package com.chiragbohet.inheritancejoined.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "creditcard")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment {

    @Column(name = "creditcard_number")
    private String creditCardNumber;

}

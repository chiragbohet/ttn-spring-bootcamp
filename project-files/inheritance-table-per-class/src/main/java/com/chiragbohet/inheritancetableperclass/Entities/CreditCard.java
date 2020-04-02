package com.chiragbohet.inheritancetableperclass.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "creditcard")
public class CreditCard extends Payment {

    @Column(name = "creditcard_number")
    private String CreditCardNumber;

}

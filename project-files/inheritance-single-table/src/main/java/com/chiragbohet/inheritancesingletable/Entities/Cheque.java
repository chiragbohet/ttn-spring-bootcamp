package com.chiragbohet.inheritancesingletable.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("CH")
public class Cheque extends Payment {
    @Column(name = "cheque_number")
    private String ChequeNumber;
}

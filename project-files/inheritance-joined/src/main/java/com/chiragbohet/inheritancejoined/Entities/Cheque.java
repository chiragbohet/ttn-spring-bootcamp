package com.chiragbohet.inheritancejoined.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bankcheque")
@PrimaryKeyJoinColumn(name = "id")
public class Cheque extends Payment {

    @Column(name = "cheque_number")
    private String ChequeNumber;

}
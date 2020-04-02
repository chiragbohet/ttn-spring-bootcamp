package com.chiragbohet.componentmapping.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Getter
@Setter
@Embeddable
public class Salary {

    @Column(name = "basic_salary")
    BigDecimal basicSalary;

    @Column(name = "bonus_salary")
    BigDecimal bonusSalary;

    @Column(name = "tax_amount")
    BigDecimal taxAmount;

    @Column(name = "special_allowance_salary")
    BigDecimal specialAllowanceSalary;
}

package com.chiragbohet.inheritancetableperclass.Repositories;

import com.chiragbohet.inheritancetableperclass.Entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}

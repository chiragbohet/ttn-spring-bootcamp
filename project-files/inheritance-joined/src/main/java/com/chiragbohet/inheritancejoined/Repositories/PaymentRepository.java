package com.chiragbohet.inheritancejoined.Repositories;

import com.chiragbohet.inheritancejoined.Entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}

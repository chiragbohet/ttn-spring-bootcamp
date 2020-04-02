package com.chiragbohet.inheritancesingletable.Repository;

import com.chiragbohet.inheritancesingletable.Entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> { }

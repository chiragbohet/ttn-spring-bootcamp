package com.chiragbohet.inheritancesingletable;

import com.chiragbohet.inheritancesingletable.Entities.Cheque;
import com.chiragbohet.inheritancesingletable.Entities.CreditCard;
import com.chiragbohet.inheritancesingletable.Repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritanceSingleTableApplicationTests {

    @Autowired
    PaymentRepository paymentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreate() {
        Cheque cheque = new Cheque();
        cheque.setChequeNumber("IB-1234");
        cheque.setAmount(1000);

        paymentRepository.save(cheque);

        CreditCard creditCard = new CreditCard();
        creditCard.setCreditCardNumber("111-222-333-444");
        creditCard.setAmount(2000);

        paymentRepository.save(creditCard);
    }


}

package com.chiragbohet.inheritancejoined;

import com.chiragbohet.inheritancejoined.Entities.Cheque;
import com.chiragbohet.inheritancejoined.Entities.CreditCard;
import com.chiragbohet.inheritancejoined.Repositories.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritanceJoinedApplicationTests {

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

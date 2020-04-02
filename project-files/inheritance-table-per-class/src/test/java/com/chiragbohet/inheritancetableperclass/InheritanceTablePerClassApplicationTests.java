package com.chiragbohet.inheritancetableperclass;

import com.chiragbohet.inheritancetableperclass.Entities.Cheque;
import com.chiragbohet.inheritancetableperclass.Entities.CreditCard;
import com.chiragbohet.inheritancetableperclass.Repositories.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritanceTablePerClassApplicationTests {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreate() {
		Cheque cheque = new Cheque();
		cheque.setId(121);
		cheque.setChequeNumber("IB-1234");
		cheque.setAmount(1000);

		paymentRepository.save(cheque);

		CreditCard creditCard = new CreditCard();
		creditCard.setId(122);
		creditCard.setCreditCardNumber("111-222-333-444");
		creditCard.setAmount(2000);

		paymentRepository.save(creditCard);
	}



}

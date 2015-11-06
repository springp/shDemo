package com.iboss.service.test;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.iboss.IBossApplication;
import com.iboss.bo.CreditCard;
import com.iboss.service.BankAccountServiceImpl;

@ContextConfiguration(classes = { IBossApplication.class })
@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceTest {

	private static final Logger LOGGER = Logger.getLogger(JobsServiceTest.class);

	@InjectMocks
	@Autowired
	private BankAccountServiceImpl bankAccountService;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testStoreCreditCard() throws SQLException {

		// CreditCard creditCard = new CreditCard();
		// creditCard.setExpireMonth(11);
		// creditCard.setExpireYear(2018);
		// creditCard.setNumber("4417119669820331");
		// creditCard.setType("visa");
		//
		// bankAccountService.storeCreditCard("TT", creditCard);

		// CARD-7WD4494966132933LKY5W34A
		// CARD-2C942750AU8201618KY5YHOA
	}

	@Test
	public void testCaptureTransaction() throws SQLException {

		// bankAccountService.captureTransaction("CARD-14S12470WW068683RKY6DGZI",
		// "10.00");
		// PAY-7MN54268C3393322NKY6DJAY

	}

	@Test
	public void testPaymentHistory() throws SQLException {

//		bankAccountService.paymentHistory();
		//
	}
}

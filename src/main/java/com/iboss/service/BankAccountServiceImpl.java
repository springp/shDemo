package com.iboss.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.iboss.bo.CreditCard;
import com.iboss.exceptions.BankAccountException;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	public String storeCreditCard(String userId, CreditCard creditCard) throws BankAccountException {
		try {
			OAuthTokenCredential oAuthTokenCredential = new OAuthTokenCredential(
					"AYSq3RDGsmBLJE-otTkBtM-jBRd1TCQwFf9RGfwddNXWz0uFU9ztymylOhRS",
					"EGnHDxD_qRPdaLdZz8iCr8N7_MzF-YHPTkjs6NKYQvQSBngp4PTTVWkPZRbL");
			System.out.println("Paypal AccessToken: " + oAuthTokenCredential.getAccessToken());
			// CreditCard creditCard = new CreditCard();
			// creditCard.setExpireMonth(11);
			// creditCard.setExpireYear(2018);
			// creditCard.setNumber("4417119669820331");
			// creditCard.setType("visa");

			com.paypal.api.payments.CreditCard paypalCreditCard = new com.paypal.api.payments.CreditCard();

			BeanUtils.copyProperties(paypalCreditCard, creditCard);
			APIContext aPIContext = new APIContext(oAuthTokenCredential.getAccessToken());

			com.paypal.api.payments.CreditCard createdCreditCard = paypalCreditCard.create(aPIContext);

			System.out.println("Stored paypal credit card id: " + createdCreditCard.getId());

			return createdCreditCard.getId();
		} catch (IllegalAccessException e) {
			throw new BankAccountException(e);
		} catch (InvocationTargetException e) {
			throw new BankAccountException(e);
		} catch (PayPalRESTException e) {
			throw new BankAccountException(e);
		}
	}

}

package com.iboss.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iboss.bo.CreditCard;
import com.iboss.exceptions.BankAccountException;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCardToken;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentHistory;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Value("${paypal.clientId}")
	private String paypalClientId;
	
	@Value("${paypal.clientSecret}")
	private String paypalClientSecret;
	
	public String storeCreditCard(String userId, CreditCard creditCard) throws BankAccountException {
		try {
//			OAuthTokenCredential oAuthTokenCredential = new OAuthTokenCredential(
//					"Aa800N2ZmkNhBNubjmiD1Y0radprIR4ZNSDWBD5Nj9_ttAMwD5aUqc43rnNUGjLtoTmpbcI8zSZPxK2O",
//					"EJFG6BlvNIdVfHj6Va6eL046l-VMG1B6jF1pFry28HiAm4DpyYOC-VxcvCjNdJIWPz9tXw_xsCb7Zjr_");
			
			System.out.println("paypalClientId " + paypalClientId);
			OAuthTokenCredential oAuthTokenCredential = new OAuthTokenCredential(paypalClientId, paypalClientSecret);
			
			System.out.println("Paypal AccessToken: " + oAuthTokenCredential.getAccessToken());

			com.paypal.api.payments.CreditCard paypalCreditCard = new com.paypal.api.payments.CreditCard();

			//BeanUtils.copyProperties(creditCard, paypalCreditCard);
			paypalCreditCard.setExpireMonth(creditCard.getExpireMonth());
			paypalCreditCard.setExpireYear(creditCard.getExpireYear());
			paypalCreditCard.setNumber(creditCard.getNumber());
			paypalCreditCard.setType(creditCard.getType());
			
			APIContext aPIContext = new APIContext(oAuthTokenCredential.getAccessToken());
			com.paypal.api.payments.CreditCard createdCreditCard = paypalCreditCard.create(aPIContext);

			System.out.println("Stored paypal credit card id: " + createdCreditCard.getId());

			return createdCreditCard.getId();
//		} catch (IllegalAccessException e) {
//			throw new BankAccountException(e);
//		} catch (InvocationTargetException e) {
//			throw new BankAccountException(e);
		} catch (PayPalRESTException e) {
			throw new BankAccountException(e);
		}
	}

		
	public void captureTransaction(String cardId, String totalAmount) {
		try {
//			OAuthTokenCredential oAuthTokenCredential = new OAuthTokenCredential(paypalClientId, paypalClientSecret);
			OAuthTokenCredential oAuthTokenCredential = new OAuthTokenCredential(
					"Aa800N2ZmkNhBNubjmiD1Y0radprIR4ZNSDWBD5Nj9_ttAMwD5aUqc43rnNUGjLtoTmpbcI8zSZPxK2O",
					"EJFG6BlvNIdVfHj6Va6eL046l-VMG1B6jF1pFry28HiAm4DpyYOC-VxcvCjNdJIWPz9tXw_xsCb7Zjr_");
			
			String accessToken = oAuthTokenCredential.getAccessToken();

			CreditCardToken creditCardToken = new CreditCardToken();
			//creditCardToken.setCreditCardId("CARD-14S12470WW068683RKY6DGZI");
			creditCardToken.setCreditCardId(cardId);

			Details amountDetails = new Details();
//			amountDetails.setSubtotal("9.41");
//			amountDetails.setTax("0.03");
			
			Amount amount = new Amount();
			amount.setTotal(totalAmount);
			amount.setCurrency("USD");
			amount.setDetails(amountDetails);

			Transaction transaction = new Transaction();
			transaction.setAmount(amount);
			transaction.setDescription("Weekly payment for: " + new Date());

			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions.add(transaction);

			FundingInstrument fundingInstrument = new FundingInstrument();
			fundingInstrument.setCreditCardToken(creditCardToken);

			List<FundingInstrument> fundingInstruments = new ArrayList<FundingInstrument>();
			fundingInstruments.add(fundingInstrument);

			Payer payer = new Payer();
			payer.setFundingInstruments(fundingInstruments);
			payer.setPaymentMethod("credit_card");

			Payment payment = new Payment();
			payment.setIntent("sale");
			payment.setPayer(payer);
			payment.setTransactions(transactions);

			Payment createdPayment = payment.create(accessToken);
			if ("approved".equalsIgnoreCase(createdPayment.getState())) {
				System.out.println(createdPayment);
			}
			
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
	}
	
	public void paymentHistory() {
		try {
			System.out.println("paypalClientId " + paypalClientId);
			//OAuthTokenCredential oAuthTokenCredential = new OAuthTokenCredential(paypalClientId, paypalClientSecret);
			OAuthTokenCredential oAuthTokenCredential = new OAuthTokenCredential(
					"Aa800N2ZmkNhBNubjmiD1Y0radprIR4ZNSDWBD5Nj9_ttAMwD5aUqc43rnNUGjLtoTmpbcI8zSZPxK2O",
					"EJFG6BlvNIdVfHj6Va6eL046l-VMG1B6jF1pFry28HiAm4DpyYOC-VxcvCjNdJIWPz9tXw_xsCb7Zjr_");

			String accessToken = oAuthTokenCredential.getAccessToken();
			
			Map<String, String> map = new HashMap<String, String>(); 
			map.put("count", "10");
			
			PaymentHistory paymentHistory = Payment.list(accessToken, map);
			
			System.out.println(paymentHistory);
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
	}
}

package com.iboss.service;

import com.iboss.bo.CreditCard;
import com.iboss.exceptions.BankAccountException;

public interface BankAccountService {

	public String storeCreditCard(String userId, CreditCard creditCard) throws BankAccountException;
}

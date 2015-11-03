package com.iboss.bo;

public class CreditCard {

	/**
	 * ID of the credit card being saved for later use.
	 */
	private String id;

	/**
	 * Card number.
	 */
	private String number;

	/**
	 * Type of the Card (eg. Visa, Mastercard, etc.).
	 */
	private String type;

	/**
	 * 2 digit card expiry month.
	 */
	private int expireMonth;

	/**
	 * 4 digit card expiry year
	 */
	private int expireYear;

	/**
	 * Card validation code. Only supported when making a Payment but not when
	 * saving a credit card for future use.
	 */
	private Integer cvv2;

	/**
	 * Card holder's first name.
	 */
	private String firstName;

	/**
	 * Card holder's last name.
	 */
	private String lastName;

	/**
	 * Billing Address associated with this card.
	 */
	// private Address billingAddress;

	/**
	 * A unique identifier of the customer to whom this bank account belongs to.
	 * Generated and provided by the facilitator. This is required when creating
	 * or using a stored funding instrument in vault.
	 */
	private String externalCustomerId;

	/**
	 * State of the funding instrument.
	 */
	private String state;

	/**
	 * Date/Time until this resource can be used to fund a payment.
	 */
	private String validUntil;

	/**
	 * 
	 */
	// private List<Links> links;

	/**
	 * Payer ID
	 */
	private String payerId;

	/**
	 * Default Constructor
	 */
	public CreditCard() {
	}

	/**
	 * Parameterized Constructor
	 */
	public CreditCard(String number, String type, int expireMonth, int expireYear) {
		this.number = number;
		this.type = type;
		this.expireMonth = expireMonth;
		this.expireYear = expireYear;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(int expireMonth) {
		this.expireMonth = expireMonth;
	}

	public int getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(int expireYear) {
		this.expireYear = expireYear;
	}

	public Integer getCvv2() {
		return cvv2;
	}

	public void setCvv2(Integer cvv2) {
		this.cvv2 = cvv2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getExternalCustomerId() {
		return externalCustomerId;
	}

	public void setExternalCustomerId(String externalCustomerId) {
		this.externalCustomerId = externalCustomerId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(String validUntil) {
		this.validUntil = validUntil;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

}

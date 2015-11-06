package com.iboss.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_BANK_ACCOUNT_INFO")
public class UserBankAccountInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_INFO_ID")
	private Long id;

	@Column(name = "ACCOUNT_INFO_UUID")
	private String userBankAccountUUID;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User client;
	
	@Column(name = "ACCOUNT_TYPE")
	//LOCAL, PAYP
	private String accountType;

	@Column(name = "PAYMENT_GATEWAY")
	private String paymentGateway;
	
	@Column(name = "CARD_ID")
	private String cardId;
	
	@Column(name = "CARD_TYPE")
	private String cardType;
	
	@Column(name = "IS_CARD_APPROVED")
	private Boolean cardApproved;
	
	@Column(name = "CARD_APPROVAL_DATE")
	private Date cardApprovalDate;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	
}

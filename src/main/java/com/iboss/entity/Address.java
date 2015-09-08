package com.iboss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "ADDRESS_LINE_1")
	private String addressList1;

	@Column(name = "ADDRESS_LINE_2")
	private String addressList2;

	@Column(name = "CITY", length = 50)
	private String city;

	@Column(name = "STATE", length = 50)
	private String state;

	@Column(name = "COUNTRY", length = 50)
	private String country;

	@Column(name = "PINCODE", length = 20)
	private String pincode;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressList1() {
		return addressList1;
	}

	public void setAddressList1(String addressList1) {
		this.addressList1 = addressList1;
	}

	public String getAddressList2() {
		return addressList2;
	}

	public void setAddressList2(String addressList2) {
		this.addressList2 = addressList2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

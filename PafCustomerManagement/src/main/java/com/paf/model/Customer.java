package com.paf.model;

public class Customer {

	private String CustomerId;
	private String CustomerName;
	private String Address;
	private String MobileNo;
	private String Email;
	private String AccNumber;

	public Customer() {

	}

	public Customer(String CustomerId, String CustomerName, String Address, String MobileNo, String Email, String AccNumber) {
		super();
		this.CustomerId = CustomerId;
		this.CustomerName = CustomerName;
		this.Address = Address;
		this.MobileNo = MobileNo;
		this.Email = Email;
		this.AccNumber = AccNumber;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String CustomerId) {
		this.CustomerId = CustomerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String CustomerName) {
		this.CustomerName = CustomerName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String MobileNo) {
		this.MobileNo = MobileNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String AccNumber) {
		this.AccNumber = AccNumber;
	}

}

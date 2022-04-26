package com.paf.model;

public class Payment {

	private String PaymentId;
	private String CardType;
	private Float AmountPaid;
	private Float ArrearsAmount;
	private String PaidDate;
	private String AccNumber;

	public Payment() {

	}

	public Payment(String PaymentId, String CardType, Float AmountPaid, Float ArrearsAmount, String PaidDate, String AccNumber) {
		super();
		this.PaymentId = PaymentId;
		this.CardType = CardType;
		this.AmountPaid = AmountPaid;
		this.ArrearsAmount = ArrearsAmount;
		this.PaidDate = PaidDate;
		this.AccNumber = AccNumber;
	}

	public String getPaymentId() {
		return PaymentId;
	}

	public void setPaymentId(String PaymentId) {
		this.PaymentId = PaymentId;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String CardType) {
		this.CardType = CardType;
	}

	public Float getAmountPaid() {
		return AmountPaid;
	}

	public void setAmountPaid(Float AmountPaid) {
		this.AmountPaid = AmountPaid;
	}

	public Float getArrearsAmount() {
		return ArrearsAmount;
	}

	public void setArrearsAmount(Float ArrearsAmount) {
		this.ArrearsAmount = ArrearsAmount;
	}

	public String getPaidDate() {
		return PaidDate;
	}

	public void setPaidDate(String PaidDate) {
		this.PaidDate = PaidDate;
	}

	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String AccNumber) {
		this.AccNumber = AccNumber;
	}

}

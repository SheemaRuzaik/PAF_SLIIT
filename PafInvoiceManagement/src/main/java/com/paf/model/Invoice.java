package com.paf.model;

public class Invoice {

	private String InvoiceId;
	private Float NormalUnitPrice;
	private Float PeakUnitPrice;
	private Float Amount;
	private String IssueDate;
	private String AccNumber;

	public Invoice() {

	}

	public Invoice(String InvoiceId, Float NormalUnitPrice, Float PeakUnitPrice, Float Amount, String IssueDate, String AccNumber) {
		super();
		this.InvoiceId = InvoiceId;
		this.NormalUnitPrice = NormalUnitPrice;
		this.PeakUnitPrice = PeakUnitPrice;
		this.Amount = Amount;
		this.IssueDate = IssueDate;
		this.AccNumber = AccNumber;
	}

	public String getInvoiceId() {
		return InvoiceId;
	}

	public void setInvoiceId(String InvoiceId) {
		this.InvoiceId = InvoiceId;
	}

	public Float getNormalUnitPrice() {
		return NormalUnitPrice;
	}

	public void setNormalUnitPrice(Float NormalUnitPrice) {
		this.NormalUnitPrice = NormalUnitPrice;
	}

	public Float getPeakUnitPrice() {
		return PeakUnitPrice;
	}

	public void setPeakUnitPrice(Float PeakUnitPrice) {
		this.PeakUnitPrice = PeakUnitPrice;
	}

	public Float getAmount() {
		return Amount;
	}

	public void setAmount(Float Amount) {
		this.Amount = Amount;
	}

	public String getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(String IssueDate) {
		this.IssueDate = IssueDate;
	}

	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String AccNumber) {
		this.AccNumber = AccNumber;
	}

}

package net.invoice.we;

public class Invoice {
	
	public String getInvoice_ID() {
		return Invoice_ID;
	}
	public void setInvoice_ID(String invoice_ID) {
		Invoice_ID = invoice_ID;
	}
	public String getInvoice_status() {
		return Invoice_status;
	}
	public void setInvoice_status(String invoice_status) {
		Invoice_status = invoice_status;
	}
	public float getNormal_unitPrice() {
		return Normal_unitPrice;
	}
	public void setNormal_unitPrice(float normal_unitPrice) {
		Normal_unitPrice = normal_unitPrice;
	}
	public float getPeak_unitPrice() {
		return Peak_unitPrice;
	}
	public void setPeak_unitPrice(float peak_unitPrice) {
		Peak_unitPrice = peak_unitPrice;
	}
	public String getDue_date() {
		return Due_date;
	}
	public void setDue_date(String due_date) {
		Due_date = due_date;
	}
	public String getIssued_date() {
		return Issued_date;
	}
	public void setIssued_date(String issued_date) {
		Issued_date = issued_date;
	}
	public float getIncoice_amount() {
		return Incoice_amount;
	}
	public void setIncoice_amount(float incoice_amount) {
		Incoice_amount = incoice_amount;
	}
	String Invoice_ID; 
	String Invoice_status;
	float Normal_unitPrice;
	float Peak_unitPrice;
	String Due_date;
	String Issued_date;  
	float Incoice_amount;
	public Invoice(String invoice_ID, String invoice_status, float normal_unitPrice, float peak_unitPrice,
			String due_date, String issued_date, float incoice_amount) {
		super();
		Invoice_ID = invoice_ID;
		Invoice_status = invoice_status;
		Normal_unitPrice = normal_unitPrice;
		Peak_unitPrice = peak_unitPrice;
		Due_date = due_date;
		Issued_date = issued_date;
		Incoice_amount = incoice_amount;
	}


}

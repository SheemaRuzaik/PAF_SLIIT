package com.paf.model;

public class Complaint {

	private String ComplaintId;
	private String CustomerId;
	private String ComplaintDate;
	private String Complaint;

	public Complaint() {

	}

	public Complaint(String ComplaintId, String CustomerId, String ComplaintDate, String Complaint) {
		super();
		this.ComplaintId = ComplaintId;
		this.CustomerId = CustomerId;
		this.ComplaintDate = ComplaintDate;
		this.Complaint = Complaint;

	}

	public String getComplaintId() {
		return ComplaintId;
	}

	public void setComplaintId(String ComplaintId) {
		this.ComplaintId = ComplaintId;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String CustomerId) {
		this.CustomerId = CustomerId;
	}

	public String getComplaintDate() {
		return ComplaintDate;
	}

	public void setComplaintDate(String ComplaintDate) {
		this.ComplaintDate = ComplaintDate;
	}

	public String getComplaint() {
		return Complaint;
	}

	public void setComplaint(String Complaint) {
		this.Complaint = Complaint;
	}

}

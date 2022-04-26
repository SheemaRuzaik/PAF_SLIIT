package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class PaymentService {
	Connection con = null;

	public PaymentService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertpayment(Payment payment) {
		String query = " insert into payment(`PaymentId`,`CardType`,`AmountPaid`,`ArrearsAmount`,`PaidDate`,`AccNumber`)"
				+ " values (?,?, ?, ?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, payment.getPaymentId());
			preparedStatement.setString(2, payment.getCardType());
			preparedStatement.setFloat(3, payment.getAmountPaid());
			preparedStatement.setFloat(4, payment.getArrearsAmount());
			preparedStatement.setString(5, payment.getPaidDate());
			preparedStatement.setString(6, payment.getAccNumber());
			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the payment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readpayments() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Payment Id</th><th>Card Type</th><th>Amount Paid</th><th>Arrears Amount</th><th>Paid Date</th><th>Account Number</th></tr>";
			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String PaymentId = rs.getString("PaymentId");
				String CardType = rs.getString("CardType");
				String AmountPaid = rs.getString("AmountPaid");
				String ArrearsAmount = rs.getString("ArrearsAmount");
				String PaidDate = rs.getString("PaidDate");
				String AccNumber = rs.getString("AccNumber");
				// Add into the html table
				output += "<tr><td>" + PaymentId + "</td>";
				output += "<td>" + CardType + "</td>";
				output += "<td>" + AmountPaid + "</td>";
				output += "<td>" + ArrearsAmount + "</td>";
				output += "<td>" + PaidDate + "</td>";
				output += "<td>" + AccNumber + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the payments.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatepayment(Payment payment) {

		String query = "UPDATE payment SET CardType=?,AmountPaid=?,ArrearsAmount=?,PaidDate=?,AccNumber=? WHERE PaymentId=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, payment.getCardType());
			preparedStatement.setFloat(2, payment.getAmountPaid());
			preparedStatement.setFloat(3, payment.getArrearsAmount());
			preparedStatement.setString(4, payment.getPaidDate());
			preparedStatement.setString(5, payment.getAccNumber());
			preparedStatement.setString(6, payment.getPaymentId());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Billing.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletepayment(Payment payment) {
		String query = "delete from payment where PaymentId=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, payment.getPaymentId());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";


		} catch (Exception e) {
			output = "Error while deleting the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	public String asAccountNo(String AccNo) {

		String output = "";

		try {

			if (con == null) {

				return "Error while connecting to the database for reading.";
			}
			output = "<table border=\"1\"><tr><th>Invoice Id</th><th>Normal Unit Price</th><th>Peak Unit Price</th><th>Amount</th><th>IssueDate</th><th>Account Number</th></tr>";
			String query = "select * from invoice where AccNumber = " + AccNo;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {

				String InvoiceId = rs.getString("InvoiceId");
				String NormalUnitPrice = rs.getString("NormalUnitPrice");
				String PeakUnitPrice = rs.getString("PeakUnitPrice");
				String Amount = rs.getString("Amount");
				String IssueDate = rs.getString("IssueDate");
				String AccNumber = rs.getString("AccNumber");
				// Add into the html table
				output += "<tr><td>" + InvoiceId + "</td>";
				output += "<td>" + NormalUnitPrice + "</td>";
				output += "<td>" + PeakUnitPrice + "</td>";
				output += "<td>" + Amount + "</td>";
				output += "<td>" + IssueDate + "</td>";
				output += "<td>" + AccNumber + "</td>";
			}
			output += "</table>";
		}catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage() + "---------------------------------------------");
		}
		return output;
	}

}

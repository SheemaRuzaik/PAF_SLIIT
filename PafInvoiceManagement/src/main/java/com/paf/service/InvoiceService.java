package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class InvoiceService {
	Connection con = null;

	public InvoiceService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertinvoice(Invoice invoice) {
		String query = " insert into invoice(`InvoiceId`,`NormalUnitPrice`,`PeakUnitPrice`,`Amount`,`IssueDate`,`AccNumber`)"
				+ " values (?,?, ?, ?, ?, ?)";
		float Amount = 0;
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			String strAccNo = invoice.getAccNumber();
			float intNormalUnitPrice = invoice.getNormalUnitPrice();
			float intPeakUnitPrice = invoice.getPeakUnitPrice();
			String querySelect = "select * from consumption";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querySelect);
			float noNormalUnits = 0;
			float noPeakUnits = 0;
			 
			while (rs.next()) {
				String strAccNo_consumption = rs.getString("AccNumber");
				if(strAccNo_consumption.equals(strAccNo)) {
					noNormalUnits = rs.getFloat("NormalHoursUnit");
					noPeakUnits = rs.getFloat("PeakHoursUnit");
				}
			}
			
			Amount = intNormalUnitPrice * noNormalUnits + intPeakUnitPrice * noPeakUnits;
						
		} catch (Exception e) {
			
			System.err.println(e.getMessage() + "---------------------------------------------");
		}
		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, invoice.getInvoiceId());
			preparedStatement.setFloat(2, invoice.getNormalUnitPrice());
			preparedStatement.setFloat(3, invoice.getPeakUnitPrice());
			preparedStatement.setFloat(4, Amount);
			preparedStatement.setString(5, invoice.getIssueDate());
			preparedStatement.setString(6, invoice.getAccNumber());
			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the invoice.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readinvoices() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Invoice Id</th><th>Normal Unit Price</th><th>Peak Unit Price</th><th>Amount</th><th>IssueDate</th><th>Account Number</th></tr>";
			String query = "select * from invoice";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
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
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the invoices.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateinvoice(Invoice invoice) {

		String query = "UPDATE invoice SET NormalUnitPrice=?,PeakUnitPrice=?,Amount=?,IssueDate=?,AccNumber=? WHERE InvoiceId=?";
		float Amount = 0;
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			String strAccNo = invoice.getAccNumber();
			float intNormalUnitPrice = invoice.getNormalUnitPrice();
			float intPeakUnitPrice = invoice.getPeakUnitPrice();
			String querySelect = "select * from consumption";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querySelect);
			float noNormalUnits = 0;
			float noPeakUnits = 0;
			 
			while (rs.next()) {
				String strAccNo_consumption = rs.getString("AccNumber");
				if(strAccNo_consumption.equals(strAccNo)) {
					noNormalUnits = rs.getFloat("NormalHoursUnit");
					noPeakUnits = rs.getFloat("PeakHoursUnit");
				}
			}
			
			Amount = intNormalUnitPrice * noNormalUnits + intPeakUnitPrice * noPeakUnits;
						
		} catch (Exception e) {
			
			System.err.println(e.getMessage() + "---------------------------------------------");
		}
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setFloat(1, invoice.getNormalUnitPrice());
			preparedStatement.setFloat(2, invoice.getPeakUnitPrice());
			preparedStatement.setFloat(3, Amount);
			preparedStatement.setString(4, invoice.getIssueDate());
			preparedStatement.setString(5, invoice.getAccNumber());
			preparedStatement.setString(6, invoice.getInvoiceId());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Billing.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the invoice.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteinvoice(Invoice invoice) {
		String query = "delete from invoice where InvoiceId=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, invoice.getInvoiceId());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";


		} catch (Exception e) {
			output = "Error while deleting the invoice.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}

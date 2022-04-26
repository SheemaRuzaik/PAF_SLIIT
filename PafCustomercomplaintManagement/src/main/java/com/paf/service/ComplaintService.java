package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class ComplaintService {
	Connection con = null;

	public ComplaintService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertcomplaint(Complaint complaint) {
		String query = " insert into complaint(`ComplaintId`,`CustomerId`,`ComplaintDate`,`Complaint`)"
				+ " values (?,?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, complaint.getComplaintId());
			preparedStatement.setString(2, complaint.getCustomerId());
			preparedStatement.setString(3, complaint.getComplaintDate());
			preparedStatement.setString(4, complaint.getComplaint());

			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the complaint.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readcomplaints() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Complaint Id</th><th>Customer Id</th><th>Complaint Date</th><th>Complaint</th></tr>";
			String query = "select * from complaint";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String ComplaintId = rs.getString("ComplaintId");
				String CustomerId = rs.getString("CustomerId");
				String ComplaintDate = rs.getString("ComplaintDate");
				String Complaint = rs.getString("Complaint");

				// Add into the html table
				output += "<tr><td>" + ComplaintId + "</td>";
				output += "<td>" + CustomerId + "</td>";
				output += "<td>" + ComplaintDate + "</td>";
				output += "<td>" + Complaint + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the complaints.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatecomplaint(Complaint complaint) {

		String query = "UPDATE complaint SET CustomerId=?,ComplaintDate=?,Complaint=? WHERE ComplaintId=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, complaint.getCustomerId());
			preparedStatement.setString(2, complaint.getComplaintDate());
			preparedStatement.setString(3, complaint.getComplaint());
			preparedStatement.setString(4, complaint.getComplaintId());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Billing.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the complaint.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletecomplaint(Complaint complaint) {
		String query = "delete from complaint where ComplaintId=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, complaint.getComplaintId());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";


		} catch (Exception e) {
			output = "Error while deleting the complaint.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}

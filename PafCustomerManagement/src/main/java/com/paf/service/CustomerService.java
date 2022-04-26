package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class CustomerService {
	Connection con = null;

	public CustomerService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertcustomer(Customer customer) {
		String query = " insert into customer(`CustomerId`,`CustomerName`,`Address`,`MobileNo`,`Email`,`AccNumber`)"
				+ " values (?,?, ?, ?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getAddress());
			preparedStatement.setString(4, customer.getMobileNo());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.setString(6, customer.getAccNumber());
			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the customer.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readcustomers() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>customer CustomerId</th><th>Customer Name</th><th>Address</th><th>Mobile</th><th>Email</th><th>Account Number</th></tr>";
			String query = "select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String CustomerId = rs.getString("CustomerId");
				String CustomerName = rs.getString("CustomerName");
				String Address = rs.getString("Address");
				String MobileNo = rs.getString("MobileNo");
				String Email = rs.getString("Email");
				String AccNumber = rs.getString("AccNumber");
				// Add into the html table
				output += "<tr><td>" + CustomerId + "</td>";
				output += "<td>" + CustomerName + "</td>";
				output += "<td>" + Address + "</td>";
				output += "<td>" + MobileNo + "</td>";
				output += "<td>" + Email + "</td>";
				output += "<td>" + AccNumber + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the customers.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatecustomer(Customer customer) {

		String query = "UPDATE customer SET CustomerName=?,Address=?,MobileNo=?,Email=?,AccNumber=? WHERE CustomerId=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getAddress());
			preparedStatement.setString(3, customer.getMobileNo());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getAccNumber());
			preparedStatement.setString(6, customer.getCustomerId());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Billing.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the customer.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletecustomer(Customer customer) {
		String query = "delete from customer where CustomerId=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, customer.getCustomerId());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";


		} catch (Exception e) {
			output = "Error while deleting the customer.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}

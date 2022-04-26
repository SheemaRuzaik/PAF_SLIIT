package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class PowerConsumptionService {
	Connection con = null;

	public PowerConsumptionService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertconsumption(PowerConsumption consumption) {
		String query = " insert into consumption(`TrackId`,`PeakHoursUnit`,`NormalHoursUnit`,`Month`,`AccNumber`)"
				+ " values (?,?, ?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, consumption.getTrackId());
			preparedStatement.setFloat(2, consumption.getPeakHoursUnit());
			preparedStatement.setFloat(3, consumption.getNormalHoursUnit());
			preparedStatement.setString(4, consumption.getMonth());
			preparedStatement.setString(5, consumption.getAccNumber());
			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the consumption.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readconsumptions() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Track Id</th><th>Peak Hours Unit</th><th>Normal Hours Unit</th><th>Month</th><th>Account Number</th></tr>";
			String query = "select * from consumption";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String TrackId = rs.getString("TrackId");
				String PeakHoursUnit = rs.getString("PeakHoursUnit");
				String NormalHoursUnit = rs.getString("NormalHoursUnit");
				String Month = rs.getString("Month");
				String AccNumber = rs.getString("AccNumber");
				// Add into the html table
				output += "<tr><td>" + TrackId + "</td>";
				output += "<td>" + PeakHoursUnit + "</td>";
				output += "<td>" + NormalHoursUnit + "</td>";
				output += "<td>" + Month + "</td>";
				output += "<td>" + AccNumber + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the consumptions.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateconsumption(PowerConsumption consumption) {

		String query = "UPDATE consumption SET PeakHoursUnit=?,NormalHoursUnit=?,Month=?,AccNumber=? WHERE TrackId=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setFloat(1, consumption.getPeakHoursUnit());
			preparedStatement.setFloat(2, consumption.getNormalHoursUnit());
			preparedStatement.setString(3, consumption.getMonth());
			preparedStatement.setString(4, consumption.getAccNumber());
			preparedStatement.setString(5, consumption.getTrackId());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Billing.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the consumption.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteconsumption(PowerConsumption consumption) {
		String query = "delete from consumption where TrackId=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, consumption.getTrackId());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";


		} catch (Exception e) {
			output = "Error while deleting the consumption.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}

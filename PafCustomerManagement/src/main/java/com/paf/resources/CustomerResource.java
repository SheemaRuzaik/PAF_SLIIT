package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;


@Path("/Customers")
public class CustomerResource {

	Customer customerObj = new Customer();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readcustomers() {
		CustomerService customerObj = new CustomerService();

		return customerObj.readcustomers();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertcustomer(String customerData) {
		JsonObject customerObject = new JsonParser().parse(customerData).getAsJsonObject();

		String CustomerId = customerObject.get("CustomerId").getAsString();
		String CustomerName = customerObject.get("CustomerName").getAsString();
		String Address = customerObject.get("Address").getAsString();
		String MobileNo = customerObject.get("MobileNo").getAsString();
		String Email = customerObject.get("Email").getAsString();
		String AccNumber = customerObject.get("AccNumber").getAsString();

		CustomerService customerObject2 = new CustomerService();

		customerObj.setCustomerId(CustomerId);
		customerObj.setCustomerName(CustomerName);
		customerObj.setAddress(Address);
		customerObj.setMobileNo(MobileNo);
		customerObj.setEmail(Email);
		customerObj.setAccNumber(AccNumber);

		String output = customerObject2.insertcustomer(customerObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatecustomer(String customerData) {
		// Convert the input string to a JSON object
		JsonObject customerObject = new JsonParser().parse(customerData).getAsJsonObject();
		// Read the values from the JSON object
		String CustomerId = customerObject.get("CustomerId").getAsString();
		String CustomerName = customerObject.get("CustomerName").getAsString();
		String Address = customerObject.get("Address").getAsString();
		String MobileNo = customerObject.get("MobileNo").getAsString();
		String Email = customerObject.get("Email").getAsString();
		String AccNumber = customerObject.get("AccNumber").getAsString();

		CustomerService customerObject1 = new CustomerService();

		customerObj.setCustomerId(CustomerId);
		customerObj.setCustomerName(CustomerName);
		customerObj.setAddress(Address);
		customerObj.setMobileNo(MobileNo);
		customerObj.setEmail(Email);
		customerObj.setAccNumber(AccNumber);

		String output = customerObject1.updatecustomer(customerObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletecustomer(String customerData) {

		JsonObject customerObject = new JsonParser().parse(customerData).getAsJsonObject();

		String CustomerId = customerObject.get("CustomerId").getAsString();

		CustomerService customerObject2 = new CustomerService();
		customerObj.setCustomerId(CustomerId);

		String output = customerObject2.deletecustomer(customerObj);
		return output;
	}

}
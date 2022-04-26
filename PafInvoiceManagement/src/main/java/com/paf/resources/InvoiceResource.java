package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;



import javax.annotation.security.RolesAllowed;
//For REST Service

@Path("/Invoice")
public class InvoiceResource {

	Invoice invoiceObj = new Invoice();

	// Read API
	@RolesAllowed({"user","admin"})
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readinvoices() {
		InvoiceService invoiceObj = new InvoiceService();

		return invoiceObj.readinvoices();
	}

	// Insert API
	@RolesAllowed({"admin"})
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertinvoice(String invoiceData) {
		JsonObject invoiceObject = new JsonParser().parse(invoiceData).getAsJsonObject();

		String InvoiceId = invoiceObject.get("InvoiceId").getAsString();
		Float NormalUnitPrice = invoiceObject.get("NormalUnitPrice").getAsFloat();
		Float PeakUnitPrice = invoiceObject.get("PeakUnitPrice").getAsFloat();
		String IssueDate = invoiceObject.get("IssueDate").getAsString();
		String AccNumber = invoiceObject.get("AccNumber").getAsString();

		InvoiceService invoiceObject2 = new InvoiceService();

		invoiceObj.setInvoiceId(InvoiceId);
		invoiceObj.setNormalUnitPrice(NormalUnitPrice);
		invoiceObj.setPeakUnitPrice(PeakUnitPrice);
		invoiceObj.setIssueDate(IssueDate);
		invoiceObj.setAccNumber(AccNumber);

		String output = invoiceObject2.insertinvoice(invoiceObj);
		return output;
	}

	// Update API
	@RolesAllowed({"admin"})
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateinvoice(String invoiceData) {
		// Convert the input string to a JSON object
		JsonObject invoiceObject = new JsonParser().parse(invoiceData).getAsJsonObject();
		// Read the values from the JSON object
		String InvoiceId = invoiceObject.get("InvoiceId").getAsString();
		Float NormalUnitPrice = invoiceObject.get("NormalUnitPrice").getAsFloat();
		Float PeakUnitPrice = invoiceObject.get("PeakUnitPrice").getAsFloat();
		String IssueDate = invoiceObject.get("IssueDate").getAsString();
		String AccNumber = invoiceObject.get("AccNumber").getAsString();

		InvoiceService invoiceObject1 = new InvoiceService();

		invoiceObj.setInvoiceId(InvoiceId);
		invoiceObj.setNormalUnitPrice(NormalUnitPrice);
		invoiceObj.setPeakUnitPrice(PeakUnitPrice);
		invoiceObj.setIssueDate(IssueDate);
		invoiceObj.setAccNumber(AccNumber);

		String output = invoiceObject1.updateinvoice(invoiceObj);
		return output;
	}

	// Delete API
	@RolesAllowed({"admin"})
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteinvoice(String invoiceData) {

		JsonObject invoiceObject = new JsonParser().parse(invoiceData).getAsJsonObject();

		String InvoiceId = invoiceObject.get("InvoiceId").getAsString();

		InvoiceService invoiceObject2 = new InvoiceService();
		invoiceObj.setInvoiceId(InvoiceId);

		String output = invoiceObject2.deleteinvoice(invoiceObj);
		return output;
	}

}
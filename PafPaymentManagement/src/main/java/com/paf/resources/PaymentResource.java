package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

@Path("/Payments")
public class PaymentResource {

	Payment paymentObj = new Payment();

	// Read API
	@RolesAllowed({"user","admin"})
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readpayments() {
		PaymentService paymentObj = new PaymentService();

		return paymentObj.readpayments();
	}

	// Insert API
	@RolesAllowed({"user","admin"})
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertpayment(String paymentData) {
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();

		String PaymentId = paymentObject.get("PaymentId").getAsString();
		String CardType = paymentObject.get("CardType").getAsString();
		Float AmountPaid = paymentObject.get("AmountPaid").getAsFloat();
		Float ArrearsAmount = paymentObject.get("ArrearsAmount").getAsFloat();
		String PaidDate = paymentObject.get("PaidDate").getAsString();
		String AccNumber = paymentObject.get("AccNumber").getAsString();

		PaymentService paymentObject2 = new PaymentService();

		paymentObj.setPaymentId(PaymentId);
		paymentObj.setCardType(CardType);
		paymentObj.setAmountPaid(AmountPaid);
		paymentObj.setArrearsAmount(ArrearsAmount);
		paymentObj.setPaidDate(PaidDate);
		paymentObj.setAccNumber(AccNumber);

		String output = paymentObject2.insertpayment(paymentObj);
		return output;
	}

	// Update API
	@RolesAllowed({"user","admin"})
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatepayment(String paymentData) {
		// Convert the input string to a JSON object
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();
		// Read the values from the JSON object
		String PaymentId = paymentObject.get("PaymentId").getAsString();
		String CardType = paymentObject.get("CardType").getAsString();
		Float AmountPaid = paymentObject.get("AmountPaid").getAsFloat();
		Float ArrearsAmount = paymentObject.get("ArrearsAmount").getAsFloat();
		String PaidDate = paymentObject.get("PaidDate").getAsString();
		String AccNumber = paymentObject.get("AccNumber").getAsString();

		PaymentService paymentObject1 = new PaymentService();

		paymentObj.setPaymentId(PaymentId);
		paymentObj.setCardType(CardType);
		paymentObj.setAmountPaid(AmountPaid);
		paymentObj.setArrearsAmount(ArrearsAmount);
		paymentObj.setPaidDate(PaidDate);
		paymentObj.setAccNumber(AccNumber);

		String output = paymentObject1.updatepayment(paymentObj);
		return output;
	}

	// Delete API
	@RolesAllowed({"user","admin"})
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletepayment(String paymentData) {

		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();

		String PaymentId = paymentObject.get("PaymentId").getAsString();

		PaymentService paymentObject2 = new PaymentService();
		paymentObj.setPaymentId(PaymentId);

		String output = paymentObject2.deletepayment(paymentObj);
		return output;
	}
	
	@RolesAllowed({"user","admin"})
	@GET
	@Path("/AccountInfo/{AccNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public String readPaymentAccordingToAccountNo(@PathParam("AccNo") String AccNo) {
		PaymentService payObj = new PaymentService();
		return payObj.asAccountNo(AccNo);
	}
}
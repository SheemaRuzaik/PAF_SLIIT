package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;


@Path("/Consumptions")
public class PowerConsumptionResource {

	PowerConsumption consumptionObj = new PowerConsumption();

	// Read API
	@RolesAllowed({"user","admin"})
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readconsumptions() {
		PowerConsumptionService consumptionObj = new PowerConsumptionService();

		return consumptionObj.readconsumptions();
	}

	// Insert API
	@RolesAllowed({"admin"})
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertconsumption(String consumptionData) {
		JsonObject consumptionObject = new JsonParser().parse(consumptionData).getAsJsonObject();

		String TrackId = consumptionObject.get("TrackId").getAsString();
		Float PeakHoursUnit = consumptionObject.get("PeakHoursUnit").getAsFloat();
		Float NormalHoursUnit = consumptionObject.get("NormalHoursUnit").getAsFloat();
		String Month = consumptionObject.get("Month").getAsString();
		String AccNumber = consumptionObject.get("AccNumber").getAsString();

		PowerConsumptionService consumptionObject2 = new PowerConsumptionService();

		consumptionObj.setTrackId(TrackId);
		consumptionObj.setPeakHoursUnit(PeakHoursUnit);
		consumptionObj.setNormalHoursUnit(NormalHoursUnit);
		consumptionObj.setMonth(Month);
		consumptionObj.setAccNumber(AccNumber);

		String output = consumptionObject2.insertconsumption(consumptionObj);
		return output;
	}

	// Update API
	@RolesAllowed({"admin"})
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateconsumption(String consumptionData) {
		// Convert the input string to a JSON object
		JsonObject consumptionObject = new JsonParser().parse(consumptionData).getAsJsonObject();
		// Read the values from the JSON object
		String TrackId = consumptionObject.get("TrackId").getAsString();
		Float PeakHoursUnit = consumptionObject.get("PeakHoursUnit").getAsFloat();
		Float NormalHoursUnit = consumptionObject.get("NormalHoursUnit").getAsFloat();
		String Month = consumptionObject.get("Month").getAsString();
		String AccNumber = consumptionObject.get("AccNumber").getAsString();

		PowerConsumptionService consumptionObject1 = new PowerConsumptionService();

		consumptionObj.setTrackId(TrackId);
		consumptionObj.setPeakHoursUnit(PeakHoursUnit);
		consumptionObj.setNormalHoursUnit(NormalHoursUnit);
		consumptionObj.setMonth(Month);
		consumptionObj.setAccNumber(AccNumber);

		String output = consumptionObject1.updateconsumption(consumptionObj);
		return output;
	}

	// Delete API
	@RolesAllowed({"admin"})
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteconsumption(String consumptionData) {

		JsonObject consumptionObject = new JsonParser().parse(consumptionData).getAsJsonObject();

		String TrackId = consumptionObject.get("TrackId").getAsString();

		PowerConsumptionService consumptionObject2 = new PowerConsumptionService();
		consumptionObj.setTrackId(TrackId);

		String output = consumptionObject2.deleteconsumption(consumptionObj);
		return output;
	}

}
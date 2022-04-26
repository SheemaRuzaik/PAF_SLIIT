package com.paf.model;

public class PowerConsumption {

	private String TrackId;
	private Float PeakHoursUnit;
	private Float NormalHoursUnit;
	private String Month;
	private String AccNumber;

	public PowerConsumption() {

	}

	public PowerConsumption(String TrackId, Float PeakHoursUnit, Float NormalHoursUnit, String Month,  String AccNumber) {
		super();
		this.TrackId = TrackId;
		this.PeakHoursUnit = PeakHoursUnit;
		this.NormalHoursUnit = NormalHoursUnit;
		this.Month = Month;
		this.AccNumber = AccNumber;
	}

	public String getTrackId() {
		return TrackId;
	}

	public void setTrackId(String TrackId) {
		this.TrackId = TrackId;
	}

	public Float getPeakHoursUnit() {
		return PeakHoursUnit;
	}

	public void setPeakHoursUnit(Float PeakHoursUnit) {
		this.PeakHoursUnit = PeakHoursUnit;
	}

	public Float getNormalHoursUnit() {
		return NormalHoursUnit;
	}

	public void setNormalHoursUnit(Float NormalHoursUnit) {
		this.NormalHoursUnit = NormalHoursUnit;
	}

	public String getMonth() {
		return Month;
	}

	public void setMonth(String Month) {
		this.Month = Month;
	}


	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String AccNumber) {
		this.AccNumber = AccNumber;
	}

}

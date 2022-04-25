package net.invoice.we;

public class InvoiceDelete {

	public InvoiceDelete() {
		float numOfUnits;
		float normalUnitPrice;
		float peakUnitPrice;
		
		
		public CalculateBill(float numOfUnits, float normalUnitPrice, float peakUnitPrice) {
			super();
			this.numOfUnits = numOfUnits;
			this.normalUnitPrice = normalUnitPrice;
			this.peakUnitPrice = peakUnitPrice;
		}


		public float Calculation( numOfUnits,){
			
			float peakUnitprice;
			float amount = numOfUnits * peakUnitprice;
			
			return amount;
			
			
		}
		
	}


		public float getNumOfUnits() {
			return numOfUnits;
		}


		public void setNumOfUnits(float numOfUnits) {
			this.numOfUnits = numOfUnits;
		}


		public float getNormalUnitPrice() {
			return normalUnitPrice;
		}


		public void setNormalUnitPrice(float normalUnitPrice) {
			this.normalUnitPrice = normalUnitPrice;
		}


		public float getPeakUnitPrice() {
			return peakUnitPrice;
		}


		public void setPeakUnitPrice(float peakUnitPrice) {
			this.peakUnitPrice = peakUnitPrice;
		}
		// TODO Auto-generated constructor stub
	}



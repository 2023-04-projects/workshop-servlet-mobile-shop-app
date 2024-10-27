package com.khadri.stock.mobile.form;

import java.sql.Date;

public class ChargerForm {

		private String chargerBrand;
		private Double chargerprice;
		private String chargerModel;
		private Date arrivedDate ;
		
		public ChargerForm(String chargerBrand, Double chargerprice, String chargerModel, Date arrivedDate) {
			super();
			this.chargerBrand = chargerBrand;
			this.chargerprice = chargerprice;
			this.chargerModel = chargerModel;
			this.arrivedDate = arrivedDate;
		}

		public String getChargerBrand() {
			return chargerBrand;
		}

		public Double getChargerprice() {
			return chargerprice;
		}

		public String getChargeMrodel() {
			return chargerModel;
		}

		public Date getArrivedDate() {
			return arrivedDate;
		}
}

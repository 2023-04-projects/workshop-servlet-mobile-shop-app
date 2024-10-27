package com.khadri.stock.mobile.form;

import java.sql.Date;

public class PowerBankForm {

	private String powerBankBrand;
	private Double powerBankprice;
	private String powerBankModel;
	private Date arrivedDate;
	
	public PowerBankForm(String powerBankBrand, Double powerBankprice, String powerBankModel, Date arrivedDate) {
		super();
		this.powerBankBrand = powerBankBrand;
		this.powerBankprice = powerBankprice;
		this.powerBankModel = powerBankModel;
		this.arrivedDate = arrivedDate;
	}

	public String getPowerBankBrand() {
		return powerBankBrand;
	}

	public Double getPowerBankprice() {
		return powerBankprice;
	}

	public String getPowerBankModel() {
		return powerBankModel;
	}

	public Date getArrivedDate() {
		return arrivedDate;
	}

}

package com.khadri.stock.mobile.form;

import java.sql.Date;

public class HeadSetForm {

	private String headSetBrand;
	private Double headSetprice;
	private String headSetModel;
	private Date arrivedDate;

	public HeadSetForm(String headSetBrand, Double headSetprice, String headSetModel, Date arrivedDate) {
		super();
		this.headSetBrand = headSetBrand;
		this.headSetprice = headSetprice;
		this.headSetModel = headSetModel;
		this.arrivedDate = arrivedDate;
	}

	public String getHeadSetBrand() {
		return headSetBrand;
	}

	public Double getHeadSetprice() {
		return headSetprice;
	}

	public String getHeadSetModel() {
		return headSetModel;
	}

	public Date getArrivedDate() {
		return arrivedDate;
	}

}

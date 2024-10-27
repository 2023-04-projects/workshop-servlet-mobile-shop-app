package com.khadri.stock.mobile.form;

import java.sql.Date;

public class MobileForm {
	private String mobileBrand;
	private Double mobileprice;
	private String mobileModel;
	private Date arrivedDate;

	public MobileForm(String mobileBrand, Double mobileprice, String mobileModel, Date arrivedDate) {
		super();
		this.mobileBrand = mobileBrand;
		this.mobileprice = mobileprice;
		this.mobileModel = mobileModel;
		this.arrivedDate = arrivedDate;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public Double getMobileprice() {
		return mobileprice;
	}

	public String getMobileModel() {
		return mobileModel;
	}

	public Date getArrivedDate() {
		return arrivedDate;
	}

}
//select * from stock if mobile
//we need to write switch case
//if it is execute it should execute it should update in if block table set =1+1 update in if block only u should write

//call select *for stock if 











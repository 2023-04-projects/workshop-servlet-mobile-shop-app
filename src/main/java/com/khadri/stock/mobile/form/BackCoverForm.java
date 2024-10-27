package com.khadri.stock.mobile.form;

import java.sql.Date;

public class BackCoverForm {
	
	private String backCoverBrand;
	private Double backCoverprice;
	private String backCoverModel;
	private Date arrivedDate;
	
	public BackCoverForm(String backCoverBrand, Double backCoverprice, String backCoverModel, Date arrivedDate) {
		super();
		this.backCoverBrand = backCoverBrand;
		this.backCoverprice = backCoverprice;
		this.backCoverModel = backCoverModel;
		this.arrivedDate = arrivedDate;
	}

	public String getBackCoverBrand() {
		return backCoverBrand;
	}

	public Double getBackCoverprice() {
		return backCoverprice;
	}

	public String getBackCoverModel() {
		return backCoverModel;
	}

	public Date getArrivedDate() {
		return arrivedDate;
	}


}

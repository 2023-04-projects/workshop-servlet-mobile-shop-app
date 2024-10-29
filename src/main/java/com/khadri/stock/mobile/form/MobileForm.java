package com.khadri.stock.mobile.form;

import java.sql.Date;

public class MobileForm {
	private String productBrand;
	private Double productprice;
	private String productModel;
	private Date arrivedDateTime;
	public MobileForm(String productBrand, Double productprice, String productModel, Date arrivedDateTime) {
		super();
		this.productBrand = productBrand;
		this.productprice = productprice;
		this.productModel = productModel;
		this.arrivedDateTime = arrivedDateTime;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public Double getProductprice() {
		return productprice;
	}
	public String getProductModel() {
		return productModel;
	}
	public Date getArrivedDateTime() {
		return arrivedDateTime;
	}

	

}










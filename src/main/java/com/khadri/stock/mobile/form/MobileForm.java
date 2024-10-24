package com.khadri.stock.mobile.form;

public class MobileForm {
	private int mobileModelNo;
	private String mobileName;
	private String mobileBrand;
	private Double mobileCost;
	private int mobileQuantity;

	public MobileForm(int mobileModelNo, String mobileName, String mobileBrand, Double mobileCost, int mobileQuantity) {
		super();
		this.mobileModelNo = mobileModelNo;
		this.mobileName = mobileName;
		this.mobileBrand = mobileBrand;
		this.mobileCost = mobileCost;
		this.mobileQuantity = mobileQuantity;
	}

	public int getMobileModelNo() {
		return mobileModelNo;
	}

	public String getMobileName() {
		return mobileName;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

public Double getMobileCost() {		
		return mobileCost;
	}

	public int getMobileQuantity() {
		return mobileQuantity;
	}

}

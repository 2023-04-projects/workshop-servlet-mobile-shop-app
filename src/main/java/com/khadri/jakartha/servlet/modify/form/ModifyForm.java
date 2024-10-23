package com.khadri.jakartha.servlet.modify.form;

public class ModifyForm {
	private String mobileModelNumber;
	private String mobileName;
	private String mobileBrand;
	private double mobileCost;
	private int mobileQuantity;

	public ModifyForm(String mobileModelNumber, String mobileName, String mobileBrand, double mobileCost,
			int mobileQuantity) {
		super();
		this.mobileModelNumber = mobileModelNumber;
		this.mobileName = mobileName;
		this.mobileBrand = mobileBrand;
		this.mobileCost = mobileCost;
		this.mobileQuantity = mobileQuantity;
	}

	public ModifyForm() {
	}

	public String getMobileModelNumber() {
		return mobileModelNumber;
	}

	public void setMobileModelNumber(String mobileModelNumber) {
		this.mobileModelNumber = mobileModelNumber;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public double getMobileCost() {
		return mobileCost;
	}

	public void setMobileCost(double mobileCost) {
		this.mobileCost = mobileCost;
	}

	public int getMobileQuantity() {
		return mobileQuantity;
	}

	public void setMobileQuantity(int mobileQuantity) {
		this.mobileQuantity = mobileQuantity;
	}

}

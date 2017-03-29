package com.iqbal.pojoclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBag {

	@SerializedName("BrandName")
	@Expose
	private String brandName;
	@SerializedName("Features")
	@Expose
	private Features features;
	@SerializedName("Id")
	@Expose
	private Integer id;
	@SerializedName("LaptopName")
	@Expose
	private String laptopName;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Features getFeatures() {
		return features;
	}

	public void setFeatures(Features features) {
		this.features = features;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

}
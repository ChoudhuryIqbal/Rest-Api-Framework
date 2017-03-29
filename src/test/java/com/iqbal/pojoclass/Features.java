package com.iqbal.pojoclass;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Features {

	@SerializedName("Feature")
	@Expose
	private List<String> feature = null;

	public List<String> getFeature() {
		return feature;
	}

	public void setFeature(List<String> feature) {
		this.feature = feature;
	}

}
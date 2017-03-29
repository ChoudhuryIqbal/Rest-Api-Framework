package com.iqbal.testScripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iqbal.pojoclass.GetBag;
import com.iqbal.utils.EndPointUrl;
import com.iqbal.utils.URL;
import com.iqbal.webserviceMethods.Webservices;
import com.jayway.restassured.response.Response;

public class TC_001 {
	Response response;
	ArrayList<String > brandName;
	@BeforeClass
	public void setUp() {
		brandName=new ArrayList<String>();
		brandName.add("Dell");
		brandName.add("Apple");

	}

	@Test(enabled=false)
	public void verifyGetMessage() {

		String url = URL.lapTopBagUrl+EndPointUrl.PING_MESSAGE.getResourcePath("pingman");
		response = Webservices.Get(url);
		System.out.println(url);
		System.out.println(response.getBody().asString());
		System.out.println("...................");
	}

	@Test
	public void verifyGetAllLaptopBag() {
		Gson gson = new Gson();
		GetBag getBag[];

		String url = URL.lapTopBagUrl + EndPointUrl.GET_BAG.getResourcePath();
		 //System.out.println(url);
		response = Webservices.Get(url);
		
		System.out.println(response.getBody().asString());

		if (response.getStatusCode() == 200) {
			getBag = gson.fromJson(response.getBody().asString(), GetBag[].class);
			//String getComp[]={"Dell","Apple"};
			for (int i = 0; i < getBag.length; i++) {
				//System.out.println(getBag[0].getBrandName());
				Assert.assertEquals(brandName.get(i), getBag[i].getBrandName());
			
			
			}

		}

	}

	
	public void verifyGetById() {
		String url = URL.lapTopBagUrl.concat(EndPointUrl.GET_BAG_BY_ID.getResourcePath("126"));

		response = Webservices.Get(url);
		System.out.println(response.getBody().asString());
	}

	
	public void VerifyAddCountry() {

	}

}

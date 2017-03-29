package com.iqbal.testScripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
	ArrayList<Object> brandName;
	ArrayList<Object> bagId;
	ArrayList<Object> laptopName;
	// ArrayList<Object> bagId;

	@BeforeClass
	public void setUp() {
		brandName = new ArrayList<Object>();
		// brandName.add("Dell");
		// brandName.add("Apple");
		// id=new ArrayList<Object>();
		laptopName = new ArrayList<Object>();
		bagId = new ArrayList<Object>();

	}

	@Test(enabled = false)
	public void verifyGetMessage() {

		String url = URL.lapTopBagUrl + EndPointUrl.PING_MESSAGE.getResourcePath("pingman");
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
		// System.out.println(url);
		response = Webservices.Get(url);

		System.out.println(response.getBody().asString());

		if (response.getStatusCode() == 200) {
			getBag = gson.fromJson(response.getBody().asString(), GetBag[].class);
			// String getComp[]={"Dell","Apple"};
			for (int i = 0; i < getBag.length; i++) {
				// System.out.println(getBag[0].getBrandName());
				Assert.assertEquals(new Integer(i + 126), getBag[i].getId());
				brandName.add(getBag[i].getBrandName());
				laptopName.add(getBag[i].getLaptopName());
				bagId.add(getBag[i].getId());

			}

		}

	}
@Test(dataProvider="getBagById")
	public void verifyGetById(Integer id,String brand,String lname) {
		
	Gson gson=new Gson();
	GetBag getBag;
	
	
	
	String url = URL.lapTopBagUrl.concat(EndPointUrl.GET_BAG_BY_ID.getResourcePath(id.toString()));
		
		response = Webservices.Get(url);
		//System.out.println(response.getBody().asString());
		
		if (response.getStatusCode()==200){
			getBag=gson.fromJson(response.getBody().asString(), GetBag.class);
			//Assert.assertEquals(new Integer(i + 126), getBag[i].getId());
			//brandName.add(brand,getBag.getBrandName());
			//laptopName.add(getBag[i].getLaptopName());
			//bagId.add(getBag[i].getId());
			Assert.assertEquals(brand,getBag.getBrandName());
			Assert.assertEquals(lname, getBag.getLaptopName());
			Assert.assertEquals(id, getBag.getId().toString());
		}
	}

	@DataProvider(name = "getBagById")
	public Object[][] getBagById() {

		Object[][] result = new Object[2][1];
		for (int i = 0; i < result.length; i++) {
			result[i][0] = bagId.get(i);
			result[i][1]=brandName.get(i);
			result[i][2]=laptopName.get(i);
			

		}
		return result;

	}

	public void VerifyAddCountry() {

	}

}

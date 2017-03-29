/*
 * Created By Iqbal 
 * date 03/28/2017
 */
package com.iqbal.utils;

// TODO: Auto-generated Javadoc
/**
 * The Enum EndPointUrl.
 */
public enum EndPointUrl {
	// String word;

	/** The ping message. */
	PING_MESSAGE("/ping/"),

	/** The get bag. */
	GET_BAG("/all"),

	/** The get bag by id. */
	GET_BAG_BY_ID("/find/"),

	/** The add bag. */
	ADD_BAG("/add"),

	/** The update bag. */
	UPDATE_BAG("/update"),

	/** The delet bag. */
	DELET_BAG("/delete");

	/** The resource path. */
	String resourcePath;

	/**
	 * Instantiates a new end point url.
	 *
	 * @param resourcePath
	 *            the resource path
	 */
	EndPointUrl(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	/**
	 * Gets the resource path.
	 *
	 * @return the resource path
	 */
	public String getResourcePath() {
		return this.resourcePath;
	}

	/**
	 * Gets the resource path.
	 *
	 * @param data
	 *            the data
	 * @return the resource path
	 */
	public String getResourcePath(String data) {
		return this.resourcePath + data;
	}
	public static void main (String [] args){
		System.out.println(EndPointUrl.ADD_BAG.getResourcePath());
	
	System.out.println("making fulll url for add bag:");
	String url=URL.lapTopBagUrl+EndPointUrl.ADD_BAG.getResourcePath();
	System.out.println(url);
	}

}

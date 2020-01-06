package vn.teko.test.application.common;

import vn.teko.jira.Configuration;

public enum ApplicationEndPoints {
	PRODUCT_CREATION("/products/"),
    BRAND_CREATION("/brands"),
    BRAND_UPDATING("/brands/{brandId}"),
    
    ATTRIBUTE_SET_CREATION("/attribute_sets"),
    
    SALE_CATEGORY_CREATION("/sale_categories"),
	
	SALE_CHANNEL_CREATION("/sale_channels");

    private final String url;
  

    ApplicationEndPoints(String url) {    	
    	String baseUrl = Configuration.getApplicationEndPoint();
    	this.url = baseUrl + url;
    }

    public String getUrl() {
        return url;
    }
}

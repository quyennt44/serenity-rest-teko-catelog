package vn.teko.test.application.common;

import vn.teko.jira.Configuration;

public enum ApplicationEndPoints {
	PRODUCT_CREATION("/products"),
    BRAND_CREATION("/brands"),
    BRAND_UPDATE("/brands/{brandId}"),
    
    ATTRIBUTE_SET_CREATION("/attribute_sets"),
    
    MASTER_CATEGORY_CREATION("/master_categories"),
    MASTER_CATEGORY_UPDATE("/master_categories/{masterCategoryId}"),
	
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

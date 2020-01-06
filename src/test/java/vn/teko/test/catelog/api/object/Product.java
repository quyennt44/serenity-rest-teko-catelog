package vn.teko.test.catelog.api.object;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import vn.teko.application.steps.DatabaseSteps;

public class Product {
    private String name;
    private Integer brandId;
    private Integer masterCategoryId;
    private String originCode;
    private String model;
    private Integer unitId;
    private Integer unitPoId;
    private Integer warrantyMonths;
    private String highlight;
    private String description;
    
    
    public Product() {
    	Random random = new Random();   
    	DatabaseSteps database = new DatabaseSteps();
    	this.name = RandomStringUtils.random(10, true, true).toLowerCase();	    	
    	this.brandId = database.getRandomBrandId();
    	this.masterCategoryId = database.getRandomMasterCategoryId();
    	this.model = RandomStringUtils.random(10);
    	this.unitId = database.getRandomUnitId();
    	this.unitPoId = database.getRandomUnitId();
    	this.highlight = RandomStringUtils.random(10);
    	this.description = RandomStringUtils.random(10);
    	this.warrantyMonths = random.nextInt(100);
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Integer getBrandId() {
		return brandId;
	}


	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}


	public Integer getMasterCategoryId() {
		return masterCategoryId;
	}


	public void setMasterCategoryId(Integer masterCategoryId) {
		this.masterCategoryId = masterCategoryId;
	}


	public String getOriginCode() {
		return originCode;
	}

	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Integer getUnitId() {
		return unitId;
	}


	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}


	public Integer getUnitPoId() {
		return unitPoId;
	}


	public void setUnitPoId(Integer unitPoId) {
		this.unitPoId = unitPoId;
	}



	public Integer getWarrantyMonths() {
		return warrantyMonths;
	}


	public void setWarrantyMonths(Integer warrantyMonths) {
		this.warrantyMonths = warrantyMonths;
	}


	public String getHighlight() {
		return highlight;
	}


	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
    
		
}

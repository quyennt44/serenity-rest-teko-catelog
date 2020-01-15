package vn.teko.test.catelog.api.object;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import vn.teko.application.steps.CommonSteps;
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
    private String detailedDescription;
    private String description;
    private Boolean type;
    
    
    public Product() {
    	Random random = new Random();    	
    	CommonSteps commonSteps = new CommonSteps();	
    	
    	DatabaseSteps database = new DatabaseSteps();
    	this.name = RandomStringUtils.random(10, true, true).toLowerCase();    	
//    	this.brandId = database.getRandomBrandId();
//    	this.masterCategoryId = 1000;
    	this.masterCategoryId = (Integer) commonSteps.retrieveObject("parentMasterCategoryId");
    	this.brandId =  (Integer) commonSteps.retrieveObject("brandId");
    	this.model = RandomStringUtils.random(10, true, true);
    	this.unitId = database.getRandomUnitId();
    	this.unitPoId = database.getRandomUnitId();
    	this.detailedDescription = RandomStringUtils.random(10, true, true);
    	this.description = RandomStringUtils.random(10, true, true);
    	this.warrantyMonths = random.nextInt(100);
    	this.originCode = "VN";
    	this.type = random.nextBoolean();
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

	
	public String getDetailedDescription() {
		return detailedDescription;
	}


	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getType() {
		return type;
	}


	public void setType(Boolean type) {
		this.type = type;
	}
	
}

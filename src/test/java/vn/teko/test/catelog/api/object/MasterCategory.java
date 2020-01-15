package vn.teko.test.catelog.api.object;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class MasterCategory {
	private String name;
	private String code;	
	private Integer parentId;
	private Integer isActive;
	private String image;
	

	
	public MasterCategory() {
		Random random = new Random();
		this.code = RandomStringUtils.random(40, true, true).toLowerCase();
		this.name = RandomStringUtils.random(50, true, true).toLowerCase();	
		this.isActive = random.nextInt(2);	
		this.parentId = 0;
		this.image = "";
	}
	
	public MasterCategory(Integer isActive) {		
		this.code = RandomStringUtils.random(40, true, true).toLowerCase();
		this.name = RandomStringUtils.random(50, true, true).toLowerCase();	
		this.isActive = isActive;	
		this.parentId = 0;
		this.image = "";
	}	
	
	public MasterCategory(Integer isActive, Integer parentId) {		
		this.code = RandomStringUtils.random(40, true, true).toLowerCase();
		this.name = RandomStringUtils.random(50, true, true).toLowerCase();	
		this.isActive = isActive;	
		this.parentId = parentId;
		this.image = "";
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
}

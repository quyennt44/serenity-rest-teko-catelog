package vn.teko.test.catelog.api.object;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class SaleCategory {
	private String name;
	private String code;	
	private Integer parent_id;
	private Integer is_active;
	private String image;
	

	
	public SaleCategory() {
		Random random = new Random();
		this.code = RandomStringUtils.random(40, true, true).toLowerCase();
		this.name = RandomStringUtils.random(50, true, true).toLowerCase();	
		this.is_active = random.nextInt(2);	
		this.parent_id = 0;
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

	public Integer getIs_active() {
		return is_active;
	}

	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}


	public Integer getParent_id() {
		return parent_id;
	}


	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
}

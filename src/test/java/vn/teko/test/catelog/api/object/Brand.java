package vn.teko.test.catelog.api.object;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

//@JsonInclude(Include.NON_NULL)
public class Brand {	
	private String name;	
	private String code;
	private String logo;
	private boolean docRequest;
	private boolean isActive;
	
	public Brand() {
		Random random = new Random();
		this.code = RandomStringUtils.random(40, true, true).toLowerCase();
		this.name = RandomStringUtils.random(50, true, true).toLowerCase();
		this.docRequest = random.nextBoolean();
		this.logo = "";		
	}
	
	public Brand(String name) {
		Random random = new Random();
		this.code = RandomStringUtils.random(40, true, true).toLowerCase();
		this.name = name;
		this.docRequest = random.nextBoolean();
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public boolean getDocRequest() {
		return docRequest;
	}

	public void setDocRequest(boolean docRequest) {
		this.docRequest = docRequest;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}

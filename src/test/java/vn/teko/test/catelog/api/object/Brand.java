package vn.teko.test.catelog.api.object;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

//@JsonInclude(Include.NON_NULL)
public class Brand {	
	private String name;	
	private String code;
	private String logo;
	private boolean doc_request;
	private boolean is_active;
	
	public Brand() {
		Random random = new Random();
		this.code = RandomStringUtils.random(40, true, true).toLowerCase();
		this.name = RandomStringUtils.random(50, true, true).toLowerCase();
		this.doc_request = random.nextBoolean();
		this.logo = "";
	}
	
	public Brand(String name) {
		Random random = new Random();
		this.code = RandomStringUtils.random(40, true, true).toLowerCase();
		this.name = name;
		this.doc_request = random.nextBoolean();
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

	

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean getDoc_request() {
		return doc_request;
	}

	public void setDoc_request(boolean doc_request) {
		this.doc_request = doc_request;
	}
}

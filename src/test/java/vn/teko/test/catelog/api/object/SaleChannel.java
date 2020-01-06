package vn.teko.test.catelog.api.object;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import vn.teko.utilities.Constant;

public class SaleChannel {
	private String name;
	private String code;
	private String type;
	private Integer seller_id;
	private Integer is_active;

	
	public SaleChannel() {
		Random random = new Random();
		this.code = RandomStringUtils.random(40, true, true).toLowerCase();
		this.name = RandomStringUtils.random(50, true, true).toLowerCase();		
		this.type = Constant.SALE_CHANNEL_TYPE_LIST.get(random.nextInt(Constant.SALE_CHANNEL_TYPE_LIST.size()));
		this.seller_id = Constant.SELLER_LIST.get(random.nextInt(Constant.SELLER_LIST.size()));
		this.is_active = random.nextInt(2);		
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	public Integer getSeller_id() {
		return seller_id;
	}


	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}


	public Integer getIs_active() {
		return is_active;
	}


	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}

	
	
}

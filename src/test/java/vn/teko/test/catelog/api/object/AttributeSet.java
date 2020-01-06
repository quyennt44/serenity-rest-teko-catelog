package vn.teko.test.catelog.api.object;

import org.apache.commons.lang3.RandomStringUtils;

public class AttributeSet {
	private String name;
	
	public AttributeSet() {		
		this.name = RandomStringUtils.random(50, true, true);
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

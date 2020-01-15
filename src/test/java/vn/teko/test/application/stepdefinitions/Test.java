package vn.teko.test.application.stepdefinitions;

import org.apache.commons.lang3.RandomStringUtils;

public class Test {

	public static void main(String str[]) {		
		System.out.println(RandomStringUtils.randomAlphanumeric(5));
		System.out.println(RandomStringUtils.randomAscii(10));
		System.out.println(RandomStringUtils.random(5));
	}
}

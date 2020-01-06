package vn.teko.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString{
	
	public static String generateSpecialRandomString(String type, boolean letter, boolean number, int length) {
		String returnedString = null;
		switch(type) {		
			case Constant.SPACES_ONLY_VALUE:
				returnedString = "                   ";
				break;
				
			case Constant.LEADING_ENDING_SPACES_VALUE:
				returnedString = "           " + RandomStringUtils.random(length, letter, number) + "                    ";				
				break;
				
			case Constant.CONTAIN_SPACE_VALUE:
				returnedString = RandomStringUtils.random(length, RandomStringUtils.random(length, letter, number) + Constant.SPECIAL_CHARACTERS);		
				break;
				
			case Constant.CONTAIN_SPECIAL_CHARACTERS_VALUE:
				returnedString = RandomStringUtils.random(length, RandomStringUtils.random(length, letter, number) + Constant.SPACE_CHARACTERS);								
				break;
				
			case Constant.RANDOM_DIACRITIC_MARK:
				returnedString = RandomStringUtils.random(length, RandomStringUtils.random(length, letter, number) + Constant.UNICODE_CHARACTERS);		
				break;	
				
			case Constant.RANDOM_STRING_VALUE:
				returnedString = RandomStringUtils.random(length, letter, number);		
				break;	
				
			default:
				returnedString = RandomStringUtils.random(length, letter, number);				
		}
		
		return returnedString;
	}	
}

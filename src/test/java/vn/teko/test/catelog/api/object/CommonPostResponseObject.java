package vn.teko.test.catelog.api.object;

import java.util.Map;

public class CommonPostResponseObject {	
	private String code;
	private String message;
	private Map<String,String> errors;
	
	private Map<String,Integer> result;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Integer> getResult() {
		return result;
	}
	public void setResult(Map<String, Integer> result) {
		this.result = result;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	
	
}

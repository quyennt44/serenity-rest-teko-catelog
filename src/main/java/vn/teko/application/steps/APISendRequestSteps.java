package vn.teko.application.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import vn.teko.jira.Configuration;
import vn.teko.utilities.Constant;


public class APISendRequestSteps {	
	@Step
	public void excutePostRequest(Object object, String url, String user) {	
		try {
			SerenityRest.given().contentType(Configuration.CONTENT_TYPE)
					.header(Configuration.HEADER_AUTHOR, Configuration.getUserToken(user)).body(object).post(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				Thread.sleep(Constant.THREAD_SLEEP);
				SerenityRest.given().contentType(Configuration.CONTENT_TYPE)
				.header(Configuration.HEADER_AUTHOR, Configuration.getUserToken(user)).body(object).post(url);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				SerenityRest.given().contentType(Configuration.CONTENT_TYPE)
				.header(Configuration.HEADER_AUTHOR, Configuration.getUserToken(user)).body(object).post(url);
			}
		}		
	}
	
	
	@Step
	public void excutePostRequest(String objectName, String url, String user) {	
		Object object = Serenity.getCurrentSession().get(objectName);
		
		try {
			SerenityRest.given().contentType(Configuration.CONTENT_TYPE)
					.header(Configuration.HEADER_AUTHOR, Configuration.getUserToken(user)).body(object).post(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				Thread.sleep(Constant.THREAD_SLEEP);
				SerenityRest.given().contentType(Configuration.CONTENT_TYPE)
				.header(Configuration.HEADER_AUTHOR, Configuration.getUserToken(user)).body(object).post(url);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				SerenityRest.given().contentType(Configuration.CONTENT_TYPE)
				.header(Configuration.HEADER_AUTHOR, Configuration.getUserToken(user)).body(object).post(url);
			}
		}		
	}	
	
	@Step
	public void excuteUpdateRequest(Object object, String url, @SuppressWarnings("unchecked") HashMap<String, ?> ...parameterNameValuePairs) {	
		String user = getUser();
		if(parameterNameValuePairs.length > 0) {
			SerenityRest.given()
					.pathParams(parameterNameValuePairs[0])
					.contentType(Configuration.CONTENT_TYPE)
					.header(Configuration.HEADER_AUTHOR, Configuration.getUserToken(user))
					.body(object).put(url);		
		}else {
			SerenityRest.given()			
			.contentType(Configuration.CONTENT_TYPE)
			.header(Configuration.HEADER_AUTHOR, Configuration.getUserToken(user))
			.body(object).put(url);			
		}
	}	
	
//	@Step
//	public void excutePostRequestParamMissing(Object object, String url, List<String> paramToRemoves, String user) {		
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode node = mapper.valueToTree(object);
//		for (String fieldToRemove : paramToRemoves) {
//			((ObjectNode) node).remove(fieldToRemove);
//		}		
//		try {
//			object = mapper.treeToValue(node, Object.class);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		SerenityRest.given().contentType(Configuration.CONTENT_TYPE)
//				.header(Configuration.HEADER_AUTHOR, Configuration.getUserToken(user)).body(object).post(url);
//	}	
	
	

	@Step
	public void responseStatusShouldBeEqual(int statusCode) {
		assertThat(statusCode, equalTo(SerenityRest.then().extract().statusCode()));
	}
	
	@Step
	public void storeUser(String user) {		
		Serenity.getCurrentSession().put("user", user);
	}	

	public String getUser() {		
		String user = (String) Serenity.getCurrentSession().get("user");
		return user;
	}
//	
//	
//	public void setUser(String user) {		
//		this.user = user;		
//	}
}

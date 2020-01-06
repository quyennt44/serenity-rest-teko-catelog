package vn.teko.test.application.stepdefinitions.common;

import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.APISendRequestSteps;
import vn.teko.application.steps.CommonSteps;
import vn.teko.application.steps.DatabaseSteps;
import vn.teko.application.steps.SetGetBeanProperties;
import vn.teko.test.application.model.SellerModel;
import vn.teko.utilities.Constant;
import vn.teko.utilities.DataKeeper;
import vn.teko.utilities.Helper;

public class CommonSetValueStepDefinitions {
	@Steps
	APISendRequestSteps apiSteps;
		
	@Steps
	SetGetBeanProperties setGetBeanProperties;
	
	DataKeeper dataKeeper = new DataKeeper();

	@Steps
	CommonSteps commonSteps;
	

	@Steps
	DatabaseSteps database;
		

	@When("^User changes value of variable ['\"]([^'\"]*)['\"] to ['\"]([^'\"]*)['\"]$")
	public void change_value(String variable, String type) {
		commonSteps.changeValueOfStringVariable(variable, type);
	}
	 

	@And("^User set value of object ['\"]([^'\"]*)['\"] for field ['\"]([^'\"]*)['\"] to ['\"]([^'\"]*)['\"]$")
	public void set_value(String objectName, String fieldName, String value) {
		setGetBeanProperties.changeObjectValue(objectName, fieldName, value);
	}
	
	@And("^User set value of object ['\"]([^'\"]*)['\"] for field ['\"]([^'\"]*)['\"] to \\+?(-?\\d+)$")
	public void set_value(String objectName, String fieldName, int value) {
		setGetBeanProperties.changeObjectValue(objectName, fieldName, value);
	}	
	
	@And("^User set value of object ['\"]([^'\"]*)['\"] for field ['\"]([^'\"]*)['\"] to ['\"]([^'\"]*)['\"] in length (\\d+)$")
	public void set_value(String objectName, String fieldName, String value, int length) {
		setGetBeanProperties.changeObjectValue(objectName, fieldName, value, length);
	}

	@When("^User set value of object ['\"]([^'\"]*)['\"] for field ['\"]([^'\"]*)['\"] with variable ['\"]([^'\"]*)['\"]$")
	public void set_data_by_variable(String objectName, String fieldName, String variable) {		
		setGetBeanProperties.changeObjectWithVariable(objectName, fieldName, variable);
	}
	
	@When("^User store a variable ['\"]([^'\"]*)['\"] with value as ['\"]([^'\"]*)['\"] in length (\\d+)$")
	public void store_variable(String variable, String type, int length) {
		commonSteps.storeStringData(variable, type, true, true, length);
	}
	
	@And("User removes field ['\"]([^'\"]*)['\"] from object ['\"]([^'\"]*)['\"]$")
	public void field_to_remove(String fieldName, String objectName) {
		commonSteps.removeFieldFromObjectAndStoreToVariable(objectName, fieldName);
	}
	
	@And("^User sends request to ['\"](create|update)['\"] object ['\"]([^'\"]*)['\"] as user ['\"]([^'\"]*)['\"] with url ['\"]([^'\"]*)['\"]$")
	public void send_request(String action, String objectName, String user, String urlVariable) {
		String url = (String) Serenity.getCurrentSession().get(urlVariable);
		apiSteps.excutePostRequest(objectName, url, user);
		if(SerenityRest.then().extract().statusCode() != Constant.SERVER_STATUS_ERROR) {
			JsonNode id = Helper.searchForEntityFromResponse(Constant.RESPONSE_ID_FIELD);
			if(id != null) {
				dataKeeper.addIdToList(id.asInt());
			}
		}
		commonSteps.storeObject("dataKeeper", dataKeeper);	
		
	}	
	
	@And("^User gets max id from (.*) then add some more value and store to a variable ['\"]([^'\"]*)['\"]$")
	public void get_max_id(String table, String variable) {
		String model = (String) Serenity.getCurrentSession().get(Constant.DATABASE_MODEL_CLASS_TEMP_VARIABLE);
		int overMaxValue = database.getMaxValueFromColumn(model) * 10;
		commonSteps.storeObject(variable, overMaxValue);	
	}
	
	@And("User gets random sale channel type and store as variable ['\"]([^'\"]*)['\"]$")
	public void get_random_sale_channel_type(String variable) {		
		Random random = new Random();
		String type = Constant.SALE_CHANNEL_TYPE_LIST.get(random.nextInt(Constant.SALE_CHANNEL_TYPE_LIST.size()));
		commonSteps.storeObject(variable, type);	
	}
	
	@And("User gets random seller id and store as variable ['\"]([^'\"]*)['\"]$")
	public void get_random_seller_id(String variable) {		
		Random random = new Random();
		int sellerId = Constant.SELLER_LIST.get(random.nextInt(Constant.SELLER_LIST.size()));
		commonSteps.storeObject(variable, sellerId);	
	}
	
	@And("User sets seller id ['\"]([^'\"]*)['\"] to status inactive$")
	public void set_seller_status_inactive(String sellerVariable) {		
		int sellerId = (int) commonSteps.retrieveObject(sellerVariable);	
		SellerModel seller = (SellerModel) database.findObjectById(SellerModel.class, sellerId);
		seller.setStatus(Constant.SELLER_STATUS_INACTIVE);
		database.update(seller);			
	}

	@And("User sets seller id ['\"]([^'\"]*)['\"] to status active$")
	public void set_seller_status_active(String sellerVariable) {		
		int sellerId = (int) commonSteps.retrieveObject(sellerVariable);	
		SellerModel seller = (SellerModel) database.findObjectById(SellerModel.class, sellerId);
		seller.setStatus(Constant.SELLER_STATUS_ACTIVE);
		database.update(seller);			
	}
	
	@And("User gets id from the response and store as varialbe ['\"]([^'\"]*)['\"]")
	public void get_id_from_response(String variable) {		
		int id = Helper.getIdFromResponse();
		commonSteps.storeObject(variable, id);	
	}
}

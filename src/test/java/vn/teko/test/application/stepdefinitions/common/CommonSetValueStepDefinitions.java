


package vn.teko.test.application.stepdefinitions.common;

import java.util.HashMap;
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
import vn.teko.test.application.common.ApplicationEndPoints;
import vn.teko.test.application.model.SellerModel;
import vn.teko.test.catelog.api.object.Brand;
import vn.teko.test.catelog.api.object.MasterCategory;
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
	 
	//Set String value
	@And("^User sets value of object ['\"]([^'\"]*)['\"] for field ['\"]([^'\"]*)['\"] to ['\"]([^'\"]*)['\"]$")
	public void set_value(String objectName, String fieldName, String value) {
		setGetBeanProperties.changeObjectValue(objectName, fieldName, value);
	}
	
	//Set int value
	@And("^User sets value of object ['\"]([^'\"]*)['\"] for field ['\"]([^'\"]*)['\"] to \\+?(-?\\d+)$")
	public void set_value(String objectName, String fieldName, int value) {
		setGetBeanProperties.changeObjectValue(objectName, fieldName, value);
	}	
	
	@And("^User sets value of object ['\"]([^'\"]*)['\"] for field ['\"]([^'\"]*)['\"] to ['\"]([^'\"]*)['\"] in length (\\d+)$")
	public void set_value(String objectName, String fieldName, String value, int length) {
		setGetBeanProperties.changeObjectValue(objectName, fieldName, value, length);
	}

	@When("^User sets value of object ['\"]([^'\"]*)['\"] for field ['\"]([^'\"]*)['\"] with variable ['\"]([^'\"]*)['\"]$")
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
	
	@And("^User sends request to create object ['\"]([^'\"]*)['\"] as user ['\"]([^'\"]*)['\"] with url ['\"]([^'\"]*)['\"]$")
	public void send_post_request(String objectName, String user, String urlVariable) {
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
	
//	@And("^User sends request to update object ['\"]([^'\"]*)['\"] as user ['\"]([^'\"]*)['\"] with url ['\"]([^'\"]*)['\"]$")
//	public void send_update_request(String objectName, String user, String urlVariable) {
//		String url = (String) Serenity.getCurrentSession().get(urlVariable);
////		HashMap pathParams = new HashMap<String, Integer>();
////		pathParams.put("brandId", 1149);
////		apiSteps.excutePatchRequest(objectName, url, user,pathParams);		
//	}		
	
	@And("^User gets max id from (.*) then add some more value and store to a variable ['\"]([^'\"]*)['\"]$")
	public void get_max_id(String table, String variable) {
		String model = (String) Serenity.getCurrentSession().get(Constant.DATABASE_MODEL_CLASS_REFERENCE_VARIABLE);
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
	
	@When("User creats a master category with status (\\d+) as user ['\"]([^'\"]*)['\"] and return id as variable ['\"]([^'\"]*)['\"]")
	public void create_master_category_with_status(int status, String user, String storeVariable) {		
		MasterCategory category = new MasterCategory(status);
		String url = ApplicationEndPoints.MASTER_CATEGORY_CREATION.getUrl();
		apiSteps.excutePostRequest(category, url, user);
		JsonNode categoryId = Helper.searchForEntityFromResponse(Constant.RESPONSE_ID_FIELD);
//		System.out.println("masterCategoryId = " + categoryId);
		commonSteps.storeObject(storeVariable, categoryId.asInt());	
	}
	
	@When("User creats a master category with status (\\d+) and parentId (.*) as user ['\"]([^'\"]*)['\"] and return id as variable ['\"]([^'\"]*)['\"]")
	public void create_master_category_with_status_parentId(int status, Object parentId, String user, String storeVariable) {	
		MasterCategory category = null;
		int categoryParentId;
		System.out.println("category id from session = " + commonSteps.retrieveObject(parentId.toString().replace("'", "").replace("\"", "")));
		try {
			categoryParentId = Integer.parseInt(parentId.toString());
			
		}catch(NumberFormatException exception) {
			System.out.println("parentMasterCategoryId = " + parentId.toString());
			categoryParentId = (int) commonSteps.retrieveObject(parentId.toString().replace("'", "").replace("\"", ""));
			
		}		
		category = new MasterCategory(status,categoryParentId);
		
		String url = ApplicationEndPoints.MASTER_CATEGORY_CREATION.getUrl();
		apiSteps.excutePostRequest(category, url, user);
		JsonNode categoryId = Helper.searchForEntityFromResponse(Constant.RESPONSE_ID_FIELD);
//		System.out.println("masterCategoryId = " + categoryId);
		commonSteps.storeObject(storeVariable, categoryId.asInt());	
	}	
	
	@When("User creats a brand as user ['\"]([^'\"]*)['\"] and return id as variable ['\"]([^'\"]*)['\"]")
	public void create_brand(String user, String storeVariable) {		
		Brand brand = new Brand();
		String url = ApplicationEndPoints.BRAND_CREATION.getUrl();
		Object requestBrand = commonSteps.removeFieldFromObjectAndStoreToVariable(brand, "isActive");
		apiSteps.excutePostRequest(requestBrand, url, user);
		JsonNode brandId = Helper.searchForEntityFromResponse(Constant.RESPONSE_ID_FIELD);
//		System.out.println("brandId = " + brandId);
		commonSteps.storeObject(storeVariable, brandId.asInt());	
	}	
	
	@SuppressWarnings("unchecked")
	@When("User creats an inactive brand as user ['\"]([^'\"]*)['\"] and return id as variable ['\"]([^'\"]*)['\"]")
	public void createInactiveBrand(String user, String storeVariable) {
		String updateUrl = ApplicationEndPoints.BRAND_UPDATE.getUrl();
		create_brand(user, storeVariable);
		int brandId = (int) commonSteps.retrieveObject(storeVariable);
//		System.out.println("BrandId = " + brandId);
		HashMap<String, Integer> pathParams = new HashMap<String, Integer>();
		pathParams.put("brandId", brandId);

		HashMap<String, Boolean> queryParams = new HashMap<String, Boolean>();
		queryParams.put("isActive", false);
		
		apiSteps.excutePatchRequest(queryParams, updateUrl, user, pathParams);
		commonSteps.storeObject(storeVariable, brandId);		
	}	
	
	@SuppressWarnings("unchecked")
	@When("User updates a brand to inactive as user ['\"]([^'\"]*)['\"] and return id as variable ['\"]([^'\"]*)['\"]")
	public void updateBrandToInactive(String user, String storeVariable) {
		String updateUrl = ApplicationEndPoints.BRAND_UPDATE.getUrl();		
		int brandId = (int) commonSteps.retrieveObject(storeVariable);
//		System.out.println("BrandId update = " + brandId);
		HashMap<String, Integer> pathParams = new HashMap<String, Integer>();
		pathParams.put("brandId", brandId);

		HashMap<String, Boolean> queryParams = new HashMap<String, Boolean>();
		queryParams.put("isActive", false);
		
		apiSteps.excutePatchRequest(queryParams, updateUrl, user, pathParams);
		commonSteps.storeObject(storeVariable, brandId);		
	}
	
	@SuppressWarnings("unchecked")
	@When("User updates a master category to inactive as user ['\"]([^'\"]*)['\"] and return id as variable ['\"]([^'\"]*)['\"]")
	public void updateMasterCategoryToInactive(String user, String storeVariable) {
		String updateUrl = ApplicationEndPoints.MASTER_CATEGORY_UPDATE.getUrl();		
		int masterCategoryId = (int) commonSteps.retrieveObject(storeVariable);
		
		HashMap<String, Integer> pathParams = new HashMap<String, Integer>();
		pathParams.put("masterCategoryId", masterCategoryId);

		HashMap<String, Integer> queryParams = new HashMap<String, Integer>();
		queryParams.put("isActive", Constant.STATUS_INACTIVE);
		
		apiSteps.excutePatchRequest(queryParams, updateUrl, user, pathParams);
		commonSteps.storeObject(storeVariable, masterCategoryId);		
	}	
}

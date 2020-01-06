package vn.teko.test.application.stepdefinitions.common;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.APISendRequestSteps;
import vn.teko.application.steps.CommonSteps;
import vn.teko.application.steps.DatabaseSteps;
import vn.teko.application.steps.SetGetBeanProperties;
import vn.teko.utilities.Constant;
import vn.teko.utilities.Helper;

public class CommonValidationStepDefinitions {
	@Steps
	APISendRequestSteps apiSteps;
		
	@Steps
	SetGetBeanProperties setGetBeanProperties;
	
	@Steps
	CommonSteps commonSteps;
	
	@Steps
	DatabaseSteps database;
	
	@Then("^The response shows hppt code as (\\d+)$")
	public void check_http_code(int httpCode) {
		apiSteps.responseStatusShouldBeEqual(httpCode);
	}
	
	
	@And("^The response should contain node ['\"]([^'\"]*)['\"]$")
	public void response_should_contain_node(String nodeName) {
		commonSteps.responseShouldContainNode(nodeName);
	}

	@And("^The value of node ['\"]([^'\"]*)['\"] should be ['\"]([^'\"]*)['\"]$")
	public void check_response_content(String nodeName, String nodeValue) {
		commonSteps.responseNodeValueShouldBe(nodeName, nodeValue);
	}
	
	@And("^The data of input object ['\"]([^'\"]*)['\"] and output object in database should be matched by those fields:$")
	public void compare_data_to_database(String objectName, DataTable compareFields) {
		Object inputObject = Serenity.getCurrentSession().get(objectName);
		
		Class<?> className = (Class<?>) Serenity.getCurrentSession().get(Constant.DATABASE_MODEL_CLASS_VARIABLE);
		
		int id = Helper.searchForEntityFromResponse(Constant.RESPONSE_ID_FIELD).asInt();
		
		Object outputObject = database.findObjectById(className, id);
		List<Map<String, String>> fields = compareFields.asMaps(String.class, String.class);
		commonSteps.compareDataToDatabase(inputObject, outputObject, fields, Constant.DATATABLE_INPUT_LABEL, Constant.DATATABLE_OUTPUT_LABEL);
	}
}

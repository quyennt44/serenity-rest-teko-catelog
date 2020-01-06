package vn.teko.test.specification.stepdefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import vn.teko.specification.steps.JiraSteps;


public class AddingTestCaseToJiraStepDefinitions {
	
	@Steps
	JiraSteps jiraSteps;


	@Given("^User has access to jira$")
	public void authenJiraConnection() {
		jiraSteps.authenJiraConnection();		
	}
	
		
	@When("^User adds features from file '(.*)' to folder '(.*)' on jira and adds to issue '(.*)'$")
	public void user_add_features_to_folder(String file, String folder, List<String> issue) {
		jiraSteps.addBDDTestcaseToFolder(folder, file, issue);
	}
			
	@Then("^The return code should be (\\d+)$")
	public void the_status_code_is(int statusCode) {
		jiraSteps.requestExecutedSuccesfully(statusCode);
	}
	
}

package vn.teko.specification.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import vn.teko.jira.Configuration;
import vn.teko.jira.FeatureFileToTestCase;
import vn.teko.jira.JiraTasks;
import vn.teko.jira.ScenarioContent;
import vn.teko.jira.TestCase;
import vn.teko.jira.TestManagementBuilder;
import vn.teko.jira.TestManagementEndPoints;


public class JiraSteps {
	private JiraTasks jiraTask = new JiraTasks();
		
	@Step
	public void authenJiraConnection() {
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName(Configuration.getJiraUserName());
		authScheme.setPassword(Configuration.getJiraUserPassword());
		RestAssured.authentication = authScheme;
	}
	
	@Step
	public void addBDDTestcaseToFolder(String folder, String featureFile, List<String> issueLink) {
		if(!jiraTask.checkIfFolderExisted(folder)) {
			jiraTask.createTestCaseFolder(folder);
		} else {
			//delete old testcase
			jiraTask.deleteTestCaseFromFolder(folder);
		}
		
		//Add testcase to folder
		TestManagementBuilder testManagementBuilder = new TestManagementBuilder();
		FeatureFileToTestCase readObject = new FeatureFileToTestCase();
		String content = readObject.readFeatureFile(featureFile);	
		
		List<ScenarioContent> scenarioContentList = readObject.buildScenarioContent(content);
		
		for (ScenarioContent scenarioContent : scenarioContentList) {

//			TestCaseInput testCase = testManagementBuilder.buildTestCaseBDD(folder, scenarioContent.getScenarioName(), scenarioContent.getStepDescription(), issueLink);
			TestCase testCase = testManagementBuilder.buildTestCaseBDD(folder, scenarioContent.getScenarioName(), scenarioContent.getStepDescription(), issueLink);
			
			SerenityRest.given()
	        .contentType(Configuration.CONTENT_TYPE)
	        .header(Configuration.HEADER_CONTENT_TYPE, Configuration.HEADER_CONTENT_TYPE_VALUE)
	        .body(testCase)
	        .when()
	        .post(TestManagementEndPoints.TEST_CASE_CREATION.getUrl());
		}
		
	}
	
		
	@Step
	public void requestExecutedSuccesfully(int statusCode) {
		assertThat(statusCode,equalTo(SerenityRest.then().extract().statusCode()));
	}	
}

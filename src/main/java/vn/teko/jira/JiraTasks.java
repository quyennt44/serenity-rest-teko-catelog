package vn.teko.jira;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.serenitybdd.rest.SerenityRest;


public class JiraTasks {
		
	public void deleteTestCaseFromFolder(String folder) {
		List<TestCase> testcaseList = getTestCaseFromFolder(folder);
		for (TestCase testCase : testcaseList) {
			SerenityRest.given().pathParam(TestManagementEndPoints.TEST_CASE_KEY_PATH_PARAM, testCase.getKey())
	        .contentType(Configuration.CONTENT_TYPE)
	        .header(Configuration.HEADER_CONTENT_TYPE, Configuration.HEADER_CONTENT_TYPE_VALUE)
	        .when()
	        .delete(TestManagementEndPoints.TEST_CASE_DELETE.getUrl());
		}
	}
	
	
	public List<TestCase> getTestCaseFromFolder(String folder) {
		String query = TestManagementEndPoints.SEARCH_TESTCASE_BY_FOLDER.replace("{folder}", folder);
		SerenityRest.given().queryParam(TestManagementEndPoints.SEARCH_QUERY_PARAM, query)
        .contentType(Configuration.CONTENT_TYPE)
        .header(Configuration.HEADER_CONTENT_TYPE, Configuration.HEADER_CONTENT_TYPE_VALUE)
        .when()
        .get(TestManagementEndPoints.TEST_CASE_SEARCH.getUrl());
				
		String response = SerenityRest.then().extract().response().asString();
		Type collectionType = new TypeToken<List<TestCase>>(){}.getType();
		@SuppressWarnings("unchecked")
		List<TestCase> testcaseList = (List<TestCase>) new Gson().fromJson( response , collectionType);
		
		return testcaseList;		
	}
	
	public boolean checkIfFolderExisted(String folder) {
		String query = TestManagementEndPoints.SEARCH_TESTCASE_BY_FOLDER.replace("{folder}", folder);
		SerenityRest.given().queryParam(TestManagementEndPoints.SEARCH_QUERY_PARAM, query)
        .contentType(Configuration.CONTENT_TYPE)
        .header(Configuration.HEADER_CONTENT_TYPE, Configuration.HEADER_CONTENT_TYPE_VALUE)
        .when()
        .get(TestManagementEndPoints.TEST_CASE_SEARCH.getUrl());
				
		int responseCode = SerenityRest.then().extract().statusCode();
		if(responseCode == TestManagementEndPoints.TEST_MANAGEMENT_SEARCH_SUCCESS)
			return true;
		else
			return false;		
	}	
	
	
	public void createTestCaseFolder(String folderName) {
		TestManagementBuilder testManagementBuilder = new TestManagementBuilder();
		TestCaseFolder testCaseFolderInput = testManagementBuilder.buildTestCaseFolder(folderName);
				
		SerenityRest.given()
        .contentType(Configuration.CONTENT_TYPE)
        .header(Configuration.HEADER_CONTENT_TYPE, Configuration.HEADER_CONTENT_TYPE_VALUE)
        .body(testCaseFolderInput)
        .when()
        .post(TestManagementEndPoints.TEST_FOLDER_CREATION.getUrl());
	}
}

package vn.teko.jira;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestManagementBuilder {
	public TestCase buildTestCaseBDD(String folder, String testcaseName, String testDescription, List<String> issueLinks) {
		Map<String, String> testScript = new HashMap<>();
		testScript.put("type", "BDD");
		testScript.put("text", testDescription);
		
		TestCase testCase = new TestCase();
		testCase.setProjectKey(Configuration.getProjectKey());
		testCase.setFolder(folder);
		testCase.setName(testcaseName);
		testCase.setIssueLinks(issueLinks);
		testCase.setTestScript(testScript);
		testCase.setStatus("Approved");
				
		return testCase;
	}
	
	public TestCaseFolder buildTestCaseFolder(String folderName) {
		TestCaseFolder testCaseFolderInput = new TestCaseFolder();
		testCaseFolderInput.setProjectKey(Configuration.getProjectKey());
		testCaseFolderInput.setType(TestManagementEndPoints.TEST_CASE_FOLDER);
		testCaseFolderInput.setName(folderName);
		
		return testCaseFolderInput;
	}	

}

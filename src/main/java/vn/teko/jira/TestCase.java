package vn.teko.jira;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TestCase {	
	private String key;
	
	private String projectKey;
	private String folder;
	private String name;	
	private String status;
	private List<String> issueLinks;
	private Map<String, String> testScript;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProjectKey() {
		return projectKey;
	}
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
	public List<String> getIssueLinks() {
		return issueLinks;
	}
	public void setIssueLinks(List<String> issueLinks) {
		this.issueLinks = issueLinks;
	}
	public Map<String, String> getTestScript() {
		return testScript;
	}
	public void setTestScript(Map<String, String> testScript) {
		this.testScript = testScript;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}

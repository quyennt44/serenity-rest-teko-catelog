package vn.teko.jira;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Configuration {	
	public static final String[] FEATURE_KEYWORDS = {"Scenario:", "Given", "When", "Then", "And", "But"};
	public static final String CONTENT_TYPE = "application/json";
	public static final String HEADER_CONTENT_TYPE = "Content-Type";
	public static final String HEADER_AUTHOR = "Authorization";
	public static final String HEADER_CONTENT_TYPE_VALUE = "application/json";
	
	private static EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
	
	
	public static String getBaseFeaturePath() {
		String value =  EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.feature.path");
		return value;		
	}
	
	public static String getApplicationEndPoint() {
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("application.url");
		return value;		
	}	
	
	public static String getJiraUserName() {
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("jira.user");
		return value;
	}
	
	public static String getJiraUserPassword() {
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("jira.password");		
		return value;
	}	
	
	public static String getJiraUrl() {
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("jira.url");		
		return value;
	}	
	
	public static String getProjectKey() {
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("project.key");		
		return value;
	}		
	
//	public static String getDatabaseName() {
//		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("database.name");	
//		return value;
//	}		
	
	public static String getUserToken(String user) {		
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(user);		
		return value;
	}
	
//	Database connection
	public static String getJdbcUrl() {		
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("jdbc.url");		
		return value;
	}	

	public static String getJdbcUser() {		
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("jdbc.user");		
		return value;
	}	
	
	public static String getJdbcPassword() {		
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("jdbc.password");		
		return value;
	}	
	
	public static String getJdbcDriver() {		
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("jdbc.driver");		
		return value;
	}	
	
	public static String getJdbcPersistenceUnit() {		
		String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("persistence.unit");		
		return value;
	}	
}

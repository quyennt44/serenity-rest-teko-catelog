package vn.teko.jira;

public enum TestManagementEndPoints {
    TEST_CASE_CREATION("/rest/atm/1.0/testcase"),
    TEST_CASE_SEARCH("/rest/atm/1.0/testcase/search"),
	TEST_CASE_DELETE("/rest/atm/1.0/testcase/{testCaseKey}"),
	TEST_CYCLE_CREATION("/rest/atm/1.0/testrun"),
	TEST_FOLDER_CREATION("/rest/atm/1.0/folder");
	
	public static final String TEST_CASE_KEY_PATH_PARAM = "testCaseKey";
	public static final String TEST_CASE_FOLDER = "TEST_CASE";
	

	private String baseUrl =	"https://jira.teko.vn";
    private final String url;
    public static final String SEARCH_QUERY_PARAM = "query";
    public static String SEARCH_TESTCASE_BY_FOLDER = "projectKey = " + "\"" + Configuration.getProjectKey() + "\"" + " AND folder = \"{folder}\"";
    
    public static final int TEST_MANAGEMENT_DELETE_SUCCESS = 204;
    public static final int TEST_MANAGEMENT_CREATE_SUCCESS = 201;
    public static final int TEST_MANAGEMENT_SEARCH_SUCCESS = 200;

    TestManagementEndPoints(String url) {
        this.url = baseUrl + url;
    }

    public String getUrl() {
        return url;
    }
}

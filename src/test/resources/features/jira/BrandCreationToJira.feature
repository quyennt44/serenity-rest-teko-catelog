@BrandCreationSpecification
Feature: Create test cases for adding new brand
    
Scenario: Add test case of new brand to jira
    Given User has access to jira    
    When User adds features from file '/brand/BrandCreation.feature' to folder '/API Test/Test' on jira and adds to issue 'SC-258'
    Then The return code should be 201
 
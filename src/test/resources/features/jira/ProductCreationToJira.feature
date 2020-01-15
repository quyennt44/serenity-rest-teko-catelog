@ProductCreationSpecification
Feature: Create test cases for adding new brand
    
Scenario: Add test case of new brand to jira
    Given User has access to jira    
    When User adds features from file '/product/ProductCreation.feature' to folder '/API Test/Product/Create' on jira and adds to issue 'SC-334'
    Then The return code should be 201
 
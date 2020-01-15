@ProductCreation
Feature: Adding new product

  Background: 
    When User creats a master category with status 1 as user 'user1' and return id as variable 'parentMasterCategoryId'
    And User creats a brand as user 'user1' and return id as variable 'brandId'


  Scenario: TC01 Create A Product With Valid Input
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The response should contain node 'statusCode'
    And The value of node 'statusCode' should be 'draft'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| name       | name        |

  Scenario Outline: TC02 Check Fields With Null Value
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field '<field_name>' to 'null'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as <http_code>
    And The response should contain node 'code'
    And The value of node 'code' should be '<code_value>'

    Examples: 
      | field_name          | http_code | code_value |
      | name                |       400 | INVALID    |
      | masterCategoryId    |       400 | INVALID    |
      | brandId             |       400 | INVALID    |
      | warrantyMonths      |       400 | INVALID    |
      | originCode          |       200 | SUCCESS    |
      | model               |       200 | SUCCESS    |
      | detailedDescription |       200 | SUCCESS    |
      | description         |       200 | SUCCESS    |

  Scenario Outline: TC03 Check String Fields With Empty Value
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field '<field_name>' to 'empty'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as <http_code>
    And The response should contain node 'code'
    And The value of node 'code' should be '<code_value>'

    Examples: 
      | field_name          | http_code | code_value |
      | name                |       400 | INVALID    |      
      | originCode          |       200 | SUCCESS    |
      | model               |       200 | SUCCESS    |
      | detailedDescription |       200 | SUCCESS    |
      | description         |       200 | SUCCESS    |
   
  Scenario Outline: TC04 Check missing field
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User removes field '<field_name>' from object 'product'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as <http_code>
    And The response should contain node 'code'
    And The value of node 'code' should be '<code_value>'

    Examples: 
      | field_name          | http_code | code_value |
      | name                |       400 | INVALID    |
      | masterCategoryId    |       400 | INVALID    |
      | brandId             |       400 | INVALID    |
      | warrantyMonths      |       400 | INVALID    |
      | originCode          |       200 | SUCCESS    |
      | model               |       200 | SUCCESS    |
      | unitId              |       400 | INVALID    |
      | unitPoId            |       200 | SUCCESS    |
      | detailedDescription |       200 | SUCCESS    |
      | description         |       200 | SUCCESS    |
      | type                |       400 | INVALID    |

  Scenario Outline: TC05 Check String Fields With Spaces Value Only
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field '<field_name>' to 'spaces_only'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as <http_code>
    And The response should contain node 'code'
    And The value of node 'code' should be '<code_value>'

    Examples: 
      | field_name          | http_code | code_value |
      | name                |       400 | INVALID    |
      | model               |       200 | SUCCESS    |
      | detailedDescription |       200 | SUCCESS    |
      | description         |       200 | SUCCESS    |
  

  Scenario Outline: TC06 Check String Fields Containing Leading Ending Spaces Value
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field '<field_name>' to 'leading_ending_spaces' in length 10
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |

    Examples: 
      | field_name          |
      | name                |
      | model               |
      | detailedDescription |
      | description         |
   

  Scenario Outline: TC07 Check Fields With Max Length
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field '<field_name>' to 'random_alphabet' in length <length>
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |

    Examples: 
      | field_name          | length |
      | name                |    265 |
      | model               |    255 |
      | detailedDescription |    10000|
      | description         |  500 |

  Scenario Outline: TC08 Check Fields Over Max Length
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field '<field_name>' to 'random_alphabet' in length <length>
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'code'
    And The value of node 'code' should be 'INVALID'

    Examples: 
      | field_name          | length |
      | name                |    266 |
      | model               |    256 |
      | detailedDescription |  10001 |
      | description         |    501 |

  Scenario Outline: TC09 Check Fields With Special Characters
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field '<field_name>' to 'contain_special_characters' in length 20
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |

    Examples: 
      | field_name          |
      | name                |
      | model               |
      | detailedDescription |
      | description         |

  Scenario Outline: TC10 Check Fields Containing Space Characters
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field '<field_name>' to 'contain_space_characters' in length 30
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |

    Examples: 
      | field_name          |
      | name                |
      | model               |
      | detailedDescription |
      | description         |

  Scenario Outline: TC100 Check Fields Containing Specical Unicode Characters
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field '<field_name>' to 'random_string_from_all_characters' in length 30
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as <http_code>
    And The response should contain node 'code'
    And The value of node 'code' should be '<code_value>'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |

    Examples: 
      | field_name          | http_code | code_value |
      | name                |       400 | INVALID    |
      | model               |       400 | INVALID    |
      | detailedDescription |       200 | success    |
      | description         |       200 | success    |
      


  Scenario Outline: TC101 Check Fields With Not-Existed Reference
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets reference database table
    And User gets max id from brand table then add some more value and store to a variable 'max_id'
    And User sets value of object 'product' for field '<field_name>' with variable 'max_id'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'code'
    And The value of node 'code' should be 'INVALID'

    Examples: 
      | field_name       |
      | brandId          |
      | masterCategoryId |
      | unitId           |
      | unitPoId         |

  Scenario: TC102 Check That Adding A Not-Exist Origin Code Is Not Allowed
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field 'originCode' to 'random_alphabet' in length 10
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'code'
    And The value of node 'code' should be 'INVALID'

  Scenario Outline: TC11 Check Adding A Duplicated Product
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User store a variable 'nameVar' with value as 'random_alphabet' in length 10
    And User sets value of object 'product' for field 'name' with variable 'nameVar'
    And User sends request to create object 'product' as user '<user_var1>' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field 'name' with variable 'nameVar'
    And User sends request to create object 'product' as user '<user_var2>' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'code'
    And The value of node 'code' should be 'INVALID'

    Examples: 
      | user_var1 | user_var2 |
      | user1     | user1     |
      | user1     | user2     |

  Scenario Outline: TC12 Check That Adding A Product With Duplicated In Uppercase And Lowercase Is Not Allowed
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User store a variable 'nameVar' with value as 'random_alphabet' in length 30
    And User changes value of variable 'nameVar' to 'upper_case'
    And User sets value of object 'product' for field 'name' with variable 'nameVar'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User changes value of variable 'nameVar' to 'lower_case'
    And User sets value of object 'product' for field 'name' with variable 'nameVar'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'code'
    And The value of node 'code' should be 'INVALID'

  Scenario Outline: TC13 Check That Adding A Product With Duplicated In Diacritic Mark And No Diacritic Mark Is OK
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User store a variable 'nameVar' with value as 'random_diacritic_mark' in length 100
    And User sets value of object 'product' for field '<field_name>' with variable 'nameVar'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User changes value of variable 'nameVar' to 'no_diacritic_mark'
    And User sets value of object 'product' for field '<field_name>' with variable 'nameVar'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'

    Examples: 
      | field_name |
      | name       |

  Scenario: TC14 Check That Adding A Product With Inactive Brand Is Not Allowed
    When User updates a brand to inactive as user 'user1' and return id as variable 'brandId'
    And User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field 'brandId' with variable 'brandId'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'code'
    And The value of node 'code' should be 'INVALID'

  Scenario: TC15 Check That Adding A Product With An Inactive Category That Is Last Node Is Not Allowed
    When User updates a master category to inactive as user 'user1' and return id as variable 'parentMasterCategoryId'
    And User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field 'masterCategoryId' with variable 'parentMasterCategoryId'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'code'
    And The value of node 'code' should be 'INVALID'

  Scenario Outline: TC16 Check That Adding A Product With An Active Category And All Children Are Inactive Is OK
    When User creats a master category with status 0 and parentId 'parentMasterCategoryId' as user 'user1' and return id as variable 'category_child1_inactive'
    And User creats a master category with status 0 and parentId 'parentMasterCategoryId' as user 'user1' and return id as variable 'category_child2_active'
    And User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field 'masterCategoryId' with variable '<categoryVariable>'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as <httpCode>
    And The response should contain node 'code'
    And The value of node 'code' should be '<codeValue>'

    Examples: 
      | categoryVariable         | httpCode | codeValue |
      | parentMasterCategoryId   |      200 | SUCCESS   |
      | category_child1_inactive |      400 | INVALID   |

  
  Scenario Outline: TC17 Check That Adding A Product With An Active Category And All Children Are Active Is Not Allowed
    When User creats a master category with status 1 and parentId 'parentMasterCategoryId' as user 'user1' and return id as variable 'category_child1_active'
    And User creats a master category with status 0 and parentId 'parentMasterCategoryId' as user 'user1' and return id as variable 'category_child2_inactive'
    And User creats a master category with status 1 and parentId 'category_child2_active' as user 'user1' and return id as variable 'category_childOf2_active'
    And User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field 'masterCategoryId' with variable '<categoryVariable>'
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as <httpCode>
    And The response should contain node 'code'
    And The value of node 'code' should be '<codeValue>'

    Examples: 
      | categoryVariable         | httpCode | codeValue |
      | parentMasterCategoryId   |      400 | INVALID   |
      | category_child1_inactive |      200 | SUCCESS   |
      | category_child2_inactive |      400 | INVALID   |
      | category_childOf2_active |      200 | SUCCESS   |

  Scenario Outline: TC18 Check warrantyMonths limit
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets value of object 'product' for field 'warrantyMonths' to <warrantyMonthsValue>
    And User sends request to create object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as <httpCode>
    And The response should contain node 'code'
    And The value of node 'code' should be '<codeValue>'

    Examples: 
      | warrantyMonthsValue | httpCode | codeValue |
      |                   0 |      200 | SUCCESS   |
      |                9999 |      200 | SUCCESS   |
      |                  -1 |      400 | INVALID   |
      |               10000 |      400 | INVALID   |

      Scenario Outline: TC19 Check type field
#	  When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'product' for field 'type' to <typeValue>
    #And User sends request to create object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as <httpCode>
    #And The response should contain node 'code'
    #And The value of node 'code' should be '<codeValue>'    
    #Examples: 
      #| typeValue |httpCode|codeValue|
      #|"true"|200|SUCCESS|
      #|"false"|200|SUCCESS|
      #|"abc"|400|INVALID|
      #|0|400|INVALID|
      #|1|400|INVALID|
      #|true|400|INVALID|
      #|false|400|INVALID|          

@ProductCreation
Feature: Adding new product 

  Scenario: TC01 Create A Product With Valid Input
    When User initializes an object and stores as variable 'product'
    And User sets request url as variable 'url'
    And User sets database entity
    And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
      #| parent_id  | parent_id   |     
      #| is_active  | is_active   |

  #Scenario Outline: TC02 Check Fields With Null Value
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User set value of object 'product' for field '<field_name>' to 'null'
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as <http_code>
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'code_value'
#
    #Examples: 
      #| field_name |http_code|code_value|
      #| name       |400|INVALID|
      #| masterCategoryCode|400|INVALID|
      #|brandCode|400|INVALID|
      #|warrantyMonths|400|INVALID|
      #|originCode|200|SUCCESS|
      #|model|200|SUCCESS|
      #|highlight|200|SUCCESS|
      #|description|200|SUCCESS|
#
  #Scenario Outline: TC03 Check String Fields With Empty Value
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User set value of object 'product' for field '<field_name>' to 'empty'
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as <httpcode>
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'code_value'
#
    #Examples: 
      #| field_name |http_code|code_value|
      #| name       |400|INVALID|
      #| masterCategoryCode|400|INVALID|
      #|brandCode|400|INVALID|
      #|warrantyMonths|400|INVALID|
      #|originCode|200|SUCCESS|
      #|model|200|SUCCESS|
      #|highlight|200|SUCCESS|
      #|description|200|SUCCESS|
      #
      #
  #Scenario Outline: TC04 Check missing field
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User removes field '<field_name>' from object 'product'
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as <httpcode>
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'code_value'
#
    #Examples: 
      #| field_name |httpcode|code_value|
      #| name       |400|INVALID|
      #| masterCategoryCode       |400|INVALID|
      #| brandCode      |400|INVALID|
      #| warrantyMonths  |400|INVALID|
      #| originCode  |200|SUCCESS|
      #| model  |200|SUCCESS|
      #| unitId  |200|SUCCESS|
      #| unitPoId  |200|SUCCESS|
      #| highlight  |200|SUCCESS|
      #| description  |200|SUCCESS|
     #
      #
#
  #Scenario Outline: TC05 Check String Fields With Spaces Value Only
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User set value of object 'product' for field '<field_name>' to 'spaces_only'
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as <httpcode>
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'code_value'
#
    #Examples: 
      #| field_name |httpcode|code_value|
      #| name       |400|INVALID|
      #| masterCategoryCode       |400|INVALID|
      #| brandCode      |400|INVALID|
      #| warrantyMonths  |400|INVALID|
      #| originCode  |200|SUCCESS|
      #| model  |200|SUCCESS|
      #| unitId  |200|SUCCESS|
      #| unitPoId  |200|SUCCESS|
      #| highlight  |200|SUCCESS|
      #| description  |200|SUCCESS|
     #
#
  #Scenario Outline: TC06 Check String Fields Containing Leading Ending Spaces Value
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User set value of object 'product' for field '<field_name>' to 'leading_ending_spaces' in length 10
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |      
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |
#
    #Examples: 
      #| field_name |
      #| name       |
      #| masterCategoryCode|
      #| brandCode      |
      #| warrantyMonths  |
      #| originCode  |
      #| model  |
      #| unitId  |
      #| unitPoId  |
      #| highlight  |
      #| description  |
     #
#
  #Scenario Outline: TC07 Check Fields With Max Length
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User set value of object 'product' for field '<field_name>' to 'random_string' in length <length>
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |      
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |
#
    #Examples: 
      #| field_name |length|
      #| name       |265|    
      #| model  |255| 
      #| highlight  |500|
      #| description  |10000|
    #
#
  #Scenario Outline: TC08 Check Fields Over Max Length
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User set value of object 'product' for field '<field_name>' to 'random_string' in length <length>
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'INVALID'
#
    #Examples: 
      #| field_name |length|
      #| name       |266|    
      #| model  |256| 
      #| highlight  |501|
      #| description  |10001|
#
  #Scenario Outline: TC09 Check Fields With Special Characters
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User set value of object 'product' for field '<field_name>' to 'contain_special_characters' in length 20
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |      
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |
#
    #Examples: 
      #| field_name |
      #| name       |
      #| model  |
      #| highlight  |
      #| description  |
#
  #Scenario Outline: TC10 Check Fields Containing Space Characters
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User set value of object 'product' for field '<field_name>' to 'contain_space_characters' in length 30
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'product' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |      
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |
#
    #Examples: 
      #| field_name |
      #| name       |
      #| model  |
      #| highlight  |
      #| description  |
#
  #Scenario Outline: TC101 Check Fields With Not-Existed Reference
    #Examples: 
      #| field_name |
   #		|brandCode|
   #		|masterCategoryCode|
   #		|unitId|
   #		|originCode|
   #		|unitPoId|
   #		
#
  #Scenario Outline: TC11 Check Adding A Duplicated Product
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User store a variable 'nameVar' with value as 'random_string' in length 10
    #And User set value of object 'product' for field 'name' with variable 'nameVar'
    #And User sends request to 'create' object 'product' as user '<user_var1>' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User set value of object 'product' for field 'name' with variable 'nameVar'
    #And User sends request to 'create' object 'product' as user '<user_var2>' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'INVALID'
    #Examples: 
    #|user_var1|user_var2|
    #|user1|user1|
    #|user1|user2|
#
#
  #Scenario Outline: TC12 Check That Adding A Product With Duplicated In Uppercase And Lowercase Is Not Allowed
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User store a variable 'nameVar' with value as 'random_string' in length 30
    #And User changes value of variable 'nameVar' to 'upper_case'
    #And User set value of object 'product' for field 'name' with variable 'nameVar'
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User changes value of variable 'nameVar' to 'lower_case'
    #And User set value of object 'product' for field 'name' with variable 'nameVar'
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'INVALID'
#
#
  #Scenario Outline: TC13 Check That Adding A Product With Duplicated In Diacritic Mark And No Diacritic Mark Is Not OK
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User store a variable 'nameVar' with value as 'random_diacritic_mark' in length 100
    #And User set value of object 'product' for field '<field_name>' with variable 'nameVar'
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #When User initializes an object and stores as variable 'product'
    #And User sets request url as variable 'url'
    #And User changes value of variable 'nameVar' to 'no_diacritic_mark'
    #And User set value of object 'product' for field '<field_name>' with variable 'nameVar'
    #And User sends request to 'create' object 'product' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'INVALID'
#
    #Examples: 
      #| field_name |
      #| name       |
#
#	
#	Scenario: TC14 Check That Adding A Product With Inactive BrandCode Is Not Allowed
#
#	Scenario: TC15 Check That Adding A Product With An Inactive Category That Is Last Node Is Not Allowed
#	
#	Scenario: TC16 Check That Adding A Product With An Active Category And All Children Are Inactive Is OK
#	
#	Scenario: TC17 Check That Adding A Product With An Active Category And All Children Are Active Is Not Allowed
#	
#	Scenario: TC18 Check warrantyMonths
#	
#	
	
	
    
    
    
    
    
    
    
    
  
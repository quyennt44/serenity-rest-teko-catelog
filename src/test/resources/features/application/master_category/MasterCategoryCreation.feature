@MasterCategoryCreation
Feature: Create new test case for adding master category

  Scenario: TC01 Create A Master Category With Valid Input
    When User initializes an object and stores as variable 'master_category'
    And User sets request url as variable 'url'
    And User sets database entity
    And User sends request to create object 'master_category' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'master_category' and output object in database should be matched by those fields:
      | inputField | outputField |
      | code       | code        |
      | name       | name        |
      | parent_id  | parent_id   |     
      | is_active  | is_active   |
#
  #Scenario Outline: TC02 Check Fields With Null Value
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field '<field_name>' to 'null'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name |
      #| name       |
      #| code       |
#
  #Scenario Outline: TC03 Check String Fields With Empty Value
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field '<field_name>' to 'empty'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as <httpcode>
    #And The response should contain node '<node>'
#
    #Examples: 
      #| field_name |httpcode|node|
      #| name       |400|errors|
      #| code       |400|errors|
      #| image      |200|code|
#
  #Scenario Outline: TC04 Check missing field
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User removes field '<field_name>' from object 'master_category'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as <httpcode>
    #And The response should contain node '<node>'
#
    #Examples: 
      #| field_name |httpcode|node|
      #| name       |400|errors|
      #| code       |400|errors|
      #| image      |200|code|
      #| parent_id  |400|errors|
      #| is_active  |400|errors|
#
  #Scenario Outline: TC05 Check String Fields With Spaces Value Only
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field '<field_name>' to 'spaces_only'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name |
      #| name       |
      #| code       |
     #
#
  #Scenario Outline: TC06 Check String Fields Containing Leading Ending Spaces Value
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field '<field_name>' to 'leading_ending_spaces' in length <length>
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'master_category' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |      
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |
#
    #Examples: 
      #| field_name | length |
      #| name       |     10 |
      #| code       |     10 |
#
  #Scenario Outline: TC07 Check Fields With Max Length
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field '<field_name>' to 'random_alphabet' in length <length>
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'master_category' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |      
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |
#
    #Examples: 
      #| field_name | length |
      #| name       |    255 |
      #| code       |    255 |
#
  #Scenario Outline: TC08 Check Fields Over Max Length
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field '<field_name>' to 'random_alphabet' in length <length>
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name | length |
      #| name       |    256 |
      #| code       |    256 |
#
  #Scenario Outline: TC09 Check Fields With Special Characters
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field '<field_name>' to 'contain_special_characters' in length <length>
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'master_category' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |      
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |
#
    #Examples: 
      #| field_name | length |
      #| name       |     10 |
      #| code       |     10 |
#
  #Scenario Outline: TC10 Check Fields Containing Space Characters
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field '<field_name>' to 'contain_space_characters' in length <length>
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'master_category' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |      
      #| parent_id  | parent_id   |
      #| is_active  | is_active   |
#
    #Examples: 
      #| field_name | length |
      #| name       |     10 |
      #| code       |     10 |
#
  #Scenario Outline: TC11 Check Adding A Duplicated Master Category
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User store a variable 'nameVar' with value as 'random_alphabet' in length 10
    #And User sets value of object 'master_category' for field '<field_name>' with variable 'nameVar'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets value of object 'master_category' for field '<field_name>' with variable 'nameVar'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name |
      #| name       |
      #| code       |
#
  #Scenario Outline: TC12 Check That Adding A Master Category With Duplicated In Uppercase And Lowercase Is Not Allowed
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User store a variable 'nameVar' with value as 'random_alphabet' in length 30
    #And User changes value of variable 'nameVar' to 'upper_case'
    #And User sets value of object 'master_category' for field '<field_name>' with variable 'nameVar'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User changes value of variable 'nameVar' to 'lower_case'
    #And User sets value of object 'master_category' for field '<field_name>' with variable 'nameVar'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name |
      #| name       |
      #| code       |
#
  #Scenario Outline: TC13 Check That Adding A Master Category With Duplicated In Diacritic Mark And No Diacritic Mark Is Not OK
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User store a variable 'nameVar' with value as 'random_diacritic_mark' in length 100
    #And User sets value of object 'master_category' for field '<field_name>' with variable 'nameVar'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User changes value of variable 'nameVar' to 'no_diacritic_mark'
    #And User sets value of object 'master_category' for field '<field_name>' with variable 'nameVar'
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name |
      #| name       |
      #| code       |
#
#
  #Scenario Outline: TC14 Check That Adding A Master Category With Invalid Status Is Not OK
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field 'is_active' to <is_active>
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| is_active |
      #|         3 |
      #|        -1 |
           #
  #Scenario: TC15 Check That Adding A Master Category With Not-Existed Parent Id Is Not OK
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets reference database table
    #And User gets max id from master category then add some more value and store to a variable 'max_id'
    #And User sets value of object 'master_category' for field 'parent_id' with variable 'max_id'    
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
    #
    #
  #Scenario: TC16 Check That Adding A Master Category As Children For Active Parent Is OK
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field 'is_active' to 1
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #And User gets id from the response and store as varialbe 'id'
    #And User initializes an object and stores as variable 'master_category'
    #And User sets value of object 'master_category' for field 'parent_id' with variable 'id'   
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'master_category' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
      #| parent_id  | parent_id   |     
      #| is_active  | is_active   | 
      #
      #
  #Scenario: TC17 Check That Adding A Master Category As Children For Intive Parent Is Not Allowed
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field 'is_active' to 0
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #And User gets id from the response and store as varialbe 'id'
    #And User initializes an object and stores as variable 'master_category'
    #And User sets value of object 'master_category' for field 'parent_id' with variable 'id'   
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'    
    #
  #Scenario Outline: TC18 Check That Adding Duplicate Master Category Name As Children For Different Parent Is Not Allowed
    # The first parent master category
    #When User initializes an object and stores as variable 'master_category'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'master_category' for field 'is_active' to 1
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #And User gets id from the response and store as varialbe 'id1'
    # The second parent master category
 #		And User initializes an object and stores as variable 'master_category'
 #		And User sets value of object 'master_category' for field 'is_active' to 1
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #And User gets id from the response and store as varialbe 'id2'
    #
    # Add child to first parent
    #And User initializes an object and stores as variable 'master_category'
    #And User store a variable 'stringVar' with value as 'random_alphabet' in length 10
    #And User sets value of object 'master_category' for field '<field_name>' with variable 'stringVar'
    #And User sets value of object 'master_category' for field 'parent_id' with variable 'id1'   
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'      
    #
    # Add child with same name/code to second parent
    #And User initializes an object and stores as variable 'master_category'    
    #And User sets value of object 'master_category' for field '<field_name>' with variable 'stringVar'
    #And User sets value of object 'master_category' for field 'parent_id' with variable 'id1'   
    #And User sends request to create object 'master_category' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'       
    #
    #Examples: 
      #| field_name |
      #|        name |
      #|        code |
    #
    #
    
    
    
    
    
    
    
    

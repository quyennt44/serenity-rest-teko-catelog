@BrandUpdate
Feature: Updating existing brands
	Background: Create A Brand
  When User initializes an object and stores as variable 'brand'
  And User sets request url as variable 'url'
  And User sets database entity
  And User sends request to create object 'brand' as user 'user1' with url 'url'
  
  #Scenario: TC01 Update A Brand With Valid Input
  #When User initializes an object and stores as variable 'brand'  
  #And User sends request to update object 'brand' as user 'user1' with url 'url'
  #Then The response shows hppt code as 200
  #And The response should contain node 'code'
  #And The value of node 'code' should be 'success'
  #And The data of input object 'brand' and output object in database should be matched by those fields:
  #| inputField | outputField |
  #| code       | code        |
  #| name       | name        |
  #| doc_request| doc_request |
  
  Scenario Outline: TC02 Check Fields With Null Value
    And User sets value of object 'brand' for field '<field_name>' to 'null'    
    And User sets update url as variable 'update_url'
    And User sends request to update object 'brand' as user 'user1' with url 'update_url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'

    Examples: 
      | field_name |
      | name       |
      
#
  #Scenario Outline: TC03 Check String Fields With Empty Value
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'brand' for field '<field_name>' to 'empty'
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as <httpcode>
    #And The response should contain node '<node>'
#
    #Examples: 
      #| field_name | httpcode | node   |
      #| name       |      400 | errors |
      #| code       |      400 | errors |
      #| logo       |      200 | code   |
#
  #Scenario Outline: TC04 Check missing field
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User removes field '<field_name>' from object 'brand'
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as <httpcode>
    #And The response should contain node '<node>'
#
    #Examples: 
      #| field_name | httpcode | node   |
      #| name       |      400 | errors |
      #| code       |      400 | errors |
      #| logo       |      200 | code   |
  #
  #Scenario Outline: TC05 Check String Fields With Spaces Value Only
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'brand' for field '<field_name>' to 'spaces_only'
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as <httpcode>
    #And The response should contain node '<node>'
#
    #Examples: 
      #| field_name | httpcode | node   |
      #| name       |      400 | errors |
      #| code       |      400 | errors |
      #| logo       |      200 | code   |
#
  #Scenario Outline: TC06 Check String Fields Containing Leading Ending Spaces Value
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'brand' for field '<field_name>' to 'leading_ending_spaces' in length <length>
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'brand' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
  #
    #Examples: 
      #| field_name | length |
      #| name       |     10 |
      #| code       |     10 |
#
  #Scenario Outline: TC07 Check Fields With Max Length
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'brand' for field '<field_name>' to 'random_alphabet' in length <length>
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'brand' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
  #
    #Examples: 
      #| field_name | length |
      #| name       |    255 |
      #| code       |    255 |
#
  #Scenario Outline: TC08 Check Fields Over Max Length
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'brand' for field '<field_name>' to 'random_alphabet' in length <length>
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name | length |
      #| name       |    256 |
      #| code       |    256 |
#
  #Scenario Outline: TC09 Check Fields With Special Characters
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'brand' for field '<field_name>' to 'contain_special_characters' in length <length>
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'brand' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |
   #
    #Examples: 
      #| field_name | length |
      #| name       |     10 |
      #| code       |     10 |
      #
  #Scenario Outline: TC10 Check Fields Containing Space Characters
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'brand' for field '<field_name>' to 'contain_space_characters' in length <length>
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of input object 'brand' and output object in database should be matched by those fields:
      #| inputField | outputField |
      #| code       | code        |
      #| name       | name        |      
     #
    #Examples: 
      #| field_name | length |
      #| name       |     10 |
      #| code       |     10 |
#
  #Scenario Outline: TC11 Check Adding A Duplicated Brand
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User store a variable 'nameVar' with value as 'random_alphabet' in length 10
    #And User sets value of object 'brand' for field '<field_name>' with variable 'nameVar'
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets value of object 'brand' for field '<field_name>' with variable 'nameVar'
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name |
      #| name       |
      #| code       |
#
  #Scenario Outline: TC12 Check That Adding A Brand With Duplicated In Uppercase And Lowercase Is Not Allowed
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User store a variable 'nameVar' with value as 'random_alphabet' in length 30
    #And User changes value of variable 'nameVar' to 'upper_case'
    #And User sets value of object 'brand' for field '<field_name>' with variable 'nameVar'
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User changes value of variable 'nameVar' to 'lower_case'
    #And User sets value of object 'brand' for field '<field_name>' with variable 'nameVar'
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name |
      #| name       |
      #| code       |
#
  #Scenario Outline: TC13 Check That Adding A Brand With Duplicated In Diacritic Mark And No Diacritic Mark Is Not OK
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User store a variable 'nameVar' with value as 'random_diacritic_mark' in length 100
    #And User sets value of object 'brand' for field '<field_name>' with variable 'nameVar'
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User changes value of variable 'nameVar' to 'no_diacritic_mark'
    #And User sets value of object 'brand' for field '<field_name>' with variable 'nameVar'
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| field_name |
      #| name       |
      #| code       |
#
#
  #Scenario Outline: TC14 Check That Adding A Brand With Invalid Status Is Not OK
    #When User initializes an object and stores as variable 'brand'
    #And User sets request url as variable 'url'
    #And User sets database entity
    #And User sets value of object 'brand' for field 'is_active' to <is_active>
    #And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response should contain node 'errors'
#
    #Examples: 
      #| is_active |
      #|         3 |
      #|        -1 |
           #
     #
  #Scenario Outline: TC15 Check Brand Code Containing Dash
    #When User sets dash '<dash>' in code at the position '<position>'
    #And User sets database entity
#		And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as <http_code>
    #And The response shows content as '<response_content>'
#
    #Examples: 
      #| position | dash              | http_code | response_content |
      #| middel   | Sed-ut-perspici   |       200 | success          |
      #| leading  | -Sedutperspici    |       400 | invalid          |
      #| after    | Sedutperspici-    |       400 | invalid          |
      #| middel   | Sed--ut--perspici |       200 | success          |
      #| leading  | --Sedutperspici   |       400 | invalid          |
      #| after    | Sedutperspici--   |       400 | invalid          |
#
  #Scenario: TC16 Check That Adding A Brand With Uppercase Code Is Not Allowed
    #When User store a variable 'nameVar' with value as 'random_alphabet' in length 30
    #And User changes value of variable 'nameVar' to 'upper_case'
    #And User sets value for field 'code' with variable 'nameVar'
    #And User sets database entity
#		And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as 400
    #And The response shows content as 'invalid'
#
  #Scenario: TC17 Check That Adding A Brand With Code Containing Diacritic Mark Is Not Allowed
    #When User store a variable 'nameVar' with value as 'random_diacritic_mark' in length 10
    #And User sets value for field 'code' with variable 'nameVar'
    #And User sets database entity
#		And User sends request to update object 'brand' as user 'user1' with url 'url'   
    #Then The response shows hppt code as 400
    #And The response shows content as 'invalid'
#
  #Scenario Outline: TC18 Check doc_request field
    #When User sets value for field 'doc_request' to '<doc_request_value>'
    #And User sets database entity
#		And User sends request to update object 'brand' as user 'user1' with url 'url'
    #Then The response shows hppt code as <http_code>
    #And The response shows content as '<response_content>'
#
    #Examples: 
      #| doc_request_value | http_code | response_content |
      #| true              |       200 | success          |
      #| false             |       200 | success          |
      #|                 1 |       400 | invalid          |
      #|                 0 |       400 | invalid          |
      #| abc               |       400 | invalid          |
#
  #Scenario: TC19 Check That Adding Many Brands Will Not Add Duplicated Internal Codes
    #When User sets value for field 'name' to 'random_alphabet' in length 30
    #And User sends request to update brand as user 'user1'
    #And User repeats action update for 10 times as user 'user1'
    #Then The response shows hppt code as 200
    #And The response shows content as 'success'
    #And The list of brands have no duplicated internal code
#
#
  #Scenario Outline: TC20 Check logo image field
    #When User sets value for field 'name' to 'random_alphabet' in length 30
    #Given User selects image type as '<image_type>' and in size width <width> and height <height>
    #And User sets database entity
#		And User sends request to update object 'brand' as user 'user1' with url 'url'  
    #Then The response shows hppt code as <http_code>
    #And The response shows content as '<response_content>'
#
    #Examples: 
      #| image_type | width | height | http_code | response_content |
      #| png        |   500 |    500 |       200 | success          |
      #| png        |   300 |    300 |       200 | success          |
      #| png        |   430 |    430 |       200 | success          |
      #| png        |   209 |    209 |       400 | INVALID          |
      #| png        |   501 |    501 |       400 | INVALID          |
      #| png        |   500 |    300 |       400 | INVALID          |
      #| jpg        |   400 |    400 |       400 | INVALID          |
      #| string     |     0 |      0 |       400 | ERROR            |

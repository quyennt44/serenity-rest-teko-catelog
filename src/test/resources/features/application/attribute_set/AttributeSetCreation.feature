@AttributeSetCreation
Feature: Adding new attribute set

  Scenario: TC01 Create A Attribute Set With Valid Input
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'attribute_set' and output object in database should be matched by those fields:
      | inputField | outputField |     
      | name       | name        |
     

  Scenario: TC02 Check Fields With Null Value
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'attribute_set' for field 'name' to 'null'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'


  Scenario: TC03 Check String Fields With Empty Value
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'attribute_set' for field 'name' to 'empty'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'

  Scenario: TC04 Check missing field
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User removes field 'name' from object 'attribute_set'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'


  Scenario: TC05 Check String Fields With Spaces Value Only
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'attribute_set' for field 'name' to 'spaces_only'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'
     

  Scenario: TC06 Check String Fields Containing Leading Ending Spaces Value
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'attribute_set' for field 'name' to 'leading_ending_spaces' in length 15
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'attribute_set' and output object in database should be matched by those fields:
      | inputField | outputField |     
      | name       | name        |      
   

  Scenario: TC07 Check Fields With Max Length
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'attribute_set' for field 'name' to 'random_string' in length 255
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'attribute_set' and output object in database should be matched by those fields:
      | inputField | outputField |  
      | name       | name        |      
     

  Scenario: TC08 Check Fields Over Max Length
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'attribute_set' for field 'name' to 'random_string' in length 256
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'


  Scenario: TC09 Check Fields With Special Characters
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'attribute_set' for field 'name' to 'contain_special_characters' in length 10
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'attribute_set' and output object in database should be matched by those fields:
      | inputField | outputField |     
      | name       | name        |      
     

  Scenario: TC10 Check Fields Containing Space Characters
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'attribute_set' for field 'name' to 'contain_space_characters' in length 20
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'attribute_set' and output object in database should be matched by those fields:
      | inputField | outputField |     
      | name       | name        |      
     

  Scenario: TC11 Check Adding A Duplicated Attribute Set
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User store a variable 'nameVar' with value as 'random_string' in length 10
    And User set value of object 'attribute_set' for field 'name' with variable 'nameVar'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User set value of object 'attribute_set' for field 'name' with variable 'nameVar'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'


  Scenario: TC12 Check That Adding A Attribute Set With Duplicated In Uppercase And Lowercase Is Not Allowed
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User store a variable 'nameVar' with value as 'random_string' in length 30
    And User changes value of variable 'nameVar' to 'upper_case'
    And User set value of object 'attribute_set' for field 'name' with variable 'nameVar'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User changes value of variable 'nameVar' to 'lower_case'
    And User set value of object 'attribute_set' for field 'name' with variable 'nameVar'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'


  Scenario: TC13 Check That Adding A Attribute Set With Duplicated In Diacritic Mark And No Diacritic Mark Is Not OK
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User sets database entity
    And User store a variable 'nameVar' with value as 'random_diacritic_mark' in length 100
    And User set value of object 'attribute_set' for field 'name' with variable 'nameVar'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    When User initializes an object and stores as variable 'attribute_set'
    And User sets request url as variable 'url'
    And User changes value of variable 'nameVar' to 'no_diacritic_mark'
    And User set value of object 'attribute_set' for field 'name' with variable 'nameVar'
    And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'
    
  #Scenario: TC14 Check That Attribute Set Code Is Converted Correctly From Attribute Set Name 
    #code: Tự động sinh theo tên thuộc tính sau khi đã bỏ dấu, chuyển ký tự viết hoa về chữ viết thường và thay khoảng trắng thành ký tự '_'.
    #When User generates attribute set with name 'attribute_set'
    #And User sets request url as variable 'url'
    #And User sets database entity    
    #And User sends request to 'create' object 'attribute_set' as user 'user1' with url 'url'
    #Then The response shows hppt code as 200
    #And The response should contain node 'code'
    #And The value of node 'code' should be 'success'
    #And The data of attribute set code should be converted correctly
    
    
    
    
    
    
    
    
    

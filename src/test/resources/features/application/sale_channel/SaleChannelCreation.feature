@SaleChannelCreation
Feature: Adding new sale channel

  Scenario: TC01 Create A Sale Channel With Valid Input
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'sale_channel' and output object in database should be matched by those fields:
      | inputField | outputField |
      | code       | code        |
      | name       | name        |
      | type       | type        |
      | seller_id  | seller_id   |
      | is_active  | is_active   |

  Scenario Outline: TC02 Check Fields With Null Value
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User set value of object 'sale_channel' for field '<field_name>' to 'null'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'

    Examples: 
      | field_name |
      | name       |
      | code       |
      | type       |
      | seller_id  |
      | is_active  |

  Scenario Outline: TC03 Check String Fields With Empty Value
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User set value of object 'sale_channel' for field '<field_name>' to 'empty'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

    Examples: 
      | field_name |
      | name       |
      | code       |
      | type       |

  Scenario Outline: TC04 Check missing field
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User removes field '<field_name>' from object 'sale_channel'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'errors'

    Examples: 
      | field_name |
      | name       |
      | code       |
      | type       |
      | seller_id  |
      | is_active  |

  Scenario Outline: TC05 Check String Fields With Spaces Value Only
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User set value of object 'sale_channel' for field '<field_name>' to 'spaces_only'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

    Examples: 
      | field_name |
      | name       |
      | code       |
      | type       |

  Scenario Outline: TC06 Check String Fields Containing Leading Ending Spaces Value
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'sale_channel' for field '<field_name>' to 'leading_ending_spaces' in length <length>
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'sale_channel' and output object in database should be matched by those fields:
      | inputField | outputField |
      | code       | code        |
      | name       | name        |
      | type       | type        |
      | seller_id  | seller_id   |
      | is_active  | is_active   |

    Examples: 
      | field_name | length |
      | name       |     10 |
      | code       |     10 |

  Scenario Outline: TC07 Check Fields With Max Length
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'sale_channel' for field '<field_name>' to 'random_string' in length <length>
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'sale_channel' and output object in database should be matched by those fields:
      | inputField | outputField |
      | code       | code        |
      | name       | name        |
      | type       | type        |
      | seller_id  | seller_id   |
      | is_active  | is_active   |

    Examples: 
      | field_name | length |
      | name       |    255 |
      | code       |    255 |

  Scenario Outline: TC08 Check Fields Over Max Length
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User set value of object 'sale_channel' for field '<field_name>' to 'random_string' in length <length>
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

    Examples: 
      | field_name | length |
      | name       |    256 |
      | code       |    256 |

  Scenario Outline: TC09 Check Fields With Special Characters
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'sale_channel' for field '<field_name>' to 'contain_special_characters' in length <length>
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'sale_channel' and output object in database should be matched by those fields:
      | inputField | outputField |
      | code       | code        |
      | name       | name        |
      | type       | type        |
      | seller_id  | seller_id   |
      | is_active  | is_active   |

    Examples: 
      | field_name | length |
      | name       |     10 |
      | code       |     10 |

  Scenario Outline: TC10 Check Fields Containing Space Characters
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'sale_channel' for field '<field_name>' to 'contain_space_characters' in length <length>
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    And The data of input object 'sale_channel' and output object in database should be matched by those fields:
      | inputField | outputField |
      | code       | code        |
      | name       | name        |
      | type       | type        |
      | seller_id  | seller_id   |
      | is_active  | is_active   |

    Examples: 
      | field_name | length |
      | name       |     10 |
      | code       |     10 |

  Scenario Outline: TC11 Check Adding A Duplicated Sale Channel
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User store a variable 'nameVar' with value as 'random_string' in length 10
    And User set value of object 'sale_channel' for field '<field_name>' with variable 'nameVar'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User set value of object 'sale_channel' for field '<field_name>' with variable 'nameVar'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

    Examples: 
      | field_name |
      | name       |
      | code       |

  Scenario Outline: TC12 Check That Adding A Sale Channel With Duplicated In Uppercase And Lowercase Is Not Allowed
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User store a variable 'nameVar' with value as 'random_string' in length 30
    And User changes value of variable 'nameVar' to 'upper_case'
    And User set value of object 'sale_channel' for field '<field_name>' with variable 'nameVar'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User changes value of variable 'nameVar' to 'lower_case'
    And User set value of object 'sale_channel' for field '<field_name>' with variable 'nameVar'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

    Examples: 
      | field_name |
      | name       |
      | code       |

  Scenario Outline: TC13 Check That Adding A Sale Channel With Duplicated In Diacritic Mark And No Diacritic Mark Is Not OK
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User store a variable 'nameVar' with value as 'random_diacritic_mark' in length 100
    And User set value of object 'sale_channel' for field '<field_name>' with variable 'nameVar'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 200
    And The response should contain node 'code'
    And The value of node 'code' should be 'success'
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User changes value of variable 'nameVar' to 'no_diacritic_mark'
    And User set value of object 'sale_channel' for field '<field_name>' with variable 'nameVar'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

    Examples: 
      | field_name |
      | name       |
      | code       |

  Scenario: TC14 Check That Adding A Sale Channel With Not-Existed Type Is Not OK
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'sale_channel' for field 'type' to 'random_string' in length 5
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

  Scenario: TC15 Check That Adding A Sale Channel With Type In UpperCase Is Not OK
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User gets random sale channel type and store as variable 'sale_type'
    And User changes value of variable 'sale_type' to 'upper_case'
    And User set value of object 'sale_channel' for field 'type' with variable 'sale_type'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

  Scenario: TC16 Check That Adding A Sale Channel With Not-Existed Seller ID Is Not OK
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User gets max id from seller id then add some more value and store to a variable 'max_id'
    And User set value of object 'sale_channel' for field 'seller_id' with variable 'max_id'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

  Scenario: TC17 Check That Adding A Sale Channel With Inactive Seller ID Is Not OK
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User gets random seller id and store as variable 'seller_id'
    And User sets seller id 'seller_id' to status inactive
    And User set value of object 'sale_channel' for field 'seller_id' with variable 'seller_id'
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'
    And User sets seller id 'seller_id' to status active

  Scenario Outline: TC18 Check That Adding A Sale Channel With Invalid Status Is Not OK
    When User initializes an object and stores as variable 'sale_channel'
    And User sets request url as variable 'url'
    And User sets database entity
    And User set value of object 'sale_channel' for field 'is_active' to <is_active>
    And User sends request to 'create' object 'sale_channel' as user 'user1' with url 'url'
    Then The response shows hppt code as 400
    And The response should contain node 'error'

    Examples: 
      | is_active |
      |         3 |
      |        -1 |

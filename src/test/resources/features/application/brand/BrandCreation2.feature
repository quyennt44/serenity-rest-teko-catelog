@BrandCreationSpecification2
Feature: Create new test case for adding brand

  Background: 
    Given User has access to application as 'user1'
    When User has a brand with valid values

  Scenario Outline: TC01 Check Fields With Null Value
    And User set value for '<field_name>' to null
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'
    And The data in database should be checked: '<check_database>'
      | inputField  | outputField |
      | code        | code        |
      | name        | name        |
      | logo        | path        |
      | doc_request | doc_request |

    Examples: 
      | field_name  | http_code | response_content | check_database |
      | name        |       400 | errors           | No             |
      | code        |       400 | errors           | No             |
      | logo        |       200 | success          | Yes            |
      | doc_request |       200 | success          | Yes            |

  Scenario Outline: TC02 Check String Fields With Empty Value
    And User set value for '<field_name>' to empty
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'
    And The data in database should be checked: '<check_database>'
      | inputField  | outputField |
      | code        | code        |
      | name        | name        |
      | logo        | path        |
      | doc_request | doc_request |

    Examples: 
      | field_name  | http_code | response_content | check_database |
      | name        |       400 | INVALID          | No             |
      | code        |       400 | INVALID          | No             |
      | logo        |       400 | errors           | No             |
      | doc_request |       400 | errors           | No             |

  Scenario Outline: TC03 Check String Fields With Spaces Value Only
    And User set value for '<field_name>' to spaces value only
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'
    And The data in database should be checked: '<check_database>'
      | inputField  | outputField |
      | code        | code        |
      | name        | name        |
      | logo        | path        |
      | doc_request | doc_request |

    Examples: 
      | field_name | http_code | response_content | check_database |
      | name       |       400 | INVALID          | No             |
      | code       |       400 | INVALID          | No             |

  Scenario Outline: TC04 Check String Fields Containing Spaces Value
    And User set value for '<field_name>' containing leading and ending spaces
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'
    And The data in database should be checked: '<check_database>'
      | inputField  | outputField |
      | code        | code        |
      | name        | name        |
      | logo        | path        |
      | doc_request | doc_request |

    Examples: 
      | field_name | http_code | response_content | check_database |
      | name       |       200 | success          | Yes            |
      | code       |       200 | success          | Yes            |

  Scenario Outline: TC05 Check Fields With Max Length
    And User set value for '<field_name>' with value to length <length>
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'
    And The data in database should be checked: '<check_database>'
      | inputField  | outputField |
      | code        | code        |
      | name        | name        |
      | logo        | path        |
      | doc_request | doc_request |

    Examples: 
      | field_name | length | http_code | response_content | check_database |
      | name       |    100 |       200 | success          | Yes            |
      | code       |    100 |       200 | success          | Yes            |
      | logo       |    255 |       200 | success          | Yes            |

  Scenario Outline: TC06 Check Fields Over Max Length
    And User set value for '<field_name>' with value to length <length>
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'
    And The data in database should be checked: '<check_database>'
      | inputField  | outputField |
      | code        | code        |
      | name        | name        |
      | logo        | path        |
      | doc_request | doc_request |

    Examples: 
      | field_name | length | http_code | response_content | check_database |
      | name       |    101 |       400 | INVALID          | No             |
      | code       |    101 |       400 | INVALID          | No             |

  Scenario Outline: TC07 Check Fields With Special Characters
    And User set value for '<field_name>' containing special characters
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'
    And The data in database should be checked: '<check_database>'
      | inputField  | outputField |
      | code        | code        |
      | name        | name        |
      | logo        | path        |
      | doc_request | doc_request |

    Examples: 
      | field_name | http_code | response_content | check_database |
      | name       |       200 | success          | No             |
      | code       |       400 | INVALID          | No             |

  Scenario Outline: TC072 Check Fields Containing Space Characters
    And User set value for '<field_name>' containing space characters
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'
    And The data in database should be checked: '<check_database>'
      | inputField  | outputField |
      | code        | code        |
      | name        | name        |
      | logo        | path        |
      | doc_request | doc_request |

    Examples: 
      | field_name | http_code | response_content | check_database |
      | name       |       200 | success          | No             |
      | code       |       400 | INVALID          | No             |

  Scenario Outline: TC08 Check Adding A Duplicated Brand
    Given User has a brand with status '<active_status1>'
    And User creates another brand with the same '<field_name>' and with status '<active_status2>'
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'

    Examples: 
      | field_name | active_status1 | active_status2 | http_code | response_content |
      | name       | true           | true           |       400 | errors           |
      | name       | false          | true           |       200 | success          |
      | code       | true           | true           |       400 | errors           |
      | code       | false          | true           |       400 | errors           |

  Scenario: TC10 Check That Adding A Brand With Duplicated Name Uppercase And Lowercase Is Not Allowed
    Given User creates a brand
    And User creates another brand with the same name in uppercase
    Then The response shows hppt code as 400
    And The response shows content as 'errors'

  Scenario Outline: TC11 Check That Adding A Brand With Duplicated Name Diacritic Mark And No Diacritic Mark Is OK
    Given User creates a brand with field '<fieldName>' containing '<name1>'
    And User creates a brand with field '<fieldName>' containing '<name2>'
    Then The response shows hppt code as 200
    And The response shows content as 'success'

    Examples: 
      | fieldName | name1             | name2            |
      | name      | Phong Vũ          | Phong Vu         |
      | name      | Cooku’s nest café | Cookus nest cafe |

  Scenario Outline: TC12 Check Brand Code Containing Dash
    Given User set dash '<dash>' in code at the position '<position>'
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'

    Examples: 
      | position | dash              | http_code | response_content |
      | middel   | Sed-ut-perspici   |       200 | success          |
      | leading  | -Sedutperspici    |       400 | errors           |
      | after    | Sedutperspici-    |       400 | errors           |
      | middel   | Sed--ut--perspici |       200 | success          |
      | leading  | --Sedutperspici   |       400 | errors           |
      | after    | Sedutperspici--   |       400 | errors           |

  Scenario Outline: TC13 Check That Adding A Brand With Uppercase Code Is Not Allowed
    Given User creates a brand with field '<fieldName>' containing '<value>'
    Then The response shows hppt code as 400
    And The response shows content as 'errors'

    Examples: 
      | fieldName | value      |
      | code      | Hello      |
      | code      | helloWorld |

  Scenario Outline: TC14 Check That Adding A Brand With Code Containing Diacritic Mark Is Not Allowed
    Given User creates a brand with field '<fieldName>' containing '<value>'
    Then The response shows hppt code as 400
    And The response shows content as 'errors'

    Examples: 
      | fieldName | value             |
      | code      | phong-vũ          |
      | code      | cooku’s-nest-café |

  Scenario Outline: TC15 Check doc_request field
    Given User creates a brand with field '<fieldName>' containing '<value>'
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'

    Examples: 
      | fieldName   | doc_request_value | http_code | response_content |
      | doc_request | true              |       200 | success          |
      | doc_request | false             |       200 | success          |
      | doc_request |                 1 |       400 | errors           |
      | doc_request |                 0 |       400 | errors           |
      | doc_request | abc               |       400 | errors           |

  Scenario Outline: TC16 Check That Adding Many Brands Will Not Add Duplicated Internal Codes
    Given User creates a brand with field '<fieldName>' containing '<value>'  
    Then The response shows hppt code as 200
    And The response shows content as 'success'
    And The response is added to a list
    And The list of brands have no duplicated internal code
    Examples:
    |fieldName|value|
    |name|a1|
    |name|a2|
    |name|a3|
    |name|a4|
    |name|a5|
    |name|a6|
    |name|a7|
    |name|a8|
    |name|a9|
    |name|a10|

  Scenario Outline: TC17 Check logo image field
    Given User selects image type as '<image_type>' and in size width <width> and height <height>
    And User send request to create brand
    Then The response shows hppt code as <http_code>
    And The response shows content as '<response_content>'

    Examples: 
      | image_type | width | height | http_code | response_content |
      | png        |   500 |    500 |       200 | success          |
      | png        |   300 |    300 |       200 | success          |
      | png        |   430 |    430 |       200 | success          |
      | png        |   209 |    209 |       400 | INVALID          |
      | png        |   501 |    501 |       400 | INVALID          |
      | png        |   500 |    300 |       400 | INVALID          |
      | jpg        |   400 |    400 |       400 | INVALID          |
      | string     |     0 |      0 |       400 | ERROR            |

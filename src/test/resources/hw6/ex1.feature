@DifferentElementsAndLogin
Feature: Login and Different Elements pages

  Scenario:
    Given I am on Home page
    Then 'HOME_PAGE' page is opened
    When I login as user 'PITER CHAILOVSKII'
    Then User name should be 'PITER CHAILOVSKII'
    And Home page should have 'IMAGES' pictures
    And Home page should have 4 texts under pictures
    And Home page should have headline 'MAINHEADER' and description 'MAINHEADERTEXT'
    When I click on Service button in Header
    Then Service DropDown list contains options
      |Support|Dates|Complex Table|Simple Table|User Table|Table with pages|Different elements|Performance|
    When I click on Service button in Left section
    Then Service Left Section list contains options
      |Support|Dates|Complex Table|Simple Table|User Table|Table with pages|Different elements|Performance|
    When I click on Service button in Header
    And in dropdown list I click on Different elements option
    Then 'DIFFERENT_ELEMENTS' page is opened
    And Check interface: checkBox 'CHECKBOX', Radio 'RADIO', SelectSection 'SELECT', Buttons 'BUTTON'
    And There is Right Section
    And There is Left Section
    When I select checkboxes 'WATER'
    Then Log row changes status to 'true' for checkbox 'WATER'
    When I select checkboxes 'WIND'
    Then Log row changes status to 'true' for checkbox 'WIND'
    When I select radio 'SELEN'
    Then Log row changes status to 'true' for radio 'SELEN'
    When I select in dropdown 'YELLOW'
    Then Log row changes status to 'true' for select option 'YELLOW'
    When I select checkboxes 'WATER'
    Then Log row changes status to 'false' for checkbox 'WATER'
    When I select checkboxes 'WIND'
    Then Log row changes status to 'false' for checkbox 'WIND'

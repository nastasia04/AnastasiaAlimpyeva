@UserTable
Feature: User Table Page

  Scenario: User Table Page test
    Given I am on Home page
    And I login as user 'PITER CHAILOVSKII'
    When I click on Service button in Header
    And I click on User Table button in Service dropdown
    Then 'USER_TABLE' page is opened
    And 'DROPDOWNS_ON_USER_TABLE_PAGE' dropdowns are displayed on Users Table on User Table Page
    And 'NAMES_ON_USER_TABLE_PAGE' names are displayed on Users Table on User Table Page
    And 'DESCRIPTION_IMAGES_ON_USER_TABLE_PAGE' images are displayed on Users Table on User Table Page
    And 'DESCRIPTION_TEXTS_ON_USER_TABLE_PAGE' texts are displayed on Users Table on User Table Page
    And 'CHECKBOXES_ON_USER_TABLE_PAGE' checkboxes are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    When I select vip checkbox for 'SERGEY_IVAN'
    Then log row has 'Vip: condition changed to true' text in log section
    When I click on dropdown in column Type for user 'ROMAN'
    Then droplist for 'ROMAN' contains values
      | Admin   |
      | User    |
      | Manager |


@regression
Feature: Verifying Vehicle Exists
  As a user
  I want to be able to get the details of some vehicles of my choice
  So that I can validate the makes and colours of these vehicles.


  Background:
    Given I am on the VFS Page

  Scenario: Enter a valid vehicle registration number that exists in the system
    When I search with a "validExisting vehicleRegNumber" and click to find vehicle
    Then I should be able to see the details of the vehicle as below:
      | Field       | Value       |
      | Result      | result for  |
      | Cover Start | cover start |
      | Cover End   | cover end   |

  Scenario: Enter a valid vehicle registration number that does not exist in the system
    When I search with a "valid vehicleRegNumber" and click to continue
    Then I should be able to see "detailsNotFound message"


  Scenario: Enter an invalid vehicle registration number and receive an error message
    When I enter an "invalid vehicleRegNumber" on the searchField and click to continue
    Then I should be able to see "detailsNotFound message"


  Scenario: Enter no vehicle registration number and receive an error page with an error message
    When I leave the "field blank" and I click to continue
    Then I should be able to see "error message" displayed
@reg
@DemoWebsite
Feature: demowebsite
  Background:
    Given user is on demowebsite
    @datePicker
  Scenario: select date from the calender
    And user clicks on widgets menu and selects date picker
    And user selects date from calender
    Then date is displayed on
  @autoSuggestions
  Scenario: select from autosuggestions after entering a letter
    And user clicks widgets menu and autosuggestions
    And user enters a letter and selects from list
    Then selected element reflects in box

@selectable
Scenario: user checks for element is selected.
  And user clicks widgets menu and selectable
  And user selects and clicks elemnet
  Then user verifies
@resizable
Scenario: user checks the size changing valuebles
  And user clicks widgets menu and reSizable
  Then verifies the change in the size


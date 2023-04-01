@helpChecker @helpList
Feature: NHS Cost Help Eligibility Check

  Scenario Outline: As a UK Citizen, I am able to get the list of help for NHS COST using eligibilty check
    Given I start the eligibity check
    When I select all the options <eligibilityOptions> for eligibility check
    Then I am able to see the NHS help listed successfully

    Examples: 
      | eligibilityOptions         |
      | diabeticEnglandMember.json |

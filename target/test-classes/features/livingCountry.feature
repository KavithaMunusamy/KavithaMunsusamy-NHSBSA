@helpChecker @livingCountry
Feature: Living Country Selection of eligibility check for Help for NHS Cost

  Scenario Outline: As a UK Citizen, I am able to choose living country and proceed to next check
    Given I start the eligibity check
    When I choose my living country <country>
    Then I am able to proceed to next check with <country> successfully

    Examples: 
      | country  |
      | England  |
      | Wales    |
      | NI       |
      | Scotland |


  Scenario: As a UK Citizen, I am not able to proceed to next check without choosing country
    Given I start the eligibity check
    When I attempt to proceed without choosing living country
    Then error message is displayed   
    
    
  #Scenario: As a UK Citizen, I am able to navigate back to Start eligibilty check page
   # Given I start the eligibity check
   # When I click on back from living country selection page
   # Then I navigated back to Start eligibilty check page
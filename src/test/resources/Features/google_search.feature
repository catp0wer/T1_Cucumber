Feature: Google search


  Scenario: Google search
    Given user opens Google
    When user enter 'Elbrus' in search
    And click on Search
    Then results contain the word 'Elbrus'
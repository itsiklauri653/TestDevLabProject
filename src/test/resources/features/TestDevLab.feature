Feature: TestDevLab automation
  Background:
    Given User navigates to Test Dev Lab Page

  Scenario: User access subsections of each-sub menu
    Then Sub sections must not be visible before hovering
    Then User hovers to the sub-menu and sub sections must be visible

  Scenario: User tries to send an empty message in contact us page
    When User clicks contact us button
    And User clicks send button
    Then Error messages must be visible
    Then Error icons must be visible
    Then Error star icons must be visible

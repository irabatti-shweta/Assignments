Feature: Dropable 
  I want to write scenarios for Dropable features

  Scenario: Drag and drop to target
    Given Open Chrome browser and navigate to url 'https://jqueryui.com/droppable/'
    When Dragged source and dropped to target
    Then Verify Text and color changed
    #Then Verify Text changed to "Dropped!" and color changed to "#777620"
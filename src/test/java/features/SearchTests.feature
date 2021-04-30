Feature: Search UI tests


  Scenario Outline: Verify ability to search product
    Given go to Rozetka
    When search for "<searchText>", write in "<searchInput>", click to the "<searchButton>"
    Then title "<titleResult>",should be contains "<searchText>"
    Examples:
      | searchText | searchInput             | searchButton               | titleResult        |
      | Dispay     | //input[@name='search'] | button.search-form__submit | h1.catalog-heading |
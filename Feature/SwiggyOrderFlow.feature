Feature: Customer Orders Pizza from Swiggy
  @orderflow
  Scenario Outline: Customer Places an Order for Pizza on Swiggy
    Given a customer is on the Swiggy homepage
    And the customer enters the delivery location as "<city>"
    And the customer selects the first suggested location from the suggestion box
    And the customer is redirected to the pizza item page
    And the customer hovers over the search icon
    And the customer enters "Pizza" as the desired item
    And the customer selects the first suggested pizza item
    And the customer searches for a restaurant and selects the first available restaurant
    And the customer is redirected to the order page
    And the customer adds the first pizza item to the cart
    And the customer clicks on the checkout button
    Then the customer should be able to successfully place an order for pizza on Swiggy

    Examples:
      | city      |
      | Mumbai    |
      | Bangalore |
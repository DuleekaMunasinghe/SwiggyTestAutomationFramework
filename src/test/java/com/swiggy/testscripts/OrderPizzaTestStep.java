package com.swiggy.testscripts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import com.swiggy.CommonUtils.Driver;

public class OrderPizzaTestStep extends Driver {

	@Given("a customer is on the Swiggy homepage")
	public void a_customer_is_on_the_swiggy_homepage() {
		Assert.assertTrue(driver.getTitle()
				.equals("Order food online from India's best food delivery service. Order from restaurants near you"));
	}

	@Given("the customer enters the delivery location as {string}")
	public void the_customer_enters_the_delivery_location_as(String string) {
		// Write code here that turns the phrase above into concrete actions
		landingPage.enterLocation(string);
	}

	@When("the customer selects the first suggested location from the suggestion box")
	public void the_customer_selects_the_first_suggested_location_from_the_suggestion_box() {
		landingPage.selectLocation();
	}

	@When("the customer is redirected to the pizza item page")
	public void the_customer_is_redirected_to_the_pizza_item_page() {
		System.out.println("test casse");
	}

	@When("the customer hovers over the search icon")
	public void the_customer_hovers_over_the_search_icon() {
		items.hoverOverSerch();
	}

	@When("the customer enters {string} as the desired item")
	public void the_customer_enters_as_the_desired_item(String string) {
		items.enterItem(string);
		items.searchItem();
	}

	@When("the customer selects the first suggested pizza item")
	public void the_customer_selects_the_first_suggested_pizza_item() {
		items.selectFirstItem();
	}

	@When("the customer searches for a restaurant and selects the first available restaurant")
	public void the_customer_searches_for_a_restaurant_and_selects_the_first_available_restaurant() {
		placeOrder.addItem();
	}

	@When("the customer is redirected to the order page")
	public void the_customer_is_redirected_to_the_order_page() {
		placeOrder.continueorder();
	}

	@When("the customer adds the first pizza item to the cart")
	public void the_customer_adds_the_first_pizza_item_to_the_cart() {
		placeOrder.moveToCart();
	}

	@When("the customer clicks on the checkout button")
	public void the_customer_clicks_on_the_checkout_button() {
		placeOrder.checkoutAction();

	}

	@Then("the customer should be able to successfully place an order for pizza on Swiggy")
	public void the_customer_should_be_able_to_successfully_place_an_order_for_pizza_on_swiggy() {
		String expectedErrMsg = "SECURE CHECKOUT";
		String actualErrMsg = checkOut.getMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);

	}

}

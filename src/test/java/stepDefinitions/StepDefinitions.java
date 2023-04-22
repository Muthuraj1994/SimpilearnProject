package stepDefinitions;

import base.Base;
import base.Common;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends Base {

    Common common=new Common();
    Base base=new Base();

    @Given("Initialize")
    public void initialize() {
       System.out.println("Initialized");

    }
    @When("LogIN")
    public void log_in() {
        System.out.println("Logged In");

    }
    @Then("Validate")
    public void validate() {
        System.out.println("Validated");

    }

    @Given("Get the Data {string}")
    public void get_the_data(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(string);
    }

    @Given(": Using Swiggy Food Application Order the food {string}")
    public void using_swiggy_food_application_order_the_food(String location) {
        common.searchbyLocation(location);



    }
    @Then(": Verify the Tittle of the Swiggy Food Application")
    public void verify_the_tittle_of_the_swiggy_food_application() {
        common.verifyTitle("Order food online from India's best food delivery service. Order from restaurants near you");
            }
    @When(": Searching the product in swiggy application {string}")
    public void searching_the_product_in_swiggy_application(String product) {
        common.searchForProducts(product);
    }
    @Then(": User Successfully Select the Item and Click the AddtoCard of the product")
    public void user_successfully_select_the_item_and_click_the_addto_card_of_the_product() {
        common.addProductToCart();

    }

}

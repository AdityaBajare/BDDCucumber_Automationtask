package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CucumberTags {

	@Given("^Required phone number will be displayed$")
	public void required_phone_number_will_be_displayed() throws Throwable {
		 System.out.println("SMOKE EXECUTED");
	}

	@Given("^Desired deal will be displayed$")
	public void desired_deal_will_be_displayed() throws Throwable {
		 System.out.println("REGRESSION EXECUTED");
	}

	@Then("^Add it to cart$")
	public void add_it_to_cart() throws Throwable {
		 System.out.println("REGRESSION EXECUTED");
	}

	@Given("^Desired email will be displayed$")
	public void desired_email_will_be_displayed() throws Throwable {
	   System.out.println("REGRESSION AND SMOKE EXECUTED");
	
	}	
	
	
}

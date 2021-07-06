package StepDefinition;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;

public class Search {
	
	final static String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

	@Given("Bank Transactions Of Customer")
	public void Get_Customer_Transaction() {
		
		
		 given().when().get(url).then().log()
	      .all();

	  given().queryParam("CUSTOMER_ID","68195")
	               .queryParam("PASSWORD","1234!")
	               .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
	}

}

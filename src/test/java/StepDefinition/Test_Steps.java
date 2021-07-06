package StepDefinition;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_Steps {
 public static WebDriver driver;
 ConfigFileReader CFR;


 @Before
 public void Setup() {
	 
		 CFR=new ConfigFileReader();
		 CFR.getChromeDriver();
		 driver=new ChromeDriver();
		
 }
 
 @After
 public void QuitBrowser() {
	 driver.close();
 } 
 
 
 @Given("^User is on Amazon Page$")
 public void user_is_on_Paytm_Page() throws Throwable {

	 driver.get("https://www.amazon.in/");	 
	 driver.manage().window().maximize();
	 WebDriverWait wait = new WebDriverWait(driver,30);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-logo-sprites")));
	 
 }
 
 
 @When("^Check actual & expected title of Amazon Page$")
 public void user_On_AmazonPage() throws Throwable {
	String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	String actualTitle= driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
	 Select s=new Select(driver.findElement(By.cssSelector("#searchDropdownBox")));
	 s.selectByIndex(5);
	 
 }
 
 @Then("^Verify status code 200 or 400$")
 public void verify_Status_Code() throws Throwable {
	
	String CurrentURL= driver.getCurrentUrl();
	System.out.println("Status code is "+RestAssured.get(CurrentURL).getStatusCode());
	
	
 }
 
 @When("^Click on Amazon Pay link$")
 public void Click_Electricity_Link() throws Throwable {
	
	 driver.findElement(By.xpath("/html/body/div[1]/header/div/div[5]/div[2]/div/div/a[8]")).click();
	                              
 }
 

 
 
 @Then("^Amazon Pay page should be open & verify status code 301 or 302$")
 public void Verify_Status_Code() throws Throwable {

		String CurrentURL= driver.getCurrentUrl();
		System.out.println("Status code is "+RestAssured.get(CurrentURL).getStatusCode());
		
		
		                           
 } 
 
 @When("^User Click on electricity link$")
 public void Open_New_Link() throws Throwable {

	 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[5]/div/div/div[3]/span/a/div[2]/span")).click();
	 driver.findElement(By.id("a-autoid-1-announce")).click();
	 
		
 }
 
 
 @Then("^Delete all cookies$")
 public void Delete_All_Cookies() throws Throwable {

driver.manage().deleteAllCookies();


 }
 @When("^User Navigate to Amzon home page$")
 public void New_Page_Link() throws Throwable {
	 
	 driver.navigate().to("https://www.amazon.in/");
 }
	
 
 
 @Then("^Handle multple frames$")
 public void Handle_Multiple_Frames() throws Throwable {

	List<WebElement>  frames = driver.findElements(By.tagName("iframe"));
	 System.out.println("Total frames are on page "+frames.size());
	 System.out.println(frames.toString());
	
	 driver.switchTo().frame(0);
	 System.out.println("We are on 1st frame "+driver.getTitle());
	
	 
	 
 }
 
 @Then("^Verify resopnse headers$")
 public void Verify_Response_Headers() {
	 String CurrentURL=driver.getCurrentUrl();
	 RestAssured.baseURI = CurrentURL;
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Amazon Pay");
	 Headers allHeaders = response.headers();
	 
	 // Iterate over all the Headers
	 for(Header header : allHeaders)
	 {
	 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
	 }
 }
 
 
 @Then("^Verify value/text in page source$")
 public void Verify_Texton_PageSource() throws Throwable {

	 String t = "Amazon Pay";
     // getPageSource() to get page source
     if ( driver.getPageSource().contains("Amazon Pay")){
        System.out.println("Text: " + t + " is present. ");
     } else {
        System.out.println("Text: " + t + " is not present. ");
     }
	 
 }
 

 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
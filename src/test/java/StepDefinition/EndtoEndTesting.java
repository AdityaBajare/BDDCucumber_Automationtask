package StepDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import DataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EndtoEndTesting {
	
	public static WebDriver driver;
	 ConfigFileReader CFR;


	/* @Before
	 public void Setup() {
		
			CFR=new ConfigFileReader();
			 CFR.getChromeDriver(); 
			 driver=new ChromeDriver();
			
	 }
	 
	 @After
	 public void QuitBrowser() {
		 driver.close();
	 } 
	*/
	
	 
	 
	@Given("^User is on Student registration page$")
	public void Student_Registration_Form() {
		 System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\hp\\\\Desktop\\\\Drivers\\\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.jotform.com/form/211741256357455#preview");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}

	 @Then("^Select value from dropdown, select check box & radio button$")
	 public void J() throws InterruptedException {

		 // select value from dropdown
		 Select s= new Select(driver.findElement(By.xpath("//*[@id=\"input_3\"]")));
		 s.selectByIndex(5);
		
		// Select check box
		WebElement Checkbox = driver.findElement(By.xpath("//*[@id=\"input_8_0\"]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Checkbox);
		
		//Select radio button
		
		WebElement RadioButton = driver.findElement(By.xpath("//*[@id=\"input_13_1\"]"));
		
		executor.executeScript("arguments[0].click();", RadioButton);
		
		if(RadioButton.isSelected()) {
			System.out.println("Radio button is selected");
		}
		Thread.sleep(2000);
		
		 }
	 
	 
	 @When("^User Navigato to ipo site$")
	 public void Navigate_Ipo_Site() throws Throwable {
		 
		 driver.navigate().to("https://www.nyse.com/ipo-center/filings");
	 }
	 
	 
	 @Then("^Handle webtables count number of rows & columns$")
	 public void Handle_Webtable() throws InterruptedException {
		
		 
		 System.out.println(driver.getTitle());
		 
		 List<WebElement> totalcolumns= driver.findElements(By.xpath("//*[@id=\"content-8b4988b9-2ec9-4e77-9b4d-9c2994bd9e8a\"]/div/div/table[1]/thead/tr/th[1]"));
		 
		 System.out.println("Total columns are "+totalcolumns.size());
		 
	 List<WebElement> totalrows= driver.findElements(By.xpath("//*[@id=\"content-8b4988b9-2ec9-4e77-9b4d-9c2994bd9e8a\"]/div/div/table[1]/tbody/tr[4]/td[3]"));
		 
		 System.out.println("Total rows are "+totalrows.size());
		 
		 
		 
	 }
	 


	 @Then("^Use assert to verify actual & expected result$")
	 public void Verify_Title_Of_Paytm() {

		 
	String expectedTitle= "IPOs | Recent IPO Filings, Calendar of Upcoming IPOs, and IPO Data";
	String actualTitle= driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);

	 } 
	 
	 @Then("^Handle multiple browser windows & Drag and drop image$")
	 public void Handle_Multiple_Browser() throws InterruptedException {
		 driver.get("http://www.naukri.com/");

	    String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();

	   if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());

		driver.close();
		}

		}

		driver.switchTo().window(parent);
		
		// drag drop image
		WebElement From= driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[3]/div[1]/div[1]/ul/li[3]/a/img"));

		WebElement To= driver.findElement(By.xpath("//*[@id=\"qsb-location-sugg\"]"));
		
		Actions act=new Actions(driver);	
		act.dragAndDrop(From, To).build().perform();	
		System.out.println("Image Dropped Successful");

		}
		 
	 
	 
	 
	 
	 
	 

}

package DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigFileReader {
	static WebDriver driver;
	private Properties properties;
	 private final String propertyFilePath= "Config//Configuration.properties";
	 
	 
	 public ConfigFileReader(){
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	
		 
	
	 
	 public void getChromeDriver() {
		 System.setProperty("webdriver.chrome.driver", properties.getProperty("ChromedriverPath"));
		 }
	 
	 public void getGeckoDriver() {
		 System.setProperty("webdriver.gecko.driver", properties.getProperty("GeckodriverPath"));
		 }
	 
	 
		 public long getImplicitlyWait() { 
		 String implicitlyWait = properties.getProperty("implicitlyWait");
		 if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		 else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
		 }
		 
		 public String getAmazonUrl() {
		 String url = properties.getProperty("AmazonUrl");
		 if(url != null) return url;
		 else throw new RuntimeException("url not specified in the Configuration.properties file.");
		 }
		 
		 public String getFormUrl() {
			 String url = properties.getProperty("FormUrl");
			 if(url != null) return url;
			 else throw new RuntimeException("url not specified in the Configuration.properties file.");
			 }
	

}

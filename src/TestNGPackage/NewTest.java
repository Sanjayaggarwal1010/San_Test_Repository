package TestNGPackage;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	 public static String driverPath = "C:\\Users\\megha\\Desktop\\SeleniumJarFiles\\chromedriver_win32\\";
	 public static WebDriver driver;
	 
	 @BeforeTest
	 public void startbrowser()
	 {
		 System.out.println("launching chrome browser");
		 System.out.println("Sanjay Aggarwal");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("no-sandbox");
			options.setBinary("C:\\Users\\megha\\Desktop\\SeleniumJarFiles\\chromedriver_win32\\chromedriver.exe");
     }
	 
	 @AfterTest
	 public void Closebrowser()
	 {
		 System.out.println("Closing chrome browser");
		 driver.quit();
		 System.out.println(" chrome browser closed");
		 
		 
	 }
	 
	 
	 @Test(priority = 1)
	  public void verifyHomepageTitle() {
	       
		String Url = "https://www.americanfunds.com/advisor";
			driver.navigate().to(Url);
			System.out.println(driver.getPageSource());
				
	  }
	 
	 @Test (priority = 2)
	  public void capitalgroup() {
	       
			  driver.navigate().to("https://www.thecapitalgroup.com/us/about.html");
	             driver.findElement(By.linkText("Our Locations")).click();
	             List<WebElement> Locations = driver.findElements(By.xpath("//div[@class='row-fluid office-locations']/div/ul/li"));
	             int totalCGLocation = Locations.size();
	             List<WebElement> Ofcdetails = driver.findElements(By.xpath("//div[@class='office-details']/div"));
	            
	            for (int j=0 ; j<totalCGLocation ; j++)
	            {
	            	Locations.get(j).click();               	 
	            		 
	               String ofcdetailexists =  Ofcdetails.get(j).getAttribute("class");
	               System.out.println(ofcdetailexists);
	                 String ofcid = Ofcdetails.get(j).getAttribute("id");
	                System.out.println(ofcid); 
	                  
	                System.out.println(String.format("//div[@id = '"+ofcid+"']//img")); 
	                                
	                String Ofcimagepath = driver.findElement(By.xpath(String.format("//div[@id = '"+ofcid+"']//img"))).getAttribute("alt");
	               System.out.println(Ofcimagepath);
	              String Ofcname = driver.findElement(By.xpath(String.format("//div[@id = '"+ofcid+"']//h1"))).getText();
	              System.out.println(Ofcname);
	              String Ofcaddress = driver.findElement(By.xpath(String.format("//div[@id = '"+ofcid+"']//div[@class='address']"))).getText();
	              System.out.println(Ofcaddress);
	              String Ofcaddressviewmap = driver.findElement(By.xpath(String.format("//div[@id = '"+ofcid+"']//div[@class='address']//a"))).getText();
	              System.out.println(Ofcaddress);
	              String Ofcstatslocalemployer = driver.findElement(By.xpath(String.format("//div[@id = '"+ofcid+"']//div[@data='office-employer-since']", ofcid))).getText();
	              System.out.println(Ofcstatslocalemployer);
	              String Ofcstatsassociates = driver.findElement(By.xpath(String.format("//div[@id = '"+ofcid+"']//div[@data='office-associates']"))).getText();
	                System.out.println(Ofcstatsassociates);
	                String Ofcstatsdisclaimers = driver.findElement(By.xpath(String.format("//div[@id = '"+ofcid+"']//div[@data='office-disclaimer']"))).getText();
	             System.out.println(Ofcstatsdisclaimers);
	            }
				
				System.out.println("chrome browser Closed");
				System.out.println("End of Method");
				System.out.println("End of Method- Just Now");
			
	  }
	 
	 

}

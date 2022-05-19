package mindtree.UrbanLadder;



import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UlOrderItem {
	WebDriver driver;
	@Before
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mindsdet318\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@Test
	public void test() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com");
		driver.manage().window().maximize();
		System.out.println("page title:"+driver.getTitle());
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("li[class='header__topBarIconList_profile-icon']"))).build().perform();
		a.click(driver.findElement(By.xpath("//a[@class='login-link authentication_popup']"))).build().perform();
	
		  driver.findElement(By.cssSelector("input[class='email required input_authentication']")).sendKeys("Arun123@gmail.com",Keys.TAB, "Arun@123"); 
		  driver.findElement(By.id("ul_site_login")).click(); 
		  driver.findElement(By.id("search")).sendKeys("Book Shelves", Keys.ENTER);
		  driver.findElement(By.xpath("//a[@data-id='142633']")).click();
		  Set<String> handles =driver.getWindowHandles();
		  Iterator<String> it =handles.iterator();
		  String parent=it.next();
		  while(it.hasNext()) {
			  String child=it.next();
			  if(!parent.equalsIgnoreCase(child)) {
		 
		  
		  driver.switchTo().window(child);
		  System.out.println(driver.getTitle());
			  }
			  driver.findElement(By.cssSelector("span[class='arrow-icon']")).click();
			  driver.findElement(By.cssSelector("input[class='user-pincode']")).sendKeys("560002", Keys.ENTER);
			 
		  driver.findElement(By.cssSelector("button[data-galabel='add to cart']")).click();
		  driver.findElement(By.id("checkout-link")).click();
		  driver.findElement(By.id("order_ship_address_attributes_zipcode")).sendKeys("560002");
		  driver.findElement(By.id("order_ship_address_attributes_address1")).sendKeys("Banglore");
		  driver.findElement(By.id("order_ship_address_attributes_firstname")).sendKeys("Arun", Keys.TAB, "Reddy");
		  driver.findElement(By.id("order_ship_address_attributes_phone")).sendKeys("8342493430");
		  driver.findElement(By.id("address-form-submit")).click();
		  driver.findElement(By.cssSelector("input[class='continue button paybtn']")).click();
		  Thread.sleep(10000L);
		 	}
	}
	@After
	public void closeDriver() {
		driver.close();
	}

}

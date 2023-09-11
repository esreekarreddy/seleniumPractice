package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderUI {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//check whether return date is disabled or not
		if(!driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Round trip diabled");
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		//select current date in departure
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();
		
		Thread.sleep(2000);
		driver.close();
	}
	

}

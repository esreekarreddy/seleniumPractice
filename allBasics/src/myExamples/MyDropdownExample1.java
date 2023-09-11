package myExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyDropdownExample1 {

	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//set currency
		Select option = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		option.selectByValue("USD");
		System.out.println("Selected Currency is " + option.getFirstSelectedOption().getText());
		
		//set adults to 5
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i=0; i<4; i++) {
			Thread.sleep(200);
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("No of passengers are " + driver.findElement(By.id("divpaxinfo")).getText());
		
		//set source and destination city
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(300);
		driver.findElement(By.cssSelector("a[value='BLR']")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();
		
		
		Thread.sleep(2000);
		driver.close();

	}

}

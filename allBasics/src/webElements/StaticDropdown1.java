package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		StaticDropdown1 object = new StaticDropdown1();
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		String currency = object.selectCurrency(driver);
		
		System.out.println("Selected currency is: " + currency);
		
		String adultCount = object.adultSelection(driver);
		
		System.out.println("Adult count is: " + adultCount);
		
		Thread.sleep(1000);
		driver.close();
		
	}
	
	
	public String selectCurrency(WebDriver driver) {
		
		WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select option = new Select(element);
		
		option.selectByValue("INR");
		
		return option.getFirstSelectedOption().getText();
		
	}
	
	public String adultSelection(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.cssSelector("div#divpaxinfo")).click();;
		Thread.sleep(500);
		int i = 0;
		while(i<4) {
			driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(500);
			i++;
		}
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		
		return driver.findElement(By.className("paxinfo")).getText();
		
	}

}

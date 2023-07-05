package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select option = new Select(element);
		
		option.selectByIndex(3);
		System.out.println("1 " + option.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		option.selectByValue("AED");
		System.out.println("2 " + option.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		option.selectByVisibleText("INR");
		System.out.println("3 " + option.getFirstSelectedOption().getText());
		
		
		Thread.sleep(1000);
		driver.close();

	}

}

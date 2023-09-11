package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsExample2 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Sibling test: " + driver.findElement(By.xpath("//div/button[1]/following-sibling::button[1]")).getText());
		System.out.println("Child to parent test: " + driver.findElement(By.xpath("//div/button[1]/following-sibling::button[1]/parent::div/parent::header/div/button[2]")).getText());
		
		driver.close();
	}

}

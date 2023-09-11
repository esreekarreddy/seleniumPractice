package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("input#checkBoxOption1")).click();
		Thread.sleep(500);
		Assert.assertTrue(driver.findElement(By.cssSelector("input#checkBoxOption1")).isSelected());
		driver.findElement(By.cssSelector("input#checkBoxOption1")).click();
		Thread.sleep(500);
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		int size = driver.findElements(By.cssSelector("input[id*='checkBoxOption']")).size();
		System.out.println("Number of checkboxes are " + size);

		Thread.sleep(1000);
		driver.close();
	}

}

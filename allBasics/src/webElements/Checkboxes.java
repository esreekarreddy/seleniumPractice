package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		boolean check = driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected();
		Assert.assertFalse(check);
		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
		boolean check1 = driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected();
		Assert.assertTrue(check1);
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		Assert.assertEquals(check1, true);
		Thread.sleep(2000);
		driver.close();

	}

}

package myExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorMyExample1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		driver.findElement(By.id("inputUsername")).sendKeys("Sreekar");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("idontknow");
		driver.findElement(By.cssSelector(".signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//form/input[1]")).sendKeys("Reddy");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("sr@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8297338513");
		Thread.sleep(500);
		driver.findElement(By.className("reset-pwd-btn")).click();
		Thread.sleep(500);
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		
		String[] values = driver.findElement(By.cssSelector(".infoMsg")).getText().split("'");
		driver.findElement(By.xpath("//form/div/button[1]")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("Sreekar");
		driver.findElement(By.name("inputPassword")).sendKeys("values[1]");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.cssSelector("button[class*='submit']")).click();
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
